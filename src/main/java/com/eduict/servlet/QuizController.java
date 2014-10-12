package com.eduict.servlet;

import com.eduict.controller.QuizRegistration;
import com.eduict.data.LevelListProducer;
import com.eduict.model.Quiz;
import com.eduict.model.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/quiz")
public class QuizController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;

    @Inject
    QuizRegistration registrationService;
    
    @Inject
    LevelListProducer levelListProducer;

    @Inject
    QuizRegistration quizRegistration;
    
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        StringBuilder errorMessage = new StringBuilder();

        try {
            //if user has session, and no cookie value then create a new Quiz for him,
            //if user has session and cookie value, load quiz upon cookie reference
            //and fetch user quiz history
            HttpSession session = request.getSession();
            
            if (session.getAttribute("user") != null) {
                User user =  (User) session.getAttribute("user");
                log.info("session found for user presenting a new quiz");

                //read cookies to see if exists previously created quiz
                Cookie[] cookies = request.getCookies();
                Long previousId = null;
                for (Cookie obj : cookies) {
                    if (obj.getName().equals("previousId")) {
                        previousId = Long.parseLong(obj.getValue());
                        Quiz previousQuiz = registrationService.lookupQuizById(previousId);
                        previousQuiz.setLevels(levelListProducer.levels());
                        request.setAttribute("quiz", previousQuiz);
                        log.info("quiz: " + previousQuiz.toString());
                        break;
                    }
                }
                if (previousId == null) {
                    Quiz newQuiz = new Quiz();
                    newQuiz.setLevels(levelListProducer.levels());//fetch levels list to associate with this new quiz
                    newQuiz.setUser(user);
                    List<Quiz> userQuizzes = new ArrayList<Quiz>();
                    if (user.getQuizzes().isEmpty()) {
                        userQuizzes.add(newQuiz);
                    } else {
                        for (Quiz q : user.getQuizzes()) {
                            userQuizzes.add(q);
                        }
                        userQuizzes.add(newQuiz);
                    }
                    user.setQuizzes(userQuizzes);
                    quizRegistration.registerNewQuiz(newQuiz);
                    Cookie cookie = new Cookie("previousId", newQuiz.getId().toString());
                    cookie.setMaxAge(30 * 60); //1/2 hour
                    response.addCookie(cookie);
                    request.setAttribute("quiz", newQuiz);
                    log.info("quiz: " + newQuiz.toString());
                }
            } else {
                log.info("no session found presenting a demo quiz");
                 //else present a demo quiz
                Quiz demoQuiz = registrationService.lookupQuizById(0L);//demo quiz
                request.setAttribute("quiz", demoQuiz);
                log.info("quiz: " + demoQuiz.toString());
            }
        } catch (Exception e) {
            Throwable t = e;
            while ((t.getCause()) != null) {
                t = t.getCause();
            }
            errorMessage.append("Error========>" + t.getMessage());
            request.setAttribute("infoMessage", "");
            e.printStackTrace();
        } finally {
            request.setAttribute("errorMessage", errorMessage.toString());
            RequestDispatcher resultView = request.getRequestDispatcher("quiz.jsp");
            resultView.forward(request, response);
        }
    }
}
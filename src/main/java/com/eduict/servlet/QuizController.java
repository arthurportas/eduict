package com.eduict.servlet;

import com.eduict.controller.QuizRegistration;
import com.eduict.data.LevelListProducer;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import com.eduict.model.Quiz;
import com.eduict.model.User;
import java.util.List;
import com.eduict.model.Level;

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
            //if user has session, then create a new Quiz for him,
            //and fetch user quiz history
             User user =  (User) session.getAttribute("user");
             if(user != null) {
                Quiz newQuiz = quizRegistration.register();
                //fetch levels list to asociate with this new quiz
                List<Level> levels = levelListProducer.getLevels();
                //newQuiz.setLevels = levels;
                //newQuiz.setUser(user);
                
                Quiz demoQuiz = registrationService.lookupQuizById(0L);//demo quizz
                request.setAttribute("demoQuiz", demoQuiz);
                log.info("demoQuiz: " + demoQuiz.toString());
             } else {
                 //else present a demo quiz
                Quiz demoQuiz = registrationService.lookupQuizById(0L);//demo quizz
                request.setAttribute("demoQuiz", demoQuiz);
                log.info("demoQuiz: " + demoQuiz.toString());
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
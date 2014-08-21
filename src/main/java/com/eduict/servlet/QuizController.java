package com.eduict.servlet;

import com.eduict.controller.QuizRegistration;

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

@WebServlet(urlPatterns = "/quiz")
public class QuizController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;

    @Inject
    QuizRegistration registrationService;

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StringBuilder errorMessage = new StringBuilder();

        try {
            Quiz demoQuiz = registrationService.lookupQuizById(1L);
            request.setAttribute("quiz", demoQuiz);
            out.println(demoQuiz.toString());
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
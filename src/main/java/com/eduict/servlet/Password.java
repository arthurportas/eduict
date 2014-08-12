package com.eduict.servlet;

import com.eduict.controller.UserRegistration;
import com.eduict.model.User;

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

@WebServlet(urlPatterns = "/recover-password")
public class Password extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;

    @Inject
    UserRegistration registrationService;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StringBuilder errorMessage = new StringBuilder();

        try {
            String email = request.getParameter("recover-email");
            User user = registrationService.changePasswordRequest(email);
            if (user != null) {
                out.println("encontrado " + user.getEmail());
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                //setting session to expiry in 30 mins
                session.setMaxInactiveInterval(30 * 60);

                //send email with token

            } else {
                out.println("não encontrado ");
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
            RequestDispatcher resultView = request.getRequestDispatcher("index.jsp");
            resultView.forward(request, response);
        }
    }
}
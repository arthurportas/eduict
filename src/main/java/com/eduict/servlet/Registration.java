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
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/register")
public class Registration extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;

    @Inject
    UserRegistration registrationService;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        StringBuilder errorMessage = new StringBuilder();
//http://eduict-afmp.rhcloud.com/register?register-firstName=Arthur&register-lastName=Portas
//&register-email=arthurportas%40gmail.com&register-password=123456&register-age=34&gender-radios=male
        try {

            User user;

            while ((user = registrationService.getNewUser()) == null) {
                registrationService.initNewUser();
            }

            user.setFirstName("Arthur");
            user.setLastName("Portas");
            user.setEmail("arthurportas@gmail.com");
            user.setAge("34");
            user.setGender("masculino");
            user.setAcademicDegree("licenciatura");

            registrationService.register();

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
            RequestDispatcher resultView = request.getRequestDispatcher("users.jsp");
            resultView.forward(request, response);
        }
    }
}
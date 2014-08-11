package com.eduict.servlet;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

import com.eduict.data.UserListProducer;
import com.eduict.servlet.async.LoginTask;
import javax.inject.Inject;
import com.eduict.controller.UserRegistration;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eduict.model.User;
import javax.servlet.RequestDispatcher;
 
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

        try {

            User user;

            while ((user = registrationService.getNewUser()) == null) {
                registrationService.initNewUser();
            }

            user.setFirstName("Arthur");
            user.setLastName("Portas");
            user.setEmail("arthurportas@gmail.com");
            user.setAge(34);
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
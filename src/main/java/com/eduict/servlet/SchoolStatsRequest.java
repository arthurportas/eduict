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

@WebServlet(urlPatterns = "/school-stats-request")
public class SchoolStatsRequest extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;

    @Inject
    UserRegistration registrationService;

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

            RequestDispatcher resultView = request.getRequestDispatcher("school-stats-request.jsp");
            resultView.forward(request, response);
        }
    }
}
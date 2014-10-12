package com.eduict.servlet;

import com.eduict.controller.UserRegistration;
import com.eduict.data.RoleListProducer;
import com.eduict.model.Role;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/register")
public class Registration extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;

    @Inject
    UserRegistration registrationService;

    @Inject
    RoleListProducer roleListProducer;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        StringBuilder errorMessage = new StringBuilder();

        try {
            String firstName = request.getParameter("register-firstName");
            String lastName = request.getParameter("register-lastName");
            String email = request.getParameter("register-email");
            String password = request.getParameter("register-password");
            String age = request.getParameter("register-age");
            String gender = request.getParameter("register-gender");
            String role = request.getParameter("register-user-role");
            String academicDegree = request.getParameter("register-academic-degree");
            String recruitmentGroup = request.getParameter("register-recruitment-group");
            String currentYearTeachingLevel = request.getParameter("register-current-year-teaching-level");
            String serviceTime = request.getParameter("register-service-time");
            String workRegion = request.getParameter("register-work-region");//TODO-convert to int lookup in db
            String workSchool = request.getParameter("register-work-school");//TODO-convert to int lookup in db

            User user;

            while ((user = registrationService.getNewUser()) == null) {
                registrationService.initNewUser();
            }

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setAge(age);
            user.setGender(gender);

            Role newRole = new Role();
            newRole.setRoleName(role);//TODO: use enums with jpa
            newRole.setUser(user);
            List<Role> rolesList = new ArrayList<Role>();//TODO: develop mechanism to allow addition of multiple roles per user
            rolesList.add(newRole);
            user.setRoles(rolesList);


            user.setAcademicDegree(academicDegree);

            registrationService.register();

            User lookupUser = registrationService.lookupUserByEmailAndPassword(user.getEmail(), user.getPassword());
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", lookupUser);
                //setting session to expiry in 30 mins
                session.setMaxInactiveInterval(30 * 60);
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
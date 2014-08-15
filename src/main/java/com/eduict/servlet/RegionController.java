package com.eduict.servlet;

import com.eduict.controller.RegionRegistration;
import com.eduict.model.Region;
import com.eduict.model.School;

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
import java.util.List;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/regions")
public class RegionController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Logger log;

    @Inject
    RegionRegistration registrationService;

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuilder message = new StringBuilder(); 
        StringBuilder errorMessage = new StringBuilder();

        try {
            long regionId = Long.parseLong(request.getParameter("id"));
            Region region = registrationService.lookupRegionById(regionId);
            if (region != null) {
                //build html response
                List<School> schoolList = region.getSchools();
                for(School s: schoolList) {
                    message.append("<option value='" + s.getId()+ "'>"+ s.getSchoolName() + "</option>");
                }
                out.println(message.toString());

            } else {
                //handle error
            }

        } catch (Exception e) {
            Throwable t = e;
            while ((t.getCause()) != null) {
                t = t.getCause();
            }
            errorMessage.append("Error========>" + t.getMessage());
            request.setAttribute("infoMessage", "");
            e.printStackTrace();
        }
    }
}
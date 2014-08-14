package com.eduict.servlet;

import com.eduict.controller.RegionRegistration;
import com.eduict.model.Region;

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

        StringBuilder errorMessage = new StringBuilder();

        try {
            String regionId = request.getParameter("id");
            if (regionId != null) {
                Region region = registrationService.lookupRegionById(regionId);
                if (region != null) {
                    request.setAttribute("region", region);
                } else {
                    //handle error
                }
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
        } finally {
            request.setAttribute("errorMessage", errorMessage.toString());
            RequestDispatcher resultView = request.getRequestDispatcher("regions.jsp");
            resultView.forward(request, response);
        }
    }
}
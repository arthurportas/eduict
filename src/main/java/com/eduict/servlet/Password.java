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
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
            
            if(email != null) {
                User user = registrationService.changePasswordRequest(email);
            if (user != null) {
                out.println("<div class='alert alert-success'><strong><span class='glyphicon glyphicon-send'></span>Foi enviado um email para  " + user.getEmail() + " com instruções para alterar a sua password.</strong></div>");
                    
                //send email with token
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication("arthurportas","xKoninha");
                            }
                        });

                try {

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("arthurportas@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse("arthurportas@gmail.com"));
                    message.setSubject("Mudar password");
                    message.setText("teste");

                    Transport.send(message);

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
            } else {
                out.println("<div class='alert alert-danger'><span class='glyphicon glyphicon-alert'></span><strong> Utilizador/Password não encontrado!</strong></div>");
            }

        } catch (Exception e) {
            Throwable t = e;
            while ((t.getCause()) != null) {
                t = t.getCause();
            }
            errorMessage.append("Error========>" + t.getMessage());
            request.setAttribute("infoMessage", "");
            e.printStackTrace();
        } /*finally {
            request.setAttribute("errorMessage", errorMessage.toString());
            RequestDispatcher resultView = request.getRequestDispatcher("index.jsp");
            resultView.forward(request, response);
        }*/
    }
}
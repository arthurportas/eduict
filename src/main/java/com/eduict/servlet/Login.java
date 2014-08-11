package com.eduict.servlet.async;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import com.eduict.servlet.async.LoginTask;
import javax.inject.Inject;
import com.eduict.controller.MemberRegistration;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eduict.model.User;
 
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
 
    @Inject
    private Logger log;
    
    @Inject
    MemberRegistration registrationService;
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
      response.setContentType("text/html");
      
        long startTime = System.currentTimeMillis();
        log.info("Login Start::Name="
                + Thread.currentThread().getName() + "::ID="
                + Thread.currentThread().getId());
 
        ThreadPoolExecutor executor = (ThreadPoolExecutor) request
                .getServletContext().getAttribute("executor");
 
        User user = new User();
        user.setFirstName("Arthur");
        user.setLastName("Portas");
        user.setEmail("arthurportas@gmail.com");
        user.setAge(34);
        user.setGender("masculino");
        user.setAcademicDegree("licenciatura");
        
        Callable loginTask = new LoginTask(user);
        
        FutureTask<String> futureTask = new FutureTask<String>(loginTask);
        
        executor.execute(futureTask);
      
        PrintWriter out = response.getWriter();
        
        while (true) {
            
            try {
                out.println("Waiting for FutureTask to complete");
                String result = futureTask.get(2000L, TimeUnit.MILLISECONDS);

                if(result != null){
                    out.println("FutureTask output=" + result);
                    log.info("FutureTask output=" + result);
                }
                if(futureTask.isDone()){
                    out.println("Done");
                    return;
                }
            } catch (InterruptedException ie) {
                log.info(ie.getMessage());
            } catch(ExecutionException ee) {
                log.info(ee.getMessage());    
            } catch(TimeoutException te){
                log.info(te.getMessage());
            }
        }
        
        /*
        long endTime = System.currentTimeMillis();
        System.out.println("AsyncLongRunningServlet End::Name="
                + Thread.currentThread().getName() + "::ID="
                + Thread.currentThread().getId() + "::Time Taken="
                + (endTime - startTime) + " ms.");*/
    }
 
}
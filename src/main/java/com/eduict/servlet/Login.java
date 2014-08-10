package com.journaldev.servlet.async;
 
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.FutureTask;
import java.util.logging.Logger;
import com.eduict.servlet.async.LoginTask;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
 
    @Inject
    private Logger log;
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        long startTime = System.currentTimeMillis();
        log.info("Login Start::Name="
                + Thread.currentThread().getName() + "::ID="
                + Thread.currentThread().getId());
 
        ThreadPoolExecutor executor = (ThreadPoolExecutor) request
                .getServletContext().getAttribute("executor");
 
        LoginTask loginTask = new LoginTask();
        
        FutureTask<String> futureTask = new FutureTask<String>(loginTask);
        
        executor.execute(futureTask);
        
        while (true) {
            try {
                if(futureTask.isDone()){
                    log.info("Done");
                    return;
                }

                log.info("Waiting for FutureTask to complete");
                String result = futureTask.get(200L, TimeUnit.MILLISECONDS);
                if(result !=null){
                    log.info("FutureTask output=" + result);
                }
            } catch (InterruptedException ie) {
                log.debug(ie.getMessage());
            }catch(ExecutionException ee) {
                log.debug(ee.getMessage());   
            }catch(TimeoutException te){
                log.debug(te.getMessage());
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
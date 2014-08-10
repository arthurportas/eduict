package com.eduict.servlet.async;

import java.util.concurrent.Callable;
import com.eduict.controller.MemberRegistration;
import com.eduict.model.User;
import javax.inject.Inject;


public class LoginTask implements Callable<String> {

    
    private User user;
    
    public LoginTask(User user) {
        this.user = user;
    }
    
    @Override
    public String call() throws Exception {
        
        return this.user.getFirstName();
    }
}
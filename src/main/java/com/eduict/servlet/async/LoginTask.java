package com.eduict.servlet.async;

import java.util.concurrent.Callable;
import com.eduict.model.User;
import com.eduict.controller.MemberRegistration;



public class LoginTask implements Callable<String> {

    private MemberRegistration registrationService;
    private User user;
    
    public LoginTask(User user) {
        this.registrationService = new MemberRegistration();
        this.user = user;
    }
    
    @Override
    public String call() throws Exception {
        
        return this.user.getFirstName();
    }
}
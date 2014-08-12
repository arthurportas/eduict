package com.eduict.servlet.async;

import com.eduict.controller.UserRegistration;
import com.eduict.model.User;

import java.util.concurrent.Callable;

public class LoginTask implements Callable<String> {

    private UserRegistration registrationService;
    private User newUser;
    private User tempUser;

    public LoginTask(User user) {
        this.registrationService = new UserRegistration();
        this.tempUser = user;
    }

    @Override
    public String call() throws Exception {

        while ((newUser = registrationService.getNewUser()) == null) {
            registrationService.initNewUser();
        }

        newUser.setFirstName(tempUser.getFirstName());
        newUser.setLastName(tempUser.getLastName());
        newUser.setEmail(tempUser.getEmail());
        newUser.setAge(tempUser.getAge());
        newUser.setGender(tempUser.getGender());
        newUser.setAcademicDegree(tempUser.getAcademicDegree());

        registrationService.register();

        return this.tempUser.getFirstName();
    }
}
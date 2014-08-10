package com.eduict.servlet.async;

import java.util.concurrent.Callable;


public class LoginTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "logintask";
    }
}
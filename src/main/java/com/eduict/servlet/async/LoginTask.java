package com.eduict.servlet.async;

import java.util.concurrent.Callable;
import java.util.logging.Logger;
import javax.inject.Inject;

public class LoginTask implements Callable<String> {

    @Inject
    private Logger log;
  
    @Override
    public String call() throws Exception {
        log.info("LoginTask call()");
        return "logintask";
    }
}
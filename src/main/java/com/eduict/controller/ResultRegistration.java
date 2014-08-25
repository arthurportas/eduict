package com.eduict.controller;

import com.eduict.model.Result;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateful
@Model
public class ResultRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Result> resultEventSrc;

    private Result newResult;

    @Produces
    @Named
    public Result getNewResult() {
        return newResult;
    }

    public void register() throws Exception {
        log.info("Registering " + newResult.getResultValue());
        em.persist(newResult);
        resultEventSrc.fire(newResult);
        initNewResult();
    }

    public Result lookupResultById(long id) {
        return em.find(Result.class, id);
    }
    
    @PostConstruct
    public void initNewResult() {
        newResult = new Result();
    }
}

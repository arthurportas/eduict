package com.eduict.controller;

import com.eduict.model.Response;

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
public class ResponseRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Response> responseEventSrc;

    private Response newResponse;

    @Produces
    @Named
    public Response getNewResponse() {
        return newResponse;
    }

    public void register() throws Exception {
        log.info("Registering " + newResponse.getResponse());
        em.persist(newResponse);
        responseEventSrc.fire(newResponse);
        initNewResponse();
    }

    @PostConstruct
    public void initNewResponse() {
        newResponse = new Response();
    }
}

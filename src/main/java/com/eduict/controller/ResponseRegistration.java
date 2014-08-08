package com.eduict.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eduict.model.Response;

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

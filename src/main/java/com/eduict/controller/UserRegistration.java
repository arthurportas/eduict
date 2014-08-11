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

import com.eduict.model.User;

@Stateful
@Model
public class UserRegistration {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<User> userEventSrc;

   private User newUser;

   @Produces
   @Named
   public User getNewUser() {
      return newUser;
   }

   public void register() throws Exception {
      log.info("Registering " + newUser.getEmail());
      em.persist(newUser);
      userEventSrc.fire(newUser);
      initNewUser();
   }

   @PostConstruct
   public void initNewUser() {
      newUser = new User();
   }
}

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

import com.eduict.model.Domain;

// The @Stateful annotation eliminates the need for manual transaction demarcation
@Stateful
// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class DomainRegistration {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<Domain> domainEventSrc;

   private Domain newDomain;

   @Produces
   @Named
   public Domain getNewDomain() {
      return newDomain;
   }

   public void register() throws Exception {
      log.info("Registering " + newDomain.getDescription());
      em.persist(newDomain);
      domainEventSrc.fire(newDomain);
      initNewDomain();
   }

   @PostConstruct
   public void initNewDomain() {
      newDomain = new Domain();
   }
}

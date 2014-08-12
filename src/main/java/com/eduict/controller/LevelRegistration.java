package com.eduict.controller;

import com.eduict.model.Level;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateful annotation eliminates the need for manual transaction demarcation
@Stateful
// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class LevelRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Level> levelEventSrc;

    private Level newLevel;

    @Produces
    @Named
    public Level getNewLevel() {
        return newLevel;
    }

    public void register() throws Exception {
        log.info("Registering " + newLevel.getDescription());
        em.persist(newLevel);
        levelEventSrc.fire(newLevel);
        initNewLevel();
    }

    @PostConstruct
    public void initNewLevel() {
        newLevel = new Level();
    }
}

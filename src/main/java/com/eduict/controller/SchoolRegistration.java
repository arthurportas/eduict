package com.eduict.controller;

import com.eduict.model.School;

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
public class SchoolRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<School> schoolEventSrc;

    private School newSchool;

    @Produces
    @Named
    public School getNewSchool() {
        return newSchool;
    }

    public void register() throws Exception {
        log.info("Registering " + newSchool.getSchoolName());
        em.persist(newSchool);
        schoolEventSrc.fire(newSchool);
        initNewSchool();
    }

    @PostConstruct
    public void initNewSchool() {
        newSchool = new School();
    }
}

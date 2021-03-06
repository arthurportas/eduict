package com.eduict.controller;

import com.eduict.model.Question;

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
public class QuestionRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Question> questionEventSrc;

    private Question newQuestion;

    @Produces
    @Named
    public Question getNewQuestion() {
        return newQuestion;
    }

    public void register() throws Exception {
        log.info("Registering " + newQuestion.getQuestion());
        em.persist(newQuestion);
        questionEventSrc.fire(newQuestion);
        initNewQuestion();
    }

    @PostConstruct
    public void initNewQuestion() {
        newQuestion = new Question();
    }
}

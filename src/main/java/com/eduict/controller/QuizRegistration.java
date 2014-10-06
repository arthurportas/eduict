package com.eduict.controller;

import com.eduict.model.Quiz;

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
public class QuizRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Quiz> quizEventSrc;

    private Quiz newQuiz;

    @Produces
    @Named
    public Quiz getNewQuiz() {
        return newQuiz;
    }

    public void register() throws Exception {
        log.info("Registering " + newQuiz.getDescription());
        em.persist(newQuiz);
        quizEventSrc.fire(newQuiz);
        initNewQuiz();
    }

    public Quiz lookupQuizById(long id) {
        log.info("Searching quiz with id  " + id);
        return em.find(Quiz.class, id);
    }
    
    @PostConstruct
    public void initNewQuiz() {
        newQuiz = new Quiz();
    }
}

package com.eduict.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eduict.model.Quiz;

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

   @PostConstruct
   public void initNewQuiz() {
      newQuiz = new Quiz();
   }
}

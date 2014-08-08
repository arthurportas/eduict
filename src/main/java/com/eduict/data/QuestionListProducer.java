package com.eduict.data;

import com.eduict.model.Question;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@RequestScoped
public class QuestionListProducer {
   @Inject
   private EntityManager em;

   private List<Question> questions;

   // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<Question> getQuestions() {
      return questions;
   }

   public void onQuestionListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Question question) {
      retrieveAllQuestionOrderedByQuestion();
   }

   @PostConstruct
   public void retrieveAllQuestionOrderedByQuestion() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Question> criteria = cb.createQuery(Question.class);
      Root<Question> question = criteria.from(Question.class);
      criteria.select(question).orderBy(cb.asc(question.get("question")));
      questions = em.createQuery(criteria).getResultList();
   }
}

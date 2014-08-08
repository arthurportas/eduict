package com.eduict.data;

import com.eduict.model.Quiz;
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
public class QuizListProducer {
   @Inject
   private EntityManager em;

   private List<Quiz> quizzes;

   // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<Quiz> getQuizzes() {
      return quizzes;
   }

   public void onQuizListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Quiz quiz) {
      retrieveAllQuizzesOrderedByDescription();
   }

   @PostConstruct
   public void retrieveAllQuizzesOrderedByDescription() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Quiz> criteria = cb.createQuery(Quiz.class);
      Root<Quiz> quiz = criteria.from(Quiz.class);
      criteria.select(quiz).orderBy(cb.asc(quiz.get("description")));
      quizzes = em.createQuery(criteria).getResultList();
   }
}

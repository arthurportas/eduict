package com.eduict.data;

import com.eduict.model.Quiz;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequestScoped
public class QuizListProducer {

    @PersistenceContext(type=javax.persistence.PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Quiz> quizzes;

    // @Named provides access the return value via the EL variable name "quizzes" in the UI (e.g.,
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

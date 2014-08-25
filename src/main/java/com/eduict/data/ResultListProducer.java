package com.eduict.data;

import com.eduict.model.Result;

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
import java.util.List;

@RequestScoped
public class ResultListProducer {
    
    @Inject
    private EntityManager em;

    private List<Result> results;

    @Produces
    @Named
    public List<Result> getResults() {
        return results;
    }

    public void onResultListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Result result) {
        retrieveAllResultsOrderedById();
    }

    @PostConstruct
    public void retrieveAllResultsOrderedById() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Result> criteria = cb.createQuery(Result.class);
        Root<Result> result = criteria.from(Result.class);
        criteria.select(result).orderBy(cb.asc(result.get("id")));
        results = em.createQuery(criteria).getResultList();
    }
}

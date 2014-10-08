package com.eduict.data;

import com.eduict.model.Response;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequestScoped
public class ResponseListProducer {
    
    @PersistenceContext(type=javax.persistence.PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Response> responses;

    @Produces
    @Named
    public List<Response> getResponses() {
        return responses;
    }

    public void onResponseListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Response response) {
        retrieveAllResponsesOrderedByQuestion();
    }

    @PostConstruct
    public void retrieveAllResponsesOrderedByQuestion() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Response> criteria = cb.createQuery(Response.class);
        Root<Response> response = criteria.from(Response.class);
        criteria.select(response).orderBy(cb.asc(response.get("response")));
        responses = em.createQuery(criteria).getResultList();
    }
}

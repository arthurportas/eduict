package com.eduict.rest;

import com.eduict.model.Domain;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/domains")
@RequestScoped
public class DomainResourceRESTService {
    @Inject
    private EntityManager em;

    @GET
    @Produces("text/xml")
    public List<Domain> listAllDomains() {
        @SuppressWarnings("unchecked")
        final List<Domain> results = em.createQuery("select d from Domain d order by d.description").getResultList();
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public Domain lookupDomainById(@PathParam("id") long id) {
        return em.find(Domain.class, id);
    }

    @GET
    @Path("/{id:[0-9][0-9]*}/questions")
    @Produces("text/xml")
    public Domain lookupQuestionPerDomain(@PathParam("id") long id) {
        return em.find(Domain.class, id);
      /*return em.createNamedQuery(Domain.FIND_ALL_QUESTIONS_PER_DOMAIN_ID)
            .setParameter("id", id)
            .getSingleResult();*/
    }
}

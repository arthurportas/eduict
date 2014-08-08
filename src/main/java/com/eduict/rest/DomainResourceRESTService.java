package com.eduict.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.eduict.model.Domain;

import javax.ejb.Remove;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;

@Path("/domains")
@RequestScoped
@TransactionManagement(value=TransactionManagementType.CONTAINER)
@TransactionAttribute(value=REQUIRED)
public class DomainResourceRESTService {
   @Inject
   private EntityManager em;

   @GET
   @Produces("text/xml")
   public List<Domain> listAllDomains() {
      // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
      // this query
      @SuppressWarnings("unchecked")
      // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
      // the @Entity class
      // as described in the named query blueprint:
      // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
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

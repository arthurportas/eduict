package com.eduict.data;

import com.eduict.model.Domain;
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
public class DomainListProducer {
   @Inject
   private EntityManager em;

   private List<Domain> domains;

   // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<Domain> getDomains() {
      return domains;
   }

   public void onDomainListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Domain domain) {
      retrieveAllDomainsOrderedByDescription();
   }

   @PostConstruct
   public void retrieveAllDomainsOrderedByDescription() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Domain> criteria = cb.createQuery(Domain.class);
      Root<Domain> domain = criteria.from(Domain.class);
      criteria.select(domain).orderBy(cb.asc(domain.get("description")));
      domains = em.createQuery(criteria).getResultList();
   }
}

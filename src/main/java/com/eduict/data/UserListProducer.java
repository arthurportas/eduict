package com.eduict.data;

import com.eduict.model.User;
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
public class UserListProducer {
   @Inject
   private EntityManager em;

   private List<User> users;

   // @Named provides access the return value via the EL variable name "domains" in the UI (e.g.,
   // Facelets or JSP view)
   @Produces
   @Named
   public List<User> getUsers() {
      return users;
   }

   public void onUserListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final User user) {
      retrieveAllUsersOrderedByEmail();
   }

   @PostConstruct
   public void retrieveAllUsersOrderedByEmail() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<User> criteria = cb.createQuery(User.class);
      Root<User> user = criteria.from(User.class);
      criteria.select(user).orderBy(cb.asc(user.get("email")));
      users = em.createQuery(criteria).getResultList();
   }
}

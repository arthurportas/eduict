package com.eduict.data;

import com.eduict.model.User;

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
public class UserProducer {
    @Inject
    private EntityManager em;

    private User user;

    @Produces
    @Named
    public User getUser() {
        return user;
    }

    public void onUserChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final User user) {
        retrieveUserByEmail(user.getEmail());
    }

    @PostConstruct
    public User retrieveUserByEmail(String email) {
        return user = (User)em.createNamedQuery(User.FIND_BY_EMAIL)
        .setParameter("email", email)
        .getSingleResult();
    }
}

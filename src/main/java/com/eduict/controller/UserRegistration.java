package com.eduict.controller;

import com.eduict.model.User;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.logging.Logger;

@Stateful
@Model
public class UserRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<User> userEventSrc;

    private User newUser;

    @Produces
    @Named
    public User getNewUser() {
        return newUser;
    }

    public void register() throws Exception {
        log.info("Registering " + newUser.getEmail());
        em.persist(newUser);
        userEventSrc.fire(newUser);
        initNewUser();
    }

    public User lookupUserById(long id) throws Exception {
        return em.find(User.class, id);
    }

    public User lookupUserByEmailAndPassword(String email, String password) {
        try {
            return (User) em.createNamedQuery(User.FIND_BY_EMAIL_AND_PASSWORD)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public User lookupUserByEmail(String email) {
        try {
            return (User) em.createNamedQuery(User.FIND_BY_EMAIL)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public User changePasswordRequest(String email) {
        try {
            User user = (User) em.createNamedQuery(User.FIND_BY_EMAIL)
                    .setParameter("email", email)
                    .getSingleResult();
            return user;
        } catch (NoResultException nre) {
            return null;
        }
    }

    @PostConstruct
    public void initNewUser() {
        newUser = new User();
    }
}

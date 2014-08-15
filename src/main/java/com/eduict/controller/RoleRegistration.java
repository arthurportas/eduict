package com.eduict.controller;

import com.eduict.model.Role;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateful
@Model
public class RoleRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Role> roleEventSrc;

    private Role newRole;

    @Produces
    @Named
    public Role getNewRole() {
        return newRole;
    }

    public void register() throws Exception {
        log.info("Registering " + newRole.getRoleName());
        em.persist(newRole);
        roleEventSrc.fire(newRole);
        initNewRole();
    }

    public Role lookupRoleById(long id) {
        return em.find(Role.class, id);
    }
    
    @PostConstruct
    public void initNewRole() {
        newRole= new Role();
    }
}

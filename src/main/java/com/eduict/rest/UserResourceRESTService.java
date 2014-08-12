package com.eduict.rest;

import com.eduict.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/users")
@RequestScoped
public class UserResourceRESTService {
    @Inject
    private EntityManager em;

    @GET
    @Produces("text/xml")
    public List<User> listAllUsers() {
        @SuppressWarnings("unchecked")
        final List<User> results = em.createQuery("select u from User u order by u.email").getResultList();
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public User lookupUserById(@PathParam("id") long id) {
        return em.find(User.class, id);
    }
}

package com.eduict.rest;

import com.eduict.model.Role;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/roles")
@RequestScoped
public class RoleResourceRESTService {
    
    @Inject
    private EntityManager em;

    @GET
    @Produces("text/xml")
    public List<Role> listAllRoles() {
        @SuppressWarnings("unchecked")
        final List<Role> results = em.createQuery("select r from Role r order by r.roleName").getResultList();
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public Role lookupRoleById(@PathParam("id") long id) {
        return em.find(Role.class, id);
    }
}

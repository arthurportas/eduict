package com.eduict.rest;

import com.eduict.model.Level;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read the contents of the domains table.
 */
@Path("/levels")
@RequestScoped
public class LevelResourceRESTService {
    @Inject
    private EntityManager em;

    @GET
    @Produces("text/xml")
    public List<Level> listAllLevels() {
        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
        // this query
        @SuppressWarnings("unchecked")
        // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
        // the @Entity class
        // as described in the named query blueprint:
        // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
        final List<Level> results = em.createQuery("select l from Level l order by l.description").getResultList();
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public Level lookupLevelById(@PathParam("id") long id) {
        return em.find(Level.class, id);
    }
}

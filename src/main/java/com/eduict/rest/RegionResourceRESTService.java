package com.eduict.rest;

import com.eduict.model.Region;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/regions")
@RequestScoped
public class RegionResourceRESTService {
    @Inject
    private EntityManager em;

    @GET
    @Produces("text/xml")
    public List<Region> listAllRegions() {
        @SuppressWarnings("unchecked")
        final List<Region> results = em.createQuery("select r from Region r order by r.regionName").getResultList();
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public Region lookupDomainById(@PathParam("id") long id) {
        return em.find(Region.class, id);
    }
}

package com.eduict.rest;

import com.eduict.model.School;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/schools")
@RequestScoped
public class SchoolResourceRESTService {
    
    @Inject
    private EntityManager em;

    @GET
    @Produces("text/xml")
    public List<School> listAllSchools() {
        @SuppressWarnings("unchecked")
        final List<School> results = em.createQuery("select s from School s order by s.schoolName").getResultList();
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public School lookupSchoolById(@PathParam("id") long id) {
        return em.find(School.class, id);
    }
}

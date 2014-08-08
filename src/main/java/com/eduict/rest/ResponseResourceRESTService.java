package com.eduict.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.eduict.model.Response;

/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the domains table.
 */
@Path("/responses")
@RequestScoped
public class ResponseResourceRESTService {
   @Inject
   private EntityManager em;

   @GET
   @Produces("text/xml")
   public List<Response> listAllResponses() {
      @SuppressWarnings("unchecked")
      final List<Response> results = em.createQuery("select r from Response r order by r.response").getResultList();
      return results;
   }

   @GET
   @Path("/{id:[0-9][0-9]*}")
   @Produces("text/xml")
   public Response lookupResponseById(@PathParam("id") long id) {
      return em.find(Response.class, id);
   }
}

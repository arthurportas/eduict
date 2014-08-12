package com.eduict.rest;

import com.eduict.model.Quiz;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/quizzes")
@RequestScoped
public class QuizResourceRESTService {
    @Inject
    private EntityManager em;

    @GET
    @Produces("text/xml")
    public List<Quiz> listAllQuizzes() {
        @SuppressWarnings("unchecked")
        final List<Quiz> results = em.createQuery("select q from Quiz q order by q.description").getResultList();
        return results;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public Quiz lookupQuizById(@PathParam("id") long id) {
        return em.find(Quiz.class, id);
    }

}

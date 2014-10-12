package com.eduict.data;

import com.eduict.model.School;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequestScoped
public class SchoolListProducer {
    
    @PersistenceContext(type=javax.persistence.PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<School> schools;

    @Produces
    @Named
    public List<School> getSchools() {
        return schools;
    }

    public void onSchoolListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final School school) {
        retrieveAllSchoolsOrderedByName();
    }

    @PostConstruct
    public void retrieveAllSchoolsOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<School> criteria = cb.createQuery(School.class);
        Root<School> school = criteria.from(School.class);
        criteria.select(school).orderBy(cb.asc(school.get("schoolName")));
        schools = em.createQuery(criteria).getResultList();
    }

    public School findSchoolById(Long id) {
        return em.find(School.class, id);
    }
}

package com.eduict.data;

import com.eduict.model.Level;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequestScoped
public class LevelListProducer {
    
    @PersistenceContext(type=javax.persistence.PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Level> levels;

    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
    // Facelets or JSP view)
    @Produces
    @Named
    public List<Level> getLevels() {
        return levels;
    }

    public void onLevelListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Level level) {
        retrieveAllLevelsOrderedByDescription();
    }

    @PostConstruct
    public void retrieveAllLevelsOrderedByDescription() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Level> criteria = cb.createQuery(Level.class);
        Root<Level> level = criteria.from(Level.class);
        criteria.select(level).orderBy(cb.asc(level.get("description")));
        levels = em.createQuery(criteria).getResultList();
    }
    
    public List<Level> levels() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Level> criteria = cb.createQuery(Level.class);
        Root<Level> level = criteria.from(Level.class);
        criteria.select(level).orderBy(cb.asc(level.get("id")));
        return levels = em.createQuery(criteria).getResultList();
    }
    
}

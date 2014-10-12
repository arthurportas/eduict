package com.eduict.data;

import com.eduict.model.Region;

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
public class RegionListProducer {
    
    @PersistenceContext(type=javax.persistence.PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Region> regions;

    @Produces
    @Named
    public List<Region> getRegions() {
        return regions;
    }

    public void onRegionListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Region region) {
        retrieveAllRegionsOrderedByName();
    }

    @PostConstruct
    public void retrieveAllRegionsOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Region> criteria = cb.createQuery(Region.class);
        Root<Region> region = criteria.from(Region.class);
        criteria.select(region).orderBy(cb.asc(region.get("regionName")));
        regions = em.createQuery(criteria).getResultList();
    }

    public Region findRegionById(Long id) {
        return em.find(Region.class, id);
    }
}

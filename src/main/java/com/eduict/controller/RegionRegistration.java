package com.eduict.controller;

import com.eduict.model.Region;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateful
@Model
public class RegionRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Region> regionEventSrc;

    private Region newRegion;

    @Produces
    @Named
    public Region getNewRegion() {
        return newRegion;
    }

    public void register() throws Exception {
        log.info("Registering " + newRegion.getRegionName());
        em.persist(newRegion);
        regionEventSrc.fire(newRegion);
        initNewRegion();
    }

    @PostConstruct
    public void initNewRegion() {
        newRegion = new Region();
    }
}

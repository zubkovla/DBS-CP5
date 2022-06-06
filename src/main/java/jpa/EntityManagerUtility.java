package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
        Steps to persist an entity object.
         1) Create an entity manager factory object - EntityManagerFactory,
         2) Obtain an entity manager from factory - EntityManager,
         3) Initialize entity manager - getTransaction().begin(),
         4) Persist data from entity into relational database - persist(entity),
         5) Close transaction - getTransaction().commit(),
         6) Release resources - close() factory and entity manager
        Tutorial: https://www.javatpoint.com/jpa-entity-manager
 */

/**
 * jpa.repositories.EntityManagerUtility is a singleton which provides single EntityManager (em) based on an EntityManagerFactory (emf)
 */
public class EntityManagerUtility {

    // Name of persistence context from persistence.xml
    private static final String PERSISTENCE_UNIT_NAME = "TOUR_AGENCY_PU_JPA_TEST";

    // Static variable reference of type EntityManagerFactory
    private static EntityManagerFactory emf;

    // Static variable reference of type EntityManager
    private static EntityManager em;

    // Constructor of the class, which prevents object creation outside the class
    private EntityManagerUtility() {
    }

    // Instantiation of EntityManager class
    public static EntityManager getEm() {
        if (em == null) {
            // same as in persistence.xml
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = emf.createEntityManager();
            return em;
        }
        return em;
    }

    // Close EntityManager and EntityManagerFactory
    public void close() {
        this.em.clear(); // this may be obsolete, but is used for consistency
        this.em.close();
        this.emf.close();
    }
}


package jpa.DAO;

import jpa.EntityManagerUtility;
import jpa.modelEntities.Itinerary;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Date;

public class ItineraryRepository {

    private EntityManager em = EntityManagerUtility.getEm();
    private EntityTransaction et = em.getTransaction();

    // CRUD

    public void add(Itinerary itinerary) {
        et.begin();
        try {
            em.persist(itinerary);
            et.commit();
            System.out.println("Itinerary added: " + itinerary.toString());
        } catch (Exception ex) {
            et.rollback();
        }
    }

    public Itinerary find(Integer id) {
        Itinerary itinerary = em.find(Itinerary.class, id);
        if (itinerary != null) {
            System.out.println("Itinerary found: " + itinerary.toString());
        }
        return itinerary;
    }

//    public Itinerary update(Itinerary itinerary) {
//        Itinerary itineraryToUpdate = find(itinerary.getId());
//        et.begin();
//
//        et.commit();
//        em.clear();
//        System.out.println("Itinerary updated: " + itineraryToUpdate.toString());
//        return itineraryToUpdate;
//    }

    public void remove(Itinerary itinerary) {
        try {
            et.begin();
            em.remove(itinerary);
            et.commit();
            em.clear();
            System.out.println("Itinerary removed: " + itinerary.toString());
        } catch (Exception ex) {
        }
    }

    public void close() {
        this.em.close();
    }

    // Other

    public Boolean changeDateTime(Integer eventId, LocalDate d, LocalTime tf, LocalTime tt) {
        try {
            et.begin();
            Query query = em.createQuery("update Itinerary set eventdate = :d, timefrom = :tf, timeto = :tt where id = :eventid");
            query.setParameter("d", d);
            query.setParameter("tf", tf);
            query.setParameter("tt", tt);
            query.setParameter("eventid", eventId);
            et.commit();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

}

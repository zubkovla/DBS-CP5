package jpa.DAO;

import jpa.EntityManagerUtility;
import jpa.modelEntities.Passenger;
import org.eclipse.persistence.sessions.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.Connection;
import java.util.List;

public class PassengerRepository {

    // Ask for instance of EntityManager from EntityManagerUtility
    private EntityManager em = EntityManagerUtility.getEm();

    /* EntityManager.getTransaction()
    An application-managed entity manager vs a container-managed entity manager, latter must be a JTA entity manager
    https://stackoverflow.com/questions/8464370/jpa-when-to-use-gettransaction-when-persisting-objects
    https://stackoverflow.com/questions/13489057/differences-between-container-managed-and-application-managed-entitymanager
    https://docs.oracle.com/cd/E19798-01/821-1841/bnbqz/index.html
    i.e. we are using application-managed entity manager
    */
    // Make a shortcut to EntityTransaction interface
    private EntityTransaction et = em.getTransaction();

    /*
    Contents:
    - Basic methods (CRUDL) - these are good candidates for generic DAO
    - Other methods - entity specific methods
    - Utility methods (i.e. close EntityManager)
     */

    // - Basic methods
    /* CRUD(L) methods: Create, Read, Update, Delete, (List).
    We use JPQL queries to accomplish this.
    The methods will be accordingly: (1) add, (2) findPassenger, (3) update, (4) removePassenger, (5) list.
    */

    // (1) - Add a passenger ('Create')
    // 1.1a Add a single passenger
    public void add(Passenger passenger) {
        et.begin();
        try {
            em.persist(passenger);
            et.commit();
            System.out.println("Passenger added: " + passenger.toString());
        } catch (Exception ex) {
            et.rollback();
        }
    }

    // 1.1b overload add method to add multiple passengers
    public void add(List<Passenger> passengers) {
        et.begin();
        try {
            for (Passenger passenger : passengers) {
                em.merge(passenger);
                et.commit();
                System.out.println("Passenger added: " + passenger.toString());
            }
        } catch (Exception ex) {
            et.rollback();
        }
    }

    // 1.2 copy
//    public void copy(Integer fromId, Integer toId) {
//        Passenger passengerFrom = em.find(Passenger.class, fromId);
//        try {
//            et.begin();
//            Query query = em.createNativeQuery("insert into passenger(grouppaxid, name, surname, dateofbirth, arrivalticketno, departureticketno, passportcountry, passportno, insurancecompany, insuranceno)\n" +
//                    "select grouppaxid, name, surname, dateofbirth, arrivalticketno, departureticketno, passportcountry, passportno, insurancecompany, insuranceno\n" +
//                    "from passenger where passengerid = :fromId");
//            query.setParameter("fromId", fromId);
////            query.setParameter("toId", toId );
//            et.commit();
//            em.refresh(passengerFrom);
//            System.out.println("Copied from " + fromId + " to " + toId + " " + passengerFrom.toString());
//        } catch (Exception ex) {
//            et.rollback();
//        }
//    }

    // (2) - Find a passenger ('Read')
    // 2.1 findPassenger by native EntityManager 'find' method
    public Passenger findPassenger(Integer id) {
        Session session = em.unwrap(Session.class); // get session object from EntityManager
        System.out.println("Sesson: " + session.toString());
        et.begin();
        java.sql.Connection connection = em.unwrap(java.sql.Connection.class); // check database connection
        et.commit();
        System.out.println("Connected to: " + connection.toString());
        // find a passenger by id by native EntityManager's 'find' method
        Passenger passenger = em.find(Passenger.class, id);
        if (passenger != null) {
            System.out.println("Passenger found: " + passenger.toString());
        } else {
            System.out.println("Passenger with id " + id + " was not found in the database, return " + passenger);
        }
        return passenger;
    }

    // 2.2 findPassenger by id, JPQL query
    public Passenger findPassengerById(Integer id) {
        // prevent SQL injection by avoiding concatenating with user-controlled variables, using parametrised queries
        Query query = em.createQuery("Select p from Passenger p where p.id = :id");
        query.setParameter("id", id);
        Passenger passenger = (Passenger) query.getSingleResult();
        if (passenger != null) {
            System.out.println("Passenger found: " + passenger.toString());
        }
        return passenger;
    }

    // (3) - Update a passenger
    // 3.1 update property ('name') by id
    public Passenger updatePassengerFirstNameByIdEntityManager(String name, Integer id) {
        Passenger passengerUpdated = em.find(Passenger.class, id); // add an entity to persistence context
        System.out.println("This passenger will be updated: " + passengerUpdated.toString());
        et.begin();
        passengerUpdated.setName(name);
        et.commit(); // enter new data to the database
        em.clear(); // clear the persistence context
        System.out.println("Return updated passenger from database: " + passengerUpdated.toString());
        return passengerUpdated;
    }

    public Passenger updatePassengerFirstNameByIdJPQL(String name, Integer id) {
        System.out.println("This passenger will be updated: " + em.find(Passenger.class, id).toString());
        et.begin();
        // prevent SQL injection by avoiding concatenating with user-controlled variables, using parametrised queries instead
        Query query = em.createQuery("update Passenger set name = :name where id = :id");
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
        et.commit(); // enter new data to the database
        Passenger passengerUpdated = em.find(Passenger.class, id); // add an entity to persistence context, however it is loaded from repository
        em.refresh(passengerUpdated); // refresh entity manager object from database - this is needed to return actual db-data
        em.clear(); // clear the persistence context
        System.out.println("Return updated passenger from database: " + passengerUpdated.toString());
        return passengerUpdated;
    }

    // (4) - Remove a passenger ('Delete')
    // 4.1 removePassenger by native EntityManager 'remove' method
    // Note: it is easier to operate by id on complex entities, rather than address them directly
    public Passenger removePassenger(Integer id) {
        try {
            Passenger passengerToDelete = em.find(Passenger.class, id);
            et.begin();
            em.remove(passengerToDelete);
            et.commit();
            em.clear();
            System.out.println("Passenger removed: " + passengerToDelete.toString());
            return passengerToDelete;
        } catch (Exception ex) {
            System.out.println("No passenger found, returning " + em.find(Passenger.class, id));
            et.rollback();
        }
        return null;
    }

    // 4.2 removePassenger by id using JPQL query
    public Passenger removePassengerById(Integer id) {
        Passenger passengerToDelete = em.find(Passenger.class, id);
        et.begin();
        Query query = em.createQuery("Delete from Passenger where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        et.commit();
        em.clear();
        System.out.println("Passenger removed: " + passengerToDelete.toString());
        return passengerToDelete;
    }

    // (5) - List
    // 5.1a findPassengerByFirstName using JPQL query ('%like%')
    public List<Passenger> findPassengerByFirstNameLike(String name) {
        Query query = em.createQuery("Select p from Passenger p where p.name like :name order by p.surname asc");
        query.setParameter("name", '%' + name + '%');
        List<Passenger> passengerList = query.getResultList();
        for (Passenger passenger : passengerList) {
            System.out.println(passenger.toString());
        }
        System.out.println("Total passengers with '" + name + "' in the name found: "
                + passengerList.size() + " pax; returning " + passengerList.size() + " pax.");
        return passengerList;
    }

    // 5.1b overload findPassengerByFirstName with optional limit query result parameter
    public List<Passenger> findPassengerByFirstNameLike(String name, Integer limit) {
        if (limit == null) {
            limit = 0;
        }
        Query query = em.createQuery("Select p from Passenger p where p.name like :name order by p.surname asc");
        query.setParameter("name", '%' + name + '%');
        List<Passenger> passengerList = query.getResultList();
        List<Passenger> passengerListLimit = query.setMaxResults(limit).getResultList();
        for (Passenger passenger : passengerListLimit) {
            System.out.println(passenger.toString());
        }
        System.out.println("Total passengers with '" + name + "' in the name found: "
                + passengerList.size() + " pax; displaying and returning first "
                + passengerListLimit.size() + " pax, (limit was " + limit + ").");
        return passengerListLimit;
    }

    // 5.2a - list by id with limit
    public List<Passenger> listPassengerByIdAndLimit(Integer limit) {
        // the following query is a 'SELECT *' in JPQL, use 'order by p.id' to retrieve fixed list, as it will otherwise change its order after update
        Query query = em.createQuery("Select p from Passenger p order by p.id asc");
        List<Passenger> passengerListLimit = query.setFirstResult(0).setMaxResults(limit).getResultList();
        System.out.println("< List starts from 1 to " + limit + ":");
        for (Passenger passenger : passengerListLimit) {
            System.out.println(passenger.toString());
        }
        System.out.println("> List ends.");
        return passengerListLimit;
    }

    // 5.2b - overload method list by id with limit, including starting id
    public List<Passenger> listPassengerByIdAndLimit(Integer startId, Integer limit) {
        // the following query is a 'SELECT *' in JPQL, use 'order by p.id' to retrieve fixed list, as it will otherwise change its order after update
        Query query = em.createQuery("Select p from Passenger p order by p.id asc");
        List<Passenger> passengerListLimit = query.setFirstResult(startId).setMaxResults(limit).getResultList();
        System.out.println("< List starts from " + (startId + 1) + " to " + limit + ":");
        for (Passenger passenger : passengerListLimit) {
            System.out.println(passenger.toString());
        }
        System.out.println("> List ends.");
        return passengerListLimit;
    }


    // count
    public Long count() {
        Query query = em.createQuery("Select count(p) from Passenger p");
        Long result = (Long) query.getSingleResult();
        System.out.println("Total in PassengerRepository: " + result + " lines, (value returned).");
        return result;
    }


    // - Other methods
    // Named queries are self-explanatory,
    // List passengers by condition:
    // 1
    public List<Passenger> listPassengerByExcludingCountrySortBySurnameDesc(String excludingCountry) {
        Query query = em.createNamedQuery("Passenger.listByExcludingCountrySortSurnameDesc");
        query.setParameter("country", excludingCountry);
        System.out.println(query.getResultList().toString());
        System.out.println("Total: " + query.getResultList().stream().count() + " pax.");
        return query.getResultList();
    }

    // 2
    public List<Passenger> listPassengerByCountryAndExcludingPartialSurnameSortByNameDesc(String country, String excludingSurnamePart) {
        Query query = em.createNamedQuery("Passenger.listByCountryAndExcludingPartialSurnameSortByNameDesc");
        query.setParameter("country", country);
        query.setParameter("surname", '%' + excludingSurnamePart + '%');
        System.out.println(query.getResultList().toString());
        System.out.println("Total: " + query.getResultList().stream().count() + " pax.");
        return query.getResultList();
    }

    // 3
    public List<Integer> countPassengerPaxPerMothByYearOfBirthWithHurdleAmount(Integer yearSelected, Integer hurdleAmount) {
        Query query = em.createNamedQuery("Passenger.countPaxPerMothByYearOfBirth");
        query.setParameter("year", yearSelected);
        query.setParameter("amount", hurdleAmount);
        System.out.println(query.getResultList());
        System.out.println("Total: " + query.getResultList().stream().count() + " values.");
        return query.getResultList();
    }

    // - Utility methods
    // Method to ask to close EntityManager and EntityManagerFactory using EntityManagerUtility.
    public void close() {
        this.em.close();
    }

}

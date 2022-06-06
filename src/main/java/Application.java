import jpa.DAO.ItineraryRepository;
import jpa.DAO.PassengerRepository;
import org.eclipse.persistence.logging.AbstractSessionLog;
import org.eclipse.persistence.logging.SessionLog;
import org.eclipse.persistence.sessions.DatabaseLogin;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.UnitOfWork;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // Simple methods on PassengerRepository
        PassengerRepository passengerRepository = new PassengerRepository();

        // 1 Find - Read
//        passengerRepository.findPassenger(1);
//        passengerRepository.findPassenger(36001);

        // 2 Update
//        passengerRepository.updatePassengerFirstNameByIdEntityManager("Stinky", 1);
//        passengerRepository.updatePassengerFirstNameByIdJPQL("Damian", 1);

        // 3 List - Read
//        passengerRepository.listPassengerByIdAndLimit(0,3);

        // 4 Remove - Delete
//        Passenger deletedPassenger = passengerRepository.removePassenger(1);
//        passengerRepository.listPassengerByIdAndLimit(3);
//        passengerRepository.removePassenger(0);

        // 5 Add - Create
//        passengerRepository.add(deletedPassenger);
//        passengerRepository.listPassengerByIdAndLimit(3);

        // 6 Copy - Create
//        passengerRepository.copy(135,36001);
//        passengerRepository.count();

        // Other methods
//        passengerRepository.findPassengerByFirstNameLike("tink", 25);
//        passengerRepository.count();

        // Named Queries
//        passengerRepository.listPassengerByCountryAndExcludingPartialSurnameSortByNameDesc("China", "A");
//        passengerRepository.countPassengerPaxPerMothByYearOfBirthWithHurdleAmount(1951, 300);

       passengerRepository.close();
//
//        ItineraryRepository itineraryRepository = new ItineraryRepository();
//        itineraryRepository.changeDateTime(2, LocalDate.of(2022, 4, 30),
//                LocalTime.of(17, 15), LocalTime.of(18, 35));
//
//        itineraryRepository.find(2);
//
//        itineraryRepository.close();

//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        employeeRepository.find("775-706-2386");
//        employeeRepository.close();

    }
}

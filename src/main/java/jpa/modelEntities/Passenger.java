package jpa.modelEntities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Passenger.listByExcludingCountrySortSurnameDesc",
                query = "SELECT p FROM Passenger p WHERE p.passportcountry.id <> :country ORDER BY p.passportcountry.id, p.surname DESC"),

        @NamedQuery(name = "Passenger.listByCountryAndExcludingPartialSurnameSortByNameDesc",
                query = "SELECT p FROM Passenger p WHERE p.passportcountry.id = :country AND p.surname NOT LIKE :surname " +
                        "ORDER BY p.surname DESC"),

        @NamedQuery(name = "Passenger.countPaxPerMothByYearOfBirth",
                query = "SELECT COUNT(p) FROM Passenger p " +
                        "WHERE func('DATE_PART', 'YEAR', p.dateofbirth) = :year " +
                        "GROUP BY func('DATE_PART', 'MONTH', p.dateofbirth)" +
                        "HAVING COUNT(p) >= :amount " +
                        "ORDER BY avg(func('DATE_PART', 'MONTH', p.dateofbirth)) DESC")
})
@Table(name = "passenger", indexes = {
        @Index(name = "passenger_idx_year_of_birth", columnList = "date_part('year'::text, dateofbirth)")
})
public class Passenger {
    @Id
    @Column(name = "passengerid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "grouppaxid")
    private Grouppax grouppaxid;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "dateofbirth", nullable = false)
    private LocalDate dateofbirth;

    @Column(name = "arrivalticketno", nullable = false, length = 40)
    private String arrivalticketno;

    @Column(name = "departureticketno", nullable = false, length = 40)
    private String departureticketno;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "passportcountry")
    private Country passportcountry;

    @Column(name = "passportno", nullable = false, length = 20)
    private String passportno;

    @Column(name = "insurancecompany", nullable = false, length = 150)
    private String insurancecompany;

    @Column(name = "insuranceno", nullable = false, length = 40)
    private String insuranceno;

    @OneToMany(mappedBy = "passengerid")
    private Set<Contact> contacts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "passengerid")
    private Set<Itinerary> itineraries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "passengerid")
    private Set<Accommodation> accommodations = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Grouppax getGrouppaxid() {
        return grouppaxid;
    }

    public void setGrouppaxid(Grouppax grouppaxid) {
        this.grouppaxid = grouppaxid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getArrivalticketno() {
        return arrivalticketno;
    }

    public void setArrivalticketno(String arrivalticketno) {
        this.arrivalticketno = arrivalticketno;
    }

    public String getDepartureticketno() {
        return departureticketno;
    }

    public void setDepartureticketno(String departureticketno) {
        this.departureticketno = departureticketno;
    }

    public Country getPassportcountry() {
        return passportcountry;
    }

    public void setPassportcountry(Country passportcountry) {
        this.passportcountry = passportcountry;
    }

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    public String getInsurancecompany() {
        return insurancecompany;
    }

    public void setInsurancecompany(String insurancecompany) {
        this.insurancecompany = insurancecompany;
    }

    public String getInsuranceno() {
        return insuranceno;
    }

    public void setInsuranceno(String insuranceno) {
        this.insuranceno = insuranceno;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(Set<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public Set<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(Set<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", grouppaxid=" + grouppaxid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", arrivalticketno='" + arrivalticketno + '\'' +
                ", departureticketno='" + departureticketno + '\'' +
                ", passportcountry=" + passportcountry +
                ", passportno='" + passportno + '\'' +
                ", insurancecompany='" + insurancecompany + '\'' +
                ", insuranceno='" + insuranceno + '\'' +
                ", contacts=" + contacts +
                ", itineraries=" + itineraries +
                ", accommodations=" + accommodations +
                '}';
    }
}
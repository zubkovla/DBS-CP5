package jpa.modelEntities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "itinerary")
public class Itinerary {
    @Id
    @Column(name = "itineraryid", nullable = false)
    private Integer id;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "transportplate")
    private Transport transportplate;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "excursionid")
    private Excursion excursionid;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeephone")
    private Employee employeephone;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "grouppaxid")
    private Grouppax grouppaxid;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "passengerid")
    private Passenger passengerid;

    @Column(name = "eventdate", nullable = false)
    private LocalDate eventdate;

    @Column(name = "timefrom", nullable = false)
    private LocalTime timefrom;

    @Column(name = "timeto", nullable = false)
    private LocalTime timeto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transport getTransportplate() {
        return transportplate;
    }

    public void setTransportplate(Transport transportplate) {
        this.transportplate = transportplate;
    }

    public Excursion getExcursionid() {
        return excursionid;
    }

    public void setExcursionid(Excursion excursionid) {
        this.excursionid = excursionid;
    }

    public Employee getEmployeephone() {
        return employeephone;
    }

    public void setEmployeephone(Employee employeephone) {
        this.employeephone = employeephone;
    }

    public Grouppax getGrouppaxid() {
        return grouppaxid;
    }

    public void setGrouppaxid(Grouppax grouppaxid) {
        this.grouppaxid = grouppaxid;
    }

    public Passenger getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(Passenger passengerid) {
        this.passengerid = passengerid;
    }

    public LocalDate getEventdate() {
        return eventdate;
    }

    public void setEventdate(LocalDate eventdate) {
        this.eventdate = eventdate;
    }

    public LocalTime getTimefrom() {
        return timefrom;
    }

    public void setTimefrom(LocalTime timefrom) {
        this.timefrom = timefrom;
    }

    public LocalTime getTimeto() {
        return timeto;
    }

    public void setTimeto(LocalTime timeto) {
        this.timeto = timeto;
    }

}
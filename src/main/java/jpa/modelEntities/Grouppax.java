package jpa.modelEntities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "grouppax")
public class Grouppax {
    @Id
    @Column(name = "grouppaxid", nullable = false)
    private Integer id;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "tripid")
    private Trip tripid;

    @Column(name = "groupnumber", nullable = false, length = 15)
    private String groupnumber;

    @Column(name = "dateofarrival", nullable = false)
    private LocalDate dateofarrival;

    @Column(name = "arrivalflightno", nullable = false, length = 10)
    private String arrivalflightno;

    @Column(name = "arrivalflightdate", nullable = false)
    private LocalDate arrivalflightdate;

    @Column(name = "arrivalflighttime", nullable = false)
    private LocalTime arrivalflighttime;

    @Column(name = "departureflightno", length = 10)
    private String departureflightno;

    @Column(name = "departureflightdate")
    private LocalDate departureflightdate;

    @Column(name = "departureflighttime")
    private LocalTime departureflighttime;

    @OneToMany(mappedBy = "grouppaxid")
    private Set<Itinerary> itineraries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "grouppaxid")
    private Set<Transfer> transfers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "grouppaxid")
    private Set<Passenger> passengers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trip getTripid() {
        return tripid;
    }

    public void setTripid(Trip tripid) {
        this.tripid = tripid;
    }

    public String getGroupnumber() {
        return groupnumber;
    }

    public void setGroupnumber(String groupnumber) {
        this.groupnumber = groupnumber;
    }

    public LocalDate getDateofarrival() {
        return dateofarrival;
    }

    public void setDateofarrival(LocalDate dateofarrival) {
        this.dateofarrival = dateofarrival;
    }

    public String getArrivalflightno() {
        return arrivalflightno;
    }

    public void setArrivalflightno(String arrivalflightno) {
        this.arrivalflightno = arrivalflightno;
    }

    public LocalDate getArrivalflightdate() {
        return arrivalflightdate;
    }

    public void setArrivalflightdate(LocalDate arrivalflightdate) {
        this.arrivalflightdate = arrivalflightdate;
    }

    public LocalTime getArrivalflighttime() {
        return arrivalflighttime;
    }

    public void setArrivalflighttime(LocalTime arrivalflighttime) {
        this.arrivalflighttime = arrivalflighttime;
    }

    public String getDepartureflightno() {
        return departureflightno;
    }

    public void setDepartureflightno(String departureflightno) {
        this.departureflightno = departureflightno;
    }

    public LocalDate getDepartureflightdate() {
        return departureflightdate;
    }

    public void setDepartureflightdate(LocalDate departureflightdate) {
        this.departureflightdate = departureflightdate;
    }

    public LocalTime getDepartureflighttime() {
        return departureflighttime;
    }

    public void setDepartureflighttime(LocalTime departureflighttime) {
        this.departureflighttime = departureflighttime;
    }

    public Set<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(Set<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public Set<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Set<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

}
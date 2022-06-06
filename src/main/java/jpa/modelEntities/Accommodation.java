package jpa.modelEntities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "accommodation")
public class Accommodation {
    @Id
    @Column(name = "accomodationid", nullable = false)
    private Integer id;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "facilityid")
    private Facility facilityid;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "passengerid")
    private Passenger passengerid;

    @Column(name = "checkindate", nullable = false)
    private LocalDate checkindate;

    @Column(name = "checkoutdate", nullable = false)
    private LocalDate checkoutdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Facility getFacilityid() {
        return facilityid;
    }

    public void setFacilityid(Facility facilityid) {
        this.facilityid = facilityid;
    }

    public Passenger getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(Passenger passengerid) {
        this.passengerid = passengerid;
    }

    public LocalDate getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(LocalDate checkindate) {
        this.checkindate = checkindate;
    }

    public LocalDate getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(LocalDate checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

}
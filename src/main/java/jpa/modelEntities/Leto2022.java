package jpa.modelEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "leto_2022")
public class Leto2022 {
    @Id
    @Column(name = "itineraryid")
    private Integer itineraryid;

    @Column(name = "transportplate", length = 20)
    private String transportplate;

    @Column(name = "excursionid")
    private Integer excursionid;

    @Column(name = "employeephone", length = 25)
    private String employeephone;

    @Column(name = "grouppaxid")
    private Integer grouppaxid;

    @Column(name = "passengerid")
    private Integer passengerid;

    @Column(name = "eventdate")
    private LocalDate eventdate;

    @Column(name = "timefrom")
    private LocalTime timefrom;

    @Column(name = "timeto")
    private LocalTime timeto;

    public Integer getItineraryid() {
        return itineraryid;
    }

    public String getTransportplate() {
        return transportplate;
    }

    public Integer getExcursionid() {
        return excursionid;
    }

    public String getEmployeephone() {
        return employeephone;
    }

    public Integer getGrouppaxid() {
        return grouppaxid;
    }

    public Integer getPassengerid() {
        return passengerid;
    }

    public LocalDate getEventdate() {
        return eventdate;
    }

    public LocalTime getTimefrom() {
        return timefrom;
    }

    public LocalTime getTimeto() {
        return timeto;
    }

}
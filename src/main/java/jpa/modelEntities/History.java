package jpa.modelEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "history")
public class History {
    @Id
    @Column(name = "historyid", nullable = false)
    private Integer id;

    @Column(name = "stamp")
    private Instant stamp;

    @Column(name = "eventselected", nullable = false)
    private Integer eventselected;

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

    public Instant getStamp() {
        return stamp;
    }

    public void setStamp(Instant stamp) {
        this.stamp = stamp;
    }

    public Integer getEventselected() {
        return eventselected;
    }

    public void setEventselected(Integer eventselected) {
        this.eventselected = eventselected;
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
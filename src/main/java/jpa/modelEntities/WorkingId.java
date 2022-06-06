package jpa.modelEntities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
public class WorkingId implements Serializable {
    private static final long serialVersionUID = -173886195332311274L;
    @Column(name = "attractionid", nullable = false)
    private Integer attractionid;

    @Column(name = "weekday", columnDefinition = "weekdaynumber(10) not null")
    private Integer weekday;

    @Column(name = "timefrom", nullable = false)
    private LocalTime timefrom;

    @Column(name = "timeto", nullable = false)
    private LocalTime timeto;

    public Integer getAttractionid() {
        return attractionid;
    }

    public void setAttractionid(Integer attractionid) {
        this.attractionid = attractionid;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingId entity = (WorkingId) o;
        return Objects.equals(this.timefrom, entity.timefrom) &&
                Objects.equals(this.timeto, entity.timeto) &&
                Objects.equals(this.attractionid, entity.attractionid) &&
                Objects.equals(this.weekday, entity.weekday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timefrom, timeto, attractionid, weekday);
    }

}
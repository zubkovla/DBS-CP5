package jpa.modelEntities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SlotId implements Serializable {
    private static final long serialVersionUID = -2010314775036189346L;
    @Column(name = "excursionid", nullable = false)
    private Integer excursionid;

    @Column(name = "durationminutes", nullable = false)
    private Integer durationminutes;

    public Integer getExcursionid() {
        return excursionid;
    }

    public void setExcursionid(Integer excursionid) {
        this.excursionid = excursionid;
    }

    public Integer getDurationminutes() {
        return durationminutes;
    }

    public void setDurationminutes(Integer durationminutes) {
        this.durationminutes = durationminutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlotId entity = (SlotId) o;
        return Objects.equals(this.durationminutes, entity.durationminutes) &&
                Objects.equals(this.excursionid, entity.excursionid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(durationminutes, excursionid);
    }

}
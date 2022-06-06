package jpa.modelEntities;

import javax.persistence.*;

@Entity
@Table(name = "slot")
public class Slot {
    @EmbeddedId
    private SlotId id;

    @MapsId("excursionid")
    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "excursionid", nullable = false)
    private Excursion excursionid;

    public SlotId getId() {
        return id;
    }

    public void setId(SlotId id) {
        this.id = id;
    }

    public Excursion getExcursionid() {
        return excursionid;
    }

    public void setExcursionid(Excursion excursionid) {
        this.excursionid = excursionid;
    }

}
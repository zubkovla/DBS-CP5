package jpa.modelEntities;

import javax.persistence.*;

@Entity
@Table(name = "working")
public class Working {
    @EmbeddedId
    private WorkingId id;

//    @MapsId("attractionid")
//    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "attractionid", nullable = false)
//    private Attraction attractionid;

    public WorkingId getId() {
        return id;
    }

    public void setId(WorkingId id) {
        this.id = id;
    }

//    public Attraction getAttractionid() {
//        return attractionid;
//    }
//
//    public void setAttractionid(Attraction attractionid) {
//        this.attractionid = attractionid;
//    }

}
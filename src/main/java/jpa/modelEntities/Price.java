package jpa.modelEntities;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {
    @EmbeddedId
    private PriceId id;

//    @MapsId("serviceid")
//    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "serviceid", nullable = false)
//    private Service serviceid;

    public PriceId getId() {
        return id;
    }

    public void setId(PriceId id) {
        this.id = id;
    }

//    public Service getServiceid() {
//        return serviceid;
//    }
//
//    public void setServiceid(Service serviceid) {
//        this.serviceid = serviceid;
//    }

}
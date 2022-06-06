package jpa.modelEntities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "transport")
public class Transport extends Service{
//    @Id
    @Column(name = "transportplate", nullable = false, length = 20)
    private String plate;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceid", insertable = false, updatable = false)
    private Service serviceid;

    @Column(name = "type", nullable = false, length = 15)
    private String type;

    @OneToMany(mappedBy = "transportplate")
    private Set<Itinerary> itineraries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "transportplate")
    private Set<Transfer> transfers = new LinkedHashSet<>();

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Service getServiceid() {
        return serviceid;
    }

    public void setServiceid(Service serviceid) {
        this.serviceid = serviceid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

}
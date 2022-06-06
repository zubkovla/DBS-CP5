package jpa.modelEntities;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "excursion")
public class Excursion {
    @Id
    @Column(name = "excursionid", nullable = false)
    private Integer id;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "attractionid")
    private Attraction attractionid;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "starttime", nullable = false)
    private LocalTime starttime;

    @OneToMany(mappedBy = "excursionid")
    private Set<Itinerary> itineraries = new LinkedHashSet<>();
//    @OneToMany(mappedBy = "excursion")
//    private Set<Slot> slots = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Attraction getAttractionid() {
        return attractionid;
    }

    public void setAttractionid(Attraction attractionid) {
        this.attractionid = attractionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public Set<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(Set<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

//    public Set<Slot> getSlots() {
//        return slots;
//    }
//
//    public void setSlots(Set<Slot> slots) {
//        this.slots = slots;
//    }

/*
  TODO [JPA Buddy] create field to map the 'weekday' column
   Available actions: Define target Java type | Uncomment as is | Remove column mapping
  @Column(name = "weekday", columnDefinition = "weekdaynumber(10) not null")
  private Object weekday;
*/
}
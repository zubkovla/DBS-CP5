package jpa.modelEntities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "attraction")
public class Attraction extends Service {
//    @Id
    @Column(name = "attractionid", nullable = false)
    private Integer attractionid;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceid", insertable = false, updatable = false)
    private Service serviceid;

    @Column(name = "name", nullable = false, length = 100, insertable = false, updatable = false)
    private String attraction;

    @Column(name = "latitude", nullable = false, precision = 15, scale = 10)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false, precision = 15, scale = 10)
    private BigDecimal longitude;

    @Column(name = "description", nullable = false, length = 15500)
    private String description;

    @Column(name = "agegroup", nullable = false, length = 3)
    private String agegroup;

//    @OneToMany(mappedBy = "attraction")
//    private Set<Working> workings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "attractionid")
    private Set<Excursion> excursions = new LinkedHashSet<>();

    public Integer getAttractionid() {
        return attractionid;
    }

    public void setAttractionid(Integer attractionid) {
        this.attractionid = attractionid;
    }

    public Service getServiceid() {
        return serviceid;
    }

    public void setServiceid(Service serviceid) {
        this.serviceid = serviceid;
    }

    public String getAtraction() {
        return attraction;
    }

    public void setAtraction(String atraction) {
        this.attraction = atraction;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgegroup() {
        return agegroup;
    }

    public void setAgegroup(String agegroup) {
        this.agegroup = agegroup;
    }

//    public Set<Working> getWorkings() {
//        return workings;
//    }
//
//    public void setWorkings(Set<Working> workings) {
//        this.workings = workings;
//    }

    public Set<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }

}
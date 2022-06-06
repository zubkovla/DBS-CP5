package jpa.modelEntities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @Column(name = "facilityid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryid")
    private Country countryid;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 15)
    private FacilityType type;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postcode", column = @Column(nullable = false, insertable = false))
    })
    private Address address;

    @Column(name = "class", nullable = false)
    private Integer _class;

    @OneToMany(mappedBy = "facilityid")
    private Set<Accommodation> accommodations = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Country getCountryid() {
        return countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacilityType getType() {
        return type;
    }

    public void setType(FacilityType type) {
        this.type = type;
    }

    public Integer get_class() {
        return _class;
    }

    public void set_class(Integer _class) {
        this._class = _class;
    }

    public Set<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(Set<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

}
package jpa.modelEntities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "companyid", nullable = false)
    private Integer id;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="companypartnership",
            joinColumns=@JoinColumn(name="companyId"),
            inverseJoinColumns=@JoinColumn(name="companyId")
    )
    private List<Company> company;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="companypartnership",
            joinColumns=@JoinColumn(name="companyId"),
            inverseJoinColumns=@JoinColumn(name="companyId")
    )
    private List<Company> companyPartner;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryid")
    private Country countryid;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "isown", nullable = false)
    private Boolean isown = false;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @OneToMany(mappedBy = "companyid")
    private Set<Trip> trips = new LinkedHashSet<>();

    @Embedded private Address address;

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

    public Boolean getIsown() {
        return isown;
    }

    public void setIsown(Boolean isown) {
        this.isown = isown;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

//    public Set<Companypartnership> getCompanypartnerships() {
//        return companypartnerships;
//    }
//
//    public void setCompanypartnerships(Set<Companypartnership> companypartnerships) {
//        this.companypartnerships = companypartnerships;
//    }

}
package jpa.modelEntities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "countryid", nullable = false, length = 50)
    private String id;

    @OneToMany(mappedBy = "countryid")
    private Set<Trip> trips = new LinkedHashSet<>();

    @OneToMany(mappedBy = "countryid")
    private Set<Facility> facilities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "countryid")
    private Set<Company> companies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "passportcountry")
    private Set<Passenger> passengers = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

}
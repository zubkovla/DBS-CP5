package jpa.modelEntities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "service")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Service {
    @Id
    @Column(name = "serviceid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

//    @OneToMany(mappedBy = "service")
//    private Set<Price> prices = new LinkedHashSet<>();

//    @OneToMany(mappedBy = "serviceid")
//    private Set<Transport> transports = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "serviceid")
//    private Set<Attraction> attractions = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Price> getPrices() {
//        return prices;
//    }
//
//    public void setPrices(Set<Price> prices) {
//        this.prices = prices;
//    }

//    public Set<Transport> getTransports() {
//        return transports;
//    }
//
//    public void setTransports(Set<Transport> transports) {
//        this.transports = transports;
//    }
//
//    public Set<Attraction> getAttractions() {
//        return attractions;
//    }
//
//    public void setAttractions(Set<Attraction> attractions) {
//        this.attractions = attractions;
//    }

}
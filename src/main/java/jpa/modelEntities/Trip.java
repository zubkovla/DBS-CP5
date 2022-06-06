package jpa.modelEntities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @Column(name = "tripid", nullable = false)
    private Integer id;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryid")
    private Country countryid;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyid")
    private Company companyid;

    @Column(name = "marketingname", nullable = false, length = 100)
    private String marketingname;

    @Column(name = "durationdays", nullable = false)
    private Integer durationdays;

    @OneToMany(mappedBy = "tripid")
    private Set<Grouppax> grouppaxes = new LinkedHashSet<>();

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

    public Company getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Company companyid) {
        this.companyid = companyid;
    }

    public String getMarketingname() {
        return marketingname;
    }

    public void setMarketingname(String marketingname) {
        this.marketingname = marketingname;
    }

    public Integer getDurationdays() {
        return durationdays;
    }

    public void setDurationdays(Integer durationdays) {
        this.durationdays = durationdays;
    }

    public Set<Grouppax> getGrouppaxes() {
        return grouppaxes;
    }

    public void setGrouppaxes(Set<Grouppax> grouppaxes) {
        this.grouppaxes = grouppaxes;
    }

}
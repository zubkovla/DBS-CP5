package jpa.modelEntities;

import javax.persistence.*;
import java.util.List;

/*
  ON MY OPINION THIS ENTITY IS OBSOLETE, SEE COMPANY MANY-TO-MANY
 */

@Entity
@Table(name = "companypartnership")
public class Companypartnership {
    @EmbeddedId
    private CompanypartnershipId id;




    @MapsId("companyid")
    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "companyid", nullable = false)
    private Company companyid;

    @MapsId("companypartnerid")
    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "companypartnerid", nullable = false)
    private Company companypartnerid;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    public CompanypartnershipId getId() {
        return id;
    }

    public void setId(CompanypartnershipId id) {
        this.id = id;
    }

    public Company getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Company companyid) {
        this.companyid = companyid;
    }

    public Company getCompanypartnerid() {
        return companypartnerid;
    }

    public void setCompanypartnerid(Company companypartnerid) {
        this.companypartnerid = companypartnerid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
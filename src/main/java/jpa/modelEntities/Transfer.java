package jpa.modelEntities;

import javax.persistence.*;

@Entity
@Table(name = "transfer")
public class Transfer {
    @Id
    @Column(name = "transferid", nullable = false)
    private Integer id;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "transportplate")
    private Transport transportplate;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeephone")
    private Employee employeephone;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "grouppaxid")
    private Grouppax grouppaxid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transport getTransportplate() {
        return transportplate;
    }

    public void setTransportplate(Transport transportplate) {
        this.transportplate = transportplate;
    }

    public Employee getEmployeephone() {
        return employeephone;
    }

    public void setEmployeephone(Employee employeephone) {
        this.employeephone = employeephone;
    }

    public Grouppax getGrouppaxid() {
        return grouppaxid;
    }

    public void setGrouppaxid(Grouppax grouppaxid) {
        this.grouppaxid = grouppaxid;
    }

}
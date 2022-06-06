package jpa.modelEntities;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {
    @EmbeddedId
    private ContactId id;

    @MapsId("passengerid")
    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passengerid", nullable = false)
    private Passenger passengerid;

    @MapsId("passengercontactid")
    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passengercontactid", nullable = false)
    private Passenger passengercontactid;

    @Column(name = "islegalrepresentative")
    private Boolean islegalrepresentative;

    public ContactId getId() {
        return id;
    }

    public void setId(ContactId id) {
        this.id = id;
    }

    public Passenger getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(Passenger passengerid) {
        this.passengerid = passengerid;
    }

    public Passenger getPassengercontactid() {
        return passengercontactid;
    }

    public void setPassengercontactid(Passenger passengercontactid) {
        this.passengercontactid = passengercontactid;
    }

    public Boolean getIslegalrepresentative() {
        return islegalrepresentative;
    }

    public void setIslegalrepresentative(Boolean islegalrepresentative) {
        this.islegalrepresentative = islegalrepresentative;
    }

}
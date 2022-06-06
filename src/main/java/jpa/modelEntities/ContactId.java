package jpa.modelEntities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContactId implements Serializable {
    private static final long serialVersionUID = -3140393441030792235L;
    @Column(name = "passengerid", nullable = false)
    private Integer passengerid;

    @Column(name = "passengercontactid", nullable = false)
    private Integer passengercontactid;

    @Column(name = "phonenumber", nullable = false, length = 25)
    private String phonenumber;

    public Integer getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(Integer passengerid) {
        this.passengerid = passengerid;
    }

    public Integer getPassengercontactid() {
        return passengercontactid;
    }

    public void setPassengercontactid(Integer passengercontactid) {
        this.passengercontactid = passengercontactid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactId entity = (ContactId) o;
        return Objects.equals(this.phonenumber, entity.phonenumber) &&
                Objects.equals(this.passengerid, entity.passengerid) &&
                Objects.equals(this.passengercontactid, entity.passengercontactid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phonenumber, passengerid, passengercontactid);
    }

}
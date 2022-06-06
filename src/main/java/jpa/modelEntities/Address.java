package jpa.modelEntities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Address {

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "street", nullable = false, length = 150)
    private String street;

    @Column(name = "house", nullable = false)
    private Integer house;

    @Column(name = "postcode", length = 10)
    private String postcode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) { this.city = city; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public Integer getHouse() { return house; }

    public void setHouse(Integer house) { this.house = house; }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}
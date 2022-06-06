package jpa.modelEntities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employee", indexes = {
        @Index(name = "employee_email_key", columnList = "email", unique = true)
})
public class Employee {
    @Id
    @Column(name = "employeephone", nullable = false, length = 25)
    private String id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "type", nullable = false, length = 15)
    private String type;

    @OneToMany(mappedBy = "employeephone")
    private Set<Itinerary> itineraries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employeephone")
    private Set<Transfer> transfers = new LinkedHashSet<>();

    public Employee(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Employee() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(Set<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public Set<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Set<Transfer> transfers) {
        this.transfers = transfers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", itineraries=" + itineraries +
                ", transfers=" + transfers +
                '}';
    }
}
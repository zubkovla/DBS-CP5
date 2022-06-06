package jpa.DAO;

import jpa.modelEntities.Employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    private static EmployeeRepository repository;

    @BeforeAll
    public static void beforeClass() throws Exception{
        repository = new EmployeeRepository();
    }

    @AfterAll
    public static void afterClass() {
        repository.close();
    }

    @BeforeEach
    public void setUp() { }

    @AfterEach
    public void tearDown() { }

    @Test
    void add() {
        Employee employee = new Employee("777-777-55551", "Jack", "Nickolson");
        employee.setAddress("Bishop house 15");
        employee.setEmail("Nico@gogo.com");
        employee.setType("Driver");

        repository.add(employee);

        assertNotNull(employee);
        assertNotNull(employee.getId());
        assertEquals("Jack", employee.getName());
    }

    @Test
    void find() {
        Employee employee = new Employee("777-777-55552", "Jack", "Nickolson");
        employee.setAddress("Bishop house 15");
        employee.setEmail("Nico1@gogo.com"); // email have to be unique
        employee.setType("Driver");

        repository.add(employee);
        employee = repository.find(employee.getId());

        assertNotNull(employee);
        assertNotNull(employee.getId());
        assertEquals("Jack", employee.getName());
    }

    @Test
    void update() {
        Employee employee = new Employee("777-777-55553", "Jack", "Nickolson");
        employee.setAddress("Bishop house 15");
        employee.setEmail("Nico3@gogo.com");
        employee.setType("Driver");

        repository.add(employee);
        employee.setName("John");
        employee = repository.update(employee);

        assertNotNull(employee);
        assertNotNull(employee.getId());
        assertEquals("John", employee.getName());
        assertEquals("Nickolson", employee.getSurname());
    }

    @Test
    void remove() {
        Employee employee = new Employee("777-777-55554", "Jack", "Nickolson");
        employee.setAddress("Bishop house 15");
        employee.setEmail("Nico4@gogo.com");
        employee.setType("Driver");

        repository.add(employee);
        repository.remove(employee);
        employee = repository.find(employee.getId());

        assertNull(employee);
    }

}
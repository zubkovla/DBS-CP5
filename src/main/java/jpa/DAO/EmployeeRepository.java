package jpa.DAO;

import jpa.EntityManagerUtility;
import jpa.modelEntities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EmployeeRepository {

    private EntityManager em = EntityManagerUtility.getEm();
    private EntityTransaction et = em.getTransaction();

    public void add(Employee employee) {
        et.begin();
        try {
            em.persist(employee);
            et.commit();
            System.out.println("Employee added: " + employee.toString());
        } catch (Exception ex) {
            et.rollback();
        }
    }

    public Employee find(String id) {
        Employee employee = em.find(Employee.class, id);
        if (employee != null) {
            System.out.println("Employee found: " + employee.toString());
        }
        return employee;
    }

    public Employee update(Employee employee) {
        Employee employeeToUpdate = find(employee.getId());
        et.begin();
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setSurname(employee.getSurname());
        et.commit();
        em.clear();
        System.out.println("Employee updated: " + employeeToUpdate.toString());
        return employeeToUpdate;
    }

    public void remove(Employee employee) {
        try {
            et.begin();
            em.remove(employee);
            et.commit();
            em.clear();
            System.out.println("Employee removed: " + employee.toString());
        } catch (Exception ex) {
        }
    }

    public void close() {
        this.em.close();
    }

}

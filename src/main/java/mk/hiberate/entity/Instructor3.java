package mk.hiberate.entity;

import javax.persistence.Entity;

@Entity
public class Instructor3 extends User3{

    private Double salary;

    public Instructor3(String firstName, String lastName, String email, Double salary) {
        super(firstName, lastName, email);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

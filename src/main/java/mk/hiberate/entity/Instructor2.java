package mk.hiberate.entity;

import javax.persistence.Entity;

@Entity
public class Instructor2 extends User2{

    private Double salary;

    public Instructor2(String firstName, String lastName, String email, Double salary) {
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

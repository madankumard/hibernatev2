package mk.hiberate.entity;

import javax.persistence.Entity;

@Entity
public class Student7 extends User2{

    private String course;

    public Student7(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

package mk.hiberate.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student5")
public class Student5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @ElementCollection
    @CollectionTable(name = "image")
    @MapKeyColumn(name = "file_name") // Maps key
    //@OrderBy // defaults to @MapKeyColumn
    @OrderBy("file_name desc") // defaults to @MapKeyColumn
    @Column(name = "image_name") // Maps Value
    //private Map<String, String> images = new LinkedHashMap<String, String>();
    private SortedMap<String, String> images = new TreeMap<String, String>();

    public Student5() {
    }

    public Student5(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public SortedMap<String, String> getImages() {
        return images;
    }

    public void setImages(SortedMap<String, String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

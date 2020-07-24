package mk.hiberate.client;

import mk.hiberate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class StudentTest {
    public static void main(String[] args) {

        //Create Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try{

            session.beginTransaction();

            Student tempStudent = new Student("John", "Doe", "email@emai.com");
            Set<String> images = new HashSet<String>();
            images.add("photo1.jpg");
            images.add("photo2.jpg");
            images.add("photo3.jpg");
            images.add("photo4.jpg");
            images.add("photo5.jpg");
            images.add("photo6.jpg");
            tempStudent.setImages(images);

            session.persist(tempStudent);

            session.getTransaction().commit();
            System.out.println("Done... !!! ");

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if(session != null) session.close();
        }
    }
}

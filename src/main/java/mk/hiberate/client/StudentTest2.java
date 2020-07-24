package mk.hiberate.client;

import mk.hiberate.entity.Student;
import mk.hiberate.entity.Student2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentTest2 {
    public static void main(String[] args) {

        //Create Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student2.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try{

            session.beginTransaction();

            Student2 tempStudent = new Student2("John", "Doe", "email@emai.com");
            List<String> images = new ArrayList<String>();
            images.add("photo1.jpg");
            images.add("photo2.jpg");
            images.add("photo3.jpg");
            images.add("photo4.jpg");
            images.add("photo4.jpg");
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

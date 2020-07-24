package mk.hiberate.client;

import mk.hiberate.entity.Student2;
import mk.hiberate.entity.Student3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest3 {
    public static void main(String[] args) {

        //Create Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student3.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try{

            session.beginTransaction();

            Student3 tempStudent = new Student3("John", "Doe", "email@emai.com");
            Map<String, String> images = new HashMap<String, String>();
            images.put("photo1.jpg", "Photo 1");
            images.put("photo2.jpg", "Photo 2");
            images.put("photo3.jpg", "Photo 3");
            images.put("photo4.jpg", "Photo 4");
            images.put("photo5.jpg", "Photo 5");
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

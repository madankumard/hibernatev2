package mk.hiberate.client;

import mk.hiberate.entity.Student5;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;
import java.util.SortedMap;

public class StudentTest5 {
    public static void main(String[] args) {

        //Create Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student5.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try{

            session.beginTransaction();

            Student5 tempStudent = new Student5("John", "Doe", "email@emai.com");
            SortedMap<String, String> images = tempStudent.getImages();
            images.put("photo2.jpg", "Photo 2");
            images.put("photo1.jpg", "Photo 1");
            images.put("photo3.jpg", "Photo 3");
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

        Session session1 = sessionFactory.openSession();

        try{
            session1.beginTransaction();

            Student5 student5 = session1.get(Student5.class, 1L);
            System.out.println("Student Details: " + student5);
            System.out.println("Student Images: " + student5.getImages());

            session1.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session1.getTransaction().rollback();
        }finally {
            session1.close();
        }
    }
}

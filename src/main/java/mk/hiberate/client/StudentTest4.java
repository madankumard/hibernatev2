package mk.hiberate.client;

import mk.hiberate.entity.Student;
import mk.hiberate.entity.Student4;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class StudentTest4 {
    public static void main(String[] args) {

        //Create Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student4.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try{

            session.beginTransaction();

            Student4 tempStudent = new Student4("John", "Doe", "email@emai.com");
            Set<String> images = new LinkedHashSet<String>();
            images.add("photo1.jpg");
            images.add("photo2.jpg");
            images.add("photo3.jpg");
            images.add("photo4.jpg");
            images.add("photo5.jpg");
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

            Student4 student4 = session1.get(Student4.class, 1L);
            System.out.println("Student Details: " + student4);
            System.out.println("Student Images: " + student4.getImages());

            session1.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session1.getTransaction().rollback();
        }finally {
            session1.close();
        }
    }
}

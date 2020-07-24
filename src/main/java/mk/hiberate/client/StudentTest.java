package mk.hiberate.client;

import mk.hiberate.entity.Address;
import mk.hiberate.entity.Status;
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
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try{

            session.beginTransaction();

            Student tempStudent = new Student("John", "Doe", "email@emai.com", Status.ACTIVE);
            Set<String> images = new HashSet<String>();
            images.add("photo1.jpg");
            images.add("photo2.jpg");
            images.add("photo3.jpg");
            images.add("photo4.jpg");
            images.add("photo5.jpg");
            images.add("photo6.jpg");
            tempStudent.setImages(images);

            Address address = new Address("Street 1", "city 1", "zp1");
            Address billingAddress = new Address("Street 2", "city 2", "zp2");
            tempStudent.setHomeAddress(address);
            tempStudent.setBillingAddress(billingAddress);

            Student tempStudent2 = new Student("Hary", "Lary", "email2@emai.com", Status.INACTIVE);


            session.persist(tempStudent);
            session.persist(tempStudent2);

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

            Student student = session1.get(Student.class, 1L);
            System.out.println(student);

            Student student2 = session1.get(Student.class, 2L);
            System.out.println(student2);


            session1.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session1.getTransaction().rollback();
        }finally {
            session1.close();
        }
    }
}

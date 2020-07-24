package mk.hiberate.client;

import mk.hiberate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentUserTest1 {

    public static void main(String[] args) {

        //Create Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student6.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            session.beginTransaction();

            Student6 student6 = new Student6("John", "Doe", "email@emai.com","Course1");
            Instructor instructor = new Instructor("ins1", "inslast1", "d@d.com", 2333.00);

            session.persist(student6);
            session.persist(instructor);

            session.getTransaction().commit();
            System.out.println("Done... !!! ");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) session.close();
        }
    }
}

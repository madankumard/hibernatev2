package mk.hiberate.client;

import mk.hiberate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentUserTest2 {

    public static void main(String[] args) {

        //Create Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student7.class)
                .addAnnotatedClass(User2.class)
                .addAnnotatedClass(Instructor2.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            session.beginTransaction();

            Student7 student = new Student7("John", "Doe", "email@emai.com","Course1");
            Instructor2 instructor = new Instructor2("ins1", "inslast1", "d@d.com", 2333.00);

            session.persist(student);
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

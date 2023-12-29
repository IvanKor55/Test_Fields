package Test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Util.getMySessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String create_test_table = """
                              CREATE TABLE IF NOT EXISTS TEST(
                                     id SERIAL PRIMARY KEY,
                                     FINAL_STRING VARCHAR(50));
                              """;
            Query query = session.createSQLQuery(create_test_table).addEntity(Test.class);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        Test t1 = new Test();
        Test t2 = new Test();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(t1);
            session.save(t2);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
    }
}

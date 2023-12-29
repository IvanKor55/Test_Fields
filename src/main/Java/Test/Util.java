package Test;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    private static final String CONNECTIONURL = "jdbc:mysql://localhost:3306/mydatabase";

    private static final String USERNAME = "Iv";
    private static final String PASSWORD = "i1234567";
    private static SessionFactory sessionFactory;
    public static SessionFactory getMySessionFactory () {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                // Настройки подключения к базе данных
                settings.put(Environment.URL, CONNECTIONURL);
                settings.put(Environment.USER, USERNAME);
                settings.put(Environment.PASS, PASSWORD);
                // Другие настройки Hibernate
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL,"true");
                settings.put(Environment.HBM2DDL_AUTO, "none");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Test.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                throw new RuntimeException(e);
            }
        }
        return sessionFactory;
    }
}


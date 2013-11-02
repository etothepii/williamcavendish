package uk.co.epii.conservatives.williamcavendishbentinck;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import uk.co.epii.conservatives.williamcavendishbentinck.tables.BLPU;
import uk.co.epii.conservatives.williamcavendishbentinck.tables.DeliveryPointAddress;
import uk.co.epii.spencerperceval.tuple.Duple;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * User: James Robinson
 * Date: 30/09/2013
 * Time: 00:42
 */
public class DatabaseSessionImpl implements DatabaseSession {

    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;
    private Configuration configuration;
    private String rawPostcodeSql = "SELECT %1$s.* FROM %2$s a LEFT JOIN %3$s b ON a.%4$s = b.%4$s WHERE a.POSTCODE = :postcode ORDER BY a.%5$s";
    private String rawRectangleSql = "SELECT %1$s.* FROM %2$s a LEFT JOIN %3$s b ON a.%4$s = b.%4$s WHERE a.X_COORDINATE >= :minX AND a.X_COORDINATE <= :maxX AND a.Y_COORDINATE >= :minY AND a.Y_COORDINATE <= :maxY ORDER BY a.%5$s";

    public DatabaseSessionImpl() {
        try {
            configuration = new Configuration();
        }
        catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void setUsername(String username) {
        configuration.setProperty("hibernate.connection.username", username);
    }

    public void setPassword(String password) {
        configuration.setProperty("hibernate.connection.password", password);
    }

    public void setConnection(String connection) {
        configuration.setProperty("hibernate.connection.url", connection);
    }

    public void setRawPostcodeSql(String rawPostcodeSql) {
        this.rawPostcodeSql = rawPostcodeSql;
    }

    public void setRawRectangleSql(String rawRectangleSql) {
        this.rawRectangleSql = rawRectangleSql;
    }

    public void init() {
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().
                applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public <A, B> List<Duple<A, B>> fromPostcode(String postcode, Class<A> classA, Class<B> classB, String joinColumn, String orderColumn) {
        Session session = sessionFactory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(
                    String.format(rawPostcodeSql, "a", classA.getSimpleName(), classB.getSimpleName(), joinColumn, orderColumn));
            query.addEntity(classA);
            query.setParameter("postcode", postcode);
            List<A> aList = query.list();
            query = session.createSQLQuery(
                    String.format(rawPostcodeSql, "b", classA.getSimpleName(), classB.getSimpleName(), joinColumn, orderColumn));
            query.addEntity(classB);
            query.setParameter("postcode", postcode);
            List<B> bList = query.list();
            if (bList.size() != aList.size()) {
                throw new IllegalStateException("The returned lists are of different sizes, this should not have occurred");
            }
            List<Duple<A, B>> houses = new ArrayList<Duple<A, B>>(aList.size());
            for (int i = 0; i < aList.size(); i++) {
                A a = aList.get(i);
                B b = bList.get(i);
                houses.add(new Duple<A, B>(a, b));
            }
            return houses;
        }
        finally {
            session.close();
        }
    }

    @Override
    public <A, B> List<Duple<A, B>> containedWithin(Rectangle rectangle, Class<A> classA, Class<B> classB, String joinColumn, String orderColumn) {
        Session session = sessionFactory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(
                    String.format(rawRectangleSql, "a", classA.getSimpleName(), classB.getSimpleName(), joinColumn, orderColumn));
            query.addEntity(classA);
            query.setParameter("minX", rectangle.getX());
            query.setParameter("maxX", rectangle.getX() + rectangle.getWidth());
            query.setParameter("minY", rectangle.getY());
            query.setParameter("maxY", rectangle.getY() + rectangle.getHeight());
            List<A> aList = query.list();
            query = session.createSQLQuery(
                    String.format(rawRectangleSql, "b", classA.getSimpleName(), classB.getSimpleName(), joinColumn, orderColumn));
            query.addEntity(classB);
            query.setParameter("minX", rectangle.getX());
            query.setParameter("maxX", rectangle.getX() + rectangle.getWidth());
            query.setParameter("minY", rectangle.getY());
            query.setParameter("maxY", rectangle.getY() + rectangle.getHeight());
            List<B> bList = query.list();
            if (bList.size() != aList.size()) {
                throw new IllegalStateException("The returned lists are of different sizes, this should not have occurred");
            }
            List<Duple<A, B>> houses = new ArrayList<Duple<A, B>>(aList.size());
            for (int i = 0; i < aList.size(); i++) {
                A a = aList.get(i);
                B b = bList.get(i);
                houses.add(new Duple<A, B>(a, b));
            }
            return houses;
        }
        finally {
            session.close();
        }
    }

    public void upload(List list) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        try {
            for (int i = 0; i < list.size(); i++) {
                Object object = list.get(i);
                session.save(object);
                if (i % 20 == 0) {
                    session.flush();
                    session.clear();
                }
            }
            session.flush();
            session.clear();
        }
        finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}

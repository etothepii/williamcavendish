package uk.co.epii.politics.williamcavendishbentinck;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import uk.co.epii.politics.williamcavendishbentinck.tables.Postcode;
import uk.co.epii.spencerperceval.tuple.Duple;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
    private String rawDwellingsFromPostcodeSql = "SELECT %1$s.* FROM %2$s a LEFT JOIN %3$s b ON a.%4$s = b.%4$s WHERE a.POSTCODE = :postcode ORDER BY a.%5$s";
    private String rawDwellingsFromRectangleSql = "SELECT %1$s.* FROM %2$s a LEFT JOIN %3$s b ON a.%4$s = b.%4$s WHERE a.X_COORDINATE >= :minX AND a.X_COORDINATE <= :maxX AND a.Y_COORDINATE >= :minY AND a.Y_COORDINATE <= :maxY ORDER BY a.%5$s";
    private String rawPostcodeFromPostcodeSql = "SELECT * FROM Postcode WHERE POSTCODE = :postcode";
    private String rawPostcodesFromPostcodeRegexpSql = "SELECT * FROM Postcode WHERE POSTCODE RLIKE :postcode";
    private String rawPostcodesFromRectangleSql = "SELECT * FROM Postcode WHERE X_COORDINATE >= :minX AND X_COORDINATE <= :maxX AND Y_COORDINATE >= :minY AND Y_COORDINATE <= :maxY";
    private String rawPostcodesFromBLPURectangleSql = "SELECT p.* FROM Postcode p INNER JOIN DeliveryPointAddress a ON a.POSTCODE = p.POSTCODE INNER JOIN BLPU b ON b.UPRN = a.UPRN WHERE b.X_COORDINATE >= :minX AND b.X_COORDINATE <= :maxX AND b.Y_COORDINATE >= :minY AND b.Y_COORDINATE <= :maxY GROUP BY a.POSTCODE";

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

    public void setRawDwellingsFromPostcodeSql(String rawDwellingsFromPostcodeSql) {
        this.rawDwellingsFromPostcodeSql = rawDwellingsFromPostcodeSql;
    }

    public void setRawDwellingsFromRectangleSql(String rawDwellingsFromRectangleSql) {
        this.rawDwellingsFromRectangleSql = rawDwellingsFromRectangleSql;
    }


    public void setRawPostcodeFromPostcodeSql(String rawPostcodeFromPostcodeSql) {
        this.rawPostcodeFromPostcodeSql = rawPostcodeFromPostcodeSql;
    }

    public void setRawPostcodesFromPostcodeRegexpSql(String rawPostcodesFromPostcodeRegexpSql) {
        this.rawPostcodesFromPostcodeRegexpSql = rawPostcodesFromPostcodeRegexpSql;
    }

    public void setRawPostcodesFromRectangleSql(String rawPostcodesFromRectangleSql) {
        this.rawPostcodesFromRectangleSql = rawPostcodesFromRectangleSql;
    }

    public void setRawPostcodesFromBLPURectangleSql(String rawPostcodesFromBLPURectangleSql) {
        this.rawPostcodesFromBLPURectangleSql = rawPostcodesFromBLPURectangleSql;
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
    public Collection<Postcode> getPostcodes(String regexp) {
        Session session = sessionFactory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(rawPostcodesFromPostcodeRegexpSql);
            query.addEntity(Postcode.class);
            query.setParameter("postcode", regexp);
            return query.list();
        }
        finally {
            session.close();
        }
    }

    @Override
    public Collection<Postcode> getPostcodesWithin(Rectangle rectangle) {
        Session session = sessionFactory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(rawPostcodesFromRectangleSql);
            query.addEntity(Postcode.class);
            query.setParameter("minX", rectangle.getMinX());
            query.setParameter("minY", rectangle.getMinY());
            query.setParameter("maxX", rectangle.getMaxX());
            query.setParameter("maxY", rectangle.getMaxY());
            HashMap<String, Postcode> found = new HashMap<String, Postcode>();
            for (Postcode postcode : (List<Postcode>)query.list()) {
                found.put(postcode.getPostcode(), postcode);
            }
            query = session.createSQLQuery(rawPostcodesFromBLPURectangleSql);
            query.addEntity(Postcode.class);
            query.setParameter("minX", rectangle.getMinX());
            query.setParameter("minY", rectangle.getMinY());
            query.setParameter("maxX", rectangle.getMaxX());
            query.setParameter("maxY", rectangle.getMaxY());
            for (Postcode postcode : (List<Postcode>)query.list()) {
                found.put(postcode.getPostcode(), postcode);
            }
            return found.values();
        }
        finally {
            session.close();
        }
    }

    @Override
    public Postcode getPostcode(String postcode) {
        Session session = sessionFactory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(rawPostcodeFromPostcodeSql);
            query.addEntity(Postcode.class);
            query.setParameter("postcode", postcode);
            List<Postcode> postcodes = query.list();
            return postcodes.isEmpty() ? null : postcodes.get(0);
        }
        finally {
            session.close();
        }
    }

    @Override
    public <A, B> List<Duple<A, B>> fromPostcode(String postcode, Class<A> classA, Class<B> classB, String joinColumn, String orderColumn) {
        Session session = sessionFactory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(
                    String.format(rawDwellingsFromPostcodeSql, "a", classA.getSimpleName(), classB.getSimpleName(), joinColumn, orderColumn));
            query.addEntity(classA);
            query.setParameter("postcode", postcode);
            List<A> aList = query.list();
            query = session.createSQLQuery(
                    String.format(rawDwellingsFromPostcodeSql, "b", classA.getSimpleName(), classB.getSimpleName(), joinColumn, orderColumn));
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
                    String.format(rawDwellingsFromRectangleSql, "a", classA.getSimpleName(), classB.getSimpleName(), joinColumn, orderColumn));
            query.addEntity(classA);
            query.setParameter("minX", rectangle.getX());
            query.setParameter("maxX", rectangle.getX() + rectangle.getWidth());
            query.setParameter("minY", rectangle.getY());
            query.setParameter("maxY", rectangle.getY() + rectangle.getHeight());
            List<A> aList = query.list();
            query = session.createSQLQuery(
                    String.format(rawDwellingsFromRectangleSql, "b", classA.getSimpleName(), classB.getSimpleName(), joinColumn, orderColumn));
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

    public void upload(Collection collection) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        try {
            int i = 0;
            for (Object object : collection) {
                i++;
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

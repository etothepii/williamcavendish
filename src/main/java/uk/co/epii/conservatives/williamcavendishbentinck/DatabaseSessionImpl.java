package uk.co.epii.conservatives.williamcavendishbentinck;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import sun.util.LocaleServiceProviderPool;
import uk.co.epii.conservatives.williamcavendishbentinck.tables.BLPU;
import uk.co.epii.conservatives.williamcavendishbentinck.tables.DeliveryPointAddress;
import uk.co.epii.conservatives.williamcavendishbentinck.tables.Dwelling;
import uk.co.epii.spencerperceval.tuple.Duple;

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
    public List<Duple<BLPU, DeliveryPointAddress>> getHouses(String postcode) {
        Session session = sessionFactory.openSession();
        String blpuSql = "SELECT b.* FROM BLPU b INNER JOIN DeliveryPointAddress d ON d.UPRN = b.UPRN AND d.POSTCODE = :postcode ORDER BY d.UPRN";
        SQLQuery query = session.createSQLQuery(blpuSql);
        query.addEntity(BLPU.class);
        query.setParameter("postcode", postcode);
        List<BLPU> blpuList = query.list();
        String deliveryPointSql = "SELECT d.* FROM BLPU b INNER JOIN DeliveryPointAddress d ON d.UPRN = b.UPRN AND d.POSTCODE = :postcode ORDER BY d.UPRN";
        query = session.createSQLQuery(deliveryPointSql);
        query.addEntity(DeliveryPointAddress.class);
        query.setParameter("postcode", postcode);
        List<DeliveryPointAddress> deliveryPointAddressList = query.list();
        int size = Math.max(blpuList.size(), deliveryPointAddressList.size());
        List<Duple<BLPU, DeliveryPointAddress>> houses = new ArrayList<Duple<BLPU, DeliveryPointAddress>>(size);
        for (int i = 0; i < size; i++) {
            BLPU blpu = blpuList.get(i);
            DeliveryPointAddress deliveryPointAddress = deliveryPointAddressList.get(i);
            if (deliveryPointAddress.getUprn() != blpu.getUprn()) {
                throw new RuntimeException("Two of the results returned have different UPRNs");
            }
            houses.add(new Duple<BLPU, DeliveryPointAddress>(blpu, deliveryPointAddress));
        }
        return houses;
    }

    @Override
    public List<Duple<BLPU, DeliveryPointAddress>> getHouses(Point2D.Float location, float radius) {
        Session session = sessionFactory.openSession();
        String blpuSql = "SELECT b.* FROM BLPU b INNER JOIN DeliveryPointAddress d ON d.UPRN = b.UPRN " +
                "WHERE b.X_COORDINATE >= :minX " +
                "AND b.X_COORDINATE <= :maxX " +
                "AND b.Y_COORDINATE <= :minY " +
                "AND b.Y_COORDINATE <= :maxY ORDER BY d.UPRN";
        SQLQuery query = session.createSQLQuery(blpuSql);
        query.addEntity(BLPU.class);
        query.setParameter("minX", location.getX() - radius);
        query.setParameter("maxX", location.getX() + radius);
        query.setParameter("minY", location.getY() - radius);
        query.setParameter("maxY", location.getY() + radius);
        List<BLPU> blpuList = query.list();
        String deliveryPointSql = "SELECT d.* FROM BLPU b INNER JOIN DeliveryPointAddress d ON d.UPRN = b.UPRN " +
                "WHERE b.X_COORDINATE >= :minX " +
                "AND b.X_COORDINATE <= :maxX " +
                "AND b.Y_COORDINATE <= :minY " +
                "AND b.Y_COORDINATE <= :maxY ORDER BY d.UPRN";
        query = session.createSQLQuery(deliveryPointSql);
        query.addEntity(DeliveryPointAddress.class);
        query.setParameter("minX", location.getX() - radius);
        query.setParameter("maxX", location.getX() + radius);
        query.setParameter("minY", location.getY() - radius);
        query.setParameter("maxY", location.getY() + radius);
        List<DeliveryPointAddress> deliveryPointAddressList = query.list();
        int size = Math.max(blpuList.size(), deliveryPointAddressList.size());
        List<Duple<BLPU, DeliveryPointAddress>> houses = new ArrayList<Duple<BLPU, DeliveryPointAddress>>(size);
        for (int i = 0; i < size; i++) {
            BLPU blpu = blpuList.get(i);
            DeliveryPointAddress deliveryPointAddress = deliveryPointAddressList.get(i);
            if (deliveryPointAddress.getUprn() != blpu.getUprn()) {
                throw new RuntimeException("Two of the results returned have different UPRNs");
            }
            double dx = Math.abs(blpu.getXCoordinate() - location.getX());
            double dy = Math.abs(blpu.getYCoordinate() - location.getY());
            if (dx * dx + dy * dy <= radius * (double)radius) {
                houses.add(new Duple<BLPU, DeliveryPointAddress>(blpu, deliveryPointAddress));
            }
        }
        return houses;
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

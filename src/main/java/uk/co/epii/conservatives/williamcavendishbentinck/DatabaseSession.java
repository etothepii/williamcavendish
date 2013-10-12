package uk.co.epii.conservatives.williamcavendishbentinck;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import uk.co.epii.conservatives.williamcavendishbentinck.tables.BLPU;
import uk.co.epii.conservatives.williamcavendishbentinck.tables.DeliveryPointAddress;
import uk.co.epii.spencerperceval.tuple.Duple;

import java.util.ArrayList;
import java.util.List;

/**
 * User: James Robinson
 * Date: 30/09/2013
 * Time: 00:42
 */
public class DatabaseSession {

    private final SessionFactory sessionFactory;

    public DatabaseSession() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

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
}

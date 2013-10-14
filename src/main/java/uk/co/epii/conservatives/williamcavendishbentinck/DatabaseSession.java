package uk.co.epii.conservatives.williamcavendishbentinck;

import org.hibernate.SessionFactory;
import uk.co.epii.conservatives.williamcavendishbentinck.tables.BLPU;
import uk.co.epii.conservatives.williamcavendishbentinck.tables.DeliveryPointAddress;
import uk.co.epii.spencerperceval.tuple.Duple;

import java.util.List;

/**
 * User: James Robinson
 * Date: 13/10/2013
 * Time: 20:50
 */
public interface DatabaseSession {

    public SessionFactory getSessionFactory();
    public List<Duple<BLPU, DeliveryPointAddress>> getHouses(String postcode);
    public void upload(List list);

}

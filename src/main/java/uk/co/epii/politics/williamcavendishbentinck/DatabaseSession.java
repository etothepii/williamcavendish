package uk.co.epii.politics.williamcavendishbentinck;

import org.hibernate.SessionFactory;
import uk.co.epii.politics.williamcavendishbentinck.tables.Postcode;
import uk.co.epii.spencerperceval.tuple.Duple;

import java.awt.*;
import java.util.Collection;
import java.util.List;

/**
 * User: James Robinson
 * Date: 13/10/2013
 * Time: 20:50
 */
public interface DatabaseSession {

    public SessionFactory getSessionFactory();
    public Postcode getPostcode(String postcode);
    public Collection<Postcode> getPostcodes(String postcodeRegexp);
    public Collection<Postcode> getPostcodesWithin(Rectangle rectangle);
    public <A, B> List<Duple<A, B>> fromPostcode(String postcode, Class<A> classA, Class<B> classB, String joinColumn, String orderColumn);
    public <A, B> List<Duple<A, B>> containedWithin(Rectangle rectangle, Class<A> classA, Class<B> classB, String joinColumn, String orderColumn);
    public void upload(Collection list);

}

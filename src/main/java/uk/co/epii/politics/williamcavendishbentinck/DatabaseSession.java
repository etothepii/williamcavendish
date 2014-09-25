package uk.co.epii.politics.williamcavendishbentinck;

import org.hibernate.SessionFactory;
import uk.co.epii.spencerperceval.tuple.Duple;

import java.awt.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * User: James Robinson
 * Date: 13/10/2013
 * Time: 20:50
 */
public interface DatabaseSession {

    public SessionFactory getSessionFactory();
    public <A, B> List<Duple<A, B>> containedWithin(Rectangle rectangle, Class<A> classA, Class<B> classB, String joinColumn, String orderColumn);
    public <T> List<T> getByUuid(Class<T> clazz, UUID... uuids);
    public void upload(Collection list);

}

package uk.co.epii.politics.williamcavendishbentinck;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uk.co.epii.politics.williamcavendishbentinck.extensions.DeliveryPointAddressExtensions;
import uk.co.epii.politics.williamcavendishbentinck.tables.BLPU;
import uk.co.epii.politics.williamcavendishbentinck.tables.DeliveryPointAddress;
import uk.co.epii.spencerperceval.tuple.Duple;
import java.awt.*;
import java.util.List;

/**
 * User: James Robinson
 * Date: 30/09/2013
 * Time: 21:42
 */
public class DatabaseSessionTest {

    private static DatabaseSession databaseSessionImpl;

    @BeforeClass
    public static void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        databaseSessionImpl = (DatabaseSession)context.getBean("databaseSession");
    }

    @Test
    public void containedWithinTest() {
        List<Duple<BLPU, DeliveryPointAddress>> list = databaseSessionImpl.containedWithin(
                new Rectangle(537483, 180935, 67, 10), BLPU.class, DeliveryPointAddress.class, "UPRN", "UPRN");
        for (Duple<BLPU, DeliveryPointAddress> duple : list) {
            if (duple.getFirst() == null || duple.getSecond() == null) {
                continue;
            }
            System.out.println(String.format("%s: (%.2f, %.2f)",
                    DeliveryPointAddressExtensions.getAddress(duple.getSecond()),
                    duple.getFirst().getXCoordinate(), duple.getFirst().getYCoordinate()));
        }
    }

}

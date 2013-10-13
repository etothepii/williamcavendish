package uk.co.epii.conservatives.williamcavendishbentinck.tables;

import org.junit.Test;
import uk.co.epii.conservatives.williamcavendishbentinck.DatabaseSessionImpl;
import uk.co.epii.conservatives.williamcavendishbentinck.extensions.DeliveryPointAddressExtensions;
import uk.co.epii.spencerperceval.tuple.Duple;

/**
 * User: James Robinson
 * Date: 30/09/2013
 * Time: 21:42
 */
public class DatabaseSessionTest {

    @Test
    public void getPostcodeTest() {
        DatabaseSessionImpl databaseSessionImpl = new DatabaseSessionImpl();
        for (Duple<BLPU, DeliveryPointAddress> duple : databaseSessionImpl.getHouses("E14 0DG")) {
            System.out.println(String.format("%s: (%.2f, %.2f)",
                    DeliveryPointAddressExtensions.getAddress(duple.getSecond()),
                    duple.getFirst().getXCoordinate(), duple.getFirst().getYCoordinate()));
        }
    }

}

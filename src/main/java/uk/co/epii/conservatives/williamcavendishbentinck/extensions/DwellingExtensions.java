package uk.co.epii.conservatives.williamcavendishbentinck.extensions;

import uk.co.epii.conservatives.williamcavendishbentinck.tables.Dwelling;

/**
 * User: James Robinson
 * Date: 13/10/2013
 * Time: 14:13
 */
public class DwellingExtensions {

    public static String getAddress(Dwelling dwelling) {
        return String.format("%s, %s", dwelling.getVoaAddress(), dwelling.getPostcode());
    }

}

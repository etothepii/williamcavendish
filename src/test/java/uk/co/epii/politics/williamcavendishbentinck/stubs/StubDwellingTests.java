package uk.co.epii.politics.williamcavendishbentinck.stubs;

import org.junit.Test;
import uk.co.epii.politics.williamcavendishbentinck.tables.Dwelling;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


/**
 * User: James Robinson
 * Date: 18/10/2013
 * Time: 22:13
 */
public class StubDwellingTests {

    @Test
    public void linedUpTest1() {
        StubDwelling a = new StubDwelling(new Dwelling("1ST FLR 137, BRICK LANE, LONDON",
                null, 'A', null, null, null, null, null));
        StubDwelling b = new StubDwelling(new Dwelling("FLAT 2, WOLF COURT 546, ROMAN ROAD, LONDON",
                null, 'A', null, null, null, null, null));
        String[][] linedUp = a.getLinedUp(b);
        assertEquals(4, linedUp[0].length);
        assertEquals(4, linedUp[1].length);
        assertNull(linedUp[0][0]);
        assertEquals("1ST FLR 137", linedUp[0][1]);
        assertEquals("BRICK LANE", linedUp[0][2]);
        assertEquals("LONDON", linedUp[0][3]);
        assertEquals("FLAT 2", linedUp[1][0]);
        assertEquals("WOLF COURT 546", linedUp[1][1]);
        assertEquals("ROMAN ROAD", linedUp[1][2]);
        assertEquals("LONDON", linedUp[1][3]);
    }

    @Test
    public void getDifferenceTest1() {
        StubDwelling common = new StubDwelling(new String[] {"| FRIDESWIDES MEWS", "LODRE STREET", "LONDON"});
        StubDwelling other = new StubDwelling(new String[] {"4A", "ST FRIDESWIDES MEWS", "LODRE STREET", "LONDON"});
        assertEquals(3, common.d(other));
    }

    @Test
    public void commonTest() {
        StubDwelling a = new StubDwelling(new String[] {"4A", "ST FRIDESWIDES MEWS", "LODRE STREET", "LONDON"});
        StubDwelling b = new StubDwelling(new String[] {"3", "ST FRIDESWIDES MEWS", "LODRE STREET", "LONDON"});
        StubDwelling common  = a.getCommon(b);
        String[] result = common.getAddress();
        assertArrayEquals(new String[] {null, "ST FRIDESWIDES MEWS", "LODRE STREET", "LONDON"}, result);
    }

    @Test
    public void dTest() {
        StubDwelling a = new StubDwelling(new String[] {null, "ST FRIDESWIDES MEWS", "LODRE STREET", "LONDON"});
        StubDwelling b = new StubDwelling(new String[] {"1 FRIDESWIDES MEWS", "LODRE STREET", "LONDON"});
        int result  = a.d(b);
        assertEquals(3, result);
    }


}

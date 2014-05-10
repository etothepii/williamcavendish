package uk.co.epii.politics.williamcavendishbentinck.stubs;

import uk.co.epii.politics.williamcavendishbentinck.tables.Dwelling;
import uk.co.epii.spencerperceval.extensions.ArrayExtensions;
import uk.co.epii.spencerperceval.extensions.StringExtensions;
import uk.co.epii.spencerperceval.util.Groupable;

import java.util.Arrays;

/**
 * User: James Robinson
 * Date: 16/10/2013
 * Time: 19:41
 */
public class StubDwelling implements Groupable<StubDwelling> {

    private final String[] address;

    public StubDwelling(Dwelling dwelling) {
        address = dwelling.getVoaAddress().split(",");
        for (int i = 0; i < address.length; i++) {
            address[i] = address[i].trim();
        }
    }

    public StubDwelling(String[] address) {
        this.address = address;
    }

    public String[][] getLinedUp(StubDwelling other) {
        return getLinedUpAddresses(this.address, other.address);
    }

    public static String[][] getLinedUpAddresses(String[] A, String[] B) {
        int[] matchIndex = findLongestMatchIndex(A, B);
        if (matchIndex == null) {
            return null;
        }
        String[] a = Arrays.copyOf(A, A.length);
        String[] b = Arrays.copyOf(B, B.length);
        if (matchIndex[0] < matchIndex[1]) {
            int prepend = matchIndex[1] - matchIndex[0];
            String[] newA = new String[prepend + a.length];
            for (int i = 0; i < a.length; i++) {
                newA[i + prepend] = a[i];
            }
            a = newA;
        }
        else if (matchIndex[0] > matchIndex[1]) {
            int prepend = matchIndex[0] - matchIndex[1];
            String[] newB = new String[prepend + b.length];
            for (int i = 0; i < b.length; i++) {
                newB[i + prepend] = b[i];
            }
            b = newB;
        }
        if (a.length != b.length) {
            a = Arrays.copyOf(a, Math.max(a.length, b.length));
            b = Arrays.copyOf(b, Math.max(a.length, b.length));
        }
        return new String[][] {a, b};
    }

    private int[] findLongestMatchIndex(StubDwelling other) {
        return findLongestMatchIndex(this.address, other.address);
    }

    private static int[] findLongestMatchIndex(String[] a, String[] b) {
        int[] longestMatch = null;
        int longestMatchLength = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] != null && a[i].equals(b[j]) && (longestMatch == null || longestMatchLength > a[i].length())) {
                    longestMatch = new int[] {i, j};
                    longestMatchLength = a[i].length();
                }
            }
        }
        return longestMatch;
    }

    @Override
    public StubDwelling getCommon(StubDwelling other) {
        String[][] linedUp = getLinedUp(other);
        if (linedUp == null) {
            return new StubDwelling(new String[Math.max(other.address.length, address.length)]);
        }
        String[] a = linedUp[0];
        String[] b = linedUp[1];
        String[] address = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            address[i] = StringExtensions.common(a[i], b[i]);
        }
        return new StubDwelling(address);
    }

    public String[] getAddress() {
        return address;
    }

    @Override
    public int d(StubDwelling other) {
        String[][] linedUp = getLinedUpAddresses(
                NulllessCopy(this.address, "NULL_FILLER"),
                NulllessCopy(other.address, "NULL_FILLER"));
        if (linedUp == null) {
            return allDifferentD(other);
        }
        else {
            return ArrayExtensions.d(linedUp[0], linedUp[1]);
        }
    }

  private int allDifferentD(StubDwelling other) {
    if (this.address.length > other.address.length) {
      return ArrayExtensions.d(this.address, null);
    }
    else {
      return ArrayExtensions.d(other.address, null);
    }
  }

    private String[] NulllessCopy(String[] address, String null_filler) {
        String[] copy = Arrays.copyOf(address, address.length);
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == null) {
                copy[i] = null_filler;
            }
        }
        return copy;
    }

    @Override
    public String getDifference(StubDwelling other) {
        for (int i = 0; i < address.length; i++) {
            if (other.address[i] != null && address[i] == null) {
                return other.address[i];
            }
            else if (address[i] != null && other.address[i] == null) {
                return address[i];
            }
            else if (address[i].contains("|")) {
                return StringExtensions.difference(address[i], other.address[i]);
            }
            else if (other.address[i].contains("|")) {
                return StringExtensions.difference(other.address[i], address[i]);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String addressLine : address) {
            if (addressLine == null || addressLine.contains("|")) {
                continue;
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(addressLine);
        }
        return stringBuilder.toString();
    }
}
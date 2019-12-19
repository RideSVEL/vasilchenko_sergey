package ua.khpi.oop.vasilchenko05;
import java.util.Comparator;

public class StringLengthSort implements Comparator<String> {

    /**
     * @param o1 - first string.
     * @param o2 - second string.
     * @return
     */
    @Override
    public int compare(final String o1, final String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else {
            if (o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

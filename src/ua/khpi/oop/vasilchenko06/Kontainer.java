package ua.khpi.oop.vasilchenko06;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import static ua.khpi.oop.vasilchenko06.Functions.sortAlphabetical;
import static ua.khpi.oop.vasilchenko06.Functions.sortByLength;

/**
 * Contain elements in program.
 */
class Kontainer implements Serializable {
    /**
     * First size for array.
     */
    private final int size = 50;
    /**
     * Array contains all data.
     */
    private String[] array = new String[size];
    /**
     * Counter of number elements.
     */
    private int count = 0;
    void showArray() {
        if (count == 0) {
            System.out.println("Empty mass");
        } else {
            System.out.println();
            for (int i = 0; i < count; i++) {
                System.out.println(array[i]);
            }
        }
    }

    void aDDBack(final String str1) {
        if (count == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
            array[count++] = str1;
        } else {
            array[count++] = str1;
        }
    }

    String arrayToStr() {
        StringBuilder str1 = new StringBuilder("");
        if (count != 0) {
            str1 = new StringBuilder(array[0]);
            str1.append(" ");
            for (int i = 1; i < count; i++) {
                str1.append(array[i]);
                str1.append(" ");
            }
        }
        return str1.toString();
    }

    void clearArray() {
        for (int i = 0; i < count; i++) {
            array[i] = null;
        }
        count = 0;
    }

    int getSize() {
        return count;
    }

    boolean contains(final String str) {
        boolean cont = false;
        for (int i = 0; i < count; i++) {
            if (cont) {
                return cont;
            } else {
                String str1;
                str1 = array[i];
                cont = str.equals(str1);
                if (i == count - 1) {
                    if (!cont) {
                        return cont;
                    }

                }
            }
        }
        return cont;
    }

    boolean remove(final String str) {
        boolean remov = false;
        int coun = 0;
        for (int i = 0; i < count; i++) {
            if (remov) {
                break;
            } else {
                remov = str.equals(array[i]);
                coun++;
            }
        }
        array[coun-1] = null;
        int temp = coun-1;
        for (int i = coun; i < count; i++) {
            array[temp++] = array[i];
        }
        count--;
        return remov;
    }

    public Object[] toArray() {
        if (array == null) {
            return null;
        }
        return Arrays.copyOf(array, count);
    }

    private String elementByIndex(final int index) {
        return array[index];
    }

    void lengthSorting(final int index) {
        array[index] = sortByLength(array[index]);
    }

    void alphabeticalSorting(final int index) {
        array[index] = sortAlphabetical(array[index]);
    }

    boolean containsAll(final Kontainer container) {
        boolean result;
        if (container.getSize() != count) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            result = array[i].equals(container.elementByIndex(i));
            if (!result) {
                return false;
            }
        }
        return true;
    }

    void helperSanchez() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index of string: ");
        int temp = count;
        System.out.println("Enter number from 1 to " + temp);
        int choose2 = scan.nextInt();
        String temp1 = array[choose2];
        array[choose2] = StrBuilder.execute(temp1, UI.getWord(), UI.getSentence());
    }

    void sortContainer() {
        String[] newString;
        newString = Arrays.copyOf(array, count);
        StringLengthSort str1 = new StringLengthSort();
        Arrays.sort(newString, str1);
        array = Arrays.copyOf(newString, count);
    }

    int search(final String str) {
        boolean cont = false;
        int temp = 0;
        for (int i = 0; i < count; i++) {
            temp++;
            if (cont) {
                return temp;
            } else {
                String str1;
                str1 = array[i];
                cont = str.equals(str1);
                if (i == count - 1) {
                    if (!cont) {
                        System.out.println("This element is abs");
                        return 0;
                    }
                }
            }
        }
        return temp;
    }

    boolean compression() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index first string: ");
        int choose1 = scan.nextInt();
        System.out.println("Enter index second string: ");
        int choose2 = scan.nextInt();
        return array[choose1-1].equals(array[choose2-1]);
    }

}



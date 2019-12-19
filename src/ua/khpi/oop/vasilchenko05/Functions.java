package ua.khpi.oop.vasilchenko05;
import java.util.Arrays;
import java.util.Scanner;

final class Functions {

    private Functions() {
        //default constructor
    }

    public static void chooseMenu() {
        System.out.println("\n\nChoose the right variant:");
        System.out.println("1. Create string");
        System.out.println("2. Show string");
        System.out.println("3. Sorting alphabetically");
        System.out.println("4. Sort by length");
        System.out.println("5. Delete string");
        System.out.println("0. The End");
        System.out.print("Write:");
    }


    static void showString(final String str) {
            System.out.print(str);
    }

    private static String[] differentWords(final String str) {
        int w = 0;
        int begin = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        String[] wordArr = new String[++count];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                wordArr[w] = str.substring(begin, i);
                w++;
                begin = i + 1;
            }
        }
        wordArr[w] = str.substring(begin, str.length());
        return wordArr;
    }


    public static String initializeStr() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str1;
            str1 = scan.nextLine();
        return str1;
    }

    static String sortAlphabetical(final String str) {
        System.out.println("\nSorting by alphabetical now");
        String str1 = "";
        String[] wordArr = differentWords(str);
        Arrays.sort(wordArr);
        str1 = reload(wordArr);
        System.out.println("Successfully");
        return str1;
    }

    static String sortByLength(final String str) {
        String str1 = "";
        System.out.println("\nSorting by length now");
        String[] wordArr = differentWords(str);
        StringLengthSort sort1 = new StringLengthSort();
        Arrays.sort(wordArr, sort1);
        str1 = reload(wordArr);
        System.out.println("Successfully");
        return str1;
    }

    private static String reload(final String[] str2) {
        StringBuilder str1 = new StringBuilder("");
        str1 = new StringBuilder(str2[0]);
        str1.append(" ");
        for (int i = 1; i < str2.length; i++) {
            str1.append(str2[i]);
            str1.append(" ");
        }
       str1.deleteCharAt(str1.length() - 1);
        return str1.toString();
    }
}

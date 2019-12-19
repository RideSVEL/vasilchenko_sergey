package ua.khpi.oop.vasilchenko06;
import ua.khpi.oop.vasilchenko06.StringLengthSort;

import java.util.Arrays;
import java.util.Scanner;

final class Functions {

    private Functions() {
        //default constructor
    }

    static void chooseMenu() {
        System.out.println("\n\nChoose the right variant:");
        System.out.println("1. Create and add string in container");
        System.out.println("2. Show elements in container");
        System.out.println("3. Sorting element alphabetically");
        System.out.println("4. Sort element by length");
        System.out.println("5. Clear container");
        System.out.println("6. Show container to string");
        System.out.println("7. Deleting element from container");
        System.out.println("8. Check contains in container");
        System.out.println("9. Execute string");
        System.out.println("10. Sort elements in container");
        System.out.println("11. Search elements in container");
        System.out.println("12. Compression two elements in container");
        System.out.println("13. Save elements in file");
        System.out.println("14. Read elements from file");
        System.out.println("0. The End");
        System.out.print("Write:");
    }


    private static String[] differentWords(final String str) {
        int word = 0;
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
                wordArr[word] = str.substring(begin, i);
                word++;
                begin = i + 1;
            }
        }
        wordArr[word] = str.substring(begin, str.length());
        return wordArr;
    }


    static String initializeStr() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string: ");
        return scan.nextLine();
    }

    static String sortAlphabetical(final String str) {
        String[] wordArr = differentWords(str);
        Arrays.sort(wordArr);
        return reload(wordArr);
    }

    static String sortByLength(final String str) {
        String[] wordArr = differentWords(str);
        StringLengthSort sort1 = new StringLengthSort();
        Arrays.sort(wordArr, sort1);
        return reload(wordArr);
    }

    private static String reload(final String[] str2) {
        StringBuilder str1 = new StringBuilder();
        for (String s : str2) {
            str1.append(s);
            str1.append(" ");
        }
        str1.deleteCharAt(str1.length() - 1);
        return str1.toString();
    }
}

package ua.khpi.oop.vasilchenko04;
import java.util.Scanner;

class Functions {

    static void ChooseMenu() {
        System.out.println("\n\nChoose the right variant:");
        System.out.println("1. Create string");
        System.out.println("2. Show string");
        System.out.println("3. Sorting alphabetically");
        System.out.println("4. Sort by length");
        System.out.println("5. Delete string");
        System.out.println("0. The End");
        System.out.print("Write:");
    }

    static void ShowStringMass(String[] str){
        for (int i = 0; i< str.length; i++)
            System.out.print(str[i]+" ");
    }

    static String[] InitializeString(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of words: ");
        int col = scan.nextInt();
        String[] str1 = new String[col];
        System.out.printf("Enter %d words:%n", col);
        for (int i = 0; i < str1.length; i++)
            str1[i] = scan.next();
        return str1;
    }
}

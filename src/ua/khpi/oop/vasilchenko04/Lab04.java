package ua.khpi.oop.vasilchenko04;
import java.util.Arrays;
import java.util.Scanner;

import static ua.khpi.oop.vasilchenko04.Functions.*;


class Lab04 {
    public static void main(String[] args) {
        ArgsCMD Arguments = new ArgsCMD(args);
        if (!Arguments.isEmpty()) {
            Arguments.arguments();
        }
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        int choose;
        String[] str1 = null;
        while (loop) {
            ChooseMenu();
            choose = scan.nextInt();
            switch (choose) {
                case 1:
                    if (str1 != null){
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 1. But string has been already created");
                        System.out.println("Error! String has been already created.");
                        break;
                    }
                    else {
                        if(ArgsCMD.DBG)
                            System.out.println("You choose 1. Creating string");
                        str1 = InitializeString();
                        break;
                    }
                case 2:
                    if (str1 == null){
                        if(ArgsCMD.DBG) {
                            System.out.println("You choose 2. But your string is empty");
                        }
                        System.out.println("Error! String is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG) {
                            System.out.println("You choose 2. Showing your string");
                        }
                        System.out.println("Your string:");
                        ShowStringMass(str1);
                        break;
                    }
                case 3:
                    if (str1 == null){
                        if (ArgsCMD.DBG) {
                            System.out.println("You choose 3. But your string is empty");
                        }
                        System.out.println("Error! String is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 3. Sorting now");
                        System.out.println("\nSorting alphabetically:");
                        Arrays.sort(str1);
                        System.out.println("Successfully!");
                        break;
                    }
                case 4:
                    if (str1 == null){
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 4. But your string is empty");
                        System.out.println("Error! String is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 4. Sorting now");
                        System.out.println("\nSort by length: ");
                        StringLengthSort sort1 = new StringLengthSort();
                        Arrays.sort(str1, sort1);
                        System.out.println("Successfully!");
                        break;
                    }
                case 5:
                    if (str1 == null){
                        if(ArgsCMD.DBG)
                            System.out.println("You choose 5. But your string is empty");
                        System.out.println("Error! String is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 5. Deleting string now");
                        str1 = null;
                        System.out.println("Deleting string successfully!");
                        break;
                    }
                case 0:
                    if (ArgsCMD.DBG)
                        System.out.println("You choose 0. You the end of Work");
                    System.out.println("\n\nThanks for working!");
                    loop = false;
                    break;
                default:
                    System.out.println("Error. Mistake number!");
                    break;
            }
        }
    }
}

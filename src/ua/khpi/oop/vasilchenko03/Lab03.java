package ua.khpi.oop.vasilchenko03;
import java.lang.String;
import java.util.Arrays;

public class Lab03 {

    public static void main(String[] args) {

        String[] str1 = new String[]{"Nikolai", "Petr", "Igorek", "Mark", "Ivan", "Maksim", "Krasavchik", "Albert", "Georg", "Franc", "Sanchez", "Bogdan"};
        System.out.println("Исходная строка:");
        ShowStringMass(str1);
        Arrays.sort(str1);
        System.out.println("\nСортировка по алфавиту:");
        ShowStringMass(str1);
        StringLengthSort sort1 = new StringLengthSort();
        Arrays.sort(str1, sort1);
        System.out.println("\nСортировка по длине:");
        ShowStringMass(str1);
        String str2 = new String("Privet medved");
        StringBuilder strBLD2 = new StringBuilder(str2);
        System.out.print("\n\nИспользовани StringBuilder:");
        System.out.println("\nИсходная строка:");
        System.out.println(strBLD2);
        strBLD2.append(" , poshli tuda!");
        System.out.println("\nПреобразование через StringBuilder:");
        System.out.println(strBLD2);
    }

    private static void ShowStringMass(String[] str){
        for (int i = 0; i< str.length; i++)
            System.out.print(str[i]+" ");
    }
}

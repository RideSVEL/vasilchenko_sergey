package ua.khpi.oop.vasilchenko02;

import java.util.Random;

class Lab02 {

    public static void main(String[] args) {
        Random rand = new Random();
        int chislo = rand.nextInt(Integer.MAX_VALUE);
        System.out.println("First number: " + chislo);
        int sum = amount(chislo);
        System.out.println("Sum cifr numbers: " + sum);
    }

    public static int amount(int chislo) {
        int sum = 0;
        while (chislo != 0) {
            sum += (chislo % 10);
            chislo /= 10;
        }
        return sum;
    }
}

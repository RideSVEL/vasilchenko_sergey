package ua.khpi.oop.vasilchenko15.Tests;

public class Lab15 {
    public static void main(String[] args) {
        if (args != null) {
            if (args[0].equals("-auto")) {
                Exe.auto();
            } else {
                System.out.println("Repeat entered with params -auto");
            }
        } else {
            Exe.menu();
        }
    }

}

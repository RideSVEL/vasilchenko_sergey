package ua.khpi.oop.vasilchenko12.Tests;


import java.io.IOException;

public class Lab12 {
    public static void main(String[] args) throws IOException {
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

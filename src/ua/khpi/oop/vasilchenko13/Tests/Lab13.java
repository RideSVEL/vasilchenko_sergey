package ua.khpi.oop.vasilchenko13.Tests;


import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Lab13 {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
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

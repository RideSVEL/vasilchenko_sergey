package ua.khpi.oop.vasilchenko14.Tests;

import ua.khpi.oop.vasilchenko14.First.Recruitment;
import ua.khpi.oop.vasilchenko14.MyList.LinkedContainer;
import ua.khpi.oop.vasilchenko14.MyList.Treads;
import ua.khpi.oop.vasilchenko14.MyList.Util;


import java.util.concurrent.*;

public class Lab14 {
    public static void main(String[] args) throws Exception {
        LinkedContainer<Recruitment> linkedContainer = new LinkedContainer<>();
        Recruitment rec1 = new Recruitment();
        Recruitment rec2 = new Recruitment();
        Recruitment rec3 = new Recruitment();

        rec1.setPayment(2600);
        rec2.setPayment(3700);
        for (int i = 0; i < 45000; i++) {
            linkedContainer.add(rec1);
            linkedContainer.add(rec2);
        }
        rec3.setPayment(600);
        for (int i = 0; i < 50000; i++) {
            linkedContainer.add(rec3);
        }
        rec2.setPayment(2500);
        linkedContainer.add(rec2);
        rec2.setPayment(500);
        linkedContainer.add(rec2);
        Treads.MyTread1 myTread1 = new Treads.MyTread1();
        myTread1.set(linkedContainer);
        Treads.MyTread2 myTread2 = new Treads.MyTread2();
        myTread2.set(linkedContainer);
        Treads.MyTread3 myTread3 = new Treads.MyTread3();
        myTread3.set(linkedContainer);
        System.out.println("++++++++Another threads++++++++++");
        long start2 = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> future = executorService.submit(myTread1);
        Future<Boolean> future1 = executorService.submit(myTread2);
        Future<Boolean> future2 = executorService.submit(myTread3);
            future.get();
            future1.get();
            future2.get();
        future.cancel(true);
        future1.cancel(true);
        future2.cancel(true);
        executorService.shutdown();
        long finish2 = System.currentTimeMillis();
        long result2 = finish2 - start2;
        System.out.println("++++++++Main thread+++++++");
        long start = System.currentTimeMillis();
        myTread1.call();
        myTread2.call();
        myTread3.call();
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Main time: " + result / 1000.0 + " seconds.");
        System.out.println("Another threads time: " + result2 / 1000.0 + " seconds.");
    }
}

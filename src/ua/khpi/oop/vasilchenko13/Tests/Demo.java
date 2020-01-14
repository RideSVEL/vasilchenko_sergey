package ua.khpi.oop.vasilchenko13.Tests;


import ua.khpi.oop.vasilchenko13.First.Recruitment;
import ua.khpi.oop.vasilchenko13.MyList.LinkedContainer;
import ua.khpi.oop.vasilchenko13.MyList.Treads;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.concurrent.*;

import static ua.khpi.oop.vasilchenko13.MyList.Treads.MyTread1;
import static ua.khpi.oop.vasilchenko13.MyList.Treads.MyTread2;
import static ua.khpi.oop.vasilchenko13.MyList.Treads.MyTread3;


public class Demo {
    public static void main(String[] args) throws InputMismatchException, IOException, InterruptedException, TimeoutException, ExecutionException {
        //Lab13.main(new String[] {"-auto"});
        Lab13.main(null);



       // LinkedContainer<Recruitment> linkedContainer = new LinkedContainer<>();
//        Recruitment rec1 = new Recruitment();
//        Recruitment rec2 = new Recruitment();
//        Recruitment rec3 = new Recruitment();
//
////        rec1.setPayment(2600);
////        rec2.setPayment(3700);
////        for (int i = 0; i < 10000; i++) {
////            linkedContainer.add(rec1);
////            linkedContainer.add(rec2);
////        }
////        rec3.setPayment(600);
////        for (int i = 0; i < 1200; i++) {
////            linkedContainer.add(rec3);
////        }
////        rec2.setPayment(2500);
////        linkedContainer.add(rec2);
////        rec2.setPayment(500);
////        linkedContainer.add(rec2);
////        MyTread1 myTread1 = new MyTread1();
////        myTread1.set(linkedContainer);
////        MyTread2 myTread2 = new MyTread2();
////        myTread2.set(linkedContainer);
////        MyTread3 myTread3 = new MyTread3();
////        myTread3.set(linkedContainer);
////        ExecutorService executorService = Executors.newFixedThreadPool(3);
////        Future<Boolean> future = executorService.submit(myTread1);
////        Future<Boolean> future1 = executorService.submit(myTread2);
////        Future<Boolean> future2 = executorService.submit(myTread3);
////        try {
////            future.get(2, TimeUnit.SECONDS);
////            future1.get(2, TimeUnit.SECONDS);
////            future2.get(2, TimeUnit.SECONDS);
////        } catch (TimeoutException ex) {
////            future.cancel(true);
////            future1.cancel(true);
////            future2.cancel(true);
////        }
////        executorService.shutdown();

    }
}

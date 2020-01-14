package ua.khpi.oop.vasilchenko13.Tests;


import ua.khpi.oop.vasilchenko13.First.Recruitment;
import ua.khpi.oop.vasilchenko13.MyList.LinkedContainer;
import ua.khpi.oop.vasilchenko13.MyList.Treads;
import ua.khpi.oop.vasilchenko13.MyList.Util;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Exe {
    public static void auto() throws InputMismatchException {
        System.out.println("It is auto mode");
        System.out.println("Creating object container:");
        LinkedContainer<Recruitment> linkedContainer = new LinkedContainer<>();
        System.out.println("Reading from file: ");
        linkedContainer.readRec();
        System.out.println("Print container:");
        for (Recruitment s : linkedContainer) {
            System.out.println(s);
        }
        Thread thread = new Thread(linkedContainer);
        thread.start();
        System.out.println("Size: ");
        System.out.println(linkedContainer.size());
        System.out.println("Clear: ");
        linkedContainer.clear();
        System.out.println("Size: ");
        System.out.println(linkedContainer.size());
        System.out.println("Reading from file: ");
        linkedContainer.readRec();
        System.out.print("Not empty? : ");
        System.out.println(linkedContainer.notEmpty());
        System.out.println("Element with index 0");
        System.out.println(linkedContainer.getElementByIndex(0));
        System.out.println("Creating selection: ");
        Util.createSelection(linkedContainer);
        Recruitment rec1 = new Recruitment();
        Recruitment rec2 = new Recruitment();
        Recruitment rec3 = new Recruitment();

        rec1.setPayment(2600);
        rec2.setPayment(3700);
        for (int i = 0; i < 10000; i++) {
            linkedContainer.add(rec1);
            linkedContainer.add(rec2);
        }
        rec3.setPayment(600);
        for (int i = 0; i < 1200; i++) {
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
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(myTread1);
        executorService.submit(myTread2);
        executorService.submit(myTread3);
        executorService.shutdown();
    }

    public static void menu() throws InputMismatchException, ExecutionException, InterruptedException {
        System.out.println("It is menu mode");
        LinkedContainer<Recruitment> linkedContainer = new LinkedContainer<>();
        Recruitment rec1 = new Recruitment();
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            Util.chooseMenu();
            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    rec1.generateVacancy();
                    linkedContainer.add(rec1);
                    break;
                case 2:
                    if (linkedContainer.notEmpty()) {
                        int count = 0;
                        for (Recruitment s : linkedContainer) {
                            System.out.println("#" + (++count));
                            System.out.println(s);
                        }
                    } else {
                        System.out.println("Ошибка! Список пустой!");
                    }
                    break;
                case 3:
                    if (linkedContainer.notEmpty()) {
                        linkedContainer.clear();
                        System.out.println("Успешно!");
                    } else {
                        System.out.println("Ошибка! Массив пустой!");
                    }
                    break;
                case 4:
                    if (linkedContainer.notEmpty()) {
                        System.out.println("Your container have data.");
                    } else {
                        System.out.println("Your container doesnt have data.");
                    }
                    break;
                case 5:
                    System.out.println("Size of container: " + linkedContainer.size());
                    break;
                case 6:
                    if (linkedContainer.notEmpty()) {
                        System.out.print("Entered index from 0 to " + (linkedContainer.size() - 1) + ": ");
                        int choose1 = scan.nextInt();
                        if (choose1 > (linkedContainer.size() - 1) || choose1 < 0) {
                            System.out.println("Repeat enter");
                        } else {
                            System.out.println(linkedContainer.getElementByIndex(choose1));
                        }
                        break;
                    }
                case 7:
                    if (linkedContainer.notEmpty()) {
                        linkedContainer.saveRec();
                    } else {
                        System.out.println("Your container is empty");
                    }
                    break;
                case 8:
                    if (linkedContainer.notEmpty()) {
                        linkedContainer.clear();
                    }
                    linkedContainer.readRec();
                    break;
                case 9:
                    if (linkedContainer.notEmpty()) {
                        System.out.println("What field do you want to sort by?");
                        System.out.println("1. Sort by firm");
                        System.out.println("2. Sort by specialty");
                        System.out.println("3. Sort by education");
                        int choose2 = scan.nextInt();
                        boolean loop2 = true;
                        while (loop2) {
                            switch (choose2) {
                                case 1:
                                    Util.sortFirm(linkedContainer);
                                    loop2 = false;
                                    break;
                                case 2:
                                    Util.sortSpecialty(linkedContainer);
                                    loop2 = false;
                                    break;
                                case 3:
                                    Util.sortEducation(linkedContainer);
                                    loop2 = false;
                                    break;
                                default:
                                    System.out.println("Ошибка. Неверное число!");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Your container is empty");
                    }
                    break;
                case 10:
                    Util.createSelection(linkedContainer);
                    break;
                case 11:
                    if (linkedContainer.notEmpty()) {
                        Treads.MyTread1 myTread1 = new Treads.MyTread1();
                        myTread1.set(linkedContainer);
                        Treads.MyTread2 myTread2 = new Treads.MyTread2();
                        myTread2.set(linkedContainer);
                        Treads.MyTread3 myTread3 = new Treads.MyTread3();
                        myTread3.set(linkedContainer);
                        System.out.println("Entered time to run thread: ");
                        int time = scan.nextInt();
                        ExecutorService executorService = Executors.newFixedThreadPool(3);
                        Future<Boolean> future = executorService.submit(myTread1);
                        Future<Boolean> future1 = executorService.submit(myTread2);
                        Future<Boolean> future2 = executorService.submit(myTread3);
                        try {
                            future.get(time, TimeUnit.SECONDS);
                            future1.get(time, TimeUnit.SECONDS);
                            future2.get(time, TimeUnit.SECONDS);
                        } catch (TimeoutException ex) {
                            future.cancel(true);
                            future1.cancel(true);
                            future2.cancel(true);
                        }
                        executorService.shutdown();
                    } else {
                        System.out.println("List is empty!");
                    }
                    break;
                case 0:
                    System.out.println("Thanks for working!");
                    loop = false;
                    break;
                default:
                    System.out.println("Ошибка. Неверное число!");
                    break;
            }
        }
    }
}

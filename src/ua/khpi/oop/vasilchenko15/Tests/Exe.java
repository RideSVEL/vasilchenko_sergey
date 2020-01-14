package ua.khpi.oop.vasilchenko15.Tests;

import ua.khpi.oop.vasilchenko15.Container.Container;
import ua.khpi.oop.vasilchenko15.Container.Util;
import ua.khpi.oop.vasilchenko15.First.Recruitment;

import java.util.Scanner;

public class Exe {

    public static void auto() {
        System.out.println("it is auto mode!");
        Container container = new Container();
        Recruitment rec1 = new Recruitment();
        System.out.println("============ Read from file ===========");
        container.read();
        container.show();
        rec1.setFirm("University");
        rec1.setPayment(3200);
        rec1.setSpecialty("Java");
        rec1.setWorkingConditions("full time");
        container.add(rec1);
        System.out.println("========== Add one element ============");
        container.show();
        System.out.println("========== Sorting by firm ============");
        container.sortByFirm();
        container.show();
        System.out.println("=========== Clear container ===========");
        container.clear();
        container.show();
        System.out.println(container.size());
    }

    public static void menu() {
        System.out.println("It is menu mode");
        Container container = new Container();
        Recruitment rec1 = new Recruitment();
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            Util.chooseMenu();
            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    rec1.generateVacancy();
                    container.add(rec1);
                    break;
                case 2:
                    if (container.notEmpty()) {
                        container.show();
                    } else {
                        System.out.println("Error. List is empty!!");
                    }
                    break;
                case 3:
                    if (container.notEmpty()) {
                        container.clear();
                        System.out.println("Done!");
                    } else {
                        System.out.println("Error. List is empty!");
                    }
                    break;
                case 4:
                    if (container.notEmpty()) {
                        System.out.println("Your container have data.");
                    } else {
                        System.out.println("Your container doesnt have data.");
                    }
                    break;
                case 5:
                    System.out.println("Size of container: " + container.size());
                    break;
                case 6:
                    if (container.notEmpty()) {
                        System.out.print("Entered index from 0 to " + (container.size() - 1) + ": ");
                        int choose1 = scan.nextInt();
                        if (choose1 > (container.size() - 1) || choose1 < 0) {
                            System.out.println("Repeat enter");
                        } else {
                            System.out.println(container.getElementByIndex(choose1));
                        }
                        break;
                    }
                case 7:
                    if (container.notEmpty()) {
                        container.save();
                    } else {
                        System.out.println("Your container is empty");
                    }
                    break;
                case 8:
                    if (container.notEmpty()) {
                        container.clear();
                    }
                    container.read();
                    break;
                case 9:
                    if (container.notEmpty()) {
                        System.out.println("What field do you want to sort by?");
                        System.out.println("1. Sort by firm");
                        System.out.println("2. Sort by specialty");
                        System.out.println("3. Sort by education");
                        int choose2 = scan.nextInt();
                        boolean loop2 = true;
                        while (loop2) {
                            switch (choose2) {
                                case 1:
                                    container.sortByFirm();
                                    loop2 = false;
                                    break;
                                case 2:
                                    container.sortBySpecialty();
                                    loop2 = false;
                                    break;
                                case 3:
                                    container.sortByEducation();
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
                case 0:
                    System.out.println("Thanks for working!");
                    loop = false;
                    break;
                default:
                    System.out.println("Error. Wrong number!");
                    break;
            }
        }
    }
}

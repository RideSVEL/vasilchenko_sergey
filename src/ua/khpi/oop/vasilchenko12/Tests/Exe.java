package ua.khpi.oop.vasilchenko12.Tests;


import ua.khpi.oop.vasilchenko12.First.Recruitment;
import ua.khpi.oop.vasilchenko12.MyList.LinkedContainer;
import ua.khpi.oop.vasilchenko12.MyList.Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exe {
    public static void auto() throws InputMismatchException{
        System.out.println("It is auto mode");
        System.out.println("Creating object container:");
        LinkedContainer<Recruitment> linkedContainer = new LinkedContainer<>();
        System.out.println("Reading from file: ");
        linkedContainer.readRec();
        System.out.println("Print container:");
        for (Recruitment s : linkedContainer) {
            System.out.println(s);
        }
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
    }

    public static void menu() throws InputMismatchException {
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
                    //System.out.println("Done!");
                    break;
                case 2:
                    if (linkedContainer.notEmpty()) {
                        int count = 0;
                        for (Recruitment s : linkedContainer) {
                            System.out.println("#"+(++count));
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

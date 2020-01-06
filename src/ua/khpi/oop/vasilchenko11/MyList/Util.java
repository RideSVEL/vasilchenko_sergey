package ua.khpi.oop.vasilchenko11.MyList;

import ua.khpi.oop.vasilchenko11.First.Recruitment;

import java.util.Arrays;

public class Util {
    public static <T extends Recruitment> void sortFirm(LinkedContainer<T> obj) {
        Recruitment[] array = new Recruitment[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, Recruitment.compareByFirm);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add((T) array[i]);
        }
    }

    public static <T extends Recruitment> void sortSpecialty(LinkedContainer<T> obj) {
        Recruitment[] array = new Recruitment[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, Recruitment.compareBySpecialty);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add((T) array[i]);
        }
    }

    public static <T extends Recruitment> void sortEducation(LinkedContainer<T> obj) {
        Recruitment[] array = new Recruitment[obj.size()];
        int count = 0;
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
            if (array[i].getEducation() == null) {
                count++;
            }
        }
        Recruitment[] buff = new Recruitment[count];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i].getEducation() == null) {
                buff[j] = array[i];
                j++;
            }
        }
        Recruitment[] temp = new Recruitment[obj.size() - count];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i].getEducation() != null) {
                temp[j] = array[i];
                j++;
            }
        }
        Arrays.sort(temp, Recruitment.compareByEducation);
        obj.clear();
        for (int i = 0; i < temp.length; i++) {
            obj.add((T) temp[i]);
        }
        for (int i = 0; i < buff.length; i++) {
            obj.add((T) buff[i]);
        }
    }

    public static void chooseMenu() {
        System.out.println();
        System.out.println("1. Add vacancy.");
        System.out.println("2. Show all vacancies.");
        System.out.println("3. Clear container.");
        System.out.println("4. Check elements in container.");
        System.out.println("5. Size of container.");
        System.out.println("6. Get element by index.");
        System.out.println("7. Save data to file.");
        System.out.println("8. Read data from file.");
        System.out.println("9. Sorting data in container.");
        System.out.println("0. End of work.");
        System.out.print("Write your choose there: ");
    }
}

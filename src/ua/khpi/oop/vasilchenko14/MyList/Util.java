package ua.khpi.oop.vasilchenko14.MyList;

import ua.khpi.oop.vasilchenko14.First.Recruitment;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static <T extends Recruitment> Recruitment[] initialisation(LinkedContainer<T> obj) {
        Recruitment[] array = new Recruitment[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        return array;
    }

    public static <T extends Recruitment> void sortFirm(LinkedContainer<T> obj) {
        Recruitment[] array = initialisation(obj);
        Arrays.sort(array, Recruitment.compareByFirm);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add((T) array[i]);
        }
    }


    public static <T extends Recruitment> void sortSpecialty(LinkedContainer<T> obj) {
        Recruitment[] array = initialisation(obj);
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

    public static <T extends Recruitment> void createSelection(LinkedContainer<T> obj) {
        if (obj.notEmpty()) {
            int count = 0;
            for (Recruitment s : obj) {
                Pattern p1 = Pattern.compile("teacher", Pattern.CASE_INSENSITIVE);
                Matcher m1 = p1.matcher(s.getSpecialty());
                if (m1.find()) {
                    if (s.getExperience() >= 10) {
                        Pattern p2 = Pattern.compile("english", Pattern.CASE_INSENSITIVE);
                        Matcher m2 = p2.matcher(s.getWorkingConditions());
                        if (m2.find()) {
                            Pattern p3 = Pattern.compile("car", Pattern.CASE_INSENSITIVE);
                            Matcher m3 = p3.matcher(s.getWorkingConditions());
                            if (m3.find()) {
                                System.out.println("#" + (++count));
                                System.out.println(s);
                            }
                        }
                    }
                }
            }
        } else {
            return;
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
        System.out.println("10. Create selection from container.");
        System.out.println("0. End of work.");
        System.out.print("Write your choose there: ");
    }


}

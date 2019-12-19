package ua.khpi.oop.vasilchenko07;

import java.util.Arrays;

class Kontainer {

    /**
     * First size for array.
     */
    private final int size = 10;
    /**
     * Array contains all data.
     */
    private int count = 0;

    private Recruitment[] massik = new Recruitment[size];


    void add(final Recruitment temp){
        if (count == massik.length) {
            massik = Arrays.copyOf(massik, massik.length * 2);
            massik[count++] = temp;
        } else {
            massik[count++] = temp;
        }
    }

    void show() {
        if (count == 0) {
            System.out.println("Ошибка! Пустой массив!");
        } else {
            System.out.println();
            for (int i = 0; i < count; i++) {
                System.out.println("Вакансия #" + (i+1));
                System.out.println("Фирма: " + massik[i].getFirm());
                System.out.println("Специальность: " + massik[i].getSpecialty());
                System.out.println("Условия работы: " + massik[i].getWorkingConditions());
                System.out.println("Оплата: " + massik[i].getPayment());
                if (massik[i].getConfirms()) {
                    System.out.println("Необходимая специальность: " + massik[i].getNeedsSpeciality());
                    System.out.println("Опыт: " + massik[i].getExperience());
                    System.out.println("Образование: " + massik[i].getEducation());
                }
            }
        }
    }

    void clear() {
        for (int i = 0; i < count; i++) {
            massik[i] = null;
        }
        count = 0;
    }

    public void remove(int index) {
        for (int i = index; i < count; i++) {
            massik[index++] = massik[i + 1];
        }
        count--;
    }
}

package ua.khpi.oop.vasilchenko08;

import ua.khpi.oop.vasilchenko08.Recruitment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

class Kontainer implements Serializable {

    /**
     * First size for array.
     */
    private final int size = 10;
    /**
     * Array contains all data.
     */
    private int count = 0;

    private Recruitment[] massik = new Recruitment[size];


    void add(final Recruitment temp) {
        Recruitment buff = new Recruitment(temp);
        if (count == massik.length) {
            massik = Arrays.copyOf(massik, massik.length * 2);
            massik[count++] = buff;
        } else {
            massik[count++] = buff;
        }
    }

    void save() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            for (int i = 0; i < count; i++) {
                pw.println(count);
                pw.println(massik[i].getFirm());
                pw.println(massik[i].getSpecialty());
                pw.println(massik[i].getWorkingConditions());
                pw.println(massik[i].getPayment());
                pw.println(massik[i].getConfirms());
                if (massik[i].getConfirms()) {
                    pw.println(massik[i].getNeedsSpeciality());
                    pw.println(massik[i].getExperience());
                    pw.println(massik[i].getEducation());
                }
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    void save(final String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            for (int i = 0; i < count; i++) {
                pw.println(count);
                pw.println(massik[i].getFirm());
                pw.println(massik[i].getSpecialty());
                pw.println(massik[i].getWorkingConditions());
                pw.println(massik[i].getPayment());
                pw.println(massik[i].getConfirms());
                if (massik[i].getConfirms()) {
                    pw.println(massik[i].getNeedsSpeciality());
                    pw.println(massik[i].getExperience());
                    pw.println(massik[i].getEducation());
                }
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    void read() throws IOException {
        Recruitment temp = new Recruitment();
        try (BufferedReader br = new BufferedReader(new FileReader("save.txt"))) {
            String line;
            line = br.readLine();
            count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp.setFirm(line);
                line = br.readLine();
                temp.setSpecialty(line);
                line = br.readLine();
                temp.setWorkingConditions(line);
                line = br.readLine();
                temp.setPayment(Integer.parseInt(line));
                line = br.readLine();
                temp.setConfirm(Boolean.parseBoolean(line));
                if (temp.getConfirms()) {
                    line = br.readLine();
                    temp.setNeedsSpeciality(line);
                    line = br.readLine();
                    temp.setExperience(Integer.parseInt(line));
                    line = br.readLine();
                    temp.setEducation(line);
                }
                massik[i] = new Recruitment(temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void show() {
        if (count == 0) {
            System.out.println("Ошибка! Пустой массив!");
        } else {
            System.out.println();
            for (int i = 0; i < count; i++) {
                System.out.println("Вакансия #" + (i + 1));
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

    void remove(final int index) {
        int temp = index;
        for (int i = temp; i < count; i++) {
            massik[temp++] = massik[i + 1];
        }
        massik[count] = null;
        count--;
    }

    int size() {
        return count;
    }
}

package ua.khpi.oop.vasilchenko15.First;

import java.io.Serializable;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recruitment implements Serializable {
    private String firm;
    private String specialty;
    private String workingConditions;
    private int payment;


    private String needsSpeciality;
    private int experience;
    private String education;

    private boolean confirm;

    public void setFirm(final String firm) throws InputMismatchException {
        if (checkFirm(firm)) {
            this.firm = firm;
        } else {
            throw new InputMismatchException();
        }
    }

    private boolean checkFirm(final String firm) {
        Pattern pattern = Pattern.compile("[\\sa-z0-9.%$+#@^()=!_\\\\-]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(firm);
        return matcher.matches();
    }

    public void setSpecialty(final String specialty) throws InputMismatchException {
        if (checkSpecialty(specialty)) {
            this.specialty = specialty;
        } else {
            throw new InputMismatchException();
        }
    }

    private boolean checkSpecialty(final String specialty) {
        Pattern pattern = Pattern.compile("[\\s\\w.#%@&+=]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(specialty);
        return matcher.matches();
    }

    public void setWorkingConditions(final String workingConditions) throws InputMismatchException {
        if (checkWorkingConditions(workingConditions)) {
            this.workingConditions = workingConditions;
        } else {
            throw new InputMismatchException();
        }
    }

    private boolean checkWorkingConditions(final String workingConditions) {
        Pattern pattern = Pattern.compile("[\\s\\w%$+#@^()=,!_\\\\-]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(workingConditions);
        return matcher.matches();
    }

    public void setPayment(final int payment) {
        this.payment = payment;
    }

    public void setConfirm(final boolean confirm) {
        this.confirm = confirm;
    }

    public int getPayment() {
        return payment;
    }

    public String getWorkingConditions() {
        return workingConditions;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getFirm() {
        return firm;
    }

    public Recruitment() {
        firm = null;
        specialty = null;
        workingConditions = null;
        payment = 0;
        needsSpeciality = null;
        experience = 0;
        education = null;
        confirm = false;

    }

    public String show() {
        String show;
        show = "Фирма: " + firm + "\n" +
                "Специальность: " + specialty + "\n" +
                "Условия работы: " + workingConditions + "\n" +
                "Оплата: " + payment + "\n";
        if (confirm) {
            show += "Необходимая специальность: " + needsSpeciality + "\n";
            show += "Опыт: " + experience + "\n";
            show += "Образование: " + education + "\n";
        }
        return show;
    }

    public Recruitment(final Recruitment obj) {
        firm = obj.firm;
        specialty = obj.specialty;
        workingConditions = obj.workingConditions;
        payment = obj.payment;
        needsSpeciality = obj.needsSpeciality;
        experience = obj.experience;
        education = obj.education;
        confirm = obj.confirm;
    }

    public void generateVacancy() throws InputMismatchException {
        try {
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            int choose;
            System.out.print("\nВведите фирму: ");
            setFirm(scan.nextLine());
            System.out.print("\nВведите специальность: ");
            setSpecialty(scan.nextLine());
            System.out.print("\nВведите требования работы: ");
            setWorkingConditions(scan.nextLine());
            System.out.print("\nВведите оплату: ");
            setPayment(scan.nextInt());
            System.out.println("Желаете добавить дополнительные условия работы? 1 - Да. 0 - Нет: ");

            boolean loop = true;
            while (loop) {
                choose = scan.nextInt();
                switch (choose) {
                    case 1:
                        System.out.print("\nВведите необходимую специальность: ");
                        setNeedsSpeciality(scan2.nextLine());
                        System.out.print("\nНеобходимое образование: ");
                        setEducation(scan2.nextLine());
                        System.out.print("\nНеобходимый опыт работы: ");
                        setExperience(scan2.nextInt());
                        confirm = true;
                        loop = false;
                        break;
                    case 0:
                        needsSpeciality = null;
                        experience = 0;
                        education = null;
                        loop = false;
                        break;
                    default:
                        System.out.println("Ошибка! Повторите ввод: ");
                        break;
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Wrong input!");
            firm = null;
            specialty = null;
            workingConditions = null;
            payment = 0;
            needsSpeciality = null;
            experience = 0;
            education = null;
            confirm = false;
        }
    }


    public void setExperience(final int experience) throws InputMismatchException {
        if (checkExperience(experience)) {
            this.experience = experience;
        } else {
            throw new InputMismatchException();
        }
    }

    /**
     * Проверка правильности ввода опыта.
     * до 49 лет включительно.
     *
     * @param experience - опыт.
     * @return подтверждение сравнения.
     */
    private boolean checkExperience(final int experience) {
        Pattern pattern = Pattern.compile("[0-9]{1,2}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(String.valueOf(experience));
        return matcher.matches();
    }

    public int getExperience() {
        return experience;
    }

    public void setNeedsSpeciality(final String needsSpeciality) throws InputMismatchException {
        if (checkNeedsSpeciality(needsSpeciality)) {
            this.needsSpeciality = needsSpeciality;
        } else {
            throw new InputMismatchException();
        }
    }

    private boolean checkNeedsSpeciality(final String needsSpeciality) {
        Pattern pattern = Pattern.compile("[\\s\\w%$+#@^()=!_\\\\-]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(needsSpeciality);
        return matcher.matches();
    }


    public String getNeedsSpeciality() {
        return needsSpeciality;
    }

    public void setEducation(final String education) throws InputMismatchException {
        if (checkEducation(education)) {
            this.education = education;
        } else {
            throw new InputMismatchException();
        }
    }

    private boolean checkEducation(final String education) {
        Pattern pattern = Pattern.compile("[a-z]*-?\\s?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(education);
        return matcher.matches();
    }

    public String getEducation() {
        return education;
    }

    public boolean getConfirms() {
        return confirm;
    }

    @Override
    public String toString() {
        return show();
    }

    public static final Comparator<Recruitment> compareByEducation = new Comparator<Recruitment>() {
        @Override
        public int compare(Recruitment o1, Recruitment o2) {
            return o1.getEducation().compareTo(o2.getEducation());
        }
    };
    public static final Comparator<Recruitment> compareByFirm = new Comparator<Recruitment>() {
        @Override
        public int compare(Recruitment o1, Recruitment o2) {
            return o1.getFirm().compareTo(o2.getFirm());
        }
    };
    public static final Comparator<Recruitment> compareBySpecialty = new Comparator<Recruitment>() {
        @Override
        public int compare(Recruitment o1, Recruitment o2) {
            return o1.getSpecialty().compareTo(o2.getSpecialty());
        }
    };
}

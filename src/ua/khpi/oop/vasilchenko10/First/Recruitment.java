package ua.khpi.oop.vasilchenko10.First;

import java.util.Comparator;
import java.util.Scanner;

public class Recruitment {
    private String firm;
    private String specialty;
    private String workingConditions;
    private int payment;

    private String needsSpeciality;
    private int experience;
    private String education;

    private boolean confirm;

    public void setFirm(final String firm) {
        this.firm = firm;
    }

    public void setSpecialty(final String specialty) {
        this.specialty = specialty;
    }

    public void setWorkingConditions(final String workingConditions) {
        this.workingConditions = workingConditions;
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

    public void generateVacancy() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int choose;
        System.out.print("\nВведите фирму: ");
        firm = scan.nextLine();
        System.out.print("\nВведите специальность: ");
        specialty = scan.nextLine();
        System.out.print("\nВведите условия работы: ");

        workingConditions = scan.nextLine();
        System.out.print("\nВведите оплату: ");
        payment = scan.nextInt();
        System.out.println("Желаете добавить дополнительные условия работы? 1 - Да. 0 - Нет: ");

        boolean loop = true;
        while (loop) {
            choose = scan.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("\nВведите необходимую специальность: ");
                    needsSpeciality = scan2.nextLine();
                    System.out.print("\nНеобходимое образование: ");
                    education = scan2.nextLine();
                    System.out.print("\nНеобходимый опыт работы: ");
                    experience = scan2.nextInt();
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
    }




    public void setExperience(final int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setNeedsSpeciality(final String needsSpeciality) {
        this.needsSpeciality = needsSpeciality;
    }

    public String getNeedsSpeciality() {
        return needsSpeciality;
    }

    public void setEducation(final String education) {
        this.education = education;
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

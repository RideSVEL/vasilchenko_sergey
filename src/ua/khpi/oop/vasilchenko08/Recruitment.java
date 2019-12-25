package ua.khpi.oop.vasilchenko08;

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

    Recruitment(final Recruitment obj) {
        firm = obj.firm;
        specialty = obj.specialty;
        workingConditions = obj.workingConditions;
        payment = obj.payment;
        needsSpeciality = obj.needsSpeciality;
        experience = obj.experience;
        education = obj.education;
        confirm = obj.confirm;
    }

    void generateVacancy() {
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
        System.out.println("Желаете добавить дополнительные условия работы? 1 - Да. 0 - Нет");
        choose = scan.nextInt();
        while (true) {
            if (choose == 1) {
                System.out.print("\nВведите необходимую специальность: ");
                needsSpeciality = scan2.nextLine();
                System.out.print("\nНеобходимое образование: ");
                education = scan2.nextLine();
                System.out.print("\nНеобходимый опыт работы: ");
                experience = scan2.nextInt();
                confirm = true;
                break;
            } else if (choose == 0) {
                needsSpeciality = null;
                experience = 0;
                education = null;
                break;
            } else {
                System.out.println("Ошибка! Повторите ввод: ");
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
        return "Recruitment{" +
                "firm='" + firm + '\'' +
                ", specialty='" + specialty + '\'' +
                ", workingConditions='" + workingConditions + '\'' +
                ", payment=" + payment +
                ", needsSpeciality='" + needsSpeciality + '\'' +
                ", experience=" + experience +
                ", education='" + education + '\'' +
                ", confirm=" + confirm +
                '}';
    }
}

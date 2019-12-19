package ua.khpi.oop.vasilchenko07;

import java.util.Scanner;

class Recruitment {
    private String firm;
    private String specialty;
    private String workingConditions;
    private int payment;

    private String needsSpeciality;
    private int experience;
    private String education;

    private boolean confirm = false;



    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setWorkingConditions(String workingConditions) {
        this.workingConditions = workingConditions;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    int getPayment() {
        return payment;
    }
    String getWorkingConditions() {
        return workingConditions;
    }
    String getSpecialty() {
        return specialty;
    }
    String getFirm() {
        return firm;
    }

    void generateVacancy() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int choose = 0;
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
        while (true){
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

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setNeedsSpeciality(String needsSpeciality) {
        this.needsSpeciality = needsSpeciality;
    }

    public String getNeedsSpeciality() {
        return needsSpeciality;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public boolean getConfirms() {
        return confirm;
    }
}

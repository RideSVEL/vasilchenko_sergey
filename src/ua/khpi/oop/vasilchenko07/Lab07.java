package ua.khpi.oop.vasilchenko07;

public class Lab07 {
    public static void main(String[] args) {
        Kontainer contains = new Kontainer();
        Recruitment rec1 = new Recruitment();
        Recruitment rec2 = new Recruitment();
        rec1.generateVacancy();
        contains.add(rec1);
        contains.add(rec1);
        contains.add(rec1);
        rec2.generateVacancy();
        contains.add(rec2);
        contains.show();
    }
}

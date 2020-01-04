package ua.khpi.oop.vasilchenko09.tests;

import ua.khpi.oop.vasilchenko09.First.Recruitment;
import ua.khpi.oop.vasilchenko09.MyList.LinkedContainer;


public final class Lab09 {

    private Lab09() {
    }

    public static void main(final String[] args) {

        LinkedContainer<Recruitment> stringLinked = new LinkedContainer<>();
        Recruitment recruitment = new Recruitment();

        System.out.println("==================");
        System.out.println(stringLinked.size());
        stringLinked.readRec();
        System.out.println("==================");
        for (Recruitment s : stringLinked) {
            System.out.println(s);
        }
        System.out.println("==================");
        System.out.println(stringLinked.size());
        System.out.println("==================");

    }
}

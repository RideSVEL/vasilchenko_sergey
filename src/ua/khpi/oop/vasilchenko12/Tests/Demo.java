package ua.khpi.oop.vasilchenko12.Tests;


import ua.khpi.oop.vasilchenko12.First.Recruitment;
import ua.khpi.oop.vasilchenko12.MyList.LinkedContainer;
import ua.khpi.oop.vasilchenko12.MyList.Util;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Demo {
    public static void main(String[] args) throws InputMismatchException, IOException {
        Lab12.main(new String[] {"-auto"});
        Lab12.main(args);

//        LinkedContainer<Recruitment> linkedContainer = new LinkedContainer<>();
//        Recruitment recruitment = new Recruitment();
//        recruitment.generateVacancy();
//        linkedContainer.add(recruitment);
//        Util.createSelection(linkedContainer);
    }
}

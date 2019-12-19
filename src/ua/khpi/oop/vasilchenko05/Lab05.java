package ua.khpi.oop.vasilchenko05;


import ua.khpi.oop.vasilchenko05.Kontainer.IteratorMine;

final class Lab05 {
    private Lab05() {
        //default constructor
    }

    /**
     * Entry point in program.
     * @param args - arguments of main method.
     */
    public static void main(final String[] args) {
        Kontainer kontain = new Kontainer();
        String str1;
        str1 = Functions.initializeStr();
        Functions.showString(str1);
        String str2 = Functions.sortAlphabetical(str1);
        System.out.println();
        Functions.showString(str2);
        kontain.aDDBack(str1);
        kontain.aDDBack(str2);
        kontain.aDDBack(str1);
        kontain.aDDBack(str2);
        kontain.aDDBack(str1);
        kontain.aDDBack(str2);
        System.out.println("\n\n\n");
        kontain.showArray();
        kontain.lengthSorting(2);
        System.out.println("\n\n\n");
        kontain.showArray();
        System.out.println("\n\n\n");
        System.out.println(kontain.arrayToStr());
        kontain.alphabeticalSorting(1);
        System.out.println("\nWrite with iterator: ");
        IteratorMine iter = (Kontainer.IteratorMine) kontain.iterator();
        for (String s : kontain) {
            System.out.println(s);
        }
            iter.next();
            iter.remove();
        System.out.println();
        kontain.showArray();

        System.out.println("Size array: " + kontain.getSize());
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println("Clear array: ");
        kontain.clearArray();
        kontain.showArray();
    }
}

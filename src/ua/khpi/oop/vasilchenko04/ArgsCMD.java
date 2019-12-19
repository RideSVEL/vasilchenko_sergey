package ua.khpi.oop.vasilchenko04;

class ArgsCMD {
    static boolean DBG = false;
    private String[] args;
    ArgsCMD(String[] args) {
        this.args = args;
    }
    boolean isEmpty(){
        return args.length == 0;
    }
    void arguments(){
        for (String i: args){
        if (i.equals("-d") || i.equals("-debug"))
            ArgsCMD.debug();
        else if(i.equals("-h") || i.equals("-help"))
            ArgsCMD.help();
        else
            System.out.println("Error. Use only this arguments: \"-d\", \"-debug\", \"-h\", \"-help\"");
        }
    }

    private static void help() {
        System.out.println("Author: Vasilchenko Sergey Sergeevich");
        System.out.println("Individual tasks:");
        System.out.println("Using the program of solving the problem of laboratory work #3, \naccording to the application task provide the processing of user commands in the form of a text menu:\n" +
                "data entry;\n" +
                "view data;\n" +
                "view data;\n" +
                "displaying the result;\n" +
                "program completion, etc.");
    }

    private static void debug() {
        DBG = true;
        System.out.println("Debug");
    }
}

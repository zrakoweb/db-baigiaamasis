package lt.codeacademy.entities;

import lt.codeacademy.ConsoleMenu;

public class Menu implements ConsoleMenu {
    private static final String MENIU_TEXT =
            "\n" +
                    "pasirinkite ka norite daryti:\n" +
                    "1.prideti pajamas\n" +
                    "2.prideto islaidas\n" +
                    "3.gauta pajamu\n" +
                    "4.gauta islaidu\n" +
                    "5.pasitikrinti balansa\n"+
                    "6.gauti visas pajamas\n"+
                    "7.gauti visas islaidas\n"+
                    "8.istrinti irasa\n";


    public void printMenu(){
        System.out.println(MENIU_TEXT);
    }

}

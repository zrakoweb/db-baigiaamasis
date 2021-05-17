package lt.codeacademy.services;

import lt.codeacademy.ConsoleMenu;
import lt.codeacademy.HibernateConfiguration;
import lt.codeacademy.entities.Menu;
import lt.codeacademy.entities.IslaiduIrasas;
import lt.codeacademy.entities.PajamuIrasas;
import lt.codeacademy.entities.Sort;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BiudzetApplication {

    private final ConsoleMenu mainMenu;
    private Biudzetas biudzetas = new Biudzetas();

    Scanner sc = new Scanner(System.in);

    public BiudzetApplication() {
        this.mainMenu = new Menu();
    }

    public void run() throws IOException {
        PajamuIrasasService pajamuIrasasService = new PajamuIrasasService();

        String value = "";

        while (!value.equals("9")) {
            mainMenu.printMenu();
            value = mainMenu.readInput();
            switch (value) {
                case "1":
                    System.out.println("iveskite suma:");
                    int suma = sc.nextInt();
                    sc.nextLine();
//                    System.out.println("iveskite indeksa");
//                    int indeksas = sc.nextInt();
                    Sort sort = new Sort(1L);
                    System.out.println("pervesta i banka:");
                    String arIbanka = sc.nextLine();
                    System.out.println("iveskite info:");
                    String info = sc.nextLine();
                    PajamuIrasas irasas = new PajamuIrasas(suma, sort, arIbanka, info);

//                    biudzetas.pridetiPajamuIsrasa(irasas);
                    System.out.println("Pajamos pridetos");
                    pajamuIrasasService.save(irasas);


                    break;
                case "2":
                    System.out.println("iveskite suma:");
                    suma = sc.nextInt();
                    sc.nextLine();
//                    System.out.println("iveskite indeksa");
//                    int indeksas = sc.nextInt();
                    Sort sort1 = new Sort(2L);
                    System.out.println("pervesta i banka:");
                    arIbanka = sc.nextLine();
                    System.out.println("iveskite info:");
                    info = sc.nextLine();
                    PajamuIrasas irasas1 = new PajamuIrasas(suma, sort1, arIbanka, info);

                    System.out.println("Islaidos pridetos");

                    pajamuIrasasService.save(irasas1);

                    break;
                case "3":
                    System.out.println("gauta pajamu: ");
                    System.out.println(pajamuIrasasService.getIncomes(1));

                    break;
                case "4":
                    System.out.println("isleista pinigu: ");
                    System.out.println(pajamuIrasasService.getIncomes(2));
                    break;
                case "5":
                    System.out.println("jusu balansas: ");
                    System.out.println(pajamuIrasasService.checkBalans());
//                    System.out.println(biudzetas.gautiBalansa());
                    break;
                case "6":
                    pajamuIrasasService.printAllIncomes();
//                    ArrayList<PajamuIrasas> pajamos = biudzetas.gautiPajamuIrasa();
//                    for (PajamuIrasas pajamuIrasas : pajamos) {
//                        System.out.println(String.format("\nPajamu suma: %s \nIndeksas: %x \nData: %s \nAr i banka vesta: %s \nPapildoma info: %s",
//                                pajamuIrasas.getSuma(), pajamuIrasas.getId(), pajamuIrasas.getData(), pajamuIrasas.getArIbanka(), pajamuIrasas.getInfo()));
//                        System.out.println("---------------------------------");
//                    }
//                    pajamuIrasasService.getAll().toString();
                    break;
                case "7":
                    pajamuIrasasService.printAllCosts();
//                    ArrayList<IslaiduIrasas> islaidos = biudzetas.gautiIslaiduIrasa();
//                    for (IslaiduIrasas islaiduIrasas : islaidos) {
//                        System.out.println(islaiduIrasas.getSuma());
//                        System.out.println(String.format("\nIslaidu suma: %s \nIndeksas: %x \nData: %s \nBudas: %s \nKorteles info: %s",
//                                islaiduIrasas.getSuma(), islaiduIrasas.getIndeksas(), islaiduIrasas.getData(), islaiduIrasas.getBudas(), islaiduIrasas.getKortele()));
//                        System.out.println("---------------------------------");
//                    }
                    break;
                case "8":
                    System.out.println("iveskit irasa kuri norite istrinti: ");
                    int id = sc.nextInt();
                    pajamuIrasasService.delete(id);
//                    System.out.println("iveskite id iraso kuri norite pasalinti");
//                    int id = sc.nextInt();
//                    sc.nextLine();
//                    for (PajamuIrasas pajamuIrasas: biudzetas.gautiPajamuIrasa()) {
//                        if (biudzetas() == id) {
//                            biudzetas.gautiPajamuIrasa().remove(id);
//                        }
//                    }
                    break;
                default:
                    System.out.println("bloga ivestis");
                    break;

            }
        }

    }
}

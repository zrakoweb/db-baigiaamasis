package lt.codeacademy.services;

import lt.codeacademy.ConsoleMenu;
import lt.codeacademy.HibernateConfiguration;
import lt.codeacademy.entities.Menu;
import lt.codeacademy.entities.IslaiduIrasas;
import lt.codeacademy.entities.PajamuIrasas;
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

        while (!value.equals("8")) {
            mainMenu.printMenu();
            value = mainMenu.readInput();
            switch (value) {
                case "1":
                    System.out.println("iveskite suma:");
                    int suma = sc.nextInt();
                    sc.nextLine();
                    System.out.println("iveskite indeksa");
                    int indeksas = sc.nextInt();
                    sc.nextLine();
                    System.out.println("pervesta i banka:");
                    String arIbanka = sc.nextLine();
                    System.out.println("iveskite info:");
                    String info = sc.nextLine();
                    PajamuIrasas irasas = new PajamuIrasas(suma, indeksas, arIbanka, info);

                    biudzetas.pridetiPajamuIsrasa(irasas);
                    System.out.println("Pajamos pridetos");
                    HibernateConfiguration.buildSessionFactory();
                    pajamuIrasasService.save(irasas);
                    HibernateConfiguration.closeSessionFactory();


                    break;
                case "2":
                    System.out.println("iveskite suma:");
                    suma = sc.nextInt();
                    sc.nextLine();
                    System.out.println("iveskite indeksa");
                    indeksas = sc.nextInt();
                    sc.nextLine();
                    System.out.println("nurodykite buda: ");
                    String budas = sc.nextLine();
                    System.out.println("iveskite kortele:");
                    String kortele = sc.nextLine();
                    biudzetas.pridetislaiduIsrasa(new IslaiduIrasas(suma, indeksas, budas, kortele));
                    System.out.println("islaidos pridetos");
                    break;
                case "3":
                    System.out.println("gauta pajamu: ");
                    System.out.println(biudzetas.gautiPajamuSuma());

                    break;
                case "4":
                    System.out.println("isleista pinigu: ");
                    System.out.println(biudzetas.gautiIslaiduSuma());
                    break;
                case "5":
                    System.out.println("jusu balansas: ");
                    System.out.println(biudzetas.gautiBalansa());
                    break;
                case "6":
                    ArrayList<PajamuIrasas> pajamos = biudzetas.gautiPajamuIrasa();
                    for (PajamuIrasas pajamuIrasas : pajamos) {
                        System.out.println(String.format("\nPajamu suma: %s \nIndeksas: %x \nData: %s \nAr i banka vesta: %s \nPapildoma info: %s",
                                pajamuIrasas.getSuma(), pajamuIrasas.getIndeksas(), pajamuIrasas.getData(), pajamuIrasas.getArIbanka(), pajamuIrasas.getInfo()));
                        System.out.println("---------------------------------");
                    }
                    break;
                case "7":
                    ArrayList<IslaiduIrasas> islaidos = biudzetas.gautiIslaiduIrasa();
                    for (IslaiduIrasas islaiduIrasas : islaidos) {
                        System.out.println(islaiduIrasas.getSuma());
                        System.out.println(String.format("\nIslaidu suma: %s \nIndeksas: %x \nData: %s \nBudas: %s \nKorteles info: %s",
                                islaiduIrasas.getSuma(), islaiduIrasas.getIndeksas(), islaiduIrasas.getData(), islaiduIrasas.getBudas(), islaiduIrasas.getKortele()));
                        System.out.println("---------------------------------");
                    }
                    break;
                case "8":
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

package lt.codeacademy;

import lt.codeacademy.entities.PajamuIrasas;
import lt.codeacademy.services.BiudzetApplication;
import lt.codeacademy.services.PajamuIrasasService;
import org.hibernate.Session;

import java.io.IOException;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws IOException {

//        Session session = HibernateConfiguration.openSession().getSession();

//        new BiudzetApplication().run();

        HibernateConfiguration.buildSessionFactory();
//       PajamuIrasas pajamuIrasas = session.get(PajamuIrasas.class, 1);
//        System.out.println(pajamuIrasas.getSuma());

        PajamuIrasas pajamuIrasas1 = new PajamuIrasas(250, 2, LocalDateTime.now(), "aa", "bb");
        PajamuIrasasService pajamuIrasasService = new PajamuIrasasService();
        pajamuIrasasService.save(pajamuIrasas1);
        HibernateConfiguration.closeSessionFactory();

    }
}
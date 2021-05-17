package lt.codeacademy;

import lt.codeacademy.entities.IslaiduIrasas;
import lt.codeacademy.entities.PajamuIrasas;
import lt.codeacademy.entities.Sort;
import lt.codeacademy.services.BiudzetApplication;
import lt.codeacademy.services.PajamuIrasasService;
import org.hibernate.Session;

import java.io.IOException;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws IOException {

//        Session session = HibernateConfiguration.openSession().getSession();


        HibernateConfiguration.buildSessionFactory();


        new BiudzetApplication().run();
//       PajamuIrasas pajamuIrasas = session.get(PajamuIrasas.class, 1);
//        System.out.println(pajamuIrasas.getSuma());
//        Sort sort = new Sort(1L);
////        PajamuIrasas pajamuIrasas1 = new PajamuIrasas(250, sort, "aa", "bb");
//        PajamuIrasasService pajamuIrasasService = new PajamuIrasasService();
//        pajamuIrasasService.delete(3);
//        pajamuIrasasService.save(pajamuIrasas1);


        HibernateConfiguration.closeSessionFactory();

    }
}
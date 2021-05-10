package lt.codeacademy.services;

import lt.codeacademy.HibernateConfiguration;
import lt.codeacademy.entities.PajamuIrasas;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PajamuIrasasService {

    public PajamuIrasas save (PajamuIrasas pajamuIrasas) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.saveOrUpdate(pajamuIrasas);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally{
            session.close();
        }
        return pajamuIrasas;
    }

}

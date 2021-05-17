package lt.codeacademy.services;

import lt.codeacademy.HibernateConfiguration;
import lt.codeacademy.entities.IslaiduIrasas;
import lt.codeacademy.entities.PajamuIrasas;
import lt.codeacademy.entities.Sort;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PajamuIrasasService {

    public PajamuIrasas save(PajamuIrasas pajamuIrasas) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(pajamuIrasas);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return pajamuIrasas;
    }

    public List<PajamuIrasas> getAll() {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        List<PajamuIrasas> pajamuIrasas = new ArrayList<>();

        try {
            Query<PajamuIrasas> query = session.createQuery("FROM PajamuIrasas ", PajamuIrasas.class);
            pajamuIrasas = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return pajamuIrasas;
    }

    public int getIncomes(int sortId) {
        List<PajamuIrasas> pajamuIrasas = getAll();
        int suma = 0;
        for (PajamuIrasas pajamuIrasas1 : pajamuIrasas) {
            if (pajamuIrasas1.getSort().getTypeId() == sortId) {
                suma += pajamuIrasas1.getSuma();
            }
        }
        return suma;
//        return pajamuIrasas.size() > 0 ? pajamuIrasas.get(0).getSuma() : null;
    }

    public int checkBalans() {
        PajamuIrasasService pajamuIrasasService = new PajamuIrasasService();
        return pajamuIrasasService.getIncomes(1) - pajamuIrasasService.getIncomes(2);
    }

    public List<PajamuIrasas> getAll(String key, Object value) {
        return getAll(key, value, false);
    }

    private List<PajamuIrasas> getAll(String key, Object value, boolean limitOne) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        List<PajamuIrasas> pajamuIrasas = new ArrayList<>();

        try {
            Query<PajamuIrasas> query = session.createQuery(String.format("FROM Movie WHERE %s = :%s", key, key), PajamuIrasas.class);
            query.setParameter(key, value);

            if (limitOne) {
                query.setMaxResults(1);
            }

            pajamuIrasas = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return pajamuIrasas;
    }

    public void printAllIncomes() {
        List<PajamuIrasas> pajamuIrasas = getAll();
        for (PajamuIrasas pajamos : pajamuIrasas) {
            if (pajamos.getSort().getTypeId() == 1) {
                System.out.println("id: " + pajamos.getId());
                System.out.println("suma: " + pajamos.getSuma());
                System.out.println("data: " + pajamos.getData());
                System.out.println("metodas: " + pajamos.getArIbanka());
                System.out.println("info: " + pajamos.getInfo());
                System.out.println("----------------");
            }
        }
    }

    public void printAllCosts() {
        List<PajamuIrasas> pajamuIrasas = getAll();
        for (PajamuIrasas pajamos : pajamuIrasas) {
            if (pajamos.getSort().getTypeId() == 2) {
                System.out.println("id: " + pajamos.getId());
                System.out.println("suma: " + pajamos.getSuma());
                System.out.println("data: " + pajamos.getData());
                System.out.println("metodas: " + pajamos.getArIbanka());
                System.out.println("info: " + pajamos.getInfo());
                System.out.println("----------------");
            }
        }
    }
    public void delete(int id) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<PajamuIrasas> pajamuIrasas = getAll();
            for (PajamuIrasas pajamos : pajamuIrasas) {
                if (pajamos.getId() == id) {
                    session.delete(pajamos);
                    transaction.commit();
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

}

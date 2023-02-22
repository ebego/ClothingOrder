package Dao;

import Entities.Catalog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CatalogDao {


    public void saveCatalog(Catalog catalog){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();
            session.save(catalog);
            tx.commit();
        }
        catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
    public void catalogInsert(Catalog catalog){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            session.persist(catalog);

            tx.commit();
        }
        catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
    public void catalogUpdate(Catalog catalog){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            session.merge(catalog);

            tx.commit();
        }
        catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
    public void catalogDelete(Catalog catalog){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            catalog = session.find(Catalog.class, catalog.getCatalog_id() );

            session.remove(catalog);

            tx.commit();
        }
        catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
    public List<Catalog> catalogReadAll(){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            List<Catalog> catalogs = session.createQuery("select p from Clothing Order p")
                    .getResultList();

            tx.commit();

            return catalogs;
        }
        catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
    public Catalog catalogById(int id){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            Catalog catalog = session.find(Catalog.class, id );

            tx.commit();

            return catalog;
        }
        catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return null;
    }


}

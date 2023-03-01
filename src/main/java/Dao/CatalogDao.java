package Dao;

import Entities.Catalog;
import Utils.DbConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CatalogDao {


    public void catalogInsert(Catalog catalog){
        SessionFactory sessionFactory = DbConnection.getFactory();
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
    public void catalogUpdate(Catalog catalog){
        SessionFactory sessionFactory = DbConnection.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(catalog);
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
        SessionFactory sessionFactory = DbConnection.getFactory();
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
        SessionFactory sessionFactory = DbConnection.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            List<Catalog> catalogs = session.createQuery("select p from Catalog p")
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
        SessionFactory sessionFactory = DbConnection.getFactory();
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

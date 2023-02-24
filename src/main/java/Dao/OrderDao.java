package Dao;


import Entities.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDao {


    public void orderInsert(Order order){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            session.persist(order);

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
    public void orderUpdate(Order order){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            session.merge(order);

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
    public void orderDelete(Order order){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            order = session.find(Order.class, order.getOrder_id() );

            session.remove(order);

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
    public List<Order> orderReadAll(){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            List<Order> orders = session.createQuery("select p from Order p")
                    .getResultList();

            tx.commit();

            return orders;
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
    public Order orderById(int id){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            Order order = session.find(Order.class, id );

            tx.commit();

            return order;
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

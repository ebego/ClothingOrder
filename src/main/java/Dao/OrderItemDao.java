package Dao;


import Entities.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OrderItemDao {

    public void saveOrderItem(OrderItem orderItem){

        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();
            session.save(orderItem);
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
    public void orderItemInsert(OrderItem orderItem){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            session.persist(orderItem);

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
    public void orderItemUpdate(OrderItem orderItem){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            session.merge(orderItem);

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
    public void orderItemDelete(OrderItem orderItem){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            orderItem = session.find(OrderItem.class, orderItem.getOrderItem_id() );

            session.remove(orderItem);

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
    public List<OrderItem> orderItemReadAll(){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            List<OrderItem> orderItems = session.createQuery("select p from Clothing Order p")
                    .getResultList();

            tx.commit();

            return orderItems;
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
    public OrderItem orderItemById(int id){
        SessionFactory sessionFactory = BaseDao.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;



        try {
            tx = session.beginTransaction();

            OrderItem orderItem = session.find(OrderItem.class, id );

            tx.commit();

            return orderItem;
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

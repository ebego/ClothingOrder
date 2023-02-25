package Dao;


import Entities.OrderItem;
import Utils.DbConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OrderItemDao {


    public List<OrderItem> orderItems(int orderId){
        SessionFactory sessionFactory = DbConnection.getFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List<OrderItem> orderItems = session.createQuery("select p from OrderItem p where orderId = :orderId" )
                    .setParameter("orderId" , orderId)
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

    public void orderItemInsert(OrderItem orderItem){
        SessionFactory sessionFactory = DbConnection.getFactory();
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


}

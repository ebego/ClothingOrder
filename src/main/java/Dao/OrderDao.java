package Dao;


import Entities.Order;
import Utils.DbConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class OrderDao {

    public int orderInsert(Order order){
        SessionFactory sessionFactory = DbConnection.getFactory();
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

        return order.getOrder_id();
    }
}

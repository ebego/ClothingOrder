package Services;

import Dao.OrderDao;
import Entities.Order;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class OrderServices {

    public static void getOrderByIdService() {
        int id = 4;
        OrderDao orderDao = new OrderDao();
        Order orderById = orderDao.orderById(id);

        System.out.println(orderById);
    }

    public static void readAllOrder() {
        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.orderReadAll();
        System.out.println(orders);
    }

    public static void insertOrder() {
        Order order = createOrder();
        OrderDao orderDao = new OrderDao();
        orderDao.orderInsert(order);
    }
    public static Order createOrder() {
        Order order = new Order();

        order.setOrder_date(LocalDate.of(2000,Month.OCTOBER,5));
        order.setOrder_invoice_number(1);
        order.setCatalogId(1);

        return order;
    }

    public static void updateOrder() {
        Order order = updateOrderById();
        OrderDao orderDao = new OrderDao();
        orderDao.orderUpdate(order);

    }
    public static Order updateOrderById() {
        Order order = new Order();

        order.setOrder_date(LocalDate.of(2000,Month.OCTOBER,5));
        order.setOrder_invoice_number(1);
        order.setCatalogId(1);


        return order;
    }

    public static void deleteOrder() {
        Order order = deleteOrderById();
        OrderDao orderDao = new OrderDao();
        orderDao.orderDelete(order);

    }
    public static Order deleteOrderById() {
        Order order = new Order();

        order.setOrder_id(3);

        return order;
    }
}

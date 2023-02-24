package Services;

import Dao.OrderDao;
import Entities.Order;
import java.time.LocalDateTime;
import java.util.*;

public class OrderServices {


    public static void getOrderByIdService() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the catalog_id you want to check : ");
        int id = scanner.nextInt();
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
        OrderItemServices orderItemServices = new OrderItemServices();

        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        String addToOrder = "yes";
        while (addToOrder.equalsIgnoreCase("yes")) {



        orderItemServices.insertOrderItem();



            System.out.println("Do you want to add Items to your order? Press yes to continue or anything else to stop");
            addToOrder = scanner.nextLine();

        }

        order.setOrder_date(LocalDateTime.now());
        order.setOrder_invoice_number(1000001);
        System.out.println(order.getOrder_invoice_number());

        return order;
    }


//    public static void insertOrder() {
//        Order order = createOrder();
//        OrderDao orderDao = new OrderDao();
//        orderDao.orderInsert(order);
//    }
//    public static Order createOrder() {
//        Order order = new Order();
//
//        order.setOrder_date(LocalDate.of(2000,Month.OCTOBER,5));
//        order.setOrder_invoice_number(1);
//        order.setCatalogId(1);
//        order.setOrder_quantityOrdered(3);
//
//        return order;
//    }
//
//    public static void updateOrder() {
//        Order order = updateOrderById();
//        OrderDao orderDao = new OrderDao();
//        orderDao.orderUpdate(order);
//
//    }
//    public static Order updateOrderById() {
//        Order order = new Order();
//
//        order.setOrder_date(LocalDate.of(2000,Month.OCTOBER,5));
//        order.setOrder_invoice_number(1);
//        order.setCatalogId(1);
//
//
//        return order;
//    }
//
//    public static void deleteOrder() {
//        Order order = deleteOrderById();
//        OrderDao orderDao = new OrderDao();
//        orderDao.orderDelete(order);
//
//    }
//    public static Order deleteOrderById() {
//        Order order = new Order();
//
//        order.setOrder_id(3);
//
//        return order;
//    }
}

package Services;

import Dao.OrderDao;
import Dao.OrderItemDao;
import Entities.Catalog;
import Entities.Order;
import Entities.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderItemServices {


    public static void insertOrderItem() {

        OrderItem orderItem = createOrderItem();
        OrderItemDao orderItemDao = new OrderItemDao();
        orderItemDao.orderItemInsert(orderItem);

    }

    public static OrderItem createOrderItem() {
            Order order = new Order();
            Catalog catalog = new Catalog();
            OrderItem orderItem = new OrderItem();


            orderItem.setCatalog_name(catalog.getCatalog_name());
            orderItem.setOrder_quantityOrdered(order.getOrder_quantityOrdered());
            orderItem.setCatalog_price(catalog.getCatalog_price());
            orderItem.setOrder_totalPrice((catalog.getCatalog_price()* order.getOrder_quantityOrdered()));
            orderItem.setOrderId(2);

        return orderItem;
    }

//    public static OrderItem addToOrder(Order order){
//
//        Scanner scanner = new Scanner(System.in);
//        OrderDao orderDao = new OrderDao();
//        List<Order> orders = orderDao.orderReadAll();
//        String addToOrder;
//        System.out.println("Do you want to add Items to your order? Press yes to continue or anything else to stop");
//        addToOrder = scanner.nextLine();
//
//        do {
//            System.out.println("Enter dhe Catalog_Id of the item you want to purchase");
//            order.setCatalogId(scanner.nextInt());
//
//            orders.add(order);
//        }
//        while (addToOrder.equalsIgnoreCase("yes"));
//
//        return null;
//    }
//
//
//
//    public static void getOrderItemByIdService() {
//        int id = 11;
//        OrderItemDao orderItemDao = new OrderItemDao();
//        OrderItem orderItemById = orderItemDao.orderItemById(id);
//
//        System.out.println(orderItemById);
//    }
//
//    public static void readAllOrderItem() {
//        OrderItemDao orderItemDao = new OrderItemDao();
//        List<OrderItem> orderItems = orderItemDao.orderItemReadAll();
//        System.out.println(orderItems);
//    }
//
//    public static void insertOrderItem() {
//        OrderItem orderItem = createOrderItem();
//        OrderItemDao orderItemDao = new OrderItemDao();
//        orderItemDao.orderItemInsert(orderItem);
//    }
//    public static OrderItem createOrderItem() {
//        OrderItem orderItem = new OrderItem();
//
//
//        orderItem.setCatalog_name("Xhup");
//        orderItem.setOrder_quantityOrdered(3);
//        orderItem.setCatalog_price(12.49);
//        orderItem.setOrder_totalPrice(37.47);
//        orderItem.setOrderId(2);
//
//        return orderItem;
//    }
//
//    public static void updateOrderItem() {
//        OrderItem orderItem = updateOrderItemById();
//        OrderItemDao orderItemDao = new OrderItemDao();
//        orderItemDao.orderItemUpdate(orderItem);
//
//    }
//    public static OrderItem updateOrderItemById() {
//        OrderItem orderItem = new OrderItem();
//
//
//        orderItem.setCatalog_name("Xhup");
//        orderItem.setOrder_quantityOrdered(3);
//        orderItem.setCatalog_price(12.48);
//        orderItem.setOrder_totalPrice(37.44);
//        orderItem.setOrderId(1);
//
//        return orderItem;
//    }
//
//    public static void deleteOrderItem() {
//        OrderItem orderItem = deleteOrderItemById();
//        OrderItemDao orderItemDao = new OrderItemDao();
//        orderItemDao.orderItemDelete(orderItem);
//
//    }
//    public static OrderItem deleteOrderItemById() {
//        OrderItem orderItem = new OrderItem();
//
//        orderItem.setOrderItem_id(1);
//
//        return orderItem;
//    }

}

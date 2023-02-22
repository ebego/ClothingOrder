package Services;

import Dao.OrderItemDao;
import Entities.OrderItem;
import java.util.List;

public class OrderItemServices {

    public static void getOrderItemByIdService() {
        int id = 1;
        OrderItemDao orderItemDao = new OrderItemDao();
        OrderItem orderItemById = orderItemDao.orderItemById(id);

        System.out.println(orderItemById);
    }

    public static void readAllOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDao();
        List<OrderItem> orderItems = orderItemDao.orderItemReadAll();
        System.out.println(orderItems);
    }

    public static void insertOrderItem() {
        OrderItem orderItem = createOrderItem();
        OrderItemDao orderItemDao = new OrderItemDao();
        orderItemDao.orderItemInsert(orderItem);
    }
    public static OrderItem createOrderItem() {
        OrderItem orderItem = new OrderItem();

        orderItem.setOrderItem_id(1);
        orderItem.setCatalog_name("Xhup");
        orderItem.setOrder_quantityOrdered(3);
        orderItem.setCatalog_price(12.49);
        orderItem.setOrder_totalPrice(37.47);

        return orderItem;
    }

    public static void updateOrderItem() {
        OrderItem orderItem = updateOrderItemById();
        OrderItemDao orderItemDao = new OrderItemDao();
        orderItemDao.orderItemUpdate(orderItem);

    }
    public static OrderItem updateOrderItemById() {
        OrderItem orderItem = new OrderItem();

        orderItem.setOrderItem_id(1);
        orderItem.setCatalog_name("Xhup");
        orderItem.setOrder_quantityOrdered(3);
        orderItem.setCatalog_price(12.49);
        orderItem.setOrder_totalPrice(37.47);

        return orderItem;
    }

    public static void deleteOrderItem() {
        OrderItem orderItem = deleteOrderItemById();
        OrderItemDao orderItemDao = new OrderItemDao();
        orderItemDao.orderItemDelete(orderItem);

    }
    public static OrderItem deleteOrderItemById() {
        OrderItem orderItem = new OrderItem();

        orderItem.setOrderItem_id(1);

        return orderItem;
    }

}

package Services;

import Dao.OrderDao;
import Dao.OrderItemDao;
import Entities.Order;
import Entities.OrderItem;

import java.util.*;

public class OrderService {
    private OrderDao orderDao;
    private OrderItemDao orderItemDao;

    public OrderService(OrderDao orderDao, OrderItemDao orderItemDao) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
    }

    public int createNewOrder(List<OrderItem> items) {
        double total = items.stream().map(OrderItem::getOrder_totalPrice).mapToDouble(Double::doubleValue).sum();
        Order order = new Order();
        order.total = total;
        int orderId = orderDao.orderInsert(order);

        items.forEach(orderItem -> {
            orderItem.setOrderId(orderId);
            orderItemDao.orderItemInsert(orderItem);
        });

        System.out.println("Your order id is : " + order.getOrder_id() + '\n' + "The total price is : " + total);


        return orderId;
    }

}

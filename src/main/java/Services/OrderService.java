package Services;

import Dao.OrderDao;
import Dao.OrderItemDao;
import Entities.Order;
import Entities.OrderItem;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {
    private OrderDao orderDao;
    private OrderItemDao orderItemDao;

    public OrderService(OrderDao orderDao, OrderItemDao orderItemDao) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
    }

    public void getOrderByIdService() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the catalog_id you want to check : ");
        int id = scanner.nextInt();
        Order orderById = orderDao.orderById(id);
        System.out.println(orderById);
    }

    public void readAllOrder() {
        List<Order> orders = orderDao.orderReadAll();
        System.out.println(orders);
    }

    public void insertOrder() {
        Order order = createOrder();
        orderDao.orderInsert(order);
    }

    public static Order createOrder() {
        Order order = new Order();
        order.setOrder_date(LocalDateTime.now());
        return order;
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

        return orderId;
    }

}

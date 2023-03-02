package Services;

import Dao.CatalogDao;
import Dao.OrderItemDao;
import Entities.Catalog;
import Entities.OrderItem;

import java.util.List;
import java.util.Scanner;

public class OrderItemService {

    private final OrderItemDao orderItemDao;
    public OrderItemService(OrderItemDao orderItemDao) {
        this.orderItemDao = orderItemDao;

    }

    public void readAllOrderItems(int orderId) {
        List<OrderItem> orderItems = orderItemDao.orderItems(orderId);
        System.out.println(orderItems);
    }


    public static OrderItem readOrderItemFromConsole() {
        OrderItem orderItem = new OrderItem();
        CatalogDao catalogDao = new CatalogDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dhe Catalog_Id of the item you want to purchase");
        Catalog catalog = catalogDao.catalogById(scanner.nextInt());
        System.out.println("Enter how many such items do you want to buy");
        orderItem.setOrder_quantityOrdered(scanner.nextInt());
        orderItem.setCatalog_name(catalog.getCatalog_name());
        orderItem.setCatalog_price(catalog.getCatalog_price());
        orderItem.setOrder_totalPrice((orderItem.getCatalog_price() * orderItem.getOrder_quantityOrdered()));
        return orderItem;
    }

}

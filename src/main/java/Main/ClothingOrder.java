package Main;

import Services.CatalogServices;
import Services.OrderItemServices;
import Services.OrderServices;

public class ClothingOrder {
    public static void main(String[] args) {

        CatalogServices catalogServices = new CatalogServices();
        catalogServices.insertCatalog();
        catalogServices.getByIdService();

        OrderServices orderServices = new OrderServices();
        orderServices.insertOrder();
        orderServices.getOrderByIdService();

        OrderItemServices orderItemServices = new OrderItemServices();
        orderItemServices.insertOrderItem();
        orderItemServices.getOrderItemByIdService();

    }

}

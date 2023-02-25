package Main;

import Dao.CatalogDao;
import Dao.OrderDao;
import Dao.OrderItemDao;
import Entities.Order;
import Entities.OrderItem;
import Services.CatalogServices;
import Services.OrderItemServices;
import Services.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClothingOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userAdminOrClient;
        OrderService orderServices = new OrderService(new OrderDao() , new OrderItemDao());
        OrderItemServices orderItemServices = new OrderItemServices();
        CatalogServices catalogServices = new CatalogServices(new CatalogDao());
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        OrderDao orderDao = new OrderDao();


        System.out.println("Press Adm if you are admin or C if you want to see our catalog: ");
        userAdminOrClient= scanner.nextLine();
        if (userAdminOrClient.equalsIgnoreCase("adm")){
            catalogServices.showCatalogOnConsole();
        }
        else if (userAdminOrClient.equalsIgnoreCase("c")){
            catalogServices.readAllCatalog();

            String addToOrder = "yes";
            List<OrderItem> items = new ArrayList<>();
            while (addToOrder.equalsIgnoreCase("yes")) {
                items.add(OrderItemServices.readOrderItemFromConsole());

                System.out.println("Do you want to add Items to your order? Press yes to continue or anything else to stop");
                addToOrder = scanner.nextLine();
            }

            int orderId = orderServices.createNewOrder(items);

            System.out.println("The Items you purchased are : ");

            orderItemServices.readAllOrderItems();

            System.out.println("Do you confirm your choice? Pres yes to confirm or anything else to cancel : ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")){
                System.out.println("Congratulations on your order ");
            }
            else {
                System.out.println("Your Order has been canceled.");
            }

        }
        else {
            System.out.println("You have entered an invalid answer.");
        }


    }

}

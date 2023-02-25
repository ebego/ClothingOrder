package Main;

import Dao.CatalogDao;
import Dao.OrderDao;
import Dao.OrderItemDao;
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
        OrderItemServices orderItemServices = new OrderItemServices(new OrderItemDao() , new CatalogDao());
        CatalogServices catalogServices = new CatalogServices(new CatalogDao());



        System.out.println("Press Adm if you are admin or C if you want to see our catalog: ");
        userAdminOrClient= scanner.nextLine();
        if (userAdminOrClient.equalsIgnoreCase("adm")){
            catalogServices.showCatalogOnConsole();
        }
        else if (userAdminOrClient.equalsIgnoreCase("c")){
            catalogServices.readAllCatalog();

            System.out.println("Pres yes if you want to purchase any item or anything else if you want to quit : ");
            String buyItems = scanner.nextLine();
            if (buyItems.equalsIgnoreCase("yes")) {

                String addToOrder = "yes";
                List<OrderItem> items = new ArrayList<>();
                while (addToOrder.equalsIgnoreCase("yes")) {
                    items.add(OrderItemServices.readOrderItemFromConsole());

                    System.out.println("Do you want to add Items to your order? Press yes to continue or anything else to stop");
                    addToOrder = scanner.nextLine();
                }

                System.out.println("The Items you purchased are : ");

                for (OrderItem item : items){
                    System.out.println(item);
                }

                System.out.println("Do you confirm your choice? Pres yes to confirm or anything else to cancel : ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("yes")) {
                    orderServices.createNewOrder(items);
                    System.out.println("Congratulations on your order ");

                    System.out.println("If you still want to see your order press yes or anything else to exit : ");
                    String checkOrder = scanner.nextLine();
                    if (checkOrder.equalsIgnoreCase("yes")){
                        System.out.println("Enter the id of your order : ");
                        int idOrder = scanner.nextInt();
                        orderItemServices.readAllOrderItems(idOrder);
                        System.out.println("Thanks for your purchase. We hope to see you again.");
                    }
                    else {
                        System.out.println("Thanks for your purchase. We hope to see you again.");
                    }
                } else {
                    System.out.println("Your Order has been canceled.");
                }
            }
            else {

                System.out.println("Thanks for visiting our Catalog. ^_^");
            }

        }
        else {
            System.out.println("You have entered an invalid answer.");
        }


    }

}

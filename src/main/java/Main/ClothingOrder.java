package Main;

import Services.CatalogServices;
import Services.OrderItemServices;
import Services.OrderServices;

import java.util.Scanner;

public class ClothingOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userAdminOrClient;
        OrderServices orderServices = new OrderServices();
        OrderItemServices orderItemServices = new OrderItemServices();
        CatalogServices catalogServices = new CatalogServices();

        System.out.println("Press Adm if you are admin or C if you want to see our catalog: ");
        userAdminOrClient= scanner.nextLine();
        if (userAdminOrClient.equalsIgnoreCase("adm")){
            catalogServices.useCatalogServices();
        }
        else if (userAdminOrClient.equalsIgnoreCase("c")){
            catalogServices.readAllCatalog();

            orderServices.insertOrder();

        }
        else {
            System.out.println("You have entered an invalid answer.");
        }




        orderItemServices.insertOrderItem();




    }

}

package Controllers;

import Entities.OrderItem;
import Services.CatalogService;
import Services.OrderItemService;
import Services.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalController {
    protected CatalogService catalogService;
    protected OrderService orderService;
    protected OrderItemService orderItemService;

    public TerminalController(CatalogService catalogService,OrderService orderService,OrderItemService orderItemService ){
        this.catalogService = catalogService;
        this.orderItemService = orderItemService;
        this.orderService = orderService;
    }



    public void loadAppInteraction() {

        Scanner scanner = new Scanner(System.in);
        String userAdminOrClient;
        while (true) {
            System.out.println("Press \"adm\" if you are admin, \"c\" if you want to see our catalog or \"x\" if you want to exit application: ");
            userAdminOrClient = scanner.nextLine();
            while (userAdminOrClient.equalsIgnoreCase("adm")) {
                String checkPassword;
                int passwordTries = 3;
                while(passwordTries>0) {
                    System.out.println("Enter password please : "); // password is 123 for example
                    checkPassword = scanner.nextLine();
                    if (checkPassword.equals("123")) {
                        adminInterface();
                        break;
                    } else {
                        System.out.println("You have entered a wrong password. You have " + (passwordTries-1) + " tries left : ");
                        passwordTries = passwordTries - 1;
                    }
                }
                break;
            }
            while (userAdminOrClient.equalsIgnoreCase("c")) {
                clientInterface();
                break;
            }
            if (userAdminOrClient.equalsIgnoreCase("x")) {
                System.out.println("Thanks for using our application.");
                break;
            }
            else {
                System.out.println("This is the landing page. Enter one of the following instructions: ");
            }
        }
    }

    public void adminInterface(){
        catalogService.showCatalogOnConsole();
    }

    public void clientInterface(){

        Scanner scanner = new Scanner(System.in);
        catalogService.readAllCatalog();

        System.out.println("Pres \"yes\" if you want to purchase any item or anything else if you want to go to the landing page : ");
        String buyItems = scanner.nextLine();
        if (buyItems.equalsIgnoreCase("yes")) {

            String addToOrder = "yes";
            List<OrderItem> items = new ArrayList<>();
            while (addToOrder.equalsIgnoreCase("yes")) {
                items.add(OrderItemService.readOrderItemFromConsole());

                System.out.println("Do you want to add Items to your order? Press \"yes\" to continue or anything else to stop adding items : ");
                addToOrder = scanner.nextLine();
            }

            System.out.println("The Items you purchased are : ");

            for (OrderItem item : items){
                System.out.print(item);
            }

            System.out.println("Do you confirm your choice? Pres \"yes\" to confirm or anything else to cancel : ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                orderService.createNewOrder(items);
                System.out.println("Congratulations on your purchase!");

                System.out.println("If you still want to see your order press \"yes\" or anything else to go to the landing page : ");
                String checkOrder = scanner.nextLine();
                if (checkOrder.equalsIgnoreCase("yes")){
                    System.out.println("Enter the id of your order : ");
                    int idOrder = scanner.nextInt();
                    orderItemService.readAllOrderItems(idOrder);
                    System.out.println("Thanks for your purchase. You are now being redirected to the landing page.");
                }
                else {
                    System.out.println("Thanks for your purchase. You are now being redirected to the landing page.");
                }
            } else {
                System.out.println("Your Order has been canceled. You have been redirected to the landing page.");
            }
        }
    }
}

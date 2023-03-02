package Main;

import Controllers.TerminalController;
import Dao.CatalogDao;
import Dao.OrderDao;
import Dao.OrderItemDao;
import Services.CatalogService;
import Services.OrderItemService;
import Services.OrderService;

public class ClothingOrder {
    public static void main(String[] args) {
        CatalogDao catalogDao = new CatalogDao();
        OrderDao orderDao = new OrderDao();
        OrderItemDao orderItemDao = new OrderItemDao();

        CatalogService catalogService = new CatalogService(catalogDao);
        OrderService orderService =  new OrderService(orderDao, orderItemDao);
        OrderItemService orderItemService = new OrderItemService(orderItemDao);

        TerminalController terminalController = new TerminalController(catalogService, orderService, orderItemService);


        terminalController.loadAppInteraction();


    }
}

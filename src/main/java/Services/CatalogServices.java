package Services;

import Dao.CatalogDao;
import Entities.Catalog;
import Enums.Category;
import Enums.Size;

import java.util.List;
import java.util.Scanner;

public class CatalogServices {

    public static void useCatalogServices(){

        Scanner scanner = new Scanner(System.in);
        String databaseUsage = "yes";

        while (databaseUsage.equalsIgnoreCase("yes")){

            System.out.println("Insert one of the following instruction : " +
                    "\n1 - to insert Catalog" +
                    "\n2 - to update Catalog" +
                    "\n3 - to delete Catalog" +
                    "\n4 - to get a specific Catalog by its ID" +
                    "\n5 - to get all listed Catalog");
            int instructionToFollow = scanner.nextInt();


            switch (instructionToFollow) {
                case 1:
                    insertCatalog();
                    break;
                case 2:
                    updateCatalog();
                    break;
                case 3:
                    deleteCatalog();
                    break;
                case 4:
                    getByIdService();
                    break;
                case 5:
                    readAllCatalog();
                    break;

                default:
                    System.out.println("You entered a non valid instruction, please enter a valid instruction : ");

            }
            System.out.println("If you want to use our database insert yes or anything else if u want to quit.");
            scanner.nextLine();
            databaseUsage = scanner.nextLine();

        }

    }

    public static void getByIdService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the catalog_id you want to check : ");
        int id = scanner.nextInt();
        CatalogDao catalogDao = new CatalogDao();
        Catalog catalogById = catalogDao.catalogById(id);

        System.out.println(catalogById);
    }

    public static void readAllCatalog() {
        CatalogDao catalogDao = new CatalogDao();
        List<Catalog> catalogs = catalogDao.catalogReadAll();
        System.out.println(catalogs);
    }

    public static void insertCatalog() {
        Catalog catalog = createCatalog();
        CatalogDao catalogDao = new CatalogDao();
        catalogDao.catalogInsert(catalog);
    }
    public static Catalog createCatalog() {
        Catalog catalog = new Catalog();

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter Catalog Item Name");
        catalog.setCatalog_name(scanner.nextLine());
        System.out.println("Enter Catalog Item Category (in capital letters) ");
        catalog.setCategory(Category.valueOf(scanner.nextLine()));
        System.out.println("Enter Catalog Item Size (in capital letters) ");
        catalog.setSize(Size.valueOf(scanner.nextLine()));
        System.out.println("Enter Catalog Item Price");
        catalog.setCatalog_price(scanner.nextDouble());



        return catalog;
    }

    public static void updateCatalog() {
        Catalog catalog = updateCatalogById();
        CatalogDao catalogDao = new CatalogDao();
        catalogDao.catalogUpdate(catalog);

    }
    public static Catalog updateCatalogById() {
        Catalog catalog = new Catalog();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter Catalog Item Id");
        catalog.setCatalog_id(scanner.nextInt());
        System.out.println("Enter Catalog Item Name");
        scanner.nextLine();
        catalog.setCatalog_name(scanner.nextLine());
        System.out.println("Enter Catalog Item Category (in capital letters) ");
        catalog.setCategory(Category.valueOf(scanner.nextLine()));
        System.out.println("Enter Catalog Item Size (in capital letters) ");
        catalog.setSize(Size.valueOf(scanner.nextLine()));
        System.out.println("Enter Catalog Item Price");
        catalog.setCatalog_price(scanner.nextDouble());

        return catalog;
    }

    public static void deleteCatalog() {
        Catalog catalog = deleteCatalogById();
        CatalogDao catalogDao = new CatalogDao();
        catalogDao.catalogDelete(catalog);

    }
    public static Catalog deleteCatalogById() {
        Catalog catalog = new Catalog();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the catalog_id you want to delete : ");

        catalog.setCatalog_id(scanner.nextInt());

        return catalog;
    }
}

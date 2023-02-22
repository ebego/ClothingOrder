package Services;

import Dao.CatalogDao;
import Entities.Catalog;
import Enums.Category;
import Enums.Size;

import java.util.ArrayList;
import java.util.List;

public class CatalogServices {

    public static void getByIdService() {
        int id = 1;
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
        List<Catalog> catalogList = new ArrayList<>();

        catalog.setCatalog_id(1);
        catalog.setCatalog_name("TShirt");
        catalog.setSize(Size.MEDIUM);
        catalog.setCategory(Category.MAN);
        catalog.setCatalog_price(32.99);

        catalogList.add(catalog);

        return catalog;
    }

    public static void updateCatalog() {
        Catalog catalog = updateCatalogById();
        CatalogDao catalogDao = new CatalogDao();
        catalogDao.catalogUpdate(catalog);

    }
    public static Catalog updateCatalogById() {
        Catalog catalog = new Catalog();

        catalog.setCatalog_id(1);
        catalog.setCatalog_name("TShirt");
        catalog.setSize(Size.MEDIUM);
        catalog.setCategory(Category.MAN);
        catalog.setCatalog_price(32.99);

        return catalog;
    }

    public static void deleteCatalog() {
        Catalog catalog = deleteCatalogById();
        CatalogDao catalogDao = new CatalogDao();
        catalogDao.catalogDelete(catalog);

    }
    public static Catalog deleteCatalogById() {
        Catalog catalog = new Catalog();

        catalog.setCatalog_id(1);

        return catalog;
    }
}

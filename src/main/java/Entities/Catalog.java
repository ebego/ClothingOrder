package Entities;

import Enums.Category;
import Enums.Size;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sa_catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catalog_id;
    private String catalog_name;
    @Enumerated(EnumType.STRING)
    private Size size;
    @Enumerated(EnumType.STRING)
    private Category category;
    private double catalog_price;

    @Override
    public String toString() {
        return String.format("Id: %s Title: %s, Price: %s", catalog_id, catalog_name, catalog_price);
    }
}
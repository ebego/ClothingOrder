package Entities;

import Enums.Category;
import Enums.Size;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "catalog")
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


}

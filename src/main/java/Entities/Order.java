package Entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    private int order_id;
    private LocalDate order_date;
    private int order_invoice_number;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;


}

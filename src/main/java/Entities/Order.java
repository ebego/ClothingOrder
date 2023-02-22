package Entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "sa_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private LocalDate order_date;
    private int order_invoice_number;

    @Column(name = "catalog_id")
    protected int catalogId;

    @ManyToOne
    @JoinColumn(name = "catalog_id", insertable = false, updatable = false)
    private Catalog catalog;
}

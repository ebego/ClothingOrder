package Entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "sa_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private LocalDateTime order_date;

    private int order_quantityOrdered;

    private int order_invoice_number;


    @Column(name = "catalog_id")
    protected int catalogId;

    @ManyToOne
    @JoinColumn(name = "catalog_id", insertable = false, updatable = false)
    private Catalog catalog;

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_date='" + order_date + '\'' +
                ", order_invoice_number='" + order_invoice_number + '\'' +
                ", order_quantityOrdered='" + order_quantityOrdered + '\'' +
                '}' + '\n';
    }
}
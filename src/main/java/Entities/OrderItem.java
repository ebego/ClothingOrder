package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sa_orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItem_id;
    private String catalog_name;
    private double catalog_price;
    private int order_quantityOrdered;
    private double order_totalPrice;

    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;
}

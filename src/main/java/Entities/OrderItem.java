package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orderitem")
public class OrderItem {

    @Id
    private int orderItem_id;
    private String catalog_name;
    private double catalog_price;
    private int order_quantityOrdered;
    private double order_totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

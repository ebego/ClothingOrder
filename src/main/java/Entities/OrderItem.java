package Entities;

import Enums.Category;
import Enums.Size;
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
    @Enumerated(EnumType.STRING)
    private Size size;
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "order_id")
    protected int orderId;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @Override
    public String toString() {
        return String.format("Title: %s, Category: %s, Size: %s, Price: %s, Quantity Ordered: %s, Total Price: %s\n",catalog_name, category, size, catalog_price, order_quantityOrdered, order_totalPrice);
    }

}

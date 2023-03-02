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

    public double total;


    @PrePersist
    @Transient
    public void setOrderDate() {
        this.order_date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Id: %s, Order Date: %s", order_id, order_date);
    }
}
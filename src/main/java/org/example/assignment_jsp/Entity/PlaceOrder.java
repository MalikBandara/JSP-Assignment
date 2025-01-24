package org.example.assignment_jsp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "place_order")
public class PlaceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId; // Unique identifier for each order

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate; // Date and time of order placement

    @Column(name = "status", nullable = false)
    private String status; // Order status (e.g., Pending, Completed, Cancelled)

    @Column(name = "item_price", nullable = false)
    private String itemPrice; // Price of the item ordered

    @Column(name = "ordered_quantity", nullable = false)
    private String orderedQuantity; // Quantity of the item ordered

    @Column(name = "total_price", nullable = false)
    private String totalPrice; // Total price for the order

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "pid", nullable = false)
    private Products product; // Reference to the Products entity

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user; // Reference to the User entity
}

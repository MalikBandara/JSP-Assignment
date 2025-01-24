package org.example.assignment_jsp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PlaceOrderDto {


    private int orderId; // Unique identifier for each order
    private LocalDateTime orderDate; // Date and time of order placement
    private String status; // Order status (e.g., Pending, Completed, Cancelled)
    private String itemPrice; // Price of the item ordered
    private String orderedQuantity; // Quantity of the item ordered
    private String totalPrice; // Total price for the order
    private String paymentMethod; // Payment method (e.g., Cash, Card)
    private Products product; // Reference to the Products entity
    private User user; // Reference to the User entity
}

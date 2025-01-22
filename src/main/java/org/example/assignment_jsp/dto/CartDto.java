package org.example.assignment_jsp.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.Entity.User;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDto {

    private int cartId; // Unique ID for each cart entry
    private Products product; // Reference to the Products entity
    private User user; // Reference to the User entity
    private String itemPrice; // Price of the product
    private String orderedQuantity; // Quantity ordered
    private String totalPrice; // Total price = itemPrice * orderedQuantity
}

package org.example.assignment_jsp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId; // Unique ID for each cart entry

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "pid", nullable = false)
    private Products product; // Reference to the Products entity

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user; // Reference to the User entity


    @Column(name = "item_price", nullable = false)
    private String itemPrice; // Price of the product

    @Column(name = "ordered_quantity", nullable = false)
    private String orderedQuantity; // Quantity ordered

    @Column(name = "total_price", nullable = false)
    private String totalPrice; // Total price = itemPrice * orderedQuantity


}

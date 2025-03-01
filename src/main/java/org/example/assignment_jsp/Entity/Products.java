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
@Table(name = "Products")
public class Products {
    @Id
    private String pid;
    private String name;
    private String qty;
    private String price;
    private String  image;
    @ManyToOne
    private Category category;
}

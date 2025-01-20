package org.example.assignment_jsp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.assignment_jsp.Entity.Category;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsDto {
    private String pid;
    private String name;
    private String qty;
    private String price;
    private String image;
    private Category category;
}

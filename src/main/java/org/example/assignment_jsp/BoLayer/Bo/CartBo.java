package org.example.assignment_jsp.BoLayer.Bo;

import org.example.assignment_jsp.BoLayer.SuperBo;
import org.example.assignment_jsp.Entity.Cart;
import org.example.assignment_jsp.dto.CartDto;

public interface CartBo extends SuperBo {
    boolean saveCart(CartDto cart);
}

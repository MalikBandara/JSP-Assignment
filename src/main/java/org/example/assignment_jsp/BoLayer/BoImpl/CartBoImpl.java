package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.CartBo;
import org.example.assignment_jsp.DaoLayer.Dao.CartDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.Cart;
import org.example.assignment_jsp.dto.CartDto;

public class CartBoImpl implements CartBo {

    CartDao cartDao = (CartDao) DaoFactory.getDaoFactory().getDao(DaoType.CART);
    @Override
    public boolean saveCart(CartDto cart) {
        Cart cart1 = new Cart(cart.getCartId(), cart.getProduct(), cart.getUser(), cart.getItemPrice(), cart.getOrderedQuantity(), cart.getTotalPrice());
        return cartDao.save(cart1);
    }
}

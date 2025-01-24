package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.CartBo;
import org.example.assignment_jsp.DaoLayer.Dao.CartDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.Cart;
import org.example.assignment_jsp.dto.CartDto;

import java.util.ArrayList;
import java.util.List;

public class CartBoImpl implements CartBo {

    CartDao cartDao = (CartDao) DaoFactory.getDaoFactory().getDao(DaoType.CART);
    @Override
    public boolean saveCart(CartDto cart) {
        Cart cart1 = new Cart(cart.getCartId(), cart.getProduct(), cart.getUser(), cart.getItemPrice(), cart.getOrderedQuantity(), cart.getTotalPrice());
        return cartDao.save(cart1);
    }

    @Override
    public List<CartDto> getAllCart() {
        List<Cart> all = cartDao.getAll();

        List<CartDto> cartDtos = new ArrayList<>();

        for (Cart cart :  all){
            CartDto cartDto = new CartDto();
            cartDto.setCartId(cart.getCartId());
            cartDto.setUser(cart.getUser());
            cartDto.setProduct(cart.getProduct());
            cartDto.setItemPrice(cart.getItemPrice());
            cartDto.setTotalPrice(cart.getTotalPrice());
            cartDto.setOrderedQuantity(cart.getOrderedQuantity());
            cartDtos.add(cartDto);
        }
        return cartDtos;
    }

    @Override
    public boolean deleteCart(String cartId) {
       return cartDao.delete(cartId);
    }
}

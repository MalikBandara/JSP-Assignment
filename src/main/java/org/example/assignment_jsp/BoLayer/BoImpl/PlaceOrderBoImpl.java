package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.PlaceOrderBo;
import org.example.assignment_jsp.DaoLayer.Dao.PlaceOrderDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.PlaceOrder;
import org.example.assignment_jsp.Entity.PlaceOrderDto;

public class PlaceOrderBoImpl implements PlaceOrderBo {

    PlaceOrderDao placeOrderDao = (PlaceOrderDao) DaoFactory.getDaoFactory().getDao(DaoType.PLACEORDER);

    @Override
    public boolean saveOrder(PlaceOrderDto placeOrderDto) {

        PlaceOrder placeOrder = new PlaceOrder(placeOrderDto.getOrderId(), placeOrderDto.getOrderDate(), placeOrderDto.getOrderedQuantity(), placeOrderDto.getItemPrice(), placeOrderDto.getStatus(), placeOrderDto.getTotalPrice(), placeOrderDto.getPaymentMethod(), placeOrderDto.getProduct(), placeOrderDto.getUser());
        return placeOrderDao.save(placeOrder);
    }
}

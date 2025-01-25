package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.PlaceOrderBo;
import org.example.assignment_jsp.DaoLayer.Dao.PlaceOrderDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.PlaceOrder;
import org.example.assignment_jsp.Entity.PlaceOrderDto;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.dto.ProductsDto;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBoImpl implements PlaceOrderBo {

    PlaceOrderDao placeOrderDao = (PlaceOrderDao) DaoFactory.getDaoFactory().getDao(DaoType.PLACEORDER);

    @Override
    public boolean saveOrder(PlaceOrderDto placeOrderDto) {

        PlaceOrder placeOrder = new PlaceOrder(placeOrderDto.getOrderId(), placeOrderDto.getOrderDate(), placeOrderDto.getOrderedQuantity(), placeOrderDto.getItemPrice(), placeOrderDto.getStatus(), placeOrderDto.getTotalPrice(), placeOrderDto.getPaymentMethod(), placeOrderDto.getProduct(), placeOrderDto.getUser());
        return placeOrderDao.save(placeOrder);
    }

    @Override
    public List<PlaceOrderDto> getOrders() {
        List<PlaceOrder> all = placeOrderDao.getAll();


        List<PlaceOrderDto> placeOrderDtos = new ArrayList<>();

        for (PlaceOrder placeOrder : all){
            PlaceOrderDto dto = new PlaceOrderDto();
            dto.setOrderId(placeOrder.getOrderId());
            dto.setOrderDate(placeOrder.getOrderDate());
            dto.setOrderedQuantity(placeOrder.getOrderedQuantity());
            dto.setProduct(placeOrder.getProduct());
            dto.setStatus(placeOrder.getStatus());
            dto.setItemPrice(placeOrder.getItemPrice());
            dto.setUser(placeOrder.getUser());
            dto.setPaymentMethod(placeOrder.getPaymentMethod());
            dto.setTotalPrice(placeOrder.getTotalPrice());
            placeOrderDtos.add(dto);

        }


        return placeOrderDtos;
    }

    @Override
    public boolean updateOrderStatus(String orderId, String newStatus) {
      return   placeOrderDao.update(orderId, newStatus);
    }
}

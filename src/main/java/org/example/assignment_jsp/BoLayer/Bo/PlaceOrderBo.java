package org.example.assignment_jsp.BoLayer.Bo;


import org.example.assignment_jsp.BoLayer.SuperBo;
import org.example.assignment_jsp.Entity.PlaceOrderDto;

import java.util.List;

public interface PlaceOrderBo extends SuperBo {
    boolean saveOrder(PlaceOrderDto placeOrderDto);

    List<PlaceOrderDto> getOrders();

}

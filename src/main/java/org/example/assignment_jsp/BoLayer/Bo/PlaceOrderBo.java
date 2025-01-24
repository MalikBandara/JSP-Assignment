package org.example.assignment_jsp.BoLayer.Bo;


import org.example.assignment_jsp.BoLayer.SuperBo;
import org.example.assignment_jsp.Entity.PlaceOrderDto;

public interface PlaceOrderBo extends SuperBo {
    boolean saveOrder(PlaceOrderDto placeOrderDto);
}

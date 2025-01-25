package org.example.assignment_jsp.DaoLayer.Dao;

import org.example.assignment_jsp.BoLayer.Bo.PlaceOrderBo;
import org.example.assignment_jsp.DaoLayer.CrudDao;
import org.example.assignment_jsp.Entity.PlaceOrder;

public interface PlaceOrderDao extends CrudDao<PlaceOrder> {

    boolean update(String id , String status);
}

package org.example.assignment_jsp.DaoLayer.DaoImpl;

import org.example.assignment_jsp.BoLayer.Bo.PlaceOrderBo;
import org.example.assignment_jsp.DaoLayer.Dao.PlaceOrderDao;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.Entity.PlaceOrder;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderDaoImpl implements PlaceOrderDao {

    @Override
    public boolean save(PlaceOrder order) {
        Transaction transaction = null;
        try {

            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e ){
            transaction.rollback();
            return false;

        }
    }

    @Override
    public boolean Login(String email, String password) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(PlaceOrder placeOrder) {
        return false;
    }

    @Override
    public List<PlaceOrder> getAll() {

        Transaction transaction = null ;

        try {
            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction =  session.beginTransaction();

            List<PlaceOrder> orders = new ArrayList<>();
            orders = session.createQuery("FROM PlaceOrder ", PlaceOrder.class).getResultList();



            // Commit the transaction
            transaction.commit();
            session.close();
            return orders;

        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Category getCategoryById(String category1) {
        return null;
    }
}

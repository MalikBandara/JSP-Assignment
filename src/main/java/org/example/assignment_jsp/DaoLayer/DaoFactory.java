package org.example.assignment_jsp.DaoLayer;

import org.example.assignment_jsp.DaoLayer.DaoImpl.*;

public class DaoFactory {

    private static DaoFactory daoFactory;

    public DaoFactory(){

    }

    public static DaoFactory getDaoFactory(){
        if (daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoType daoType){
        switch (daoType){
            case USER:
                return new UserDaoImpl();
            case PRODUCT:
                return new ProductsDaoImpl();
            case CATEGORY:
                return  new CategoryDaoImpl();
            case CART:
                return new CartDaoImpl();
            case PLACEORDER:
                return new PlaceOrderDaoImpl();
            default:
                return null;
        }
    }


}

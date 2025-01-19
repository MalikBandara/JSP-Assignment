package org.example.assignment_jsp.DaoLayer;

import org.example.assignment_jsp.DaoLayer.DaoImpl.UserDaoImpl;

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
            default:
                return null;
        }
    }


}

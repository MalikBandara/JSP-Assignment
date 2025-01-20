package org.example.assignment_jsp.BoLayer;

import org.example.assignment_jsp.BoLayer.BoImpl.ProductsBoImpl;
import org.example.assignment_jsp.BoLayer.BoImpl.UserBoImpl;

public class BoFactory {

    private static BoFactory boFactory;

    public BoFactory(){

    }

    public static BoFactory getBoFactory(){
           if (boFactory == null){
               boFactory = new BoFactory();
           }
           return boFactory;
    }

    public SuperBo getBo(BoType boType) {

        switch (boType){
            case USER:
                return new UserBoImpl();
            case PRODUCT:
                return new ProductsBoImpl();

            default:
                return null;

        }
    }
}

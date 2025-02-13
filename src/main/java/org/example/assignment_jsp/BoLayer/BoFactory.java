package org.example.assignment_jsp.BoLayer;

import org.example.assignment_jsp.BoLayer.BoImpl.*;

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
            case CATEGORY:
                return new CategoryBoImpl();
            case CART:
                return new CartBoImpl();
            case PLACEORDER:
                return new PlaceOrderBoImpl();

            default:
                return null;

        }
    }
}

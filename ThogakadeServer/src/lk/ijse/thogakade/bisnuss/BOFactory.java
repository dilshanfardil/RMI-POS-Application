/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.bisnuss;

import lk.ijse.thogakade.bisnuss.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.bisnuss.custom.impl.ItemBOImpl;
import lk.ijse.thogakade.bisnuss.custom.impl.OrderBOImpl;

/**
 *
 * @author Dilshan
 */
public class BOFactory {

    public enum BOType {
        CUSTOMER, ORDER, ITEM,TEST,TEST1
    }
    private static BOFactory bOFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public static SuperBO getBOTypes(BOType doType) throws Exception {
        switch (doType) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ORDER:
                return new OrderBOImpl();
               case ITEM:
                return new ItemBOImpl();
            default:
                return null;
        }

    }

}

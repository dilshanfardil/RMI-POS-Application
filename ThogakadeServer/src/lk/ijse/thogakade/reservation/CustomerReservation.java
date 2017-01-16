/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.reservation;

import java.util.HashMap;
import lk.ijse.thogakade.service.custom.CustomerService;

/**
 *
 * @author Dilshan
 */
public class CustomerReservation {
    
        private HashMap<String, CustomerService> resevationList = new HashMap<>();

    public boolean reserveCustomer(String customerId, CustomerService customerService) {
        if (resevationList.containsKey(customerId)) {
            if (resevationList.get(customerId) == customerService) {
                return true;
            } else {
                return false;
            }
        } else {
            resevationList.put(customerId, customerService);
            return true;
        }
    }

    public boolean releseCustomer(String customerId) {
        if (resevationList.containsKey(customerId)) {
            resevationList.remove(customerId);
            return true;
        } else {
            return false;
        }
    }
    
}

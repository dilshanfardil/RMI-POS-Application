/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.CustomerController;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.custom.CustomerService;

/**
 *
 * @author student
 */
public class CustomerControllerImpl implements CustomerController {

    private CustomerService customerService;

    public CustomerControllerImpl() throws Exception {
                 
        customerService = (CustomerService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
    }

    @Override
    public boolean save(CustomerDTO t) throws Exception {
        boolean result = customerService.save(t);
        return result;
    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        boolean result = customerService.update(t);
        return result;
    }

    @Override
    public boolean delete(String id) throws Exception {
        boolean result = customerService.delete(id);
        return result;
    }

    @Override
    public CustomerDTO getbyId(String id) throws Exception {
        CustomerDTO customer = customerService.getbyId(id);
        return  customer;
    }

    @Override
    public ArrayList<CustomerDTO> get() throws Exception {
        return customerService.get();
    }

}

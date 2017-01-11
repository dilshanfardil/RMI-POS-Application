/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import lk.ijse.thogakade.bisnuss.BOFactory;
import lk.ijse.thogakade.bisnuss.custom.CustomerBO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.service.custom.CustomerService;

/**
 *
 * @author Dilshan
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    private CustomerBO customerBO;

    public CustomerServiceImpl() throws Exception {
        try {
            customerBO = (CustomerBO) BOFactory.getInstance().getBOTypes(BOFactory.BOType.CUSTOMER);
        } catch (Exception ex) {

        }
    }

    @Override
    public boolean save(CustomerDTO t) throws Exception {
        return customerBO.save(t);
    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        return customerBO.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return customerBO.delete(id);
    }

    @Override
    public CustomerDTO getbyId(String id) throws Exception {
        return customerBO.getbyId(id);
    }

    @Override
    public ArrayList<CustomerDTO> get() throws Exception {
        return customerBO.get();
    }

}

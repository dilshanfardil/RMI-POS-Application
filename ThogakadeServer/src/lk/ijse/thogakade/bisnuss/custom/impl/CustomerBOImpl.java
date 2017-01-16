/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.bisnuss.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.thogakade.bisnuss.custom.CustomerBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dto.CustomerDTO;

/**
 *
 * @author Dilshan
 */
public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO;
    Connection connection;

    public CustomerBOImpl() throws Exception {
        customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean save(CustomerDTO t) throws Exception {
        customerDAO.setConnection(connection);
        boolean reselt = customerDAO.save(t);
        connection.close();
        return reselt;
    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        customerDAO.setConnection(connection);
        boolean reselt = customerDAO.update(t);
        connection.close();
        return reselt;

    }

    @Override
    public boolean delete(String id) throws Exception {
        customerDAO.setConnection(connection);
        boolean reselt = customerDAO.delete(id);
        connection.close();
        return reselt;
    }

    @Override
    public CustomerDTO getbyId(String id) throws Exception {
        customerDAO.setConnection(connection);
        CustomerDTO customerDTO = customerDAO.getById(id);
        connection.close();
        return customerDTO;
    }

    @Override
    public ArrayList<CustomerDTO> get() throws Exception {
        customerDAO.setConnection(connection);
        ArrayList<CustomerDTO> allCustomers = customerDAO.get();
        connection.close();
        return allCustomers;
    }

}

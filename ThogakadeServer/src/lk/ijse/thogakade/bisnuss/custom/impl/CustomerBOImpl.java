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

    public CustomerBOImpl() throws Exception {
        customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }

    @Override
    public boolean save(CustomerDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        customerDAO.setConnection(connection);
        boolean reselt = customerDAO.save(t);
        connection.close();
        return reselt;
    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        customerDAO.setConnection(connection);
        boolean reselt = customerDAO.update(t);
        connection.close();
        return reselt;

    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDTO getbyId(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CustomerDTO> get() throws Exception {

        Connection connection = ConnectionFactory.getInstance().getConnection();
        customerDAO.setConnection(connection);
        ArrayList<CustomerDTO> allCustomers = customerDAO.get();
        connection.close();
        return allCustomers;

    }

    //    @Override
//    public boolean delete(CustomerDTO t) throws Exception {
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        customerDAO.setConnection(connection);
//        boolean reselt = customerDAO.delete(t);
//        connection.close();
//        return reselt;
//    }
//    @Override
//    public CustomerDTO getbyId(CustomerDTO t) throws Exception {
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        customerDAO.setConnection(connection);
//        CustomerDTO customerDTO = customerDAO.get(t);
//        connection.close();
//        return customerDTO;
//    }
}

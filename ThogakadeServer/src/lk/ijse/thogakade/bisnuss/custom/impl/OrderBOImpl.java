/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.bisnuss.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.thogakade.bisnuss.custom.OrderBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.dao.custom.OrderDAO;
import lk.ijse.thogakade.dao.custom.OrderDetailsDAO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.dto.OrderdetailDTO;

/**
 *
 * @author Dilshan
 */
public class OrderBOImpl implements OrderBO {

    OrderDetailsDAO orderdetailDAO;
    OrderDAO orderDAO;
    ItemDAO itemDAO;
    Connection connection;

    public OrderBOImpl() throws Exception {
        orderdetailDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
        orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
        itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean saveOrder(OrderDTO orderDTO, ArrayList<OrderdetailDTO> orderdetailDTOs) throws Exception {        
        orderDAO.setConnection(connection);
        orderdetailDAO.setConnection(connection);

        connection.setAutoCommit(false);

        boolean resultOrder = orderDAO.save(orderDTO);

        if (resultOrder) {
            for (OrderdetailDTO orderdetailDTO : orderdetailDTOs) {
                boolean resultOrderDetail = orderdetailDAO.save(orderdetailDTO);
                if (resultOrderDetail) {
                    connection.rollback();
                    return false;
                }
            }
            connection.setAutoCommit(true);
            return true;
        } else {
            connection.rollback();
            return false;
        }

    }

    @Override
    public boolean save(OrderDTO t) throws Exception {
        return false;
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public OrderDTO getbyId(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDTO> get() throws Exception {
        return null;
    }
    

}

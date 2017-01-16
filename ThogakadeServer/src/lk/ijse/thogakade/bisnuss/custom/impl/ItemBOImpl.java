/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.bisnuss.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.thogakade.bisnuss.custom.ItemBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.dto.ItemDTO;

/**
 *
 * @author Dilshan
 */
public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO;

    public ItemBOImpl() throws Exception {
        itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    }

    @Override
    public boolean save(ItemDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        boolean reselt = itemDAO.save(t);
        connection.close();
        return reselt;
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        boolean reselt = itemDAO.update(t);
        connection.close();
        return reselt;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        boolean reselt = itemDAO.delete(id);
        connection.close();
        return reselt;
    }

    @Override
    public ItemDTO getbyId(String id) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        ItemDTO itemDTO = itemDAO.getById(id);
        connection.close();
        return itemDTO;
    }

    @Override
    public ArrayList<ItemDTO> get() throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        itemDAO.setConnection(connection);
        ArrayList<ItemDTO> allitems = itemDAO.getAll();
        connection.close();
        return allitems;
    }

}

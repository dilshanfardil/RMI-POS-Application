/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;

/**
 *
 * @author student
 */
public class ItemDAOImpl implements ItemDAO {

    private Connection connection;
    private final String TABLE_NAME = "Item";
    
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() throws Exception {
        return this.connection;
    }
    
}

//    @Override
//    public boolean save(ItemDTO item) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
//        pst.setObject(1, item.getCode());
//        pst.setObject(2, item.getDescription());
//        pst.setObject(3, item.getQtyOnHand());
//        pst.setObject(4, item.getUnitPrice());
//        int result = pst.executeUpdate();
//        return (result > 0);
//    }

//    @Override
//    public boolean update(ItemDTO item) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("Update Item set description=?, unitPrice=?, qtyOnHand=? where code=?");
//        pst.setObject(4, item.getCode());
//        pst.setObject(1, item.getDescription());
//        pst.setObject(3, item.getQtyOnHand());
//        pst.setObject(2, item.getUnitPrice());
//        int result = pst.executeUpdate();
//        return (result > 0);
//    }

//    @Override
//    public boolean delete(String id) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("Delete From Item where code='" + id + "'");
//        int result = pst.executeUpdate();
//        return (result > 0);
//    }
//
//    @Override
//    public ItemDTO get(String id) throws Exception {
//        ItemDTO item = null;
//        String sql = "SELECT * FROM item WHERE code = '" + id + "' ";
//        Statement stm = connection.createStatement();
//        ResultSet rset = stm.executeQuery(sql);
//        if (rset.next()) {
//            item = new ItemDTO(
//                    rset.getString(1),
//                    rset.getString(2),
//                    rset.getDouble(3),
//                    rset.getInt(4));
//        }
//        return item;
//    }
//
//    @Override
//    public ArrayList<ItemDTO> getAll() throws Exception {
//        ArrayList<ItemDTO> allitems = new ArrayList<>();
//        String sql = "select * from item";
//        Statement stm = connection.createStatement();
//        ResultSet rset = stm.executeQuery(sql);
//
//        while (rset.next()) {
//            String code = rset.getString("code");
//            String description = rset.getString("description");
//            int qtyOnHand = rset.getInt("qtyOnHand");
//            double unitPrice = rset.getDouble("unitPrice");
//
//            ItemDTO item = new ItemDTO(code, description, unitPrice, qtyOnHand);
//            allitems.add(item);
//        }
//
//        return allitems;
//    }
//
//    @Override
//    public Connection getConnection() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}

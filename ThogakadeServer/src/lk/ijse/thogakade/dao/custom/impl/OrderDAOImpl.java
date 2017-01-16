
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao.custom.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.thogakade.dao.custom.OrderDAO;
import lk.ijse.thogakade.dto.OrderDTO;

/**
 *
 * @author student
 */
public class OrderDAOImpl implements OrderDAO{

    private Connection connection;
    private final String TABLE_NAME = "Orders";

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

     @Override
    public Connection getConnection() throws Exception {
        return this.connection;
    }
    
//    @Override
//    public boolean save(OrderDTO order) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("INSERT INTO orders VALUES(?,?,?)");
//        pst.setObject(1, order.getOrderId());
//        pst.setObject(2, order.getOrderDate());
//        pst.setObject(3, order.getCustId());
//        int result = pst.executeUpdate();
//        return (result > 0);
//    }

//    @Override
//    public boolean update(OrderDTO order) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("Update orders set date=?, customerId=? where id=?");
//        pst.setObject(3, order.getOrderId());
//        pst.setObject(1, order.getOrderDate());
//        pst.setObject(2, order.getCustId());
//        
//        int result = pst.executeUpdate();
//        return (result > 0);
//    }

    @Override
    public boolean delete(String id) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Delete From orders where id='" + id + "'");
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public OrderDTO get(String id) throws Exception {
        OrderDTO order = null;
        String sql = "SELECT * FROM orders WHERE id = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        if (rset.next()) {
            order = new OrderDTO(
                    rset.getString(1),
                    rset.getDate(2),
                    rset.getString(3));
                    
        }
        return order;
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        ArrayList<OrderDTO> allorders = new ArrayList<>();
        String sql = "select * from orders";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);

        while (rset.next()) {
            String OrderId = rset.getString("id");
            Date date = rset.getDate("date");
            String CustId = rset.getString("customerId");

            OrderDTO order = new OrderDTO(OrderId, date, CustId);
            allorders.add(order);
        }

        return allorders;
    }

    

}

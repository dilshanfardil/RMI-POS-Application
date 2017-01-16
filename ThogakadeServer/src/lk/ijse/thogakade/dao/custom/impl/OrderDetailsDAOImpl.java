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
import lk.ijse.thogakade.dao.custom.OrderDetailsDAO;
import lk.ijse.thogakade.dto.OrderdetailDTO;

/**
 *
 * @author student
 */
public class OrderDetailsDAOImpl implements OrderDetailsDAO{

    private Connection connection;
    private final String TABLE_NAME = "OrderDetail";
    
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }    

     @Override
    public Connection getConnection() throws Exception {
        return this.connection;
    }
    
//    @Override
//    public boolean save(OrderdetailDTO orderdetail) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("INSERT INTO Orderdetail VALUES(?,?,?,?)");
//        pst.setObject(1, orderdetail.getOrderId());
//        pst.setObject(2, orderdetail.getItemCode());
//        pst.setObject(3, orderdetail.getQty());
//        pst.setObject(4, orderdetail.getUnitPrice());
//        int result = pst.executeUpdate();
//        return (result > 0);
//    }

//    @Override
//    public boolean update(OrderdetailDTO orderdetail) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("Update Orderdetail set ItemCode=?, Qty=?, UnitPrice=? where OrderId=?");
//        pst.setObject(4, orderdetail.getOrderId());
//        pst.setObject(1, orderdetail.getItemCode());
//        pst.setObject(2, orderdetail.getQty());
//        pst.setObject(3, orderdetail.getUnitPrice());
//        int result = pst.executeUpdate();
//        return (result > 0);
//
//    }

    @Override
    public boolean delete(String id) throws Exception {
        PreparedStatement pst = connection.prepareStatement("Delete From Orderdetail where OrderId='" + id + "'");
        int result = pst.executeUpdate();
        return (result > 0);
    }

    @Override
    public OrderdetailDTO get(String id) throws Exception {
       
        OrderdetailDTO orderdetail = null;
        String sql = "SELECT * FROM Orderdetail WHERE OrderId = '" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        if (rset.next()) {
            orderdetail = new OrderdetailDTO(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getInt(3),
                    rset.getDouble(4));
        }
        return orderdetail;
    }

    @Override
    public ArrayList<OrderdetailDTO> getAll() throws Exception {
        ArrayList<OrderdetailDTO> alOrderdetails = new ArrayList<>();
        String sql = "select * from Orderdetail";
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);

        while (rset.next()) {
            String OrderId = rset.getString("OrderId");
            String ItemCode = rset.getString("ItemCode");
            int Qty = rset.getInt("Qty");
            double unitPrice = rset.getDouble("unitPrice");

            OrderdetailDTO orderdetail = new OrderdetailDTO(OrderId, ItemCode, Qty, unitPrice);
            alOrderdetails.add(orderdetail);
        }

        return alOrderdetails;

    }


    
}

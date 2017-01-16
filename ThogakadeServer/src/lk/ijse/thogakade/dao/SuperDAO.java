/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.thogakade.dto.SuperDTO;

/**
 *
 * @author student
 * @param <T>
 */
public interface SuperDAO<T extends SuperDTO> {


//    public enum Tables {
//
//        CUSTOMER("customer"), ITEM("item"), ORDER("order"), ORDER_DETAILS("orderdetails");
//
//        private String tblName;
//
//        private Tables(String tableName) {
//            tblName = tableName;
//        }
//
//        public String getTableName() {
//            return tblName;
//        }
//    }

    public default boolean save(SuperDTO dto) throws Exception {
        //<editor-fold desc="Using Reflective APIs - Save">
        Class<? extends SuperDAO> aClass = this.getClass();

        Field constTabelName = aClass.getDeclaredField("TABLE_NAME");
        constTabelName.setAccessible(true);
        String tableName = (String) constTabelName.get(this);

        Connection connection = this.getConnection();

        Field[] declaredFields = aClass.getDeclaredFields();
        String sqlStm = "INSERT INTO " + tableName + " VALUES(";
        for (int i = 1; i < declaredFields.length; i++) {
            sqlStm += "?,";
        }
        sqlStm += "?)";

        PreparedStatement pst = connection.prepareStatement(sqlStm);
        int i = 1;

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(dto);
            pst.setObject(i, value);
            i++;
        }

        int result = pst.executeUpdate();
        connection.close();
        return (result < 1);
        //</editor-fold>
    }

    public default boolean update(SuperDTO dto) throws Exception {
        //<editor-fold desc="Using Reflective APIs - Update">
        Class<? extends SuperDAO> aClass = this.getClass();

        Field constTabelName = aClass.getDeclaredField("TABLE_NAME");
        constTabelName.setAccessible(true);
        String tableName = (String) constTabelName.get(this);

        Connection connection = this.getConnection();

        Field[] declaredFields = aClass.getDeclaredFields();
        Statement statement = connection.createStatement();
        ResultSet rstColoumnHedding = statement.executeQuery("desc " + tableName + " ;");

        rstColoumnHedding.next();
        String primaryField = rstColoumnHedding.getString(1);

        String sqlStm = "UPDATE " + tableName + " set ";

        while (rstColoumnHedding.next()) {
            sqlStm += (rstColoumnHedding.getString(1) + " = ?,");
        }

        sqlStm += "\b WHERE " + primaryField + "=?";

        PreparedStatement pst = connection.prepareStatement(sqlStm);
        int i = 4;

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(dto);
            if (i == 4) {
                pst.setObject(i, value);
                i = 0;
            } else {
                pst.setObject(i, value);
            }
            i++;
        }
        int result = pst.executeUpdate();
        connection.close();
        return (result < 1);
        //</editor-fold>
    }

    public default boolean delete(SuperDTO dto) throws Exception {
        //<editor-fold desc="Using Reflective APIs - Delete">
        Class<? extends SuperDAO> aClass = this.getClass();

        Field constTabelName = aClass.getDeclaredField("TABLE_NAME");
        constTabelName.setAccessible(true);
        String tableName = (String) constTabelName.get(this);

        Connection connection = this.getConnection();

        Field[] declaredFields = aClass.getDeclaredFields();
        Statement statement = connection.createStatement();
        ResultSet rstColoumnHedding = statement.executeQuery("desc " + tableName + " ;");

        rstColoumnHedding.next();
        String primaryField = rstColoumnHedding.getString(1);

        String sqlStm = "DELETE FROM " + tableName + " WHERE " + primaryField + " = " + declaredFields[0].get(dto);
        PreparedStatement pst = connection.prepareStatement(sqlStm);

        int i = 1;
        int result = pst.executeUpdate();
        connection.close();
        return (result < 1);
        //</editor-fold>
    }

    public default T getById(SuperDTO dto) throws Exception {
        //<editor-fold desc="Using Reflective APIs - getByID">

        Class<? extends SuperDAO> aClass = this.getClass();

        Field constTabelName = aClass.getDeclaredField("TABLE_NAME");
        constTabelName.setAccessible(true);
        String tableName = (String) constTabelName.get(this);

        Connection connection = this.getConnection();

        Field[] declaredFields = aClass.getDeclaredFields();
        Statement statement = connection.createStatement();
        ResultSet rstColoumnHedding = statement.executeQuery("desc " + tableName + " ;");

        rstColoumnHedding.next();
        String primaryField = rstColoumnHedding.getString(1);

        String sqlStm = "SELECT * FROM " + tableName + " WHERE " + primaryField + " = " + declaredFields[0].get(dto);
        PreparedStatement pst = connection.prepareStatement(sqlStm);
        ResultSet rst = pst.executeQuery(sqlStm);
        rst.next();

        int i = 1;

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            declaredField.set(dto, rst.getObject(i));
            i++;
        }
        return (T) dto;
        //</editor-fold>
    }

    public default ArrayList<T> get() throws Exception {
        //<editor-fold desc="Using Reflective APIs - getAll">
        
        Class<? extends SuperDAO> aClass = this.getClass();

        ArrayList<SuperDTO> allDtos = null;
        Field constTabelName = aClass.getDeclaredField("TABLE_NAME");
        constTabelName.setAccessible(true);
        String tableName = (String) constTabelName.get(this);
        
        
        Connection connection = this.getConnection();

        Field[] declaredFields = aClass.getDeclaredFields();

        String sqlStm = "SELECT * FROM " + tableName;
        PreparedStatement pst = connection.prepareStatement(sqlStm);
        ResultSet rst = pst.executeQuery(sqlStm);

        while (rst.next()) {
            int i = 1;
            SuperDTO dtoToArray = new SuperDTO();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                declaredField.set(dtoToArray, rst.getObject(i));
                i++;
            }
            allDtos.add(dtoToArray);
        }

        return (ArrayList<T>) allDtos;
        //</editor-fold>
    }


    public void setConnection(Connection connection) throws Exception;

    public Connection getConnection() throws Exception;
   
} 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public boolean save(T dto) throws Exception;
//    public boolean update(T dto) throws Exception;
//    public boolean delete(String id) throws Exception;
//    public enum Tables {
//        CUSTOMER("customer"), ITEM("item"), ORDER("order"), ORDER_DETAILS("orderdetails");
//        private String tblName;
//        private Tables(String tableName) {
//            tblName = tableName;
//        }
//        public String getTableName() {
//            return tblName;
//        }
//    }    
//    public T get(String id) throws Exception;
//
//    public ArrayList<T> getAll() throws Exception;



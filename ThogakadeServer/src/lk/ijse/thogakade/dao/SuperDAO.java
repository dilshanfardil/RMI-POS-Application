/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.thogakade.dto.SuperDTO;

/**
 *
 * @author student
 * @param <T>
 */
public interface SuperDAO<T extends SuperDTO> {

    public enum Tables {

        CUSTOMER("customer"), ITEM("item"), ORDER("order"), ORDER_DETAILS("orderdetails");

        private String tblName;

        private Tables(String tableName) {
            tblName = tableName;
        }

        public String getTableName() {
            return tblName;
        }
    }

    public void setConnection(Connection connection) throws Exception;

//    public default boolean save(Tables table, T t) throws Exception{
//        
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        
//        Class<? extends SuperDTO> dtoClass = t.getClass();
//        
//        Field[] declaredFields = dtoClass.getDeclaredFields();
//        
//        String sqlStm = "";
//        
//        PreparedStatement pst = connection.prepareStatement(sqlStm);        
//        
//        int i = 1;
//        
//        for (Field declaredField : declaredFields) {
//            declaredField.setAccessible(true);
//            Object value = declaredField.get(t);
//            pst.setObject(i, value);
//            i++;
//        }
//        
//        pst.executeUpdate();
//        
//        return true;
//    }
    public boolean save(T dto) throws Exception;

    public boolean update(T dto) throws Exception;

    public boolean delete(String id) throws Exception;

    public T get(String id) throws Exception;

    public ArrayList<T> getAll() throws Exception;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author student
 */
public class ConnectionFactory {
    
    private static ConnectionFactory connectionFactory;
    
    private ConnectionFactory(){
        
    }
    
    public static ConnectionFactory getInstance(){
        if (connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
    
    public Connection getConnection() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/company" , "root" , "MySQL");        
    }
    
}

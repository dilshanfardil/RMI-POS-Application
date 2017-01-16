/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.service;

import java.rmi.Remote;
import java.util.ArrayList;
import lk.ijse.thogakade.observers.Subject;

/**
 *
 * @author student
 */
public interface SuperService<T> extends Remote,Subject {

    public boolean save(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(String id) throws Exception;

    public T getbyId(String id) throws Exception;

    public ArrayList<T> get() throws Exception;
    
    public boolean reserve(String id,SuperService superService) throws Exception;
    
    public boolean release(String id) throws Exception;

}


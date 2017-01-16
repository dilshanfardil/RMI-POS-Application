/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import lk.ijse.thogakade.bisnuss.BOFactory;
import lk.ijse.thogakade.bisnuss.custom.OrderBO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.observers.Observer;
import lk.ijse.thogakade.service.custom.OrderService;

/**
 *
 * @author Dilshan
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService {

    private OrderBO orderBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();

    public OrderServiceImpl() throws Exception {
        orderBO = (OrderBO) BOFactory.getInstance().getBOTypes(BOFactory.BOType.ORDER);
    }

    @Override
    public boolean save(OrderDTO t) throws Exception {
        boolean result = orderBO.save(t);
        notifyAllObservers();
        return result;
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        boolean result = orderBO.update(t);
        notifyAllObservers();
        return result;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return orderBO.delete(id);
    }

    @Override
    public OrderDTO getbyId(String id) throws Exception {
        return orderBO.getbyId(id);
    }

    @Override
    public ArrayList<OrderDTO> get() throws Exception {
        return orderBO.get();
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        alObservers.remove(observer);
    }

    @Override
    public void notifyAllObservers() throws RemoteException {
        for (Observer alObserver : alObservers) {
            alObserver.update();
        }
    }

}

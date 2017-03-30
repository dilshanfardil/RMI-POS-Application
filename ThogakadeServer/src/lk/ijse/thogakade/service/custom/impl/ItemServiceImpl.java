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
import lk.ijse.thogakade.bisnuss.custom.ItemBO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.observers.Observer;
import lk.ijse.thogakade.reservation.impl.Reservation;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.ItemService;

/**
 *
 * @author Dilshan
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService {

    private ItemBO itemBO;
    private static Reservation itemReservation = new Reservation();
    private static ArrayList<Observer> alObservers = new ArrayList<>();

    public ItemServiceImpl() throws Exception {
        try {
            itemBO = (ItemBO) BOFactory.getInstance().getBOTypes(BOFactory.BOType.ITEM);
        } catch (Exception ex) {
            System.out.println("a  " + ex);
        }
    }

    @Override
    public boolean save(ItemDTO t) throws Exception {
        boolean result = itemBO.save(t);
        notifyAllObservers();
        return result;
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        boolean result = itemBO.update(t);
        notifyAllObservers();
        return result;
    }

    @Override
    public boolean delete(String id) throws Exception {
        boolean result = itemBO.delete(id);
        notifyAllObservers();
        return result;
    }

    @Override
    public ItemDTO getbyId(String id) throws Exception {
        return itemBO.getbyId(id);
    }

    @Override
    public ArrayList<ItemDTO> get() throws Exception {
        return itemBO.get();
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

    @Override
    public boolean reserve(String id, SuperService superService) throws Exception {
        return itemReservation.reserve(id, superService);
    }

    @Override
    public boolean release(String id) throws Exception {
        return itemReservation.release(id);
    }

}

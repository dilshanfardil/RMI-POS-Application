/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import lk.ijse.thogakade.bisnuss.BOFactory;
import lk.ijse.thogakade.bisnuss.custom.ItemBO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.service.custom.ItemService;

/**
 *
 * @author Dilshan
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService{

    private ItemBO itemBO;
    
    public  ItemServiceImpl() throws Exception{
        try {
            itemBO = (ItemBO) BOFactory.getInstance().getBOTypes(BOFactory.BOType.ITEM);
        } catch (Exception ex) {
            System.out.println("a  " + ex);
        }
    }
    
    @Override
    public boolean save(ItemDTO t) throws Exception {
        return itemBO.save(t);
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        return itemBO.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return itemBO.delete(id);
    }

    @Override
    public ItemDTO getbyId(String id) throws Exception {
        return itemBO.getbyId(id);
    }

    @Override
    public ArrayList<ItemDTO> get() throws Exception {
        return itemBO.get();
    }
    
}

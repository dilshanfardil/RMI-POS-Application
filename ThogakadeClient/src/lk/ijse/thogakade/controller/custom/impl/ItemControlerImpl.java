/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.ItemController;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.custom.ItemService;

/**
 *
 * @author Dilshan
 */
public class ItemControlerImpl implements ItemController {

    private ItemService itemService;

    public ItemControlerImpl() throws Exception {
        itemService = (ItemService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
    }

    @Override
    public boolean save(ItemDTO t) throws Exception {
        return itemService.save(t);
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        return itemService.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return itemService.delete(id);
    }

    @Override
    public ItemDTO getbyId(String id) throws Exception {
        return itemService.getbyId(id);
    }

    @Override
    public ArrayList<ItemDTO> get() throws Exception {
        return itemService.get();
    }

    @Override
    public boolean reserve(String id) throws Exception {
        return itemService.reserve(id,itemService);
    }

    @Override
    public boolean release(String id) throws Exception {
        return itemService.release(id);
    }

}

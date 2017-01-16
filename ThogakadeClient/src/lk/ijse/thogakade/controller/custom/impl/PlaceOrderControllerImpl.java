/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.PlaceOrderController;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.custom.OrderService;

/**
 *
 * @author student
 */
public class PlaceOrderControllerImpl implements PlaceOrderController {

    private OrderService orderService;

    public PlaceOrderControllerImpl() throws Exception{
        orderService = (OrderService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
    }

    @Override
    public boolean save(OrderDTO t) throws Exception {
        return orderService.save(t);
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        return orderService.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return orderService.delete(id);
    }

    @Override
    public OrderDTO getbyId(String id) throws Exception {
        return orderService.getbyId(id);
    }

    @Override
    public ArrayList<OrderDTO> get() throws Exception {
        return orderService.get();
    }

}

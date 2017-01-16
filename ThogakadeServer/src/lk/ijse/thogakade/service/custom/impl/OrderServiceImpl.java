/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.service.custom.impl;

<<<<<<< HEAD
import java.rmi.server.UnicastRemoteObject;
=======
>>>>>>> origin/master
import java.util.ArrayList;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.dto.OrderdetailDTO;
import lk.ijse.thogakade.service.custom.OrderService;

/**
 *
 * @author Dilshan
 */
<<<<<<< HEAD
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService {

    private OrderBO orderBO;
    
    public  OrderServiceImpl() throws Exception{
        orderBO = (OrderBO) BOFactory.getInstance().getBOTypes(BOFactory.BOType.ORDER);
=======
public class OrderServiceImpl implements OrderService {

    public  OrderServiceImpl() throws Exception{
        
>>>>>>> origin/master
    }

    @Override
    public boolean save(OrderDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDTO getbyId(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDTO> get() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
<<<<<<< HEAD

    @Override
    public boolean saveOrder(OrderDTO orderDTO, ArrayList<OrderdetailDTO> orderDetailAry) throws Exception{
        return orderBO.saveOrder(orderDTO, orderDetailAry);
    }
=======
>>>>>>> origin/master
    
}

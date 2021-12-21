package com.virtuo.demo.service;

import com.virtuo.demo.entity.Client;
import com.virtuo.demo.entity.Order;
import com.virtuo.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public String deleteOrder(int id) {
        orderRepository.deleteById(id);
        return "Order removed !! " + id;
    }

    public Order updateOrder(Order order) {
        Order orderToUpdate =  orderRepository.findById(order.getId()).orElse(null);

        if(orderToUpdate != null){

            orderToUpdate.setNumber(order.getNumber());
            orderToUpdate.setName(order.getName());
            orderToUpdate.setType(order.getType());
            orderToUpdate.setClient(order.getClient());
            saveOrder(orderToUpdate);

        }
        return orderToUpdate;
    }
}

package com.virtuo.demo.controller;

import com.virtuo.demo.entity.Client;
import com.virtuo.demo.entity.Order;
import com.virtuo.demo.service.ClientService;
import com.virtuo.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
    private OrderService orderService;

	@Autowired
    private ClientService  clientService;

    @RequestMapping("/{id}")
    public String getOrderById(@PathVariable("id") int id){
        Order order = orderService.getOrderById(id);
        return "return the view";
    }

    @GetMapping("/list")
    public String ordersList(Model model){
        List<Order> orders= orderService.getAllOrders();
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("orders", orders);
        model.addAttribute("clients", clients);
        model.addAttribute("order", new Order());
        return "orders-list";
    }

    @PostMapping("/add")
    public String processAddOrder(Order order) {
        orderService.saveOrder(order);
        return "redirect:/order/list";
    }

    @GetMapping("/edit/{id}")
    public String updateOrderForm(@PathVariable("id") int id,Model model) {
        Order order  = orderService.getOrderById(id);
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("order", order);
        model.addAttribute("clients", clients);
        return "order-edit";
    }

    @PostMapping("/edit")
    public String processUpdateOrder(Order order) {
        orderService.updateOrder(order);
        return "redirect:/order/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return "redirect:/order/list";
    }
}

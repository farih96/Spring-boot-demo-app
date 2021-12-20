package com.virtuo.demo.controller;

import com.virtuo.demo.entity.Client;
import com.virtuo.demo.entity.Order;
import com.virtuo.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
    private OrderService orderService;

    @RequestMapping("/{id}")
    public String getOrderById(@PathVariable("id") int id){
        Order order = orderService.getOrderById(id);
        return "return the view";
    }

    @GetMapping("/list")
    public String ordersList(Model model){
        List<Order> orders= orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return"client_list";
    }

    @GetMapping("/add")
    public String addOrderForm(Model model) {
         model.addAttribute("order", new Order());
         return "order/add";
    }

    @PostMapping("/add")
    public String processAddOrder(Order order) {
        orderService.saveOrder(order);
        return "redirect:/order/";
    }

    @GetMapping("/edit/{id}")
    public String updateOrderForm(@PathVariable("id") int id,Model model) {
        Order order  = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "order/edit";  
    }

    @PostMapping("/edit")
    public String processUpdateOrder(Order order) {
        orderService.updateOrder(order);
        return "redirect:/order/";
    }

    @PostMapping("/delete")
    public String deleteOrder(Order order) {
         //orderService.deleteOrder(order.getId())
         return "delete order";
    }
}

package com.javatechie.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.crud.entity.Order;
import com.javatechie.crud.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/addorder")
    public Order addOrder(@RequestBody Order order){
        return service.addOrder(order);
    }

    @GetMapping("/getorders")
    public List<Order> getOrders(){
        return service.getOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id){
        return service.getOrderById(id);
    }
    
    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable int id){
    	try {
			service.deleteOrderById(id);
			return "Order with Id : '" + id + "' is removed successfully!";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
    }
}

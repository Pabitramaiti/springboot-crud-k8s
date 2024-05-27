package com.javatechie.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.entity.Order;
import com.javatechie.crud.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order addOrder(Order order){
       return repository.save(order);
    }

    public List<Order> getOrders(){
        return repository.findAll();
    }

    public Order getOrderById(int id){
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid id : "+id));
    }
    
    public void deleteOrderById(int id) {
    	repository.deleteById(id);
    }
}

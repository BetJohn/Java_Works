package com.javaacademy.sprinttestapp.services;

import com.javaacademy.sprinttestapp.model.Customer;
import com.javaacademy.sprinttestapp.model.Order;
import com.javaacademy.sprinttestapp.repositories.CustomerRepository;
import com.javaacademy.sprinttestapp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order getById(Integer id) {
        System.out.println(orderRepository.findById(id).get().toString());
        return orderRepository.findById(id).get();
    }

    public List<Order> getAllOrders() {
        List<Order> customers = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(customers::add);
        return customers;
    }

    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    public void update(Order order) {
        orderRepository.save(order);
    }

    public void delete(Order order ) {
        orderRepository.delete(order);
    }

}

package com.javaacademy.sprinttestapp.controllers;

import com.javaacademy.sprinttestapp.dto.CustomerDTO;
import com.javaacademy.sprinttestapp.dto.OrderDTO;
import com.javaacademy.sprinttestapp.model.Customer;
import com.javaacademy.sprinttestapp.model.Order;
import com.javaacademy.sprinttestapp.services.CustomerService;
import com.javaacademy.sprinttestapp.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() { return orderService.getAllOrders(); }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getById(id);
    }
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        orderService.insert(order);
        return order;
    }
    @PostMapping("/orders-dto")
    public Order createOrderDTO(@RequestBody OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getOrder_id(),orderDTO.getName(),orderDTO.getCustomer());
        return orderService.insert(order);
    }
    @DeleteMapping("/orders/{id}")
    public void deleteOrderDTO(@PathVariable Integer id) {
        orderService.delete(getOrderById(id));
    }

    @PostMapping("/orders/update ")
    public Order updateOrder(@RequestBody Order order) {
        orderService.update(order);
        return order;
    }
}

package com.javaacademy.sprinttestapp.controllers;

import com.javaacademy.sprinttestapp.dto.CustomerDTO;
import com.javaacademy.sprinttestapp.model.Customer;
import com.javaacademy.sprinttestapp.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() { return customerService.getAllCustomers(); }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        //System.out.println(customerService.getById(id).toString());
        return customerService.getById(id);
    }
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        customerService.insert(customer);
        //System.out.println(customer.getOrders().toString());
        return customer;
    }

    @PostMapping("/customers-dto")
    public Customer createCustomerDTO(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getName(), customerDTO.getOrders());
        return customerService.insert(customer);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomerDTO(@PathVariable Integer id) {
        customerService.delete(getCustomerById(id));
    }

    @PostMapping("/customers/update ")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.update(customer);
        return customer;
    }
}


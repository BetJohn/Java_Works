package com.javaacademy.sprinttestapp.repositories;

import com.javaacademy.sprinttestapp.model.Customer;
import com.javaacademy.sprinttestapp.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
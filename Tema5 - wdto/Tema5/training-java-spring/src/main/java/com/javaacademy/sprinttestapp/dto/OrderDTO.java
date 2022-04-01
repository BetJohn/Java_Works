package com.javaacademy.sprinttestapp.dto;

import com.javaacademy.sprinttestapp.model.Customer;
import com.javaacademy.sprinttestapp.model.Order;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
public class OrderDTO {
    private Integer order_id;
    private String name;
    Customer customer;
}

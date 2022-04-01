package com.javaacademy.sprinttestapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CustomerOrder")
@Data
@NoArgsConstructor
@Builder
public class Order {
    public Order(Integer order_id, String name, Customer customer) {
        this.order_id = order_id;
        this.name = name;
        this.customer = customer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer order_id;
    private String name;
    @ManyToOne
    Customer customer;
}

package com.javaacademy.sprinttestapp.repositories;

import com.javaacademy.sprinttestapp.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    public List<Employee> getAllByName(String name);
}

package com.example.casestudymodule3.service;

import com.example.casestudymodule3.model.Employee;

import java.util.List;

public interface IEmployeeService {
    boolean addNewList(Employee employee);
    Employee findByID(int id);
    List<Employee> getAllList();
    boolean removeList(int id);
    boolean updateList(Employee employee);
}

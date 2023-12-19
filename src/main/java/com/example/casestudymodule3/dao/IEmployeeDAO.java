package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.model.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> getAllEmployee();
    Employee findByID(int id);
    boolean addNewEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean removeEmployee(int id);
}

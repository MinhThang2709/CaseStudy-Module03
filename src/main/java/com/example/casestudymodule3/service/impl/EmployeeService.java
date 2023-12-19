package com.example.casestudymodule3.service.impl;

import com.example.casestudymodule3.dao.IEmployeeDAO;
import com.example.casestudymodule3.dao.impl.EmployeeDAO;
import com.example.casestudymodule3.model.Employee;
import com.example.casestudymodule3.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeDAO iEmployeeDao = new EmployeeDAO();
    @Override
    public boolean addNewList(Employee employee) {
        return false;
    }

    @Override
    public Employee findByID(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllList() {
        return iEmployeeDao.getAllEmployee();
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }

    @Override
    public boolean updateList(Employee employee) {
        return false;
    }
}

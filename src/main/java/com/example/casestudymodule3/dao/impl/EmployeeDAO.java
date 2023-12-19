package com.example.casestudymodule3.dao.impl;

import com.example.casestudymodule3.dao.IEmployeeDAO;
import com.example.casestudymodule3.model.Employee;
import com.example.casestudymodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            String SELECT_ALL_EMPLOYEE= "SELECT * FROM employee WHERE is_deleted = 0";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                Date dateOfBirth = resultSet.getDate("date_of_birth");
                String gender = resultSet.getString("gender");
                String position = resultSet.getString("position");
                String department = resultSet.getString("department");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                employees.add(new Employee(id,fullName,dateOfBirth,gender,position,department,email,phoneNumber,address));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  employees;
    }

    @Override
    public Employee findByID(int id) {
        return null;
    }

    @Override
    public boolean addNewEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean removeEmployee(int id) {
        return false;
    }
}

package com.example.casestudymodule3.dao.impl;

import com.example.casestudymodule3.dao.ICustomerDAO;
import com.example.casestudymodule3.model.Customer;
import com.example.casestudymodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            String SELECT_ALL_CUSTOMER = "SELECT * FROM customer WHERE is_deleted = 0";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                Double accountBalance = resultSet.getDouble("account_balance");
                String accountNumber = resultSet.getString("account_number");
                customers.add(new Customer(id,accountBalance,accountNumber));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  customers;
    }

    @Override
    public Customer findByID(int id) {
        return null;
    }

    @Override
    public boolean addNewCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean removeCustomer(int id) {
        return false;
    }
}

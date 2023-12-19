package com.example.casestudymodule3.dao.impl;

import com.example.casestudymodule3.dao.IBranchDAO;
import com.example.casestudymodule3.model.Branch;
import com.example.casestudymodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchDAO implements IBranchDAO {
    @Override
    public List<Branch> getAllBranch() {
        List<Branch> branches = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            String SELECT_ALL_BRANCH = "SELECT * FROM branch WHERE is_deleted = 0";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BRANCH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String branchName = resultSet.getString("branch_name");
                String branchAddress = resultSet.getString("branch_address");
                String branchPhoneNumber = resultSet.getString("branch_phone_number");
                branches.add(new Branch(id,branchName,branchAddress,branchPhoneNumber));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  branches;
    }

    @Override
    public Branch findByID(int id) {
        return null;
    }

    @Override
    public boolean addNewBranch(Branch branch) {
        return false;
    }

    @Override
    public boolean updateBranch(Branch branch) {
        return false;
    }

    @Override
    public boolean removeBranch(int id) {
        return false;
    }
}

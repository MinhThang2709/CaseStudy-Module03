package com.example.casestudymodule3.service.impl;

import com.example.casestudymodule3.dao.IBranchDAO;
import com.example.casestudymodule3.dao.impl.BranchDAO;
import com.example.casestudymodule3.model.Branch;
import com.example.casestudymodule3.service.IBranchService;

import java.util.List;

public class BranchService implements IBranchService {
    private IBranchDAO iBranchDAO = new BranchDAO();
    @Override
    public boolean addNewList(Branch branch) {
        return false;
    }

    @Override
    public Branch findByID(int id) {
        return null;
    }

    @Override
    public List<Branch> getAllList() {
        return iBranchDAO.getAllBranch();
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }

    @Override
    public boolean updateList(Branch branch) {
        return false;
    }
}

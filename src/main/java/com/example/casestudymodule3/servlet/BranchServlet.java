package com.example.casestudymodule3.servlet;

import com.example.casestudymodule3.model.Branch;
import com.example.casestudymodule3.service.IBranchService;
import com.example.casestudymodule3.service.impl.BranchService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BranchServlet", value = "/branch")

public class BranchServlet extends HttpServlet {
    private IBranchService iBranchService = new BranchService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action= "";
        }
        switch (action){
            case "show view update branch":
                showUpdateBranch(req,resp);
                break;
            case "update branch":
                updateBranch(req,resp);
                break;
            case "delete branch":
                removeBranch(req,resp);
                break;
            case "show view add branch":
                showAddBranch(req,resp);
                break;
            case "add branch":
                addNewBranch(req,resp);
                break;
            default:
                listBranch(req,resp);

        }
    }

    private void listBranch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Branch> branches = iBranchService.getAllList();
        req.setAttribute("branches",branches);
        RequestDispatcher dispatcher = req.getRequestDispatcher("branch/listBranch.jsp");
        dispatcher.forward(req,resp);
    }

    private void addNewBranch(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showAddBranch(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void removeBranch(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void updateBranch(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showUpdateBranch(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("add branch".equals(action)) {
            addNewBranch(req, resp);
        } else if ("delete branch".equals(action)) {
            removeBranch(req, resp);
        } else if ("update branch".equals(action)) {
            String idString = req.getParameter("branchId");
            if (idString != null && !idString.isEmpty()) {
                try {
                    int branchId = Integer.parseInt(idString);
                    updateBranch(req, resp);
                } catch (NumberFormatException e) {
                    resp.getWriter().write("ID không hợp lệ!");
                }
            } else {
                resp.getWriter().write("ID không được để trống!");
            }
        }
    }
    }


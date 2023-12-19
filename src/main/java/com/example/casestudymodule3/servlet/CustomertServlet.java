package com.example.casestudymodule3.servlet;

import com.example.casestudymodule3.model.Customer;
import com.example.casestudymodule3.service.ICustomerService;
import com.example.casestudymodule3.service.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomertServlet", value = "/customer")

public class CustomertServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "show view update customer":
                showUpdateCustomer(req, resp);
                break;
            case "update customer":
                updateCustomer(req, resp);
                break;
            case "delete customer":
                removeCustomer(req, resp);
                break;
            case "show view add customer":
                showAddCustomer(req, resp);
                break;
            case "add customer":
                addNewCustomer(req, resp);
                break;
            default:
                listCustomer(req, resp);
        }
        
    }

    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = iCustomerService.getAllList();
        req.setAttribute("customers",customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/listCustomer.jsp");
        dispatcher.forward(req,resp);
    }

    private void addNewCustomer(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showAddCustomer(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void removeCustomer(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showUpdateCustomer(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("add customer".equals(action)) {
            addNewCustomer(req, resp);
        } else if ("delete customer".equals(action)) {
            removeCustomer(req, resp);
        } else if ("update customer".equals(action)) {
            String idString = req.getParameter("customerId");
            if (idString != null && !idString.isEmpty()) {
                try {
                    int customerId = Integer.parseInt(idString);
                    updateCustomer(req, resp);
                } catch (NumberFormatException e) {
                    resp.getWriter().write("ID không hợp lệ!");
                }
            } else {
                resp.getWriter().write("ID không được để trống!");
            }
        }
    }

}

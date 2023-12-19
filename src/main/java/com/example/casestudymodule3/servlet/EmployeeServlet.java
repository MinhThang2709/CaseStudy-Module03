package com.example.casestudymodule3.servlet;

import com.example.casestudymodule3.model.Employee;
import com.example.casestudymodule3.service.IEmployeeService;
import com.example.casestudymodule3.service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")

public class EmployeeServlet extends HttpServlet {
    private IEmployeeService iEmployeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action= "";
        }
        switch (action){
            case "show view update employee":
                showUpdateEmployee(req,resp);
                break;
            case "update employee":
                updateEmployee(req,resp);
                break;
            case "delete employee":
                removeEmployee(req,resp);
                break;
            case "show view add employee":
                showAddEmployee(req,resp);
                break;
            case "add employee":
                addNewEmployee(req,resp);
                break;
            default:
                listEmployee(req,resp);

        }
    }

    private void listEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = iEmployeeService.getAllList();
        req.setAttribute("employees",employees);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/listEmployee.jsp");
        dispatcher.forward(req,resp);
    }

    private void addNewEmployee(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showAddEmployee(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void removeEmployee(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showUpdateEmployee(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("add employee".equals(action)) {
            addNewEmployee(req, resp);
        } else if ("delete employee".equals(action)) {
            removeEmployee(req, resp);
        } else if ("update employee".equals(action)) {
            String idString = req.getParameter("employeeId");
            if (idString != null && !idString.isEmpty()) {
                try {
                    int employeeId = Integer.parseInt(idString);
                    updateEmployee(req, resp);
                } catch (NumberFormatException e) {
                    resp.getWriter().write("ID không hợp lệ!");
                }
            } else {
                resp.getWriter().write("ID không được để trống!");
            }
        }
    }

}


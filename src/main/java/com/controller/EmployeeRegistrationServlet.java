package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.EmployeeServiceImpl;
import com.business.IEmployeeService;
import com.model.Employee;

/**
 * Servlet implementation class EmployeeRegistrationServlet
 */
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 IEmployeeService service=new EmployeeServiceImpl();
		 List<Employee> listofEmployees=service.findAllEmployees();
		 request.setAttribute("listofEmployees",listofEmployees);
		  request.getRequestDispatcher("view.jsp")
		        .forward(request, response);
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Employee emp=new Employee();
		 emp.setId(Integer.parseInt(request.getParameter("eid")));
		 emp.setAddress(request.getParameter("eaddress"));
		 emp.setName(request.getParameter("ename"));
		 IEmployeeService service=new EmployeeServiceImpl();
		 if(service.insertEmployee(emp)) {
			 request.setAttribute("msg","Thank you for registration!!!");
			  request.getRequestDispatcher("registration.jsp")
			        .forward(request, response);
		 }
		 
	}

}

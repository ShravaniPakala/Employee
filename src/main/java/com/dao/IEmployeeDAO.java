package com.dao;

import java.util.List;

import com.model.Employee;

public interface IEmployeeDAO {

	boolean insertEmployee(Employee employee);
	boolean deleteEmployee(int id);
	boolean updateEmployee(int id,String address);
	Employee findEmployee(int id);
	List<Employee> findAllEmployees();
}

package com.business;

import java.util.List;

import com.dao.EmployeeDAOImpl;
import com.dao.IEmployeeDAO;
import com.model.Employee;

public class EmployeeServiceImpl implements IEmployeeService{

	private IEmployeeDAO dao=new EmployeeDAOImpl();
	
	@Override
	public boolean insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.insertEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(id);
	}

	@Override
	public boolean updateEmployee(int id, String address) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(id, address);
	}

	@Override
	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.findEmployee(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return dao.findAllEmployees();
	}

}

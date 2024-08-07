package com.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.model.Employee;
import com.utility.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public boolean insertEmployee(Employee employee) {
		Connection conn=null;
		PreparedStatement psmt=null;
		
			try {
				conn=DBConnection.getConnectionObject();
			    
				if(conn!=null) {
			    	psmt=conn.prepareStatement("Insert into employee values(?,?,?)");
			    	psmt.setInt(1,employee.getId());
			    	psmt.setString(2,employee.getName());
			    	psmt.setString(3,employee.getAddress());
			    	int x=psmt.executeUpdate();
			    	if(x>0) {
			    		return true;
			    	}
			    }
			
			} catch (Exception e) {
			    e.printStackTrace();
			    
			}finally {
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Connection conn=null;
		PreparedStatement psmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDB","root","root");
			    if(conn!=null) {
			    	psmt=conn.prepareStatement("delete from employee where id=?");
			    	psmt.setInt(1,id);
			        int x=psmt.executeUpdate();
			    	if(x>0) {
			    		return true;
			    	}
			    	
			    	
			    }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return false;
	}
	

	@Override
	public boolean updateEmployee(int id, String address) {
		Connection conn=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDB","root","root");
			    if(conn!=null) {
			    	st=conn.createStatement();
			        int x=st.executeUpdate("update employee set address='"+address+"'where id="+id);
			    	if(x>0) {
			    		return true;
			    	}
			    	
			    	
			    }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return false;
	}

	@Override
	public Employee findEmployee(int id) {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Employee emp=new Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDB","root","root");
			    if(conn!=null) {
			    	psmt=conn.prepareStatement("select * from employee where id=?");
			    	psmt.setInt(1,id);
			        rs=psmt.executeQuery();
			    	if(rs.next()) {
			    		emp.setId(rs.getInt(1));
			    		emp.setName(rs.getString(2));
			    		emp.setAddress(rs.getString("address"));
			    	}
			    }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return emp;
	}
	
	

	@Override
	public List<Employee> findAllEmployees() {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		List<Employee> empList=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDB","root","root");
			    if(conn!=null) {
			    	psmt=conn.prepareStatement("select * from employee");
			    	rs=psmt.executeQuery();
			    	while(rs.next()) {
			    		Employee emp=new Employee();
			    		emp.setId(rs.getInt(1));
			    		emp.setName(rs.getString(2));
			    		emp.setAddress(rs.getString("address"));
			    		empList.add(emp);
			    	}
			    }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return empList;
	}

}



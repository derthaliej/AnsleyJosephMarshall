package com.revature.service;

import java.sql.SQLException;

import com.revature.bean.Employee;
import com.revature.daoimpl.InsertDaoImpl;
import com.revature.daoimpl.RemoveDaoImpl;
import com.revature.daoimpl.UpdateDaoImpl;
import com.revature.daoimpl.ViewDaoImpl;

public class UserService {
	
	private InsertDaoImpl insertService = new InsertDaoImpl();
	private RemoveDaoImpl removeService = new RemoveDaoImpl();
	private UpdateDaoImpl updateService = new UpdateDaoImpl();
	private ViewDaoImpl viewService = new ViewDaoImpl();
	
	public Employee autheticateUser(String username, String password) {
		System.out.println("Attempted login with credentials: Username: "+ username +" Password: " + password);
		
		Employee emp = null;
		try {
			emp = viewService.viewEmployee(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if((emp != null) && (emp.getUsername().equals(username)) &&(emp.getPassword().equals(password))) {
			return emp;
		}
		return null;
	}
	
	
	
	

}

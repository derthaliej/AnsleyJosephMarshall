package com.revature.dao;

import java.sql.SQLException;

import com.revature.bean.*;


public interface InsertDao {
	
	public void addEmployee(Employee e) throws SQLException;
	public void addEvents(Events e) throws SQLException;
	public void addGradingFormat(GradingFormat gf) throws SQLException;
	public void addReimbursement(Reimbursement r) throws SQLException;
	public void addFormatType(FormatType ft)throws SQLException;

}

package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bean.*;


public interface ViewDao {
	
	public List<Employee> viewEmployee() throws SQLException;
	public List<Events> viewEvents() throws SQLException;
	public List<GradingFormat> viewGradingFormat() throws SQLException;
	public List<Reimbursement> viewReimbursement() throws SQLException;
	public List<FormatType> viewFormatType()throws SQLException;
	public List<EventType> viewEventType()throws SQLException;
	public List<ReimbursementStatus> viewReimbursementStatus()throws SQLException;
	public List<Supervise> viewSupervise()throws SQLException;

}

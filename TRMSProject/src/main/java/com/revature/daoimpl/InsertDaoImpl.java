package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.bean.Employee;
import com.revature.bean.Events;
import com.revature.bean.FormatType;
import com.revature.bean.GradingFormat;
import com.revature.bean.Reimbursement;
import com.revature.dao.InsertDao;
import com.revature.util.ConnFactory;


public class InsertDaoImpl implements InsertDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void addEmployee(Employee e) throws SQLException {
	
		Connection conn = cf.getConnection();
		
		String sql = "select TRMS.AddEmployee(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,e.getFirstName());
		ps.setString(2,e.getLastName());
		ps.setString(3,e.getUsername());
		ps.setString(4,e.getPassword());
		ps.setInt(5, e.getEmpTyp());
		
		ps.executeQuery();
		
		
	}

	
	@Override
	public void addEvents(Events e) throws SQLException {
		
		Connection conn = cf.getConnection();
		//converting util date types to sql date type
		java.sql.Date sqlsDate = new java.sql.Date(e.getEventStartDate().getTime());
		java.sql.Date sqlaDate = new java.sql.Date(e.getApprovalDate().getTime());
		
		String sql = "select TRMS.AddEvent(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, e.getEventTyp());
		ps.setString(2, e.getReason());
		ps.setDate(3, sqlsDate);
		ps.setString(4, e.getEventLocation());
		ps.setDouble(5, e.getEventCost());
		ps.setInt(6, e.getAbsentDays());
		ps.setDate(7, sqlaDate);
		ps.setString(8, e.getResource());
		
		ps.executeQuery();
				
		
	}

	
	@Override
	public void addGradingFormat(GradingFormat gf) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "select TRMS.AddGradingFormat( ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, gf.getEventId());
		ps.setString(2, gf.getGradeNeeded());
		ps.setString(3, gf.getGradeReceived());
		
		ps.executeQuery();
		
	}

	@Override
	public void addReimbursement(Reimbursement r) throws SQLException {
		
		Connection conn = cf.getConnection();
		//converting util date types to sql date type
		java.sql.Date sqlrDate = new java.sql.Date(r.getRequestDate().getTime());
		
		String sql = "select TRMS.AddReimburstment(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, r.getEventId());
		ps.setInt(2, r.getEmpId());
		ps.setInt(3, r.getStatusId());
		ps.setDate(4, sqlrDate);
		ps.setString(5, r.getReason());
		ps.setDouble(6, r.getProjectedReimbursement());
		ps.setDouble(7, r.getTotalReimbursement());
		ps.setDouble(8, r.getAwardedReimbursements());
		ps.setDouble(9, r.getPendingReimbursements());
		ps.setDouble(10, r.getAvailableReimbursement());
			
		ps.executeQuery();
		
	}


	@Override
	public void addFormatType(FormatType ft) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "select TRMS.AddFormatType(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, ft.getFormatDesc());
		
		ps.executeQuery();
		
	}

	
	
}

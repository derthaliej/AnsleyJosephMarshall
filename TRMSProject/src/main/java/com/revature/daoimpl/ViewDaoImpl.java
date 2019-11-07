package com.revature.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Employee;
import com.revature.bean.EventType;
import com.revature.bean.Events;
import com.revature.bean.FormatType;
import com.revature.bean.GradingFormat;
import com.revature.bean.Reimbursement;
import com.revature.bean.ReimbursementStatus;
import com.revature.bean.Supervise;
import com.revature.dao.ViewDao;
import com.revature.util.ConnFactory;

public class ViewDaoImpl implements ViewDao{

	public static ConnFactory cf = ConnFactory.getInstance();


	@Override
	public List<Employee> viewEmployee() throws SQLException {
		
		List<Employee> empList= new ArrayList<Employee>();
		
		Connection conn= cf.getConnection();
		
		String sql="select * from TRMS.get_AllEmployee() ";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		Employee emp = null;
		while(rs.next()) {
			emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			empList.add(emp);
		}
		return empList;
		
	}

	@Override
	public List<Events> viewEvents() throws SQLException {
		
		List<Events> eList= new ArrayList<Events>();
		
		Connection conn= cf.getConnection();
		
		String sql="select * from TRMS.get_AllEvents() ";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		Events e = null;
		while(rs.next()) {
			e = new Events(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDate(9), rs.getString(10));
			eList.add(e);
		}
		return eList;

	}

	@Override
	public List<GradingFormat> viewGradingFormat() throws SQLException {
		
		List<GradingFormat> gfList= new ArrayList<GradingFormat>();
		
		Connection conn= cf.getConnection();
		
		String sql="select * from TRMS.get_GradingFormat()";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		GradingFormat gf = null;
		while(rs.next()) {
			gf = new GradingFormat(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			gfList.add(gf);
		}
		return gfList;
		
	}

	@Override
	public List<Reimbursement> viewReimbursement() throws SQLException {

		List<Reimbursement> rList= new ArrayList<Reimbursement>();
		
		Connection conn= cf.getConnection();
		
		String sql="select * from TRMS.get_AllReimburstment()";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		Reimbursement r = null;
		while(rs.next()) {
			r = new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDate(5),rs.getString(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9),rs.getDouble(10),rs.getDouble(11));
			rList.add(r);
		}
		return rList;
		
		
	}

	@Override
	public List<FormatType> viewFormatType() throws SQLException {
		
		List<FormatType> fList= new ArrayList<FormatType>();
		
		Connection conn= cf.getConnection();
		
		String sql="select * from TRMS.get_AllFormatType()";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		FormatType f = null;
		while(rs.next()) {
			f = new FormatType(rs.getInt(1), rs.getString(2));
			fList.add(f);
		}
		return fList;
		
	}

	@Override
	public List<EventType> viewEventType() throws SQLException {
		
		List<EventType> etList= new ArrayList<EventType>();
		
		Connection conn= cf.getConnection();
		
		String sql="select * from TRMS.get_AllEventType()";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		EventType et = null;
		while(rs.next()) {
			et = new EventType(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			etList.add(et);
		}
		return etList;
	}

	@Override
	public List<ReimbursementStatus> viewReimbursementStatus() throws SQLException {
		
		List<ReimbursementStatus> rbsList= new ArrayList<ReimbursementStatus>();
		
		Connection conn= cf.getConnection();
		
		String sql="select * from TRMS.get_AllReimbursementStatus()";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ReimbursementStatus rbs = null;
		while(rs.next()) {
			rbs = new ReimbursementStatus(rs.getInt(1), rs.getString(2));
			rbsList.add(rbs);
		}
		return rbsList;
	}

	@Override
	public List<Supervise> viewSupervise() throws SQLException {
		
		List<Supervise> sList= new ArrayList<Supervise>();
		
		Connection conn= cf.getConnection();
		
		String sql="select * from TRMS.get_AllSupervise()";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		Supervise s = null;
		while(rs.next()) {
			s = new Supervise(rs.getInt(1), rs.getInt(2));
			sList.add(s);
		}
		return sList;
	}
	
	
}

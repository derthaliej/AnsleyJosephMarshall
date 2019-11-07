package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.UpdateDao;
import com.revature.util.ConnFactory;

public class UpdateDaoImpl implements UpdateDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void UpdateRec(String tblNme, String setCNme, String setValu, String whereCNme, String whereValu)
			throws SQLException {
		
		Connection conn= cf.getConnection();
		
		String sql = "SELECT JDBC_Bank.UpdateRec( ?, ?, ?, ?, ?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ps.setString(1,tblNme);
		ps.setString(2,setCNme);
		ps.setString(3,setValu);
		ps.setString(4,whereCNme);
		ps.setString(5,whereValu);
		
		ps.executeQuery();
				
		
	}

}

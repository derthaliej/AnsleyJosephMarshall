package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.revature.dao.RemoveDao;
import com.revature.util.ConnFactory;

public class RemoveDaoImpl implements RemoveDao{

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void removeRec(String tblNme, String cNme, String valu) throws SQLException {
		
		Connection conn= cf.getConnection();
		
		String sql = "SELECT TRMS.UpdateRec( ?, ?, ?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ps.setString(1,tblNme);
		ps.setString(2,cNme);
		ps.setString(3,valu);
		
		ps.executeQuery();
		
		
	}

	@Override
	public void removeRecAll(String tblNme) throws SQLException {
		
		Connection conn= cf.getConnection();

		
		String sql = "SELECT TRMS.deleteAllRec(?)";
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ps.setString(1,tblNme);
		
		ps.executeQuery();
		
		
		
	}

}

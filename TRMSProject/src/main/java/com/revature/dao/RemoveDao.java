package com.revature.dao;

import java.sql.SQLException;


public interface RemoveDao {
	
	public void removeRec(String tblNme, String cNme, String valu)throws SQLException;
	public void removeRecAll(String tblNme)throws SQLException;


}

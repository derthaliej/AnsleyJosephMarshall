package com.revature.dao;

import java.sql.SQLException;

public interface UpdateDao {
	
	public void UpdateRec(String tblNme, String setCNme, String setValu, String whereCNme, String whereValu)throws SQLException;


}

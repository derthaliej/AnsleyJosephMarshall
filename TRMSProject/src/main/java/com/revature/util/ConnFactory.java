package com.revature.util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnFactory {
	
	
	private static ConnFactory cf = new ConnFactory();
	
	private ConnFactory()
	{
		super();
	}
	//public static synchronized getter method 
	public static synchronized ConnFactory getInstance() {
		if(cf ==null) {cf = new ConnFactory();}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();

	
		try {
			
			prop.load(ConnFactory.class.getResourceAsStream("/database.properties"));
			
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pwd"));
		}
		catch(SQLException e) {
			System.out.println("failed to connect to database");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}

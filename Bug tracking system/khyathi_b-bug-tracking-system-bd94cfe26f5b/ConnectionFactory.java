package com.jdbc;
import java.sql.*;
public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
			return con;
		}
		catch (Exception e) {
			System.out.println(e);
			
		}
		return null;
		
	}

	



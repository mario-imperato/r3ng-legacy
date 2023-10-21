package org.r3.test;

import java.sql.*;

public class main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/flowable";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "cyrano.123";
		Connection conn;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
			System.out.print("Connection estd");
			Statement st = conn.createStatement();
			st.executeQuery("select * from r3_user;");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Error : " + e.getMessage());
		}
	}

}

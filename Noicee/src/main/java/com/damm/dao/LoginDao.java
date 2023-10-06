package com.damm.dao;

import java.sql.Connection;
import java.sql.*;

public class LoginDao {
	
	String query = "select * from login where uname=? and pass=?";
	String url = "jdbc:mysql://localhost:3306/rekildo";
	String user = "root";
	String pass = "rekildo3012";
	public boolean check(String username, String password) {
		
		try {
			//load driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//create connection
			Connection conn = DriverManager.getConnection(url,user,pass);
			
			//create statement
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,username);
			st.setString(2, password);
			
			ResultSet res = st.executeQuery();
			
			if(res.next()) {
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return false;
	}
}

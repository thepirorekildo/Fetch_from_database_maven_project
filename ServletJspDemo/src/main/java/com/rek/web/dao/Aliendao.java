package com.rek.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.rek.web.model.Alien;

public class Aliendao {

	public Alien getAlien(int uid) {
		
		Alien a = new Alien();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/rekildo";
			String user = "root";
			String pass = "rekildo3012";
			Connection conn = DriverManager.getConnection(url,user,pass);
			
			Statement st = conn.createStatement();
			String query = "select * from login where id =" + uid;
			
			ResultSet res = st.executeQuery(query);
			
			//next() return boolean values
			if(res.next()) { //id, uaname, pass
				a.setUid(res.getInt("id"));
				a.setUsername(res.getString("uname"));
				a.setPassword(res.getString("pass"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return a;
	}
}

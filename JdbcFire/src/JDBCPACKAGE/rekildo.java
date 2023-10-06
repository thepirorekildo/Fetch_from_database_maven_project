package JDBCPACKAGE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class rekildo {

	public void createDB() {
		//1st-Step create connection
				try {
					
					String url = "jdbc:mysql://localhost:3306/";
					String db = "rek";
					String user = "root";
					String pass = "rekildo3012";
					
					//2nd step to create connection
					Connection conn = DriverManager.getConnection(url+db,user,pass);
					System.out.println("Connection Established");
					System.out.println();

					//3rd step to create statment
					Statement statement = conn.createStatement();

					//4th step to execute query 
					String query = "create table Professorss (Name varchar(40), YOE int)";
					statement.execute(query);
					System.out.println("Query Fired Successfully ");
					
					//close the connection
					conn.close();
					
				}catch(Exception e) {
					System.out.println(e);
				}
	}

	public void createData() {
		// TODO Auto-generated method stub
		try {
			
			String url = "jdbc:mysql://localhost:3306/";
			String db = "rek";
			String user = "root";
			String pass = "rekildo3012";
			
			//2nd step to create connection
			Connection conn = DriverManager.getConnection(url+db,user,pass);
			System.out.println("Connection Established");
			System.out.println();
			
			
			
			//use of preparedStatement to put your own values at specific indexes of your choice
			String query = "insert into student (roll_no, name, age) values (?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, 900100);
			pstm.setString(2,"Xiomi");
			pstm.setInt(3, 2000);
			pstm.executeuery();
			
			System.out.println("Query Fired Successfully ");
			
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void readData() {
		// TODO Auto-generated method stub
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/";
			String db = "rek";
			String user = "root";
			String pass = "rekildo3012";
			
			//2nd step to create connection
			Connection conn = DriverManager.getConnection(url+db,user,pass);
			System.out.println("Connection Established");
			System.out.println();

			//3rd step to create statment
			Statement statement = conn.createStatement();

			//4th step to execute query 
			String query = "select * from student";
			ResultSet result = statement.executeQuery(query);

			while(result.next()) {
				System.out.println("id : " + result.getInt(1) + ", Name : " + result.getString(2) + 
						", Age : " + result.getInt(3));
			}
			
			//close the connection
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void updateData() {
		// TODO Auto-generated method stub
			

		try {
			
			String url = "jdbc:mysql://localhost:3306/";
			String db = "rek";
			String user = "root";
			String pass = "rekildo3012";
			
			//2nd step to create connection
			Connection conn = DriverManager.getConnection(url+db,user,pass);
//			System.out.println("Connection Established");
			System.out.println();

			
			//3rd step to create statment
			String query = "update student set roll_no = ? where roll_no = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, 20108);
			statement.setInt(2, 10108);

			//4th step to execute query 
			statement.execute();

			System.out.println("Updation Done Successfully!");
			//close the connection
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void deleteData() {
		// TODO Auto-generated method stub
		
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "rek";
			String user = "root";
			String pass = "rekildo3012";
			
			//2nd
			Connection conn = DriverManager.getConnection(url+dbName, user, pass);
			
			//3rd
			Statement st = conn.createStatement();
			
			//4th
			String query = "delete from student where roll_no = 20108";
			int num = st.execute(query);
			
			System.out.println("Deletion Done Successfully");
			System.out.println("No. of rows effected were - " + num);
			
			//5ht 
			conn.close();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}


}

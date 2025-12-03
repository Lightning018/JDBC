package in;

import java.sql.*;

public class Step_3_Insert {
	
	public static void main(String[] args) {
		
		try 
		{
//			1) Load or Register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			2) Establish Connection
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","1234");
				
//			3) Create Statement
			Statement s=c.createStatement();
					
//			4) Execute Query 
			s.executeUpdate("insert into student values(17,'gowri',15000.50,'JAVA Developer',9876543210)");
			
			System.out.println("Data Saved Successfully");
		}	
		
		catch(ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}

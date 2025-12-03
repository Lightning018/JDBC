package in;

import java.sql.*;
public class Second {

	public static void main(String[]args) 
	{
		try 
		{
			// 1)Load or register
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2)Establish Connection
			DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","1234");
			System.out.println("Connection established");
		}
		catch(ClassNotFoundException | SQLException e)  
		{
			e.printStackTrace();
		}
	}
}

package in;

import java.sql.*;

public class Step_3_Delete {
	
	public static void main(String[] args) {
		
		Connection c=null;
		try 
		{
//			1) Load or Register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			2) Establish Connection
			 c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","1234");
			
			
//			3) Create Statement
			Statement s=c.createStatement();
			
			
//			4) Execute Query 
			s.executeUpdate("delete from student where id=18");
			
			System.out.println("Data Saved Successfully");
		}	
		
		catch(ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(c!=null) 
				{
					c.close();
					System.out.println("Connection Closed");
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
		
}


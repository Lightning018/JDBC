package in;

import java.sql.*;
public class Fetch_By_Salary_Asc {

	public static void main(String[] args) {
		Connection c=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","1234");
			
			Statement s=c.createStatement();
			
			ResultSet rs = s.executeQuery("Select * from student Order by salary");
			
			while(rs.next()) 
			{

				System.out.println("ID : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("Salary : "+rs.getDouble("salary"));
				System.out.println("Job : "+rs.getString("job"));
				System.out.println("Ph.No : "+rs.getLong("phone_no"));
				System.out.println("________________________________");
			}
		}
		catch(ClassNotFoundException | SQLException e) {
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

package in;

import java.util.Scanner;
import java.sql.*;
public class Fetch_By_PhNo {
	
	static Scanner light=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the phone number : ");
		long phno=light.nextLong();
		
		Connection c=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","1234");
			
			PreparedStatement ps=c.prepareStatement("Select * from student where phone_no like ?");
			
			ps.setString(1, "%" +phno+"%");
			
			ResultSet rs=ps.executeQuery();
			
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

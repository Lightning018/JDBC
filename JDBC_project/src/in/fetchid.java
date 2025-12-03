package in;

import java.util.Scanner;
import java.sql.*;
public class fetchid 
{
	static Scanner light=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		System.out.print("Enter the id : ");
		
		int id = light.nextInt();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","1234");
					
			PreparedStatement ps = c.prepareStatement("Select name,phone_no from student where id= ?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Name : " + rs.getString("name"));
				System.out.println("Ph.No : " + rs.getLong("phone_no"));
			}
		}
		catch(ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}

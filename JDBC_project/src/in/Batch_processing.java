package in;

import java.util.Scanner;
import java.sql.*;
public class Batch_processing {

	static Scanner light=new Scanner (System.in);
	public static void main(String[] args) {
		System.out.println("Enter the count : ");
		int count=light.nextInt();
		
		Connection c= null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","1234");
			
			PreparedStatement ps= c.prepareStatement("insert into student values (?,?,?,?,?)");
			
			for(int i=1;i<=count;i++) 
			{
				System.out.println("Enter your ID : ");
				int id = light.nextInt();
				
				System.out.println("Enter your Name : ");
				String name=light.next();
				
				System.out.println("Enter your Salary : ");
				double salary=light.nextDouble();
				
				System.out.println("Enter your Job : ");
				String job=light.next();
				
				System.out.println("Enter your Phone Number : ");
				long ph=light.nextLong();
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setDouble(3, salary);
				ps.setString(4, job);
				ps.setLong(5, ph);
				
				ps.addBatch();
			}
			
			ps.executeBatch();
			
			System.out.println(count + " data inserted");
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

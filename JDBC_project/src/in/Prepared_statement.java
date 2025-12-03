package in;

import java.sql.*;
import java.util.Scanner;
public class Prepared_statement {
	static Scanner light=new Scanner(System.in); 

	public static void main(String[] args) {
		
		System.out.print("Enter id : ");
		int id=light.nextInt();
		
		System.out.print("Enter salary : ");
		double salary=light.nextDouble();
		
		System.out.print("Enter Phone Number : ");
		long ph_no=light.nextLong();
		
		try 
		{
//			Step 1 Load or Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Step 2 Establish Connection
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","1234");
			
//			Step 3 Create Connection
			PreparedStatement ps=c.prepareStatement("Update student set salary=?, phone_no=? where id=?");
			
			ps.setDouble(1, salary);
			ps.setLong(2, ph_no);
			ps.setInt(3, id);
			
			ps.executeUpdate();
			System.out.println("Data updated");
			
			
		}catch(ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
	}
}

package in;

import java.sql.*;
public class Demo {
	
	public static void main(String []args) 
	{
		try 
		{
			java.sql.Driver d=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			System.out.println("Completed !!!");
		}
		catch(SQLException e) 
		{
			e.printStackTrace();	
		}
	}
	
}

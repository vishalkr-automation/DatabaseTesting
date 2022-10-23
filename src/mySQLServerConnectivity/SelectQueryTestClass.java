package mySQLServerConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SelectQueryTestClass {
	
	@Test
	public void f() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");  //FOR OLD Version of MY SQL Connector 
		System.out.println("Driver loaded");         //Import SQL Driver Manager
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/selenuim","root","root"); //Import SQL Connection
		System.out.println("Connected to My Sql DB");
		
		Statement statment=connection.createStatement(); //Import Java.Sql
		
		ResultSet resultSet=statment.executeQuery("select * from employee");   //Java.sql
		
		while(resultSet.next()){
			String empId=resultSet.getString("EmployeeId");
			System.out.println("DataBase Record is: "+ empId);
			
			String empName=resultSet.getString("EmployeeName");
			System.out.println("DataBase Record is: "+ empName);
			
		}
		
		// closing DB Connection		
	    connection.close();
		
	
	}

}

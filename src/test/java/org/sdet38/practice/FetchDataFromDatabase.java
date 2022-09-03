package org.sdet38.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {
	public static void main(String[] args) throws SQLException {
		
	
	//steps 1: create object for driver
	Driver driverRef=new Driver();
	Connection con=null;
	
	//steps 2: register driver
	DriverManager.registerDriver(driverRef);
	
	//steps 3: establish the connection-provide database name
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TechMAX","root","root");
	
	//steps 4: create statement
	// Statement statement = con.createStatement();
	 
	 //steps 5: execute query
	// statement.executeUpdate("create table empdetails(empid int(4) not null unique,empName varchar(50),phoneNumber int(10) not null unique,Address varchar(50));");
	// statement.executeUpdate("Insert into empdetails values(1050,'swati',974357235,'murugeshpallya')");
	 //statement.executeUpdate("Insert into empdetails values(1051,'shivani',974357236,'new delhi')");
	// statement.executeUpdate("Insert into empdetails values(1052,'surbhi',974357237,'kolkata')");
	// int count=statement.executeUpdate("insert into empdetails values(1053,'riya',964357823,'patna')");
	 
	 //fetch the data from databse
	 String query="Select * from empdetails;";
	 String expectedResult="swati";
	 boolean flag = false;
	Statement statement = null;
	ResultSet resultTable=statement.executeQuery(query);
	while(resultTable.next()) {
		 String actualResult = resultTable.getString(2);
		 if(actualResult.equalsIgnoreCase(expectedResult)) {
			 System.out.println(actualResult);
			 flag=true;
			 break;
		 }
	}
	if(flag) {
		System.out.println("Successfull");
	}else {
		System.out.println("UnSuccessfull");

	}
	//steps 6:validate
	//steps 7:close connection
	// System.out.println(resultTable.getString(2));
	 con.close();

}
}

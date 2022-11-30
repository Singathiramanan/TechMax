package MockInterview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DatabaseVAlidation {
	@Test
	public void dataCheck() throws SQLException{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		String Query="create table Employee(EmployeeName varchar(20) Not Null,Unique);";
		try{
			connection.createStatement().executeUpdate(Query);
		}catch (Exception e) {
			System.out.println("Table is already created");
		}
		finally {
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			String name=sc.next();
			String data="select EmployeeName from Employee;";
			ResultSet names = connection.createStatement().executeQuery(data);
			boolean flag = false;
			while(names.next()){
				System.out.println(names.getString(1));
				if(names.getString(1).equalsIgnoreCase(name)){
					System.out.println("Name already Present");
					flag=true;
					break;
				}
			}
			if(flag==false){
			String insert="insert into Employee values('"+name+"');";
			connection.createStatement().executeUpdate(insert);}
			connection.close();
		}
				
	}
}

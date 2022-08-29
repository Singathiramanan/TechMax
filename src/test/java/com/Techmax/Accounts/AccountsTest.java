package com.Techmax.Accounts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TechMax.Pomrepositorylib.AccountsPage;
import com.TechMax.Pomrepositorylib.EmployeePage;
import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.utility.BaseClass;

public class AccountsTest extends BaseClass{
	@Test(groups = "SmokeTest",enabled = true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class)
	public void CreateEmployeeInEmployeePageCheckEmployeeDisplayedInAccountsPageInAddUserAcoountLayoutTest() throws Throwable {
		//2.Read the test Data
		//Add employe Test Data
		String employeeFirstName = eLib.getExcelData("Accounts2", 2, 0);
		String employeeLastName =  eLib.getExcelData("Accounts2", 2, 1);
		String employeeGender =  eLib.getExcelData("Accounts2", 2, 2);
		String employeeEmail =  eLib.getExcelData("Accounts2", 2, 3);
		String employeePhoneNumber =  (eLib.getExcelData("Accounts2", 2, 4))+(jLib.getRanDomNumber(1000));
		String employeeRole =  eLib.getExcelData("Accounts2", 2, 5);
		String employeeProvince =  eLib.getExcelData("Accounts2", 2, 7);
		String employeeCity =  eLib.getExcelData("Accounts2", 2, 8);
		//String employeeHireDate = eLib.getExcelData("Accounts2", 2, 6);

		//Username and password Test Data
		String employeeName1 = employeeFirstName+" "+employeeLastName;
		String employeeName = employeeLastName+", "+employeeFirstName+" - "+employeeRole;
		String selectEmployee =  eLib.getExcelData("Accounts2", 2, 9);
		String username =  eLib.getExcelData("Accounts2", 2, 10);
		String password =  eLib.getExcelData("Accounts2", 2, 11);

		LoginPage Login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		EmployeePage employee = new EmployeePage(driver);
		AccountsPage accounts =new AccountsPage(driver);

		//7.click on employee major tab
		home.getNavigateToEmployee().click();

		//8.Add employee
		employee.getAddEmployeeicon().click();
		//SoftAssert sa=new SoftAssert();
		//sa.assertAll();
		employee.createEmployee(employeeFirstName, employeeLastName, employeeGender, employeeEmail, employeePhoneNumber, employeeRole, employeeProvince, employeeCity);

		//9.click on user account major tab
		home.getNavigateToAccounts().click();
		
		//home.getNavigateToAccounts().clear();  check assert fail
		List<WebElement> employeelistWE =accounts.getEmployeeNameUserAccountTable();
		List<String> EachemployeeNameList = new ArrayList<String>();
		for (WebElement EachemployeeWE : employeelistWE) {
			String EachemployeeName = EachemployeeWE.getText();
			//System.out.println(EachemployeeName);
			EachemployeeNameList.add(EachemployeeName);
		}
		//System.out.println(EachemployeeNameList);
		//System.out.println(EachemployeeNameList);
		//System.out.println(employeeName1);
		Assert.assertTrue(EachemployeeNameList.contains(employeeName1));
	
		// 10.click on add icon in User Account
		accounts.getAddUserAccountIcon().click();
		

		//11.Enter all details PROLOG
		accounts.createUserAccount(employeeName, username, password);
		//Assert.fail();
		
	}
	@Test(groups = "SmokeTest", enabled = true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class)
	public void CreateCredentialsForExistingEmployeesInAccountsPageTest() throws Throwable {
		//1.Read all the common data

		//2.Read the test Data
		String employeeFirstName = eLib.getExcelData("Accounts1", 4, 0);
		String employeeLastName = eLib.getExcelData("Accounts1", 4, 1);
		String employeeRole = eLib.getExcelData("Accounts1", 4, 2);
		String employeeName = employeeLastName+", "+employeeFirstName+" - "+employeeRole;
		String username = eLib.getExcelData("Accounts1", 4, 3);
		String password = eLib.getExcelData("Accounts1", 4, 4);

		//Create object for POM class
		AccountsPage accounts=new AccountsPage(driver);
		HomePage home=new HomePage(driver);
		LoginPage login=new LoginPage(driver);

		//6.click on user account major tab
		home.getNavigateToAccounts().click();

		//7.click on add icon in User Account
		accounts.getAddUserAccountIcon().click();

		//8.Enter all details in Add User account
		accounts.createUserAccount(employeeName, username, password);
//		SoftAssert SA= new SoftAssert();
//		SA.assertAll();
		//Assert.fail();

	}
}

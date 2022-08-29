 package com.Techmax.Home;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TechMax.Pomrepositorylib.AccountsPage;
import com.TechMax.Pomrepositorylib.EmployeePage;
import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.Pomrepositorylib.SingletonDesignPattern;
import com.TechMax.utility.BaseClass;

@Listeners(com.TechMax.utility.ItestLisImpClass.class)

public class HomeTest extends BaseClass {
	@Test(groups="RegressionTest", enabled = true,retryAnalyzer=com.TechMax.utility.RetryAnalyzerImp.class)
	public void CreateNewProductVerifyTheProductCountInHomePage_test() throws Throwable{
		String ran = jLib.getRanDomNumber(1000);
		// Fetching data from excel file
		String p_code = eLib.getExcelData("Sheet1", 11, 2);
		String p_name = eLib.getExcelData("Sheet1", 11, 3);
		String supplier = eLib.getExcelData("Sheet1", 11, 4);
		String descrpition = eLib.getExcelData("Sheet1", 11, 5);
		String quantity = eLib.getExcelData("Sheet1", 11, 6);
		String on_hand = eLib.getExcelData("Sheet1", 11, 7);
		String price = eLib.getExcelData("Sheet1", 11, 8);
		String catagory = eLib.getExcelData("Sheet1", 11, 9);
		
		SingletonDesignPattern s=new SingletonDesignPattern(driver);		
		WebElement ele = s.getHomePage().getProductCount();
		String record = ele.getText();
		String[] num = record.split(" ");
		int count = Integer.parseInt(num[0]);
		//System.out.println("Product quantity before added:- " + count);
		s.getHomePage().getNavigateToProduct().click();
		
		// CREATE A NEW PRODUCT		
		s.getProductPage().getCreateProductAddIcon().click();
		String pcode=p_code + "_" + ran;
		s.getProductPage().CreateProduct(pcode, p_name, descrpition, quantity, on_hand, price, catagory, supplier);
		
		s.getHomePage().getNavigateToHome().click();
		
		WebElement ele1 = s.getHomePage().getProductCount();
		String record1 = ele1.getText();
		String[] num1 = record1.split(" ");
		int newcount = Integer.parseInt(num1[0]);
		int qty = Integer.parseInt(quantity);
		//System.out.println("Product quantity added:- " + qty);
	//	System.out.println("Product quantity after added:- " + newcount);
		int total = count + qty;
		Assert.assertEquals(total, newcount);
		
	}
	@Test(groups = "SmokeTest",enabled = true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class)
	public void CreateNewRegistrationVerifyTheRegistrationCountInHomePageTest() throws Throwable {


		//2.Read the test Data
		//Username and password Test Data
		String employeeFirstName = eLib.getExcelData("Accounts1", 4, 0);
		String employeeLastName = eLib.getExcelData("Accounts1", 4, 1);
		String employeeRole = eLib.getExcelData("Accounts1", 4, 2);
		String employeeName = employeeLastName+", "+employeeFirstName+" - "+employeeRole;
		String username = eLib.getExcelData("Accounts1", 4, 3);
		String password = eLib.getExcelData("Accounts1", 4, 4);

		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		EmployeePage employee = new EmployeePage(driver);
		AccountsPage accounts =new AccountsPage(driver);

		//5.Fetch Registered account count
		String OldRegistrationCountString = home.getRegisteredAccountsCount().getText();
		String OldRegistrationCount = OldRegistrationCountString.split(" ")[0];
		int OldRegistrationCountNumber = Integer.parseInt(OldRegistrationCount);
		//System.out.println(OldRegistrationCountNumber);

		//6.click on user account major tab
		home.getNavigateToAccounts().click();

		//7.click on add icon in User Account
		accounts.getAddUserAccountIcon().click();

		//8.Create account for employee
		accounts.createUserAccount(employeeName, username, password);

		//9.click on home
		home.getNavigateToSalesAndInventoryIcon().click();

		//10.Fetch Registered account count
		String NewRegistrationCountString = home.getRegisteredAccountsCount().getText();
		String NewRegistrationCount = NewRegistrationCountString.split(" ")[0];
		int NewRegistrationCountNumber = Integer.parseInt(NewRegistrationCount);
		Assert.assertEquals((OldRegistrationCountNumber+1), NewRegistrationCountNumber);
		//Assert.fail();
	}
}

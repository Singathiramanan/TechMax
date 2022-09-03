package com.TechMAX.employee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sales.techmax.genericUtility.ExcelUtility;
import com.sales.techmax.genericUtility.FileUtility;
import com.sales.techmax.genericUtility.JavaUtility;
import com.sales.techmax.genericUtility.WebDriverUtility;
import com.sales.techmax.objectRepositoryUtility.CustomerPage;
import com.sales.techmax.objectRepositoryUtility.EmployeePage;
import com.sales.techmax.objectRepositoryUtility.HomePage;
import com.sales.techmax.objectRepositoryUtility.LoginPage;
import com.sales.techmax.objectRepositoryUtility.POSPage;
import com.sales.techmax.objectRepositoryUtility.ProductPage;
import com.sales.techmax.objectRepositoryUtility.TransactionPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateEmployeeWithMandatoryFields {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;

		// Create Object for Utility
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// Read the data from property file
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("Browser");

		// Read the data from Excelfile
		// Add employe Test Data
		String employeeFirstName = eLib.getExcelData("Sheet3", 3, 1);
		String employeeLastName = eLib.getExcelData("Sheet3", 3, 2);
		String employeeGender = eLib.getExcelData("Sheet3", 3, 3);
		String employeeEmail = eLib.getExcelData("Sheet3", 3, 4);
		String employeePhoneNumber = eLib.getExcelData("Sheet3", 3, 5);
		String selectProvince= eLib.getExcelData("Sheet3", 3, 7);
		String selectCity= eLib.getExcelData("Sheet3", 3, 8);
		int ran = Integer.parseInt(jLib.getRanDomNumber(10000));
		long pnum = Long.parseLong(employeePhoneNumber);
		
		pnum=pnum-ran;
		String phnum=String.valueOf(pnum);
		String employeeRole = eLib.getExcelData("Sheet3", 3, 6);

		// Launch the URL
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("INCORRECT BROWSER");

		}
		driver.manage().window().maximize();
		wLib.waitForElementInDOM(driver);
		driver.get(URL);
		
		LoginPage login=new LoginPage(driver);
		ProductPage createProductObj=new ProductPage(driver);
        HomePage hp = new 	HomePage(driver);
        POSPage pp = new POSPage(driver);
		CustomerPage cpc=new CustomerPage(driver);
		TransactionPage tp=new TransactionPage(driver);
		EmployeePage ep=new EmployeePage(driver);

		// login to the application
		LoginPage ln=new LoginPage(driver);
		ln.loginToApplication(USERNAME, PASSWORD);
		
		// 6.click on employee major tab
		hp.getNavigateToEmployee().click();

		// 7.click on add icon in employee page
		ep.getAddEmployeeicon().click();

		// 8.enter the details
		ep.createEmployee(employeeFirstName, employeeLastName, employeeGender, employeeEmail, phnum, employeeRole, selectProvince, selectCity);

		// logout admin
		hp.LogoutOFApplication();
		driver.close();

	}
}

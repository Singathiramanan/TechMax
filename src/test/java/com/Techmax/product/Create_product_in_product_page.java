package com.TechMAX.product;

import org.openqa.selenium.WebDriver;
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

public class Create_product_in_product_page {
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

		// Read the data from Excelfile  ProductCode,Name,Description,Quantity,OnHand,Price,SelectCategory,SelectSupplier
		String ProductCode = jLib.getRanDomNumber(1000000);
		String Name = eLib.getExcelData("Sheet1", 1, 3);
		String Description = eLib.getExcelData("Sheet1", 1, 4);
		String Quantity = eLib.getExcelData("Sheet1", 1, 5);
		String OnHand = eLib.getExcelData("Sheet1", 1, 6);
		String Price = eLib.getExcelData("Sheet1", 1, 7);
		String SelectCategory = eLib.getExcelData("Sheet1", 1, 8);
		String SelectSupplier = eLib.getExcelData("Sheet1", 1, 9);
		String DateStockin = eLib.getExcelData("Sheet1", 1, 10);
		String quantity = eLib.getExcelData("Sheet1", 1, 11);
		String FirstName = eLib.getExcelData("Sheet1", 1, 12);
		String LastName = eLib.getExcelData("Sheet1", 1, 13);
		String PhoneNumber = eLib.getExcelData("Sheet1", 1, 14);

		// Launch the Browser
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
		ProductPage pg=new ProductPage(driver);

		
		// login to the application
		LoginPage ln=new LoginPage(driver);
		ln.loginToApplication(USERNAME, PASSWORD);
		
		// navigate to product tab
		hp.getNavigateToProduct().click();
		
		pg.getCreateProductAddIcon().click();

		// enter all the details
		
		pg.CreateProduct(ProductCode, Name, Description, Quantity,OnHand,Price,SelectCategory,SelectSupplier);

		// logout admin
		hp.LogoutOFApplication();
		
		driver.close();
	}
}

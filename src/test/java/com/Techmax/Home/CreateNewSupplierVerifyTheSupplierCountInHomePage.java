package com.TechMAX.home;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.sales.techmax.genericUtility.ExcelUtility;
import com.sales.techmax.genericUtility.FileUtility;
import com.sales.techmax.genericUtility.JavaUtility;
import com.sales.techmax.genericUtility.WebDriverUtility;
import com.sales.techmax.objectRepositoryUtility.CustomerPage;
import com.sales.techmax.objectRepositoryUtility.HomePage;
import com.sales.techmax.objectRepositoryUtility.LoginPage;
import com.sales.techmax.objectRepositoryUtility.POSPage;
import com.sales.techmax.objectRepositoryUtility.ProductPage;
import com.sales.techmax.objectRepositoryUtility.SupplierPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewSupplierVerifyTheSupplierCountInHomePage {
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

		String CompanyName = eLib.getExcelData("Sheet4", 2, 1);

		String SelectProvince = eLib.getExcelData("Sheet4", 2, 2);

		String SelectCity = eLib.getExcelData("Sheet4", 2, 3);

		DataFormatter format = new DataFormatter();
		String ph = eLib.getExcelData("Sheet4", 2, 4);

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

		LoginPage login = new LoginPage(driver);
		ProductPage createProductObj = new ProductPage(driver);
		HomePage hp = new HomePage(driver);
		POSPage pp = new POSPage(driver);
		CustomerPage cpc = new CustomerPage(driver);
		SupplierPage sp = new SupplierPage(driver);

		// login to the application
		login.loginToApplication(USERNAME, PASSWORD);

		// navigate to supplier
		String oldcount = hp.getSupplierCount().getText();
		String[] num = oldcount.split(" ");
		int old = Integer.parseInt(num[0]);
		System.out.println(oldcount);
		hp.getNavigateToSupplier().click();
		sp.getCreateSupplierAddIcon().click();
		sp.CreateSupplier(CompanyName, SelectProvince, SelectCity, ph);

		hp.getNavigateToSalesAndInventoryIcon().click();
		String newcount = hp.getSupplierCount().getText();
		String[] num1 = newcount.split(" ");
		int newc = Integer.parseInt(num1[0]);
		System.out.println(newcount);
		if (old < newc) {
			System.out.println("TestPass");
		} else {
			System.out.println("Test FAIL");
		}
		// logout admin
		hp.LogoutOFApplication();
		driver.close();
	}
}

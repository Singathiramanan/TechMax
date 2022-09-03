package com.TechMAX.supplier;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
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

public class CreateSupplier {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		 //Create Object for Utility
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		
		
		//Read the data from property file
		FileInputStream filepath=new FileInputStream(".\\Data\\commonDataProperties");
		Properties property=new Properties();
		property.load(filepath);
		String URL=property.getProperty("url");
		String USERNAME=property.getProperty("username");
		String PASSWORD=property.getProperty("password");
		String BROWSER=property.getProperty("Browser");
		
		
	   //Read the data from Excelfile
		
		String CompanyName=eLib.getExcelData("Sheet2", 1, 0);

		String SelectProvince=eLib.getExcelData("Sheet2", 1, 1);
				
		String SelectCity=eLib.getExcelData("Sheet2", 1, 2);
		
		String ph=eLib.getExcelData("Sheet2", 1, 3);
		
		
		//Launch the URL
		if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	    }else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}else {
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
		SupplierPage sp=new SupplierPage(driver);
		
		//login to the application
		LoginPage ln=new LoginPage(driver);
		ln.loginToApplication(USERNAME, PASSWORD);
		
		//navigate to supplier
		hp.getNavigateToSupplier().click();
		sp.getCreateSupplierAddIcon().click();
		
		sp.CreateSupplier(CompanyName, SelectProvince, SelectCity, ph);
		
		// logout admin
				hp.LogoutOFApplication();
				driver.close();

		
		
		

	
		
		

	}

}

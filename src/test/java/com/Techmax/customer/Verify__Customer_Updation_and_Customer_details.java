package com.TechMAX.customer;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify__Customer_Updation_and_Customer_details {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();


		//Read the data from property file
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		String BROWSER=fLib.getPropertyKeyValue("Browser");

   
		//Read the data from Excelfile
				
				String FirstName = eLib.getExcelData("Sheet1", 6, 2);
				String Lastname = eLib.getExcelData("Sheet1", 6, 3);
				//DataFormatter format=new DataFormatter();
				String value = eLib.getExcelData("Sheet1", 6, 4);
				
				//add in excel
				String uFirstName = eLib.getExcelData("Sheet1", 6, 5);
				String uLastNamee = eLib.getExcelData("Sheet1", 6, 6);
				String uphonenu=eLib.getExcelData("Sheet1", 6, 7);
				
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
		        HomePage hp = new 	HomePage(driver);
				CustomerPage cpc=new CustomerPage(driver);
				
				//login to the application
				login.loginToApplication(USERNAME, PASSWORD);
				
				//Navigate to customer major tab
				hp.getNavigateToCustomer().click();
				//cpc.getcreateCustomerAddIcon().click();
				cpc.createcustomer(FirstName, Lastname, value);
				cpc.getSearchTextField().sendKeys(FirstName);
				cpc.getEllipsisButton().click();
				cpc.getEditButton().click();
				cpc.updateCustomer(uFirstName, uLastNamee, uphonenu);
				
				//Verify using search
				cpc.getSearchTextField().sendKeys(uFirstName);
				
				// logout admin
				hp.getLogout();
				driver.close();

				
	}

	
}



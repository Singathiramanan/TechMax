package com.sales.techmax.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.sales.techmax.objectRepositoryUtility.HomePage;
import com.sales.techmax.objectRepositoryUtility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	/*Object Creation for Lib*/
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public DatabaseUtility dLib=new DatabaseUtility();
	
	@BeforeSuite(groups = {"regressionTesting","smokeTesting"})
	public void configBS() {
	System.out.println("========================connect to DB========================");
	}
	//@Parameters("Browser")
	@BeforeClass(groups = {"regressionTesting","smokeTesting"})
	public void configBC() throws Throwable {
	System.out.println("=============Launch the Browser=======");
   String browser = fLib.getPropertyKeyValue("Browser");
	if (browser.equalsIgnoreCase("msedge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	} else if (browser.equalsIgnoreCase("chrome")) {	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	} else {
		System.out.println("invalid browser");
		
	}
	sdriver=driver;
	driver.manage().window().maximize();
	wLib.waitForElementInDOM(driver);
	}
	
	@BeforeMethod(groups = {"regressionTesting","smokeTesting"})
	public void configBM() throws Throwable {
	/*common Data*/
		
		String url = fLib.getPropertyKeyValue("url");
		String admin_UN = fLib.getPropertyKeyValue("username");
		String admin_PW = fLib.getPropertyKeyValue("password");
		driver.get(url);
	/* step 1 : login */
	LoginPage login=new LoginPage(driver);
	login.loginToApplication(admin_UN, admin_PW);
	}
	
	@AfterMethod(groups = {"regressionTesting","smokeTesting"})
	public void configAM() {
	/*step 6 : logout*/
		HomePage home=new HomePage(driver);
		home.LogoutOFApplication();
	}
	
	@AfterClass(groups = {"regressionTesting","smokeTesting"})
	public void configAC() {
	System.out.println("=============Close the Browser=======");
	driver.quit();
	}
	
	@AfterSuite(groups = {"regressionTesting","smokeTesting"})
	public void configAS() {
	System.out.println("========================close DB========================");
	}
}

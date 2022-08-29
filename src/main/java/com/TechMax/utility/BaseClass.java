package com.TechMax.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.TechMax.Pomrepositorylib.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	/*Object Creation for Lib*/
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	
	
	@BeforeSuite(groups={"SmokeTesting","RegressionTesting"})
	public void configBS() {
	System.out.println("========================connect to DB========================");
	}
	//@Parameters("Browser")
	@BeforeClass(groups={"SmokeTesting","RegressionTesting"})
	public void configBC() throws Throwable {
	System.out.println("=============Launch the Browser=======");
	String browser= fLib.getPropertyKeyValue("browser");
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
	
	@BeforeMethod(groups={"SmokeTesting","RegressionTesting"})
	public void configBM() throws Throwable {
	LoginPage login = new LoginPage(driver);
	login.loginToApplicationAsAdmin();
	System.out.println("Login");
	}
	
	@AfterMethod(groups={"SmokeTesting","RegressionTesting"})
	public void configAM() {
	/*step 6 : logout*/
		LoginPage login = new LoginPage(driver);
		login.LogoutToApplication();
	}
	@AfterClass(groups={"SmokeTesting","RegressionTesting"})
	public void configAC() {
	System.out.println("=============Close the Browser=======");
	driver.quit();
	}
	@AfterSuite (groups={"SmokeTesting","RegressionTesting"})
	public void configAS() {
	System.out.println("========================close DB========================");
	}
}

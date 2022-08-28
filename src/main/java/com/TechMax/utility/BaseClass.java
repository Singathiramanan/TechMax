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
import com.TechMax.Pomrepositorylib.SingletonDesignPattern;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver=null;
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
	}
	
	@BeforeMethod(groups={"SmokeTesting","RegressionTesting"})
	public void configBM() throws Throwable {
	/*common Data*/
		String url = fLib.getPropertyKeyValue("url");
		String admin_UN = fLib.getPropertyKeyValue("admin_username");
		String admin_PW = fLib.getPropertyKeyValue("admin_password");
	/* step 1 : login */
	SingletonDesignPattern s=new SingletonDesignPattern(driver);		
	s.getLoginPage().loginToApplication(url, admin_UN, admin_PW);
	}
	@AfterMethod(groups={"SmokeTesting","RegressionTesting"})
	public void configAM() {
	/*step 6 : logout*/
	SingletonDesignPattern s=new SingletonDesignPattern(driver);		
	s.getLoginPage().LogoutToApplication();
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

/*package com.Techmax.EndToEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.Pomrepositorylib.TransactionPage;
import com.TechMax.Pomrepositorylib.PosPage;
import com.TechMax.utility.ExcelUtility;
import com.TechMax.utility.FileUtility;
import com.TechMax.utility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sale_a_product_check_the_transaction_details_test {
	
	public static void main(String[] args) throws Throwable {

		// creating object
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		WebDriver driver = null;
		
		// Fetching data from property file
		String url = fLib.getPropertyKeyValue("url");
		String admin_UN = fLib.getPropertyKeyValue("admin_username");
		String admin_PW = fLib.getPropertyKeyValue("admin_password");
		String browser = fLib.getPropertyKeyValue("browser");
		String user_UN = fLib.getPropertyKeyValue("user_username");
		String user_PW = fLib.getPropertyKeyValue("user_password");

		// Fetching data from excel
		String qty = eLib.getExcelData("Sheet1", 4, 2);
		String cust = eLib.getExcelData("Sheet1", 4, 3);
		String category=eLib.getExcelData("Sheet1", 4, 4);
		String productName=eLib.getExcelData("Sheet1", 4, 5);

		// launch url
		if (browser.equalsIgnoreCase("msedge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			System.out.println("invalid browser");
		}
		
		// Login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(url, user_UN, user_PW);
		
		// navigate POS and select category
		PosPage pos=new PosPage(driver);
		pos.getPos_button().click();
		pos.selectategory(category);
		pos.sendQuantity(productName, qty);
		pos.clickAddButton(productName);
		
		// select a customer and click on submit
		WebElement dd1 = pos.getCust_dropdown();
		wLib.select(dd1, cust);
		pos.getSubmit_button().click();
		WebElement ele =pos.getTotal_text();
		String amount = ele.getAttribute("value");
		System.out.println("Total Amount= "+amount);
		pos.getAmount_tf().sendKeys(amount);
		pos.getProceedToPayment_btn().click();
		wLib.swithToAlertWindowAndAccpect(driver);

		// logout user
		lp.LogoutToApplication();
		
		// Login to application
		lp.loginToApplication(url, admin_UN, admin_PW);
		
		//navigate to transaction
		HomePage home=new HomePage(driver);
		TransactionPage trans=new TransactionPage(driver);
		home.getNavigateToTransaction().click();
		trans.getTrans_number_btn().click();
		trans.getDetails_btn().click();
		String cash =trans.totalAmount(amount);
		System.out.println("Total Amount in receipt="+cash);
		if (amount.contains(cash)) {
			System.out.println("Transaction Details Should present");
		} else {
			System.out.println("Transaction details not present");
		}
		
		// logout user
		lp.LogoutToApplication();
		driver.close();
	}

}*/

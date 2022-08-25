/*package com.Techmax.EndToEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.InventoryPage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.Pomrepositorylib.PosPage;
import com.TechMax.Pomrepositorylib.ProductPage;
import com.TechMax.Pomrepositorylib.TransactionPage;
import com.TechMax.utility.ExcelUtility;
import com.TechMax.utility.FileUtility;
import com.TechMax.utility.JavaUtility;
import com.TechMax.utility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductLoginAsEmployeeGenrateBillInPOSforProduct {

	public static void main(String[] args) throws Throwable {
			ExcelUtility eLib = new ExcelUtility();
			FileUtility fLib = new FileUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			WebDriver driver = null;
			String ran = jLib.getRanDomNumber();

	// Fetching data from property files
	
	String url = fLib.getPropertyKeyValue("url");
	String admin_UN = fLib.getPropertyKeyValue("admin_username");
	String admin_PW = fLib.getPropertyKeyValue("admin_password");
	String browser = fLib.getPropertyKeyValue("browser");
	String user_UN = fLib.getPropertyKeyValue("user_username");
	String user_PW = fLib.getPropertyKeyValue("user_password");
	

	// Fetching data from excel
	String p_code = eLib.getExcelData("Sheet1", 10, 2);
	String p_name = eLib.getExcelData("Sheet1", 10, 3);
	String supplier = eLib.getExcelData("Sheet1", 10, 4);
	String descrpition = eLib.getExcelData("Sheet1", 10, 5);
	String quantity = eLib.getExcelData("Sheet1", 10, 6);
	String on_hand = eLib.getExcelData("Sheet1", 10, 7);
	String price = eLib.getExcelData("Sheet1", 10, 8);
	String catagory = eLib.getExcelData("Sheet1", 10, 9);
	String p_qty = eLib.getExcelData("Sheet1", 10, 13);
	String upQuantity = eLib.getExcelData("Sheet1", 10, 11);
	String upOn_hand  = eLib.getExcelData("Sheet1", 10, 12);
	String custName = eLib.getExcelData("Sheet1", 10, 14);
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

	HomePage home=new HomePage(driver);
	LoginPage login=new LoginPage(driver);
	ProductPage product=new ProductPage(driver);
	PosPage pos=new PosPage(driver);
	InventoryPage inventory=new InventoryPage(driver);
	TransactionPage trans = new TransactionPage(driver);
	
	// Login to application
	login.loginToApplication(url, admin_UN, admin_PW);
	
	home.getNavigateToProduct().click();
	
	product.getCreateProductAddIcon().click();
	
	// CREATE A NEW PRODUCT
	String productCode=p_code+ran;
	String productName = p_name+ran;
	product.CreateProduct(productCode, productName, descrpition, quantity, on_hand, price, catagory, supplier);
	
	//navigate to inventory
	home.getNavigateToInventory().click(); 
	//search using product name
	inventory.getSearch_TF().sendKeys(productName);
	//view button
	inventory.getViewButton().click();
	
	//click on edit button
	inventory.getEditInventory().click();
	 	 
	 //update details qty and on hand stock
	 inventory.getUpdateQty().clear();
	 inventory.getUpdateQty().sendKeys(upQuantity);
	 inventory.getUpdateOnHand().clear();
	 inventory.getUpdateOnHand().sendKeys(upOn_hand);
		 
	 //clcik on update button
	 inventory.getUpdateButton().click();
	
	 //click on OK in Alert pop up
	 wLib.swithToAlertWindowAndAccpect(driver);
	 
	 //logout as admin
	 login.LogoutToApplication();
	 
	 //login as user
	 login.loginToApplication(url, user_UN, user_PW);
	 
	 //clcik on pos
	 //home.getNavigateToPOS().click();
	 
	//click on product category layout
		pos.selectategory(catagory);

		//17.add the product count and Click on Add Button
		pos.sendQuantity(productName, p_qty);
		pos.clickAddButton(productName);
		//Select customer 
		pos.getCust_dropdown().sendKeys(custName);
		
		//fetch total amount
		String total = pos.getTotal_text().getAttribute("value");

		//click on submit
		pos.getSubmit_button().click();

		//enter cash
		pos.getAmount_tf().sendKeys(total);

		//click on proceed to payment
		pos.getProceedToPayment_btn().click();
		wLib.swithToAlertWindowAndAccpect(driver);
		
		//Logout as user09082022
		login.LogoutToApplication();
		
		//login as admin
		login.loginToApplication(url, admin_UN, admin_PW);

		// click on transaction page 
		home.getNavigateToTransaction().click();
		
		//search customer in search textfiled
		trans.getSearch_TF().sendKeys(custName);
		
		//click on view button
		trans.getDetails_btn().click();
		
		login.LogoutToApplication();
		driver.quit();

		
}

	}*/



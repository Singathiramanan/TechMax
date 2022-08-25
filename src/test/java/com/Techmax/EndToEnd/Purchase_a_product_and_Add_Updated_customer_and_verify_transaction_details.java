/*package com.Techmax.EndToEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.Pomrepositorylib.ProductPage;
import com.TechMax.Pomrepositorylib.TransactionPage;
import com.TechMax.Pomrepositorylib.PosPage;
import com.TechMax.utility.ExcelUtility;
import com.TechMax.utility.FileUtility;
import com.TechMax.utility.JavaUtility;
import com.TechMax.utility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Purchase_a_product_and_Add_Updated_customer_and_verify_transaction_details {

	public static void main(String[] args) throws Throwable {
		// Create Object for Utility
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

		// Fetching data from excel
		String product_code = eLib.getExcelData("Sheet1", 1, 2);
		String product_name = eLib.getExcelData("Sheet1", 1, 3);
		String supplier = eLib.getExcelData("Sheet1", 1, 4);
		String descrpition = eLib.getExcelData("Sheet1", 1, 5);
		String quantity = eLib.getExcelData("Sheet1", 1, 6);
		String on_hand = eLib.getExcelData("Sheet1", 1, 7);
		String price = eLib.getExcelData("Sheet1", 1, 8);
		String catagory = eLib.getExcelData("Sheet1", 1, 9);
		String customer_fn = eLib.getExcelData("Sheet1", 1, 11);
		String customer_ln = eLib.getExcelData("Sheet1", 1, 12);
		String customrt_pn = eLib.getExcelData("Sheet1", 1, 13);
		String updated_price = eLib.getExcelData("Sheet1", 1, 14);
		String product_qty = eLib.getExcelData("Sheet1", 1, 15);

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
		
		// Create object for POM Class
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		ProductPage product=new ProductPage(driver);
		PosPage pos=new PosPage(driver);
		TransactionPage transaction=new TransactionPage(driver);
		try { 
			// Login to application
			login.loginToApplication(url, admin_UN, admin_PW);

			// CREATE A NEW PRODUCT
			home.getNavigateToProduct().click();
			product.getCreateProductAddIcon().click();
			String pcode = product_code + "_" + ran;
			product.CreateProduct(pcode, product_name, descrpition, quantity, on_hand, price, catagory, supplier);
			
			// click on search product and edit 
			product.getSearchTextfield().sendKeys(pcode);
			product.getElipseIcon().click();
			product.getEditButton().click();
			product.EditProduct(product_name, descrpition, updated_price, catagory);
			
			// click on pos and add product
			home.getNavigateToPOS().click();
			pos.selectategory(catagory);
			pos.sendQuantity(product_name, product_qty);
			pos.clickAddButton(product_name);
			
			// add a customer
			pos.addCustomer(customer_fn, customer_ln, customrt_pn);

			// select customer and proceed to payment
			WebElement dd1 =pos.getCust_dropdown();
			wLib.select(dd1, customer_fn + " " + customer_ln);
			pos.getSubmit_button().click();
			WebElement ele = pos.getTotal_text();
			String amount = ele.getAttribute("value");
			System.out.println("Total amount=" + amount);
			pos.getAmount_tf().sendKeys(amount);
			pos.getProceedToPayment_btn().click();
			wLib.swithToAlertWindowAndAccpect(driver);

			// check on transaction
			home.getNavigateToSalesAndInventoryIcon().click();
			home.getNavigateToTransaction().click();
			transaction.getTrans_number_btn().click();
			transaction.getDetails_btn().click();
			String cash =transaction.totalAmount(amount);
			if (amount.contains(cash)) {
				System.out.println("Transaction Details Should present");
			} else {
				System.out.println("Transaction details not present");
			}
			login.LogoutToApplication();
		} finally {
			Thread.sleep(7000);
			driver.quit();
		}
	}

}*/

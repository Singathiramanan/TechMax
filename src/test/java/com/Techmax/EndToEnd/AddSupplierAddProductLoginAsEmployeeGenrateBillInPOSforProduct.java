/*package com.Techmax.EndToEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.Pomrepositorylib.ProductPage;
import com.TechMax.Pomrepositorylib.SupplierPage;
import com.TechMax.Pomrepositorylib.TransactionPage;
import com.TechMax.Pomrepositorylib.PosPage;
import com.TechMax.utility.ExcelUtility;
import com.TechMax.utility.FileUtility;
import com.TechMax.utility.JavaUtility;
import com.TechMax.utility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddSupplierAddProductLoginAsEmployeeGenrateBillInPOSforProduct {

	public static void main(String[] args) throws Throwable {
		// creating object
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
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
		String companyName = eLib.getExcelData("Sheet1", 16, 2);
		String Province = eLib.getExcelData("Sheet1", 16, 3);
		String City = eLib.getExcelData("Sheet1", 16, 4);
		String PhoneNumber = eLib.getExcelData("Sheet1", 16, 5);
		String p_code = eLib.getExcelData("Sheet1", 16, 6);
		String p_name = eLib.getExcelData("Sheet1", 16, 7);
		String descrpition = eLib.getExcelData("Sheet1", 16, 9);
		String quantity = eLib.getExcelData("Sheet1", 16, 10);
		String on_hand = eLib.getExcelData("Sheet1", 16, 11);
		String price = eLib.getExcelData("Sheet1", 16, 12);
		String catagory = eLib.getExcelData("Sheet1", 16, 13);
		String updatedProductName = eLib.getExcelData("Sheet1", 16, 15);
		String updatedDescription = eLib.getExcelData("Sheet1", 16, 16);
		String updatedPrice = eLib.getExcelData("Sheet1", 16, 17);
		String updatedCategory = eLib.getExcelData("Sheet1", 16, 18);
		String purchaseQuantity = eLib.getExcelData("Sheet1", 16, 19);
		String customer = eLib.getExcelData("Sheet1", 16, 20);

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
		
		LoginPage login=new LoginPage(driver);
		ProductPage product=new ProductPage(driver);
		HomePage home=new HomePage(driver);
		PosPage pos=new PosPage(driver);
		SupplierPage supplier=new SupplierPage(driver);
		TransactionPage trans=new TransactionPage(driver);
		
		// Login to application
		login.loginToApplication(url, admin_UN, admin_PW);
		
		//Click on Supplier major tab
		home.getNavigateToSupplier().click();
		supplier.getCreateSupplierAddIcon().click();
		//8.Enter the details
		String company = companyName+"_"+ran;
		supplier.CreateSupplier(company, Province, City, PhoneNumber);
		System.out.println("supplier is created");
		
		// CREATE A NEW PRODUCT
		home.getNavigateToProduct().click();
		product.getCreateProductAddIcon().click();
		String pcode = p_code + "_" + ran;
		String pname = p_name + "_" + ran;
		product.CreateProduct(pcode, pname, descrpition, quantity, on_hand, price, catagory, company);
		System.out.println("Product is created");
		
		product.getSearchTextfield().sendKeys(pcode);
		product.getElipseIcon().click();
		product.getEditButton().click();
		product.EditProduct(updatedProductName, updatedDescription, updatedPrice, updatedCategory);
		//details button need to click
		login.LogoutToApplication();
		
		login.loginToApplication(url, user_UN, user_PW);
		pos.getPos_button().click();
		pos.selectategory(updatedCategory);
		pos.sendQuantity(updatedProductName,purchaseQuantity);
		pos.clickAddButton(updatedProductName);
		
		// select a customer and click on submit
		WebElement dd1 = pos.getCust_dropdown();
		wLib.select(dd1, customer);
		pos.getSubmit_button().click();
		WebElement ele =pos.getTotal_text();
		String amount = ele.getAttribute("value");
		System.out.println("Total Amount= "+amount);
		pos.getAmount_tf().sendKeys(amount);
		pos.getProceedToPayment_btn().click();
		wLib.swithToAlertWindowAndAccpect(driver);
		
		login.LogoutToApplication();
		login.loginToApplication(url, admin_UN, admin_PW);
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
		login.LogoutToApplication();
		driver.close();	
	}

}*/

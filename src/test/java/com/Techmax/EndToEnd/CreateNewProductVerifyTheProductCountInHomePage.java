/* package com.Techmax.EndToEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.Pomrepositorylib.ProductPage;
import com.TechMax.utility.ExcelUtility;
import com.TechMax.utility.FileUtility;
import com.TechMax.utility.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewProductVerifyTheProductCountInHomePage {

	public static void main(String[] args) throws Throwable {

		// creating object
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriver driver = null;
		String ran = jLib.getRanDomNumber();
		
		// Fetching data from property file
		String url = fLib.getPropertyKeyValue("url");
		String admin_UN = fLib.getPropertyKeyValue("admin_username");
		String admin_PW = fLib.getPropertyKeyValue("admin_password");
		String browser = fLib.getPropertyKeyValue("browser");

		// Fetching data from excel file
		String p_code = eLib.getExcelData("Sheet1", 7, 2);
		String p_name = eLib.getExcelData("Sheet1", 7, 3);
		String supplier = eLib.getExcelData("Sheet1", 7, 4);
		String descrpition = eLib.getExcelData("Sheet1", 7, 5);
		String quantity = eLib.getExcelData("Sheet1", 7, 6);
		String on_hand = eLib.getExcelData("Sheet1", 7, 7);
		String price = eLib.getExcelData("Sheet1", 7, 8);
		String catagory = eLib.getExcelData("Sheet1", 7, 9);

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
		lp.loginToApplication(url, admin_UN, admin_PW);
		HomePage home=new HomePage(driver);
		WebElement ele = home.getProductCount();
		String record = ele.getText();
		String[] num = record.split(" ");
		int count = Integer.parseInt(num[0]);
		System.out.println("Product quantity before added:- " + count);
		home.getNavigateToProduct().click();
		// CREATE A NEW PRODUCT
		ProductPage product=new ProductPage(driver);
		product.getCreateProductAddIcon().click();
		String pcode=p_code + "_" + ran;
		product.CreateProduct(pcode, p_name, descrpition, quantity, on_hand, price, catagory, supplier);
		
		home.getNavigateToHome().click();
		
		WebElement ele1 = home.getProductCount();
		String record1 = ele1.getText();
		String[] num1 = record1.split(" ");
		int newcount = Integer.parseInt(num1[0]);
		int qty = Integer.parseInt(quantity);
		System.out.println("Product quantity added:- " + qty);
		System.out.println("Product quantity after added:- " + newcount);

		int total = count + qty;
		if (total == newcount) {
			System.out.println("Product Quantity is increased");
		} else {
			System.out.println("product quantity not increased");
		}
		lp.LogoutToApplication();
		driver.close();

	}

}*/

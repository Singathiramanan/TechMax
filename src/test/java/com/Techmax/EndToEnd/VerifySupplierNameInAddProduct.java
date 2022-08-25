/*package com.Techmax.EndToEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.InventoryPage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.Pomrepositorylib.ProductPage;
import com.TechMax.Pomrepositorylib.SupplierPage;
import com.TechMax.utility.ExcelUtility;
import com.TechMax.utility.FileUtility;
import com.TechMax.utility.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySupplierNameInAddProduct {

	public static void main(String[] args) throws Throwable {
		// creating object
				FileUtility fLib = new FileUtility();
				JavaUtility jLib = new JavaUtility();
				ExcelUtility eLib = new ExcelUtility();
				WebDriver driver = null;
				String ran = jLib.getRanDomNumber();

				// Fetching data from property files
				String url = fLib.getPropertyKeyValue("url");
				String admin_UN = fLib.getPropertyKeyValue("admin_username");
				String admin_PW = fLib.getPropertyKeyValue("admin_password");
				String browser = fLib.getPropertyKeyValue("browser");

				// Fetching data from excel

				String companyName = eLib.getExcelData("Sheet1", 13, 2);
				String Province = eLib.getExcelData("Sheet1", 13, 3);
				String City = eLib.getExcelData("Sheet1", 13, 4);
				String PhoneNumber = eLib.getExcelData("Sheet1", 13, 5);
				String p_code = eLib.getExcelData("Sheet1", 13, 6);
				String p_name = eLib.getExcelData("Sheet1", 13, 7);
				String descrpition = eLib.getExcelData("Sheet1", 13, 9);
				String quantity = eLib.getExcelData("Sheet1", 13, 10);
				String on_hand = eLib.getExcelData("Sheet1", 13, 11);
				String price = eLib.getExcelData("Sheet1", 13, 12);
				String catagory = eLib.getExcelData("Sheet1", 13, 13);
				
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
				
				//Click on Supplier major tab
				HomePage home=new HomePage(driver);
				home.getNavigateToSupplier().click();

				//Create a supplier
				SupplierPage sp=new SupplierPage(driver);
				sp.getCreateSupplierAddIcon().click();
				String company = companyName+"_"+ran;
				sp.CreateSupplier(company, Province, City, PhoneNumber);
				System.out.println("supplier is created");
				
				// Create a product
				home.getNavigateToProduct().click();
				ProductPage product=new ProductPage(driver);
				product.getCreateProductAddIcon().click();
				String pcode = p_code + "_" + ran;
				product.CreateProduct(pcode, p_name, descrpition, quantity, on_hand, price, catagory, company);
				System.out.println("Product is created");
				
				//click on inventory check the product
				home.getNavigateToInventory().click();
				InventoryPage inventory=new InventoryPage(driver);
				inventory.getSearch_TF().sendKeys(pcode);
				System.out.println("product details is present");
				lp.LogoutToApplication();
				driver.close();

	}

}
*/
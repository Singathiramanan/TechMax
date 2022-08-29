package com.Techmax.Inventory;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TechMax.Pomrepositorylib.InventoryPage;
import com.TechMax.Pomrepositorylib.SingletonDesignPattern;
import com.TechMax.Pomrepositorylib.SupplierPage;
import com.TechMax.utility.BaseClass;

@Listeners(com.TechMax.utility.ItestLisImpClass.class)

public class InventoryTest extends BaseClass {
	
	@Test(groups="RegressionTest", enabled = true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class)
	public void VerifySupplierNameInAddProduct_test() throws Throwable{
		String ran = jLib.getRanDomNumber(1000);

		// Fetching data from excel
		String companyName = eLib.getExcelData("Sheet1", 17, 2);
		String Province = eLib.getExcelData("Sheet1", 17, 3);
		String City = eLib.getExcelData("Sheet1", 17, 4);
		String PhoneNumber = eLib.getExcelData("Sheet1", 17, 5);
		String p_code = eLib.getExcelData("Sheet1", 17, 6);
		String p_name = eLib.getExcelData("Sheet1", 17, 7);
		String descrpition = eLib.getExcelData("Sheet1", 17, 9);
		String quantity = eLib.getExcelData("Sheet1", 17, 10);
		String on_hand = eLib.getExcelData("Sheet1", 17, 11);
		String price = eLib.getExcelData("Sheet1", 17, 12);
		String catagory = eLib.getExcelData("Sheet1", 17, 13);
		
		//Click on Supplier major tab
		SingletonDesignPattern s=new SingletonDesignPattern(driver);		
		s.getHomePage().getNavigateToSupplier().click();

		//Create a supplier
		SupplierPage sp=new SupplierPage(driver);
		sp.getCreateSupplierAddIcon().click();
		String company = companyName;
		sp.CreateSupplier(company, Province, City, PhoneNumber);
		System.out.println("supplier is created");
		
		// Create a product
		s.getHomePage().getNavigateToProduct().click();
		
		s.getProductPage().getCreateProductAddIcon().click();
		String pcode = p_code + "_" + ran;
		s.getProductPage().CreateProduct(pcode, p_name, descrpition, quantity, on_hand, price, catagory, company);
		System.out.println("Product is created");
		
		//click on inventory check the product
		s.getHomePage().getNavigateToInventory().click();
		InventoryPage inventory=new InventoryPage(driver);
		inventory.getSearch_TF().sendKeys(pcode);
		System.out.println("product details is present");

		}

}

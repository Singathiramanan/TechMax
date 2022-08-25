 package com.Techmax.Home;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TechMax.Pomrepositorylib.SingletonDesignPattern;
import com.TechMax.utility.BaseClass;

@Listeners(com.TechMax.utility.ItestLisImpClass.class)

public class HomeTest extends BaseClass {
	@Test(groups="RegressionTest"/*,retryAnalyzer=com.TechMax.utility.IRetry.class*/)
	public void CreateNewProductVerifyTheProductCountInHomePage_test() throws Throwable{
		String ran = jLib.getRanDomNumber();
		// Fetching data from excel file
		String p_code = eLib.getExcelData("Sheet1", 11, 2);
		String p_name = eLib.getExcelData("Sheet1", 11, 3);
		String supplier = eLib.getExcelData("Sheet1", 11, 4);
		String descrpition = eLib.getExcelData("Sheet1", 11, 5);
		String quantity = eLib.getExcelData("Sheet1", 11, 6);
		String on_hand = eLib.getExcelData("Sheet1", 11, 7);
		String price = eLib.getExcelData("Sheet1", 11, 8);
		String catagory = eLib.getExcelData("Sheet1", 11, 9);
		
		SingletonDesignPattern s=new SingletonDesignPattern(driver);		
		WebElement ele = s.getHomePage().getProductCount();
		String record = ele.getText();
		String[] num = record.split(" ");
		int count = Integer.parseInt(num[0]);
		System.out.println("Product quantity before added:- " + count);
		s.getHomePage().getNavigateToProduct().click();
		
		// CREATE A NEW PRODUCT		
		s.getProductPage().getCreateProductAddIcon().click();
		String pcode=p_code + "_" + ran;
		s.getProductPage().CreateProduct(pcode, p_name, descrpition, quantity, on_hand, price, catagory, supplier);
		
		s.getHomePage().getNavigateToHome().click();
		
		WebElement ele1 = s.getHomePage().getProductCount();
		String record1 = ele1.getText();
		String[] num1 = record1.split(" ");
		int newcount = Integer.parseInt(num1[0]);
		int qty = Integer.parseInt(quantity);
		System.out.println("Product quantity added:- " + qty);
		System.out.println("Product quantity after added:- " + newcount);
		int total = count + qty;
		Assert.assertEquals(total, newcount);
		
	}
}

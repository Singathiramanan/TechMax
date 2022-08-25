package com.TechMax.Pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SingletonDesignPattern {
	
	public static WebDriver driver;
	public SingletonDesignPattern(WebDriver driver2) {
		PageFactory.initElements(driver2, this);
		SingletonDesignPattern.driver = driver2;
	}
	
	public LoginPage getLoginPage(){
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	public HomePage getHomePage(){
		HomePage home=new HomePage(driver);
		return home;
	}
	
	public ProductPage getProductPage(){
		ProductPage product=new ProductPage(driver);
		return product;
	}
	
	public PosPage getPosPage(){
		PosPage pos=new PosPage(driver);
		return pos;
	}

	public TransactionPage getTransactionPage(){
		TransactionPage transaction=new TransactionPage(driver);
		return transaction;
	}
	
	public InventoryPage getInventoryPage(){
		InventoryPage inventory = new InventoryPage(driver);
		return inventory;
	}
	
	public SupplierPage getSupplierPage(){
		SupplierPage supplier=new SupplierPage(driver);
		return supplier;
	}

}

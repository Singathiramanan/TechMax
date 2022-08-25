package com.TechMax.Pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement Search_TF;
	@FindBy(xpath="//div[@id='content-wrapper']/descendant::a[@class='btn btn-primary bg-gradient-primary']")
	private WebElement viewButton;
	@FindBy(xpath="//div[@id='content-wrapper']/descendant::a[@class='btn btn-warning bg-gradient-warning']")
	private WebElement editInventory;
	@FindBy(xpath="//div[@id='content-wrapper']/descendant::input[@name='qty']")
	private WebElement updateQty;
	@FindBy(xpath="//div[@id='content-wrapper']/descendant::input[@name='oh']")
	private WebElement updateOnHand;
	@FindBy(xpath="//div[@id='content-wrapper']/descendant::button[@class='btn btn-warning btn-block']")
	private WebElement updateButton;
	
	
	WebDriver driver;
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public WebElement getSearch_TF() {
		return Search_TF;
	}
	public WebElement getViewButton(){
		return viewButton;
	}
	public WebElement getEditInventory() {
		return editInventory;
	}
	public WebElement getUpdateQty() {
		return updateQty;
	}
	public WebElement getUpdateOnHand() {
		return updateOnHand;
	}
	public WebElement getUpdateButton() {
		return updateButton;
	}
}

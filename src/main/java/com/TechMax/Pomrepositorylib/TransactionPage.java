package com.TechMax.Pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage {

	@FindBy(xpath = "//th[.='Transaction Number']")
	private WebElement Trans_number_btn;
	@FindBy(xpath = "//tbody/tr[1]/descendant::a[.=' View']")
	private WebElement Details_btn;
	@FindBy(xpath="//input[@type='search']")
	private WebElement Search_TF;
	

	// Initialization
	WebDriver driver;

	public TransactionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Initialization
	public WebElement getTrans_number_btn() {
		return Trans_number_btn;
	}
	public WebElement getSearch_TF() {
		return Search_TF;
	}
	public WebElement getDetails_btn() {
		return Details_btn;
	}

	public String totalAmount(String price){
		String total = driver.findElement(By.xpath("//tbody/tr[*]/td[.='"+price+"']")).getText();
		return total;
	}

}

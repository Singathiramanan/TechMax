package com.TechMax.Pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierPage {

	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement CreateSupplierAddIcon;
	@FindBy(name="companyname")
	private WebElement CompanyNameTextfield;
	@FindBy(xpath="//div[@id='supplierModal']/descendant::select[@name='province']")
	private WebElement ProvinceDropdown;
	@FindBy(xpath="//div[@id='supplierModal']/descendant::select[@name='city']")
	private WebElement CityDropdown;
	@FindBy(xpath="//div[@id='supplierModal']/descendant::input[@name='phonenumber']")
	private WebElement PhoneNumberTextfield;
	@FindBy(xpath="//div[@id='supplierModal']/descendant::button[@class='btn btn-success']")
	private WebElement SaveButton;
	
	WebDriver driver;
	public SupplierPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public WebElement getCreateSupplierAddIcon() {
		return CreateSupplierAddIcon;
	}
	public WebElement getCompanyNameTextfield() {
		return CompanyNameTextfield;
	}
	public WebElement getProvinceDropdown() {
		return ProvinceDropdown;
	}
	public WebElement getCityDropdown() {
		return CityDropdown;
	}
	public WebElement getPhoneNumberTextfield() {
		return PhoneNumberTextfield;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}

	

	public void CreateSupplier(String CompanyName, String SelectProvince, String SelectCity, String ph)
	{	
	CompanyNameTextfield.sendKeys(CompanyName);
	ProvinceDropdown.sendKeys(SelectProvince);
	CityDropdown.sendKeys(SelectCity);
	PhoneNumberTextfield.sendKeys(ph);
	SaveButton.click();
	}
	
}

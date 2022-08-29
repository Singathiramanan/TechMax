package com.TechMax.Pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	//Declaration --Rule1
	@FindBy(xpath="//a[@class='btn btn-primary bg-gradient-primary']")
	private WebElement createCustomerAddIcon;
	@FindBy(xpath="//div[@id='customerModal']/descendant::h5[.='Add Customer']/parent::div/following-sibling::div[@class='modal-body']/descendant::input[@name='firstname']")
	private WebElement firstNameTextField;
	@FindBy(xpath="//div[@id='customerModal']/descendant::h5[.='Add Customer']/parent::div/following-sibling::div[@class='modal-body']/descendant::input[@name='lastname']")
	private WebElement lastNameTextField;
	@FindBy(xpath="//div[@id='customerModal']/descendant::h5[.='Add Customer']/parent::div/following-sibling::div[@class='modal-body']/descendant::input[@name='phonenumber']")
	private WebElement phoneNumberTextField;
	@FindBy(xpath="//div[@id='customerModal']/descendant::h5[.='Add Customer']/parent::div/following-sibling::div[@class='modal-body']/descendant::button[@class='btn btn-success']")
	private WebElement createCustomerSaveButton;
	@FindBy(name="customer")
	private WebElement customerNameTextfield;
	
	//Initialization --Rule2
	WebDriver driver;
	public CustomerPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public WebElement getcreateCustomerAddIcon(){
		return createCustomerAddIcon;
	}

	public WebElement getfirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getlastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getphoneNumberTextField() {
		return phoneNumberTextField;
	}
	public WebElement getcreateCustomerSaveButton() {
		return createCustomerSaveButton;
	}
	public WebElement getCustomerNameTextfield() {
		return customerNameTextfield;
	}

	

//Utilization
	//Login to application
public void createcustomer(String firstName,String lastName,String phoneNumber) throws Throwable {
	firstNameTextField.click();
	firstNameTextField.sendKeys(firstName);
	lastNameTextField.sendKeys(lastName);
	phoneNumberTextField.sendKeys(phoneNumber);
	createCustomerSaveButton.click();

}
}

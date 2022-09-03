package com.sales.techmax.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sales.techmax.genericUtility.WebDriverUtility;

public class CustomerPage {
	//Declaration --Rule1
	@FindBy(css=".fas.fa-fw.fa-plus")
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
	@FindBy(xpath="//input[@class='form-control text-right ' and @name='total']")
	private WebElement totalamounttextfield;
	@FindBy(xpath="//button[@class='btn btn-block btn-success']")
	private WebElement submitbutton;
	@FindBy(xpath="//div[@id='content']/descendant::input[@type='search']")
	private WebElement searchTextField;

	@FindBy(xpath="//tbody/tr[1]/td[4]/div[1]/div[1]/a[1]")
	private WebElement ellipsisButton;

	@FindBy(xpath="//tbody/tr[1]/td[4]/div[1]/div[1]/ul[1]/li[1]/a[1]/i[1]")
	private WebElement editButton;
	//customerModal
	//div[@id='content-wrapper']/descendant::input[@name='firstname']
	
	@FindBy(xpath="//div[@id='wrapper']/descendant::input[@name='firstname']")
	private WebElement updateCustFirstName;
	@FindBy(xpath="	//div[@id='wrapper']/descendant::input[@name='lastname']")
	private WebElement updateCustlastName;
	@FindBy(xpath="//div[@id='wrapper']/descendant::input[@name='phone']")
	private WebElement UpdateCustPhoneNumber;
	@FindBy(xpath="//div[@id='wrapper']/descendant::button[@type='submit']")
	private WebElement UpdateCustButton;



	public WebElement getEllipsisButton() {
		return ellipsisButton;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getUpdateCustFirstName() {
		return updateCustFirstName;
	}

	public WebElement getUpdateCustlastName() {
		return updateCustlastName;
	}

	public WebElement getUpdateCustPhoneNumber() {
		return UpdateCustPhoneNumber;
	}

	public WebElement getUpdateCustButton() {
		return UpdateCustButton;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	public WebElement getTotalamounttextfield() {
		return totalamounttextfield;
	}



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
		createCustomerAddIcon.click();
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		phoneNumberTextField.sendKeys(phoneNumber);
		createCustomerSaveButton.click();

	}

	public WebElement getCreateCustomerAddIcon() {
		return createCustomerAddIcon;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

	public WebElement getCreateCustomerSaveButton() {
		return createCustomerSaveButton;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebDriver getDriver() {
		return driver;
	}
	public void updateCustomer(String fn, String ln, String phn ) {
		
		updateCustFirstName.clear();
		updateCustFirstName.sendKeys(fn);
		updateCustlastName.clear();
		updateCustlastName.sendKeys(ln);
		UpdateCustPhoneNumber.clear();
		UpdateCustPhoneNumber.sendKeys(phn);
		UpdateCustButton.click();
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.swithToAlertWindowAndAccpect(driver, "You've Update Customer Successfully.");
	}
}

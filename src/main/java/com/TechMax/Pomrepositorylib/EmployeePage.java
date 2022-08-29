package com.TechMax.Pomrepositorylib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TechMax.utility.JavaUtility;
import com.TechMax.utility.WebDriverUtility;

public class EmployeePage {

	WebDriver driver;
	public EmployeePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement AddEmployeeicon;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::input[@name='firstname']")
	private WebElement firstNameTextfield;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::input[@name='lastname']")
	private WebElement lastNameTextfield;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::select[@name='gender']")
	private WebElement selectGender;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::input[@name='email']")
	private WebElement emailTextfield;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::input[@name='phonenumber']")
	private WebElement PhoneNumberTextfield;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::select[@name='jobs']")
	private WebElement selectJob;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::input[@id='FromDate']")
	private WebElement HireDate;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::select[@name='province']")
	private WebElement selectProvince;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::select[@name='city']")
	private WebElement selectCity;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::button[@class='btn btn-success']")
	private WebElement CreateEmployeeSaveButton;
	@FindBy(xpath="//div[@id='employeeModal']/descendant::button[@class='btn btn-danger']")
	private WebElement CreateEmployeeResetButton;
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement EmployeeSearchTextField;
	@FindBy(xpath="//a[@class='btn btn-primary bg-gradient-primary dropdown no-arrow']")
	private WebElement EmployeeEllipsis;
	
	public WebElement getSelectJob() {
		return selectJob;
	}
	public WebElement getCreateEmployeeResetButton() {
		return CreateEmployeeResetButton;
	}
	public WebElement getEmployeeEllipsis() {
		return EmployeeEllipsis;
	}
	public WebElement getAddEmployeeicon() {
		return AddEmployeeicon;
	}
	public WebElement getEmployeeSearchTextField() {
		return EmployeeSearchTextField;
	}
	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}
	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}
	public WebElement getSelectGender() {
		return selectGender;
	}
	public WebElement getEmailTextfield() {
		return emailTextfield;
	}
	public WebElement getPhoneNumberTextfield() {
		return PhoneNumberTextfield;
	}
	public WebElement getselectJob() {
		return selectJob;
	}
	public WebElement getHireDate() {
		return HireDate;
	}
	public WebElement getSelectProvince() {
		return selectProvince;
	}
	public WebElement getSelectCity() {
		return selectCity;
	}
	public WebElement getCreateEmployeeSaveButton() {
		return CreateEmployeeSaveButton;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void createEmployee(String employeeFirstName,String employeeLastName,String employeeGender,String employeeEmail,String employeePhoneNumber,String employeeJob, String employeeProvince,String employeeCity) throws AWTException, InterruptedException {
		WebDriverUtility wLib=new WebDriverUtility();
		firstNameTextfield.sendKeys(employeeFirstName);
		lastNameTextfield.sendKeys(employeeLastName);
		wLib.select(selectGender,employeeGender);
		emailTextfield.sendKeys(employeeEmail);
		PhoneNumberTextfield.sendKeys(employeePhoneNumber);
		selectJob.sendKeys(employeeJob);
		JavaUtility jLib = new JavaUtility();
		jLib.DateStock(HireDate);
		wLib.select(selectProvince,employeeProvince);
		wLib.select(selectCity,employeeCity);
		CreateEmployeeSaveButton.click();
	}
	
	
	
	
}

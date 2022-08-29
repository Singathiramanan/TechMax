package com.TechMax.Pomrepositorylib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement addUserAccountIcon;
	public WebElement getAddUserAccountIcon() {
		return addUserAccountIcon;
	}

	public WebElement getSelectEmployee() {
		return selectEmployee;
	}

	public WebElement getUsernameTextfield() {
		return usernameTextfield;
	}

	public WebElement getPasswordTextFiled() {
		return passwordTextFiled;
	}

	public WebElement getCreateUserAccountSaveButton() {
		return createUserAccountSaveButton;
	}

	public WebElement getCreateUserAccountResetButton() {
		return createUserAccountResetButton;
	}

	public WebDriver getDriver() {
		return driver;
	}
	public List<WebElement> getEmployeeNameUserAccountTable() {
		return  employeeNameUserAccountTable;
	}
	
	
	@FindAll(value = { @FindBy(xpath="//h4[@class='m-2 font-weight-bold text-primary' and text()='User Accounts ']/ancestor::div[@class='card shadow mb-4']/descendant::table[@id='dataTable']/tbody/tr[*]/td[1]"), @FindBy(xpath="//h4[text()='User Accounts ']/ancestor::div[@class='card shadow mb-4']/descendant::table[@id='dataTable']/tbody/tr[*]/td[1]"), @FindBy(xpath="//div[@class='card shadow mb-4']/descendant::table[@id='dataTable']/tbody/tr[*]/td[1]")})
	private List<WebElement> employeeNameUserAccountTable;
	
	@FindBy(xpath="//select[@class='form-control' and @name='empid']")
	private WebElement selectEmployee;
	
	@FindBy(xpath="//div[@id='supplierModal']/descendant::input[@class='form-control' and @name='username']")
	private WebElement usernameTextfield;
	
	@FindBy(xpath="//div[@id='supplierModal']/descendant::input[@class='form-control' and @name='password']")
	private WebElement passwordTextFiled;
	
	@FindBy(xpath="//div[@id='supplierModal']/descendant::button[@class='btn btn-success']")
	private WebElement createUserAccountSaveButton;
	
	@FindBy(xpath="//div[@id='supplierModal']/descendant::button[@class='btn btn-danger']")
	private WebElement createUserAccountResetButton;
	 
	WebDriver driver;

	public AccountsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void createUserAccount(String employeeName,String username, String password) {
		createUserAccountResetButton.click();
		selectEmployee.sendKeys(employeeName);
		usernameTextfield.sendKeys(username);
		passwordTextFiled.sendKeys(password);
		createUserAccountSaveButton.click();
	}
}

package com.sales.techmax.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sales.techmax.genericUtility.WebDriverUtility;

public class LoginPage {
	//Declaration --Rule1
	@FindBy(name="user")
	private WebElement usernameTextfield;
	@FindBy(name="password")
	private  WebElement passwordTextfield1;
	@FindBy(name="btnlogin")
	private WebElement loginButton;

	//Initialization --Rule2
	WebDriver driver;
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public WebElement getUsernameTextfield() {
		return usernameTextfield;
	}

	public WebElement getPasswordTextfield1() {
		return passwordTextfield1;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebDriver getDriver() {
		return driver;
	}

		//Utilization
		//Login to application
	public void loginToApplication(String username,String password) throws Throwable {
		usernameTextfield.sendKeys(username);
		passwordTextfield1.sendKeys(password);
		loginButton.click();
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.swithToAlertWindowAndAccpect(driver, "veen Welcome!");

	}

	public void LoginHomePage() {
		// TODO Auto-generated method stub
		
	}
}

package com.TechMax.Pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TechMax.utility.WebDriverUtility;

public class LoginPage {

	// Declaration 
	@FindBy(name = "user")
	private WebElement usernameTextfield;

	@FindBy(name = "password")
	private WebElement passwordTextfield1;

	@FindBy(name = "btnlogin")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@id='userDropdown']")
	private WebElement profile_button;
	
	@FindBy(xpath="//a[@data-target='#logoutModal']")
	private WebElement Logout_button;
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement popup_logout;

	// Initialization 
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Utilization
	public WebElement getUsernameTextfield() {
		return usernameTextfield;
	}

	public WebElement getPasswordTextfield1() {
		return passwordTextfield1;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getProfile_button() {
		return profile_button;
	}

	public WebElement getLogout_button() {
		return Logout_button;
	}

	public WebElement getPopup_logout() {
		return popup_logout;
	}


	// Login to application
	WebDriverUtility wLib = new WebDriverUtility();

	public void loginToApplication(String URL,String username, String password) throws Throwable {
		driver.manage().window().maximize();
		wLib.waitForElementInDOM(driver);
		driver.get(URL);
		usernameTextfield.sendKeys(username);
		passwordTextfield1.sendKeys(password);
		loginButton.click();
		wLib.swithToAlertWindowAndAccpect(driver);
	}
	
	public void LogoutToApplication(){
		profile_button.click();
		Logout_button.click();
		popup_logout.click();
	}

}

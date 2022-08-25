package com.TechMax.Pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration	
	@FindBy(xpath="//span[.='Home']")
	private WebElement navigateToHome;
	@FindBy(xpath="//span[text()='Customer']")
	private WebElement NavigateToCustomer;
	@FindBy(xpath="//span[text()='Employee']")
	private WebElement NavigateToEmployee;
	@FindBy(xpath="//span[text()='Product']")
	private WebElement NavigateToProduct;
	@FindBy(xpath="//span[text()='Inventory']")
	private WebElement NavigateToInventory;
	@FindBy(xpath="//span[text()='Transaction']")
	private WebElement NavigateToTransaction;
	@FindBy(xpath="//span[text()='Supplier']")
	private WebElement NavigateToSupplier;
	@FindBy(xpath="//span[text()='Accounts']")
	private WebElement NavigateToAccounts;
	@FindBy(xpath="//div[.='Customers']/ancestor::div[@class='row no-gutters align-items-center']/descendant::div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement CustomerCount;
	@FindBy(xpath="//div[.='Employees']/ancestor::div[@class='row no-gutters align-items-center']/descendant::div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement EmployeeCount;
	@FindBy(xpath="//div[.='Product']/ancestor::div[@class='row no-gutters align-items-center']/descendant::div[@class='h6 mb-0 mr-3 font-weight-bold text-gray-800']")
	private WebElement ProductCount;
	@FindBy(xpath="//div[.='Supplier']/ancestor::div[@class='row no-gutters align-items-center']/descendant::div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement SupplierCount;
	@FindBy(xpath="//div[.='Registered Account']/ancestor::div[@class='row no-gutters align-items-center']/descendant::div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement RegisteredAccountsCount;
	@FindBy(xpath="//span[text()='POS']")
	private WebElement NavigateToPOS;
	@FindBy(xpath="//div[.='Sales and Inventory System']")
	private WebElement NavigateToSalesAndInventoryIcon;
	@FindBy(xpath="//a[.='View All Products']")
	private WebElement ViewAllProduct;
	@FindBy(id="userDropdown")
	private WebElement ProfileLink;
	@FindBy(xpath="//a[@class='dropdown-item']/child::i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")
	private WebElement Logout;
	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement ConfirmLogout;

	
	//Initialization
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//Utilization
	public WebElement getProfileLink() {
		return ProfileLink;
	}

	public void setProfileLink(WebElement profileLink) {
		ProfileLink = profileLink;
	}

	public WebElement getLogout() {
		return Logout;
	}

	public void setLogout(WebElement logout) {
		Logout = logout;
	}

	public WebElement getConfirmLogout() {
		return ConfirmLogout;
	}

	public void setConfirmLogout(WebElement confirmLogout) {
		ConfirmLogout = confirmLogout;
	}

	public WebElement getNavigateToCustomer() {
		return NavigateToCustomer;
	}

	public WebElement getNavigateToEmployee() {
		return NavigateToEmployee;
	}

	public WebElement getNavigateToProduct() {
		return NavigateToProduct;
	}

	public WebElement getNavigateToInventory() {
		return NavigateToInventory;
	}

	public WebElement getNavigateToTransaction() {
		return NavigateToTransaction;
	}

	public WebElement getNavigateToSupplier() {
		return NavigateToSupplier;
	}

	public WebElement getNavigateToAccounts() {
		return NavigateToAccounts;
	}

	public WebElement getCustomerCount() {
		return CustomerCount;
	}

	public WebElement getEmployeeCount() {
		return EmployeeCount;
	}

	public WebElement getProductCount() {
		return ProductCount;
	}

	public WebElement getSupplierCount() {
		return SupplierCount;
	}

	public WebElement getRegisteredAccountsCount() {
		return RegisteredAccountsCount;
	}

	public WebElement getNavigateToPOS() {
		return NavigateToPOS;
	}

	public WebElement getNavigateToSalesAndInventoryIcon() {
		return NavigateToSalesAndInventoryIcon;
	}

	public WebElement getViewAllProduct() {
		return ViewAllProduct;
	}

	public WebElement getNavigateToHome() {
		return navigateToHome;
	}

}

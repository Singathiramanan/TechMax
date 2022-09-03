package com.sales.techmax.objectRepositoryUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//declaration Rule
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement createProductAddIcon;
	@FindBy(name="prodcode")
	private WebElement ProductCodeTextfield;
	@FindBy(name="name")
	private WebElement FirstNameTextfield;
	@FindBy(css="[placeholder='Description']")
	private WebElement DescriptionTextfield;
	@FindBy(name="quantity")
	private WebElement QuantityTextfield;
	@FindBy(name="onhand")
	private WebElement OnHandTextfield;
	@FindBy(name="price")
	private WebElement PriceTextfield;
	@FindBy(name="category")
	private WebElement CategoryTextfield;
	@FindBy(name="supplier")
	private WebElement SupplierTextfield;
	@FindBy(name="datestock")
	private WebElement DateStockCalendar;
	@FindBy(xpath=
				"//div[@class='modal-header']/child::h5[@id='exampleModalLabel' and text()='Add Product']/ancestor::div[@class='modal-content']/descendant::button[@type='submit']")
	private WebElement SaveButton;
	
	//utilization
	public WebElement getDateStockCalendar() {
		return DateStockCalendar;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCreateProductAddIcon() {
		return createProductAddIcon;
	}
	public WebElement getProductCodeTextfield() {
		return ProductCodeTextfield;
	}
	public WebElement getFirstNameTextfield() {
		return FirstNameTextfield;
	}
	public WebElement getDescriptionTextfield() {
		return DescriptionTextfield;
	}
	public WebElement getQuantityTextfield() {
		return QuantityTextfield;
	}
	public WebElement getOnHandTextfield() {
		return OnHandTextfield;
	}
	public WebElement getPriceTextfield() {
		return PriceTextfield;
	}
	public WebElement getCategoryTextfield() {
		return CategoryTextfield;
	}
	public WebElement getSupplierTextfield() {
		return SupplierTextfield;
	}
	
	//initializing
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	

	//Business library and utilization
	public void CreateProduct(String ProductCode,String Name, String Description, String Quantity, String OnHand, String Price, String SelectCategory, String SelectSupplier) throws AWTException {
		ProductCodeTextfield.sendKeys(ProductCode);
		FirstNameTextfield.sendKeys(Name);
		DescriptionTextfield.sendKeys(Description);
		QuantityTextfield.sendKeys(Quantity);
		OnHandTextfield.sendKeys(OnHand);
		PriceTextfield.sendKeys(Price);
		CategoryTextfield.sendKeys(SelectCategory);
		SupplierTextfield.sendKeys(SelectSupplier);
		DateStockCalendar.click();
		Robot robot = new Robot();
		DateStockCalendar.sendKeys(Keys.NUMPAD2);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DateStockCalendar.sendKeys(Keys.NUMPAD1);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DateStockCalendar.sendKeys(Keys.NUMPAD2);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		SaveButton.click();
		
		
		
		
		
		 
		
		
		
	}
	

}

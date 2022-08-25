package com.TechMax.Pomrepositorylib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TechMax.utility.WebDriverUtility;

public class ProductPage extends WebDriverUtility {

	@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
	private WebElement createProductAddIcon;
	@FindBy(name = "prodcode")
	private WebElement ProductCodeTextfield;
	@FindBy(name = "name")
	private WebElement FirstNameTextfield;
	@FindBy(css = "[placeholder='Description']")
	private WebElement DescriptionTextfield;
	@FindBy(name = "quantity")
	private WebElement QuantityTextfield;
	@FindBy(name = "onhand")
	private WebElement OnHandTextfield;
	@FindBy(name = "price")
	private WebElement PriceTextfield;
	@FindBy(name = "category")
	private WebElement CategoryTextfield;
	@FindBy(name = "supplier")
	private WebElement SupplierTextfield;
	@FindBy(name = "datestock")
	private WebElement DateStockCalendar;
	@FindBy(xpath = "//div[@class='modal-header']/child::h5[@id='exampleModalLabel' and text()='Add Product']/ancestor::div[@class='modal-content']/descendant::button[@type='submit']")
	private WebElement SaveButton;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTextfield;
	@FindBy(xpath = "//a[contains(.,'...')]")
	private WebElement elipseIcon;
	@FindBy(xpath = "//i[@class='fas fa-fw fa-edit']")
	private WebElement editButton;
	@FindBy(name = "prodname")
	private WebElement updateProductName;
	@FindBy(xpath = "//div[@id='content']/descendant::textarea[@name='description']")
	private WebElement updateDescription;
	@FindBy(xpath = "//div[@id='content']/descendant::input[@name='price']")
	private WebElement updatePrice;
	@FindBy(xpath = "//div[@id='content']/descendant::select[@name='category']")
	private WebElement updateCategory;
	@FindBy(xpath = "//button[.='Update']")
	private WebElement updateButton;

	public WebElement getDateStockCalendar() {
		return DateStockCalendar;
	}

	public WebElement getSaveButton() {
		return SaveButton;
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

	public WebElement getSearchTextfield() {
		return searchTextfield;
	}

	public WebElement getElipseIcon() {
		return elipseIcon;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getUpdateProductName() {
		return updateProductName;
	}

	public WebElement getUpdateDescription() {
		return updateDescription;
	}

	public WebElement getUpdatePrice() {
		return updatePrice;
	}

	public WebElement getUpdateCategory() {
		return updateCategory;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	// Initialization
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// utilization business library
	public void CreateProduct(String ProductCode, String Name, String Description, String Quantity, String OnHand,
			String Price, String SelectCategory, String SelectSupplier) throws AWTException {
		ProductCodeTextfield.sendKeys(ProductCode);
		FirstNameTextfield.sendKeys(Name);
		DescriptionTextfield.sendKeys(Description);
		QuantityTextfield.sendKeys(Quantity);
		OnHandTextfield.sendKeys(OnHand);
		PriceTextfield.sendKeys(Price);
		CategoryTextfield.sendKeys(SelectCategory);
		SupplierTextfield.sendKeys(SelectSupplier);
		DateStockCalendar.click();
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_0);
		r1.keyRelease(KeyEvent.VK_0);
		r1.keyPress(KeyEvent.VK_9);
		r1.keyRelease(KeyEvent.VK_9);
		r1.keyPress(KeyEvent.VK_0);
		r1.keyRelease(KeyEvent.VK_0);
		r1.keyPress(KeyEvent.VK_8);
		r1.keyRelease(KeyEvent.VK_8);
		r1.keyPress(KeyEvent.VK_2);
		r1.keyRelease(KeyEvent.VK_2);
		r1.keyPress(KeyEvent.VK_0);
		r1.keyRelease(KeyEvent.VK_0);
		r1.keyPress(KeyEvent.VK_2);
		r1.keyRelease(KeyEvent.VK_2);
		r1.keyPress(KeyEvent.VK_2);
		r1.keyRelease(KeyEvent.VK_2);
		SaveButton.click();
	}
	
	public void EditProduct(String newProductName, String newDescription, String newPrice, String newCategory) {
		WebDriverUtility wLib=new WebDriverUtility();
		updateProductName.clear();
		updateProductName.sendKeys(newProductName);
		updateDescription.clear();
		updateDescription.sendKeys(newDescription);
		updatePrice.clear();
		updatePrice.sendKeys(newPrice);
		wLib.select(updateCategory, newCategory);
		updateButton.click();
		swithToAlertWindowAndAccpect(driver);
	}
}

package com.sales.techmax.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sales.techmax.genericUtility.WebDriverUtility;

public class POSPage extends WebDriverUtility{
	//Initialization
	WebDriver driver;
	String Name;
	public POSPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//Declaration
			@FindBy(xpath="//span[.='POS']")
			private WebElement pos_button;
			
			@FindBy(xpath="//select[@name='customer']")
			private WebElement cust_dropdown;
			
			@FindBy(xpath="//button[.='SUBMIT']")
			private WebElement submit_button;
			
			@FindBy(xpath="//input[@name='cash']")
			private WebElement amount_tf;
			
			@FindBy(xpath="//button[.='PROCEED TO PAYMENT']")
			private WebElement proceedToPayment_btn;
			
			@FindBy(name="total")
			private WebElement total_text;
			@FindBy(xpath = "//i[@class='fas fa-fw fa-plus']")
			private WebElement customerAddIcon;
			@FindBy(xpath="//div[@id='poscustomerModal']/descendant::input[@name='firstname']")
			private WebElement customerFirstName;
			@FindBy(xpath="//div[@id='poscustomerModal']/descendant::input[@name='lastname']")
			private WebElement customerLastName;
			@FindBy(xpath="//div[@id='poscustomerModal']/descendant::input[@name='phonenumber']")
			private WebElement customerPhoneNumber;
			@FindBy(xpath="//div[@id='poscustomerModal']/descendant::button[@type='submit']")
			private WebElement customerSubmit;
				
			
			public WebElement getCustomerFirstName() {
				return customerFirstName;
			}
			public WebElement getCustomerLastName() {
				return customerLastName;
			}
			public WebElement getCustomerPhoneNumber() {
				return customerPhoneNumber;
			}
			public WebElement getCustomerSubmit() {
				return customerSubmit;
			}

			@FindBy(xpath="//div[text()='Sales and Inventory System']")
			private WebElement salesinventory;
			
						
			public WebElement getSalesinventory() {
				return salesinventory;
			}
			//Utilization
			public WebElement getPos_button() {
				return pos_button;
			}
			public WebElement getCust_dropdown() {
				return cust_dropdown;
			}

			public WebElement getSubmit_button() {
				return submit_button;
			}
			public WebElement getAmount_tf() {
				return amount_tf;
			}
			public WebElement getProceedToPayment_btn() {
				return proceedToPayment_btn;
			}
			public WebElement getTotal_text() {
				return total_text;
			}
			public WebElement getCustomerAddIcon() {
				return customerAddIcon;
			}			
			public void selectCatgory(String category) {
				//waitForElement(driver, driver.findElement(By.xpath("//a[.='"+category+"']")));
				 driver.findElement(By.xpath("//a[.='"+category+"']")).click();
				
			}
			public void name(String name) {
				driver.findElement(By.xpath("//h6[@class='text-info' and text()='"+name+"']/parent::div[@class='products']/child::input[@value='Add']")).click();
				}
			
			public void addCustomer(String customerFN,String customerLN,String CustomerPN){
				customerAddIcon.click();
				customerFirstName.sendKeys(customerFN);
				customerLastName.sendKeys(customerLN);
				customerPhoneNumber.sendKeys(CustomerPN);
				customerSubmit.click();

}
}








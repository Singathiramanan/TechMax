package com.TechMAX.pos;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sales.techmax.genericUtility.ExcelUtility;
import com.sales.techmax.genericUtility.FileUtility;
import com.sales.techmax.genericUtility.JavaUtility;
import com.sales.techmax.genericUtility.WebDriverUtility;
import com.sales.techmax.objectRepositoryUtility.CustomerPage;
import com.sales.techmax.objectRepositoryUtility.HomePage;
import com.sales.techmax.objectRepositoryUtility.LoginPage;
import com.sales.techmax.objectRepositoryUtility.POSPage;
import com.sales.techmax.objectRepositoryUtility.ProductPage;
import com.sales.techmax.objectRepositoryUtility.TransactionPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Purchase_a_product_and_add_new_customer_and_verify_transaction_details {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		 //Create Object for Utility
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();


		//Read the data from property file
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		String BROWSER=fLib.getPropertyKeyValue("Browser");


		//Read the data from Excelfile
		
		String ProductCode = jLib.getRanDomNumber(1000000);
		String Name = eLib.getExcelData("Sheet1", 1, 3);
		String Description = eLib.getExcelData("Sheet1", 1, 4);
		String Quantity = eLib.getExcelData("Sheet1", 1, 5);
		String OnHand = eLib.getExcelData("Sheet1", 1, 6);
		String Price = eLib.getExcelData("Sheet1", 1, 7);
		String SelectCategory = eLib.getExcelData("Sheet1", 1, 8);
		String SelectSupplier = eLib.getExcelData("Sheet1", 1, 9);
		String DateStockin = eLib.getExcelData("Sheet1", 1, 9);
		String quantity =eLib.getExcelData("Sheet1", 1, 10);
		String FirstName = eLib.getExcelData("Sheet1", 1, 12);
		String LastName = eLib.getExcelData("Sheet1", 1, 13);
		DataFormatter formatter=new DataFormatter();
		String PhoneNumber = eLib.getExcelData("Sheet1", 1, 14);
		System.out.println(ProductCode);
		System.out.println(Name);
		System.out.println(Description);
		System.out.println(Quantity);
		System.out.println(OnHand);
		System.out.println(Price);
		System.out.println(SelectCategory);
		System.out.println(SelectSupplier);
		System.out.println(DateStockin);
		System.out.println(quantity);
		System.out.println(FirstName);
		System.out.println(LastName);
		System.out.println(PhoneNumber);

		//Launch the URL
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("INCORRECT BROWSER");

		}
		driver.manage().window().maximize();
		wLib.waitForElementInDOM(driver);
		driver.get(URL);
		
		
		LoginPage login=new LoginPage(driver);
		ProductPage createProductObj=new ProductPage(driver);
        HomePage hp = new 	HomePage(driver);
        POSPage pp = new POSPage(driver);
		CustomerPage cpc=new CustomerPage(driver);
		TransactionPage tp=new TransactionPage(driver);


		//login to the application
	
		login.loginToApplication(USERNAME, PASSWORD);
		

		//navigate to product tab
		hp.getNavigateToProduct().click();
		
		createProductObj.getCreateProductAddIcon().click();
		createProductObj.CreateProduct(ProductCode, Name, Description, Quantity,OnHand, Price, SelectCategory, SelectSupplier);
			 
		 //click on POS link
		hp.getNavigateToPOS().click();
          
          
		 //click on Others
          pp.selectCatgory(SelectCategory);
          pp.name(Name);
	 
		// Thread.sleep(5000);
		 //click on Add button
		 //WebElement POSAddElement = driver.findElement(By.xpath("//h6[@class='text-info' and text()='"+Name+"']/parent::div[@class='products']/child::input[@value='Add']"));
		 //POSAddElement.click();
		 //Thread.sleep(5000);
		 //Select customer 
      pp.addCustomer(FirstName, LastName, PhoneNumber);
		 
		 
//		driver.findElement(By.xpath("//a[@class='btn btn-primary bg-gradient-primary']")).click();
//		
	//driver.findElement(By.xpath("//div[@id='poscustomerModal']/descendant::h5[.='Add Customer']/parent::div/following-sibling::div[@class='modal-body']/descendant::input[@name='firstname']")).sendKeys(FirstName);
	//driver.findElement(By.xpath("//div[@id='poscustomerModal']/descendant::h5[.='Add Customer']/parent::div/following-sibling::div[@class='modal-body']/descendant::input[@name='lastname']")).sendKeys(LastName);
	//driver.findElement(By.xpath("//div[@id='poscustomerModal']/descendant::h5[.='Add Customer']/parent::div/following-sibling::div[@class='modal-body']/descendant::input[@name='phonenumber']")).sendKeys(PhoneNumber);		
	//9.click on save button
	//driver.findElement(By.xpath("//div[@id='poscustomerModal']/descendant::h5[.='Add Customer']/parent::div/following-sibling::div[@class='modal-body']/descendant::button[@class='btn btn-success']")).click();
		 
	 //Select customer 
	WebElement selectCustomerDrop = pp.getCust_dropdown();
	String custName=FirstName+" "+LastName;
	System.out.println(custName);
	 wLib.select(selectCustomerDrop,custName);
	 
	 //fetch total amount
	 WebElement totalAmountele = cpc.getTotalamounttextfield();
	 String totalAmount = totalAmountele.getAttribute("value");

	 System.out.println(totalAmount);
	 //click on submit
	 pp.getSubmit_button().click();
	 //enter cash
	 //driver.findElement(By.id("txtNumber")).sendKeys(totalAmount);
	 pp.getAmount_tf().sendKeys(totalAmount);
	 //click on proceed to payment
	 pp.getProceedToPayment_btn().click();
	// driver.findElement(By.xpath("//button[text()='PROCEED TO PAYMENT']")).click();
	 wLib.swithToAlertWindowAndAccpect(driver, "Success.");
	 
	 //navigate to home page
	 hp.getNavigateToSalesAndInventoryIcon().click();
	 
	 //Navigate to transaction page
	 hp.getNavigateToTransaction().click();
	 tp.getTrans_number_btn().click();
	 tp.getView_btn().click();
	 
	// logout admin
			hp.LogoutOFApplication();
			
	
			
	}
	
	

	}

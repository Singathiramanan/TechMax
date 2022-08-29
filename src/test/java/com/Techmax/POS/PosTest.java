package com.Techmax.POS;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TechMax.Pomrepositorylib.AccountsPage;
import com.TechMax.Pomrepositorylib.EmployeePage;
import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.Pomrepositorylib.CustomerPage;
import com.TechMax.Pomrepositorylib.PosPage;
import com.TechMax.Pomrepositorylib.ProductPage;
import com.TechMax.Pomrepositorylib.SupplierPage;
import com.TechMax.Pomrepositorylib.SingletonDesignPattern;
import com.TechMax.utility.BaseClass;

@Listeners(com.TechMax.utility.ItestLisImpClass.class)

public class PosTest extends BaseClass {
	
	@Test(groups="SmokeTest",enabled=true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class)
	public void Purchase_a_product_and_Add_Updated_customer_and_verify_transaction_details_test() throws Throwable{
		String ran = jLib.getRanDomNumber(1000);
		// Fetching data from excel
		String product_code = eLib.getExcelData("Sheet1", 1, 2);
		String product_name = eLib.getExcelData("Sheet1", 1, 3);
		String supplier = eLib.getExcelData("Sheet1", 1, 4);
		String descrpition = eLib.getExcelData("Sheet1", 1, 5);
		String quantity = eLib.getExcelData("Sheet1", 1, 6);
		String on_hand = eLib.getExcelData("Sheet1", 1, 7);
		String price = eLib.getExcelData("Sheet1", 1, 8);
		String catagory = eLib.getExcelData("Sheet1", 1, 9);
		String customer_fn = eLib.getExcelData("Sheet1", 1, 11);
		String customer_ln = eLib.getExcelData("Sheet1", 1, 12);
		String customrt_pn = eLib.getExcelData("Sheet1", 1, 13);
		String updated_price = eLib.getExcelData("Sheet1", 1, 14);
		String product_qty = eLib.getExcelData("Sheet1", 1, 15);
		
		// Create object for POM Class
		SingletonDesignPattern s=new SingletonDesignPattern(driver);		

			// CREATE A NEW PRODUCT
			s.getHomePage().getNavigateToProduct().click();
			s.getProductPage().getCreateProductAddIcon().click();
			String pcode = product_code + "_" + ran;
			s.getProductPage().CreateProduct(pcode, product_name, descrpition, quantity, on_hand, price, catagory, supplier);
			
			// click on search product and edit 
			s.getProductPage().getSearchTextfield().sendKeys(pcode);
			s.getProductPage().getElipseIcon().click();
			s.getProductPage().getEditButton().click();
			s.getProductPage().EditProduct(product_name, descrpition, updated_price, catagory);
			
			// click on pos and add product
			s.getHomePage().getNavigateToPOS().click();
			s.getPosPage().selectategory(catagory);
			s.getPosPage().sendQuantity(product_name, product_qty);
			s.getPosPage().clickAddButton(product_name);
			
			// add a customer82022
			s.getPosPage().addCustomer(customer_fn, customer_ln, customrt_pn);

			// select customer and proceed to payment
			WebElement dd1 =s.getPosPage().getCust_dropdown();
			wLib.select(dd1, customer_fn + " " + customer_ln);
			s.getPosPage().getSubmit_button().click();
			WebElement ele = s.getPosPage().getTotal_text();
			String amount = ele.getAttribute("value");
			System.out.println("Total amount=" + amount);
			s.getPosPage().getAmount_tf().sendKeys(amount);
			s.getPosPage().getProceedToPayment_btn().click();
			wLib.swithToAlertWindowAndAccpect(driver);

			// check on transaction
			s.getHomePage().getNavigateToSalesAndInventoryIcon().click();
			s.getHomePage().getNavigateToTransaction().click();
			s.getTransactionPage().getTrans_number_btn().click();
			s.getTransactionPage().getSearch_TF().sendKeys(customer_fn + " " + customer_ln);
			s.getTransactionPage().getDetails_btn().click();
			String cash =s.getTransactionPage().totalAmount(amount);
			Assert.assertTrue(amount.contains(cash));

		}
	
	@Test(groups="RegressionTest", retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class,enabled = true)
	public void sale_a_product_check_the_transaction_details_test() throws Throwable{
		 //Fetching data from property file
				String url = fLib.getPropertyKeyValue("url");
				String admin_UN = fLib.getPropertyKeyValue("admin_username");
				String admin_PW = fLib.getPropertyKeyValue("admin_password");
				String user_UN = fLib.getPropertyKeyValue("user_username");
				String user_PW = fLib.getPropertyKeyValue("user_password");

			// Fetching data from excel
				String qty = eLib.getExcelData("Sheet1", 4, 2);
				String cust = eLib.getExcelData("Sheet1", 4, 3);
				String category=eLib.getExcelData("Sheet1", 4, 4);
				String productName=eLib.getExcelData("Sheet1", 4, 5);
			
				// logout admin
				SingletonDesignPattern s=new SingletonDesignPattern(driver);		
				s.getLoginPage().LogoutToApplication();
				
				// Login to application
				s.getLoginPage().loginToApplication(url, user_UN, user_PW);
				
				// navigate POS and select category
				s.getPosPage().getPos_button().click();
				s.getPosPage().selectategory(category);
				s.getPosPage().sendQuantity(productName, qty);
				s.getPosPage().clickAddButton(productName);
				
				// select a customer and click on submit
				WebElement dd1 = s.getPosPage().getCust_dropdown();
				wLib.select(dd1, cust);
				s.getPosPage().getSubmit_button().click();
				WebElement ele =s.getPosPage().getTotal_text();
				String amount = ele.getAttribute("value");
				System.out.println("Total Amount= "+amount);
				s.getPosPage().getAmount_tf().sendKeys(amount);
				s.getPosPage().getProceedToPayment_btn().click();
				wLib.swithToAlertWindowAndAccpect(driver);

				// logout user
				s.getLoginPage().LogoutToApplication();
				
				// Login to application
				s.getLoginPage().loginToApplication(url, admin_UN, admin_PW);
				
				//navigate to transaction
				s.getHomePage().getNavigateToTransaction().click();
				s.getTransactionPage().getSearch_TF().sendKeys(cust);
				s.getTransactionPage().getTrans_number_btn().click();
				s.getTransactionPage().getDetails_btn().click();
				String cash =s.getTransactionPage().totalAmount(amount);
				System.out.println("Total Amount in receipt="+cash);
				Assert.assertTrue(amount.contains(cash));

	}
	@Test(groups = "SmokeTest",enabled = true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class)
	public void Add_a_new_product_and_purchase_the_same_product_Test() throws Throwable {

		//1.Read the test Data from Excel
		String productcode = jLib.getRanDomNumber(1000000);
		String productName=eLib.getExcelData("POS1", 3, 1);
		String description =eLib.getExcelData("POS1", 3, 2);
		String quantity  = eLib.getExcelData("POS1", 3, 3);
		String onHand = eLib.getExcelData("POS1", 3, 4);
		String price= eLib.getExcelData("POS1", 3, 5);
		String selectCategory = eLib.getExcelData("POS1", 3, 6);
		String selectSupplier = eLib.getExcelData("POS1", 3, 7);
		String productcount = eLib.getExcelData("POS1", 3, 8);
		String selectCustomer = eLib.getExcelData("POS1", 3, 9);
	//	String DateStock = eLib.getExcelData("POS1", 3, 10);

		//2.Create object for POM class
		HomePage home=new HomePage(driver);
		ProductPage product=new ProductPage(driver);
		PosPage pos=new PosPage(driver);

		//3.click on product major tab
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-table']")).click();

		//4.click on add icon in product page
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();

		//5.Enter all the details	
		product.CreateProduct(productcode, productName, description, quantity, onHand, price, selectCategory, selectSupplier);

		//6.click on POS link
		home.getNavigateToPOS().click();

		//7.click on product category layout
		pos.selectProductCategory(selectCategory);

		//8.add the product count and Click on Add Button
		pos.addTheproductCount(productName, productcount);

		//9.Select customer 
		pos.getSelectCustomerDropdown().sendKeys(selectCustomer);

		//10.fetch total amount
		String totalAmount = pos.getFetchTotalAmount().getAttribute("value");

		//11.click on submit
		pos.getSubmitButton().click();

		//12.enter cash
		pos.getEnterAmountTextField().sendKeys(totalAmount);

		//13.click on proceed to payment
		pos.getProceedToPaymentButton().click();
		wLib.swithToAlertWindowAndAccpectValidate(driver, "Success");
//		SoftAssert SA= new SoftAssert();
//		SA.assertAll();
	}

	@Test(groups = "RegressionTest", enabled = true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class)
	public void AddSupplierAddProductGenrateBillInPOSforProductTest() throws Throwable {	
		String companyName = eLib.getExcelData("Transaction", 3, 0);
		String selectProvince = eLib.getExcelData("Transaction", 3, 1);
		String selectCity = eLib.getExcelData("Transaction", 3, 2);
		String suppContNumber = eLib.getExcelData("Transaction", 3, 3);

		//Product Test Data
		String productcode=jLib.getRanDomNumber(1000000);
		String productName=eLib.getExcelData("Transaction", 3, 5);
		String description = eLib.getExcelData("Transaction", 3, 6);
		String quantity  = eLib.getExcelData("Transaction", 3, 7);
		String onHand = eLib.getExcelData("Transaction", 3, 8);
		String price= eLib.getExcelData("Transaction", 3, 9);
		String selectCategory =eLib.getExcelData("Transaction", 3, 10);
		String selectSupplier =eLib.getExcelData("Transaction", 3, 11);
		//String DateStock = eLib.getExcelData("Transaction", 3, 12);

		//Product Update test Data
		String productPriceUpdate = eLib.getExcelData("Transaction", 3, 13);

		//Quantity test data
		String customerProdQuantity = eLib.getExcelData("Transaction", 3, 14);

		//Customer Details Test Data
		String firstname = eLib.getExcelData("Transaction", 3, 15);
		String lastName = eLib.getExcelData("Transaction", 3, 16);
		String custPhoneNumber = eLib.getExcelData("Transaction", 3, 17);

		//Create object for POM class
		HomePage home=new HomePage(driver);
		SupplierPage supplier=new SupplierPage(driver);
		ProductPage product=new ProductPage(driver);
		PosPage pos=new PosPage(driver);

		//6.Click on Supplier major tab
		home.getNavigateToSupplier().click();

		//7.Click on Add icon in supplier page
		supplier.getCreateSupplierAddIcon().click();

		//8.Enter the details and click on save button
		supplier.CreateSupplier(companyName, selectProvince, selectCity, suppContNumber);

		//6.click on product major tab
		home.getNavigateToProduct().click();

		//7.click on add icon in product page
		product.getCreateProductAddIcon().click();

		//8.Enter all the details	
		product.CreateProduct(productcode, productName, description, quantity, onHand, price, selectCategory, selectSupplier );

		//10.search for product
		product.getSearchTextfield().sendKeys(productName);

		//11.click on ellipsis icon
		product.getProductEllipsis().click();

		//12. click on edit button
		product.getEditButton().click();

		//13.update the product details
		product.EditProduct(productName, description, productPriceUpdate, selectCategory);

		//15.click on POS link
		home.getNavigateToPOS().click();

		//16.click on product category layout
		pos.selectProductCategory(selectCategory);

		//17.add the product count and Click on Add Button
		pos.addTheproductCount(productName, customerProdQuantity);

		//click on Add customer icon
		pos.getAddCustomerIcon().click();

		//Add New customer and click on save button
		pos.addCustomer(firstname, lastName, custPhoneNumber);

		//Select customer 
		pos.getSelectCustomerDropdown().sendKeys(firstname);

		//fetch total amount
		String totalAmount = pos.getFetchTotalAmount().getAttribute("value");

		//click on submit
		pos.getSubmitButton().click();

		//enter cash
		pos.getEnterAmountTextField().sendKeys(totalAmount);

		//click on proceed to payment
		pos.getProceedToPaymentButton().click();
		wLib.swithToAlertWindowAndAccpectValidate(driver, "Success");
//		SoftAssert SA= new SoftAssert();
//		SA.assertAll();
	//	Assert.fail();
	}
	

	@Test(groups = "SmokeTest", enabled=true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class) 
	public void Verify_data_flow_from_Customer_to_pos_Test() throws Throwable {

		//2.Read the test Data
		//2.Read the test Data
		String FirstName = eLib.getExcelData("POS2", 3, 0);
		String LastName = eLib.getExcelData("POS2", 3, 1);
		String PhoneNumber = eLib.getExcelData("POS2", 3, 2);
		String productcount = eLib.getExcelData("POS2", 3, 3);
		String SelectCategory = eLib.getExcelData("POS2", 3, 4);
		String productName = eLib.getExcelData("POS2", 3, 5);
		String CustomerName=FirstName+" "+LastName;

		HomePage home=new HomePage(driver);
		LoginPage login=new LoginPage(driver);
		SupplierPage supplier=new SupplierPage(driver);
		ProductPage product=new ProductPage(driver);
		PosPage pos=new PosPage(driver);
		CustomerPage customer=new CustomerPage(driver);
		//6. click on customer major tab
		home.getNavigateToCustomer().click();

		//7. click on add icon in customer page
		customer.getcreateCustomerAddIcon().click();

		//8.Enter the details
		customer.createcustomer(FirstName, LastName, PhoneNumber);

		//10.click on POS link
		home.getNavigateToPOS().click();

		//11.click on product category
		pos.selectProductCategory(SelectCategory);

		//12.add the product count and click on Add button
		pos.addTheproductCount(productName, productcount);

		// 13. get the elements from select customer dropdown
		WebElement selectCustomerDrop = pos.getSelectCustomerDropdown();
		List<WebElement> allCustomerWE = wLib.getOptions(selectCustomerDrop);
		List<String> allCustomerList = new ArrayList<String>(); //Empty Container
		for (WebElement eachCustomerWE : allCustomerWE) {
			String eachCustomerName = eachCustomerWE.getText();
			allCustomerList.add(eachCustomerName);
		}

		//16. validate customer in select customer dropdown
		Assert.assertTrue(allCustomerList.contains(CustomerName));
//		Assert.fail();
		}



}

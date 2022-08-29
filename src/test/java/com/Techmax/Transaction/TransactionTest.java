package com.Techmax.Transaction;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.TechMax.Pomrepositorylib.SingletonDesignPattern;
import com.TechMax.utility.BaseClass;

@Listeners(com.TechMax.utility.ItestLisImpClass.class)

public class TransactionTest extends BaseClass{

	@Test(groups="SmokeTest", enabled = true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class)
	public void AddProductLoginAsEmployeeGenrateBillInPOSforProduct_test() throws Throwable {

		String ran = jLib.getRanDomNumber(1000);
		/*common Data*/
		String url = fLib.getPropertyKeyValue("url");
		String admin_UN = fLib.getPropertyKeyValue("admin_username");
		String admin_PW = fLib.getPropertyKeyValue("admin_password");
		String user_UN = fLib.getPropertyKeyValue("user_username");
		String user_PW = fLib.getPropertyKeyValue("user_password");
		// Fetching data from excel
		String p_code = eLib.getExcelData("Sheet1", 14, 2);
		String p_name = eLib.getExcelData("Sheet1", 14, 3);
		String supplier = eLib.getExcelData("Sheet1", 14, 4);
		String descrpition = eLib.getExcelData("Sheet1", 14, 5);
		String quantity = eLib.getExcelData("Sheet1", 14, 6);
		String on_hand = eLib.getExcelData("Sheet1", 14, 7);
		String price = eLib.getExcelData("Sheet1", 14, 8);
		String catagory = eLib.getExcelData("Sheet1", 14, 9);
		String p_qty = eLib.getExcelData("Sheet1", 14, 13);
		String upQuantity = eLib.getExcelData("Sheet1", 14, 11);
		String upOn_hand = eLib.getExcelData("Sheet1", 14, 12);
		String custName = eLib.getExcelData("Sheet1", 14, 14);
		
		SingletonDesignPattern s=new SingletonDesignPattern(driver);		
			
			//navigating to product page
			s.getHomePage().getNavigateToProduct().click();
			//click on add product icon
			s.getProductPage().getCreateProductAddIcon().click();
			// CREATE A NEW PRODUCT
			String productCode = p_code + ran;
			String productName = p_name + ran;
			s.getProductPage().CreateProduct(productCode, productName, descrpition, quantity, on_hand, price, catagory, supplier);
			// navigate to inventory
			s.getHomePage().getNavigateToInventory().click();
			// search using product name
			s.getInventoryPage().getSearch_TF().sendKeys(productName);
			// view button
			s.getInventoryPage().getViewButton().click();

			// click on edit button
			s.getInventoryPage().getEditInventory().click();

			// update details qty and on hand stock
			s.getInventoryPage().getUpdateQty().clear();
			s.getInventoryPage().getUpdateQty().sendKeys(upQuantity);
			s.getInventoryPage().getUpdateOnHand().clear();
			s.getInventoryPage().getUpdateOnHand().sendKeys(upOn_hand);

			// clcik on update button
			s.getInventoryPage().getUpdateButton().click();

			// click on OK in Alert pop up
			wLib.swithToAlertWindowAndAccpect(driver);

			// logout as admin
			s.getLoginPage().LogoutToApplication();

			// login as user
			s.getLoginPage().loginToApplication(url, user_UN, user_PW);

			// clcik on pos
			s.getHomePage().getNavigateToPOS().click();

			// click on product category layout
			s.getPosPage().selectategory(catagory);

			// 17.add the product count and Click on Add Button
			s.getPosPage().sendQuantity(productName, p_qty);
			s.getPosPage().clickAddButton(productName);

			// Select customer
			s.getPosPage().getCust_dropdown().sendKeys(custName);

			// fetch total amount
			String total = s.getPosPage().getTotal_text().getAttribute("value");

			// click on submit
			s.getPosPage().getSubmit_button().click();

			// enter cash
			s.getPosPage().getAmount_tf().sendKeys(total);

			// click on proceed to payment
			s.getPosPage().getProceedToPayment_btn().click();
			wLib.swithToAlertWindowAndAccpect(driver);

			// Logout as user
			s.getLoginPage().LogoutToApplication();

			// Login as admin
			s.getLoginPage().loginToApplication(url, admin_UN, admin_PW);

			// click on transaction page
			s.getHomePage().getNavigateToTransaction().click();

			// search customer in search textfiled
			s.getTransactionPage().getSearch_TF().sendKeys(custName);

			// click on view button
			s.getTransactionPage().getDetails_btn().click();

		}
	
	@Test(groups="RegressionTest", enabled = true, retryAnalyzer = com.TechMax.utility.RetryAnalyzerImp.class)
	public void AddSupplierAddProductLoginAsEmployeeGenrateBillInPOSforProducttest() throws Throwable{
		String ran = jLib.getRanDomNumber(1000);

		// Fetching data from property files
		String url = fLib.getPropertyKeyValue("url");
		String admin_UN = fLib.getPropertyKeyValue("admin_username");
		String admin_PW = fLib.getPropertyKeyValue("admin_password");
		String user_UN = fLib.getPropertyKeyValue("user_username");
		String user_PW = fLib.getPropertyKeyValue("user_password");
		
		// Fetching data from excel
		String companyName = eLib.getExcelData("Sheet1", 20, 2);
		String Province = eLib.getExcelData("Sheet1", 20, 3);
		String City = eLib.getExcelData("Sheet1", 20, 4);
		String PhoneNumber = eLib.getExcelData("Sheet1", 20, 5);
		String p_code = eLib.getExcelData("Sheet1", 20, 6);
		String p_name = eLib.getExcelData("Sheet1", 20, 7);
		String descrpition = eLib.getExcelData("Sheet1", 20, 9);
		String quantity = eLib.getExcelData("Sheet1", 20, 10);
		String on_hand = eLib.getExcelData("Sheet1", 20, 11);
		String price = eLib.getExcelData("Sheet1", 20, 12);
		String catagory = eLib.getExcelData("Sheet1", 20, 13);
		String updatedProductName = eLib.getExcelData("Sheet1", 20, 15);
		String updatedDescription = eLib.getExcelData("Sheet1", 20, 16);
		String updatedPrice = eLib.getExcelData("Sheet1", 20, 17);
		String updatedCategory = eLib.getExcelData("Sheet1", 20, 18);
		String purchaseQuantity = eLib.getExcelData("Sheet1", 20, 19);
		String customer = eLib.getExcelData("Sheet1", 20, 20);
		
		SingletonDesignPattern s=new SingletonDesignPattern(driver);		
		
		//Click on Supplier major tab
		s.getHomePage().getNavigateToSupplier().click();
		s.getSupplierPage().getCreateSupplierAddIcon().click();
		//8.Enter the details
		String company = companyName;
		s.getSupplierPage().CreateSupplier(company, Province, City, PhoneNumber);
		System.out.println("supplier is created");
		
		// CREATE A NEW PRODUCT
		s.getHomePage().getNavigateToProduct().click();
		s.getProductPage().getCreateProductAddIcon().click();
		String pcode = p_code + "_" + ran;
		String pname = p_name ;
		s.getProductPage().CreateProduct(pcode, pname, descrpition, quantity, on_hand, price, catagory, company);
		System.out.println("Product is created");
		
		s.getProductPage().getSearchTextfield().sendKeys(pcode);
		s.getProductPage().getElipseIcon().click();
		s.getProductPage().getEditButton().click();
		String upname = updatedProductName;
		s.getProductPage().EditProduct(upname, updatedDescription, updatedPrice, updatedCategory);
		//details button need to click
		s.getLoginPage().LogoutToApplication();
		
		s.getLoginPage().loginToApplication(url, user_UN, user_PW);
		s.getPosPage().getPos_button().click();
		s.getPosPage().selectategory(updatedCategory);
		s.getPosPage().sendQuantity(updatedProductName,purchaseQuantity);
		s.getPosPage().clickAddButton(updatedProductName);
		
		// select a customer and click on submit
		WebElement dd1 = s.getPosPage().getCust_dropdown();
		wLib.select(dd1, customer);
		s.getPosPage().getSubmit_button().click();
		WebElement ele =s.getPosPage().getTotal_text();
		String amount = ele.getAttribute("value");
		System.out.println("Total Amount= "+amount);
		s.getPosPage().getAmount_tf().sendKeys(amount);
		s.getPosPage().getProceedToPayment_btn().click();
		wLib.swithToAlertWindowAndAccpect(driver);
		
		s.getLoginPage().LogoutToApplication();
		s.getLoginPage().loginToApplication(url, admin_UN, admin_PW);
		s.getHomePage().getNavigateToTransaction().click();
		s.getTransactionPage().getSearch_TF().sendKeys(customer);
		s.getTransactionPage().getTrans_number_btn().click();
		s.getTransactionPage().getDetails_btn().click();
		String cash =s.getTransactionPage().totalAmount(amount);
		System.out.println("Total Amount in receipt="+cash);
		Assert.assertEquals(amount, cash);
	}

}



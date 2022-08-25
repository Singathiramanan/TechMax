/*package com.Techmax.EndToEnd;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.TechMax.Pomrepositorylib.HomePage;
import com.TechMax.Pomrepositorylib.InventoryPage;
import com.TechMax.Pomrepositorylib.LoginPage;
import com.TechMax.Pomrepositorylib.PosPage;
import com.TechMax.Pomrepositorylib.ProductPage;
import com.TechMax.Pomrepositorylib.SupplierPage;
import com.TechMax.Pomrepositorylib.TransactionPage;
import com.TechMax.utility.BaseClass;

public class TestScricpts1 extends BaseClass {
	@Test(enabled=false)
	public void AddProductLoginAsEmployeeGenrateBillInPOSforProduct() throws Throwable {

		String ran = jLib.getRanDomNumber();
		
		String url = fLib.getPropertyKeyValue("url");
		String admin_UN = fLib.getPropertyKeyValue("admin_username");
		String admin_PW = fLib.getPropertyKeyValue("admin_password");
		String user_UN = fLib.getPropertyKeyValue("user_username");
		String user_PW = fLib.getPropertyKeyValue("user_password");
		// Fetching data from excel
		String p_code = eLib.getExcelData("Sheet1", 10, 2);
		String p_name = eLib.getExcelData("Sheet1", 10, 3);
		String supplier = eLib.getExcelData("Sheet1", 10, 4);
		String descrpition = eLib.getExcelData("Sheet1", 10, 5);
		String quantity = eLib.getExcelData("Sheet1", 10, 6);
		String on_hand = eLib.getExcelData("Sheet1", 10, 7);
		String price = eLib.getExcelData("Sheet1", 10, 8);
		String catagory = eLib.getExcelData("Sheet1", 10, 9);
		String p_qty = eLib.getExcelData("Sheet1", 10, 13);
		String upQuantity = eLib.getExcelData("Sheet1", 10, 11);
		String upOn_hand = eLib.getExcelData("Sheet1", 10, 12);
		String custName = eLib.getExcelData("Sheet1", 10, 14);
		
			HomePage home = new HomePage(driver);
			LoginPage login = new LoginPage(driver);
			ProductPage product = new ProductPage(driver);
			PosPage pos = new PosPage(driver);
			InventoryPage inventory = new InventoryPage(driver);
			TransactionPage trans = new TransactionPage(driver);
			
			//navigating to product page
			home.getNavigateToProduct().click();
			//click on add product icon
			product.getCreateProductAddIcon().click();
			// CREATE A NEW PRODUCT
			String productCode = p_code + ran;
			String productName = p_name + ran;
			product.CreateProduct(productCode, productName, descrpition, quantity, on_hand, price, catagory, supplier);
			// navigate to inventory
			home.getNavigateToInventory().click();
			// search using product name
			inventory.getSearch_TF().sendKeys(productName);
			// view button
			inventory.getViewButton().click();

			// click on edit button
			inventory.getEditInventory().click();

			// update details qty and on hand stock
			inventory.getUpdateQty().clear();
			inventory.getUpdateQty().sendKeys(upQuantity);
			inventory.getUpdateOnHand().clear();
			inventory.getUpdateOnHand().sendKeys(upOn_hand);

			// clcik on update button
			inventory.getUpdateButton().click();

			// click on OK in Alert pop up
			wLib.swithToAlertWindowAndAccpect(driver);

			// logout as admin
			login.LogoutToApplication();

			// login as user
			login.loginToApplication(url, user_UN, user_PW);

			// clcik on pos
			home.getNavigateToPOS().click();

			// click on product category layout
			pos.selectategory(catagory);

			// 17.add the product count and Click on Add Button
			pos.sendQuantity(productName, p_qty);
			pos.clickAddButton(productName);

			// Select customer
			pos.getCust_dropdown().sendKeys(custName);

			// fetch total amount
			String total = pos.getTotal_text().getAttribute("value");

			// click on submit
			pos.getSubmit_button().click();

			// enter cash
			pos.getAmount_tf().sendKeys(total);

			// click on proceed to payment
			pos.getProceedToPayment_btn().click();
			wLib.swithToAlertWindowAndAccpect(driver);

			// Logout as user
			login.LogoutToApplication();

			// login as admin
			login.loginToApplication(url, admin_UN, admin_PW);

			// click on transaction page
			home.getNavigateToTransaction().click();

			// search customer in search textfiled
			trans.getSearch_TF().sendKeys(custName);

			// click on view button
			trans.getDetails_btn().click();
	}



	@Test(enabled=false)
	public void AddSupplierAddProductLoginAsEmployeeGenrateBillInPOSforProduct() throws Throwable{
		String ran = jLib.getRanDomNumber();

		// Fetching data from property files
		String url = fLib.getPropertyKeyValue("url");
		String admin_UN = fLib.getPropertyKeyValue("admin_username");
		String admin_PW = fLib.getPropertyKeyValue("admin_password");
		String user_UN = fLib.getPropertyKeyValue("user_username");
		String user_PW = fLib.getPropertyKeyValue("user_password");
		
		// Fetching data from excel
		String companyName = eLib.getExcelData("Sheet1", 16, 2);
		String Province = eLib.getExcelData("Sheet1", 16, 3);
		String City = eLib.getExcelData("Sheet1", 16, 4);
		String PhoneNumber = eLib.getExcelData("Sheet1", 16, 5);
		String p_code = eLib.getExcelData("Sheet1", 16, 6);
		String p_name = eLib.getExcelData("Sheet1", 16, 7);
		String descrpition = eLib.getExcelData("Sheet1", 16, 9);
		String quantity = eLib.getExcelData("Sheet1", 16, 10);
		String on_hand = eLib.getExcelData("Sheet1", 16, 11);
		String price = eLib.getExcelData("Sheet1", 16, 12);
		String catagory = eLib.getExcelData("Sheet1", 16, 13);
		String updatedProductName = eLib.getExcelData("Sheet1", 16, 15);
		String updatedDescription = eLib.getExcelData("Sheet1", 16, 16);
		String updatedPrice = eLib.getExcelData("Sheet1", 16, 17);
		String updatedCategory = eLib.getExcelData("Sheet1", 16, 18);
		String purchaseQuantity = eLib.getExcelData("Sheet1", 16, 19);
		String customer = eLib.getExcelData("Sheet1", 16, 20);
		
		LoginPage login=new LoginPage(driver);
		ProductPage product=new ProductPage(driver);
		HomePage home=new HomePage(driver);
		PosPage pos=new PosPage(driver);
		SupplierPage supplier=new SupplierPage(driver);
		TransactionPage trans=new TransactionPage(driver);
		
		//Click on Supplier major tab
		home.getNavigateToSupplier().click();
		supplier.getCreateSupplierAddIcon().click();
		//8.Enter the details
		String company = companyName+"_"+ran;
		supplier.CreateSupplier(company, Province, City, PhoneNumber);
		System.out.println("supplier is created");
		
		// CREATE A NEW PRODUCT
		home.getNavigateToProduct().click();
		product.getCreateProductAddIcon().click();
		String pcode = p_code + "_" + ran;
		String pname = p_name + "_" + ran;
		product.CreateProduct(pcode, pname, descrpition, quantity, on_hand, price, catagory, company);
		System.out.println("Product is created");
		
		product.getSearchTextfield().sendKeys(pcode);
		product.getElipseIcon().click();
		product.getEditButton().click();
		product.EditProduct(updatedProductName, updatedDescription, updatedPrice, updatedCategory);
		//details button need to click
		login.LogoutToApplication();
		
		login.loginToApplication(url, user_UN, user_PW);
		pos.getPos_button().click();
		pos.selectategory(updatedCategory);
		pos.sendQuantity(updatedProductName,purchaseQuantity);
		pos.clickAddButton(updatedProductName);
		
		// select a customer and click on submit
		WebElement dd1 = pos.getCust_dropdown();
		wLib.select(dd1, customer);
		pos.getSubmit_button().click();
		WebElement ele =pos.getTotal_text();
		String amount = ele.getAttribute("value");
		System.out.println("Total Amount= "+amount);
		pos.getAmount_tf().sendKeys(amount);
		pos.getProceedToPayment_btn().click();
		wLib.swithToAlertWindowAndAccpect(driver);
		
		login.LogoutToApplication();
		login.loginToApplication(url, admin_UN, admin_PW);
		home.getNavigateToTransaction().click();
		trans.getTrans_number_btn().click();
		trans.getDetails_btn().click();
		String cash =trans.totalAmount(amount);
		System.out.println("Total Amount in receipt="+cash);
		if (amount.contains(cash)) {
			System.out.println("Transaction Details Should present");
		} else {
			System.out.println("Transaction details not present");
		}
	}
	
	@Test(enabled=false)
	public void CreateNewProductVerifyTheProductCountInHomePage_test() throws Throwable{
		String ran = jLib.getRanDomNumber();
		// Fetching data from excel file
		String p_code = eLib.getExcelData("Sheet1", 7, 2);
		String p_name = eLib.getExcelData("Sheet1", 7, 3);
		String supplier = eLib.getExcelData("Sheet1", 7, 4);
		String descrpition = eLib.getExcelData("Sheet1", 7, 5);
		String quantity = eLib.getExcelData("Sheet1", 7, 6);
		String on_hand = eLib.getExcelData("Sheet1", 7, 7);
		String price = eLib.getExcelData("Sheet1", 7, 8);
		String catagory = eLib.getExcelData("Sheet1", 7, 9);

		HomePage home=new HomePage(driver);
		WebElement ele = home.getProductCount();
		String record = ele.getText();
		String[] num = record.split(" ");
		int count = Integer.parseInt(num[0]);
		System.out.println("Product quantity before added:- " + count);
		home.getNavigateToProduct().click();
		// CREATE A NEW PRODUCT
		ProductPage product=new ProductPage(driver);
		product.getCreateProductAddIcon().click();
		String pcode=p_code + "_" + ran;
		product.CreateProduct(pcode, p_name, descrpition, quantity, on_hand, price, catagory, supplier);
		
		home.getNavigateToHome().click();
		
		WebElement ele1 = home.getProductCount();
		String record1 = ele1.getText();
		String[] num1 = record1.split(" ");
		int newcount = Integer.parseInt(num1[0]);
		int qty = Integer.parseInt(quantity);
		System.out.println("Product quantity added:- " + qty);
		System.out.println("Product quantity after added:- " + newcount);

		int total = count + qty;
		if (total == newcount) {
			System.out.println("Product Quantity is increased");
		} else {
			System.out.println("product quantity not increased");
		}
	}
	@Test
	public void Purchase_a_product_and_Add_Updated_customer_and_verify_transaction_details_test() throws Throwable{
		String ran = jLib.getRanDomNumber();
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
		HomePage home = new HomePage(driver);
		ProductPage product=new ProductPage(driver);
		PosPage pos=new PosPage(driver);
		TransactionPage transaction=new TransactionPage(driver);

			// CREATE A NEW PRODUCT
			home.getNavigateToProduct().click();
			product.getCreateProductAddIcon().click();
			String pcode = product_code + "_" + ran;
			product.CreateProduct(pcode, product_name, descrpition, quantity, on_hand, price, catagory, supplier);
			
			// click on search product and edit 
			product.getSearchTextfield().sendKeys(pcode);
			product.getElipseIcon().click();
			product.getEditButton().click();
			product.EditProduct(product_name, descrpition, updated_price, catagory);
			
			// click on pos and add product
			home.getNavigateToPOS().click();
			pos.selectategory(catagory);
			pos.sendQuantity(product_name, product_qty);
			pos.clickAddButton(product_name);
			
			// add a customer
			pos.addCustomer(customer_fn, customer_ln, customrt_pn);

			// select customer and proceed to payment
			WebElement dd1 =pos.getCust_dropdown();
			wLib.select(dd1, customer_fn + " " + customer_ln);
			pos.getSubmit_button().click();
			WebElement ele = pos.getTotal_text();
			String amount = ele.getAttribute("value");
			System.out.println("Total amount=" + amount);
			pos.getAmount_tf().sendKeys(amount);
			pos.getProceedToPayment_btn().click();
			wLib.swithToAlertWindowAndAccpect(driver);

			// check on transaction
			home.getNavigateToSalesAndInventoryIcon().click();
			home.getNavigateToTransaction().click();
			transaction.getTrans_number_btn().click();
			transaction.getDetails_btn().click();
			String cash =transaction.totalAmount(amount);
			if (amount.contains(cash)) {
				System.out.println("Transaction Details Should present");
			} else {
				System.out.println("Transaction details not present");
			}
	}
	
	@Test
	public void sale_a_product_check_the_transaction_details_test() throws Throwable{
		// Fetching data from property file
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
				LoginPage lp=new LoginPage(driver);
				lp.LogoutToApplication();
				
				// Login to application
				lp.loginToApplication(url, user_UN, user_PW);
				
				// navigate POS and select category
				PosPage pos=new PosPage(driver);
				pos.getPos_button().click();
				pos.selectategory(category);
				pos.sendQuantity(productName, qty);
				pos.clickAddButton(productName);
				
				// select a customer and click on submit
				WebElement dd1 = pos.getCust_dropdown();
				wLib.select(dd1, cust);
				pos.getSubmit_button().click();
				WebElement ele =pos.getTotal_text();
				String amount = ele.getAttribute("value");
				System.out.println("Total Amount= "+amount);
				pos.getAmount_tf().sendKeys(amount);
				pos.getProceedToPayment_btn().click();
				wLib.swithToAlertWindowAndAccpect(driver);

				// logout user
				lp.LogoutToApplication();
				
				// Login to application
				lp.loginToApplication(url, admin_UN, admin_PW);
				
				//navigate to transaction
				HomePage home=new HomePage(driver);
				TransactionPage trans=new TransactionPage(driver);
				home.getNavigateToTransaction().click();
				trans.getTrans_number_btn().click();
				trans.getDetails_btn().click();
				String cash =trans.totalAmount(amount);
				System.out.println("Total Amount in receipt="+cash);
				if (amount.contains(cash)) {
					System.out.println("Transaction Details Should present");
				} else {
					System.out.println("Transaction details not present");
				}
				
				

	}
	@Test(enabled=false)
	public void VerifySupplierNameInAddProduct_test() throws Throwable{
		String ran = jLib.getRanDomNumber();

		// Fetching data from excel
		String companyName = eLib.getExcelData("Sheet1", 13, 2);
		String Province = eLib.getExcelData("Sheet1", 13, 3);
		String City = eLib.getExcelData("Sheet1", 13, 4);
		String PhoneNumber = eLib.getExcelData("Sheet1", 13, 5);
		String p_code = eLib.getExcelData("Sheet1", 13, 6);
		String p_name = eLib.getExcelData("Sheet1", 13, 7);
		String descrpition = eLib.getExcelData("Sheet1", 13, 9);
		String quantity = eLib.getExcelData("Sheet1", 13, 10);
		String on_hand = eLib.getExcelData("Sheet1", 13, 11);
		String price = eLib.getExcelData("Sheet1", 13, 12);
		String catagory = eLib.getExcelData("Sheet1", 13, 13);
		
		//Click on Supplier major tab
		HomePage home=new HomePage(driver);
		home.getNavigateToSupplier().click();

		//Create a supplier
		SupplierPage sp=new SupplierPage(driver);
		sp.getCreateSupplierAddIcon().click();
		String company = companyName+"_"+ran;
		sp.CreateSupplier(company, Province, City, PhoneNumber);
		System.out.println("supplier is created");
		
		// Create a product
		home.getNavigateToProduct().click();
		ProductPage product=new ProductPage(driver);
		product.getCreateProductAddIcon().click();
		String pcode = p_code + "_" + ran;
		product.CreateProduct(pcode, p_name, descrpition, quantity, on_hand, price, catagory, company);
		System.out.println("Product is created");
		
		//click on inventory check the product
		home.getNavigateToInventory().click();
		InventoryPage inventory=new InventoryPage(driver);
		inventory.getSearch_TF().sendKeys(pcode);
		System.out.println("product details is present");

	}
}*/
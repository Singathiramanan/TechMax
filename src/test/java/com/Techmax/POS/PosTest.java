package com.Techmax.POS;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TechMax.Pomrepositorylib.SingletonDesignPattern;
import com.TechMax.utility.BaseClass;

@Listeners(com.TechMax.utility.ItestLisImpClass.class)

public class PosTest extends BaseClass {
	
	@Test(groups="SmokeTest",enabled=true)
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
	
	@Test(groups="RegressionTest",dataProvider="dataProvider_multipleData",enabled=true)
	public void sale_a_product_check_the_transaction_details_test(String qty,String cust,String category,String productName ) throws Throwable{
		// Fetching data from property file
				String url = fLib.getPropertyKeyValue("url");
				String admin_UN = fLib.getPropertyKeyValue("admin_username");
				String admin_PW = fLib.getPropertyKeyValue("admin_password");
				String user_UN = fLib.getPropertyKeyValue("user_username");
				String user_PW = fLib.getPropertyKeyValue("user_password");

//				// Fetching data from excel
//				String qty = eLib.getExcelData("Sheet1", 4, 2);
//				String cust = eLib.getExcelData("Sheet1", 4, 3);
//				String category=eLib.getExcelData("Sheet1", 4, 4);
//				String productName=eLib.getExcelData("Sheet1", 4, 5);
			
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
	
	@DataProvider
	public Object[][] dataProvider_multipleData() throws Throwable{
		Object[][] arr = new Object[5][4];
		int r=4,c=2;
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				arr[i][j]=eLib.getExcelData("Sheet1", r, c);
				c++;
			}
			c=2;
			r++;
		}
		return arr;
		
	}


}

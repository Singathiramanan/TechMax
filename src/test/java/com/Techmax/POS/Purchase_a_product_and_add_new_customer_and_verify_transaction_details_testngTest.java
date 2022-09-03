package com.TechMAX.pos;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sales.techmax.genericUtility.BaseClass;
import com.sales.techmax.objectRepositoryUtility.CustomerPage;
import com.sales.techmax.objectRepositoryUtility.HomePage;
import com.sales.techmax.objectRepositoryUtility.POSPage;
import com.sales.techmax.objectRepositoryUtility.ProductPage;
import com.sales.techmax.objectRepositoryUtility.TransactionPage;

public class Purchase_a_product_and_add_new_customer_and_verify_transaction_details_testngTest extends BaseClass{
	@Test(groups = "smokeTesting")
	public void Purchase_a_product_and_add_new_customer_and_verify_transaction_details_Test() throws Throwable
	{
		String ProductCode = jLib.getRanDomNumber(10000);
		String Name = eLib.getExcelData("Sheet1", 1, 3);
		String Description = eLib.getExcelData("Sheet1", 1, 4);
		String Quantity = eLib.getExcelData("Sheet1", 1, 5);
		String OnHand = eLib.getExcelData("Sheet1", 1, 6);
		String Price = eLib.getExcelData("Sheet1", 1, 7);
		String SelectCategory = eLib.getExcelData("Sheet1", 1, 8);
		String SelectSupplier = eLib.getExcelData("Sheet1", 1, 9);
		String FirstName = eLib.getExcelData("Sheet1", 1, 12);
		String LastName = eLib.getExcelData("Sheet1", 1, 13);
		String PhoneNumber = eLib.getExcelData("Sheet1", 1, 14);
		
		
		ProductPage createProductObj=new ProductPage(driver);
        HomePage hp = new 	HomePage(driver);
        POSPage pp = new POSPage(driver);
		CustomerPage cpc=new CustomerPage(driver);
		TransactionPage tp=new TransactionPage(driver);
		
		//navigate to product tab
				hp.getNavigateToProduct().click();
				
				createProductObj.getCreateProductAddIcon().click();
				createProductObj.CreateProduct(ProductCode, Name, Description, Quantity,OnHand, Price, SelectCategory, SelectSupplier);
					 
				 //click on POS link
				hp.getNavigateToPOS().click();
		          
		          
				 //click on Others
		          pp.selectCatgory(SelectCategory);
		          pp.name(Name);
		          
		          pp.addCustomer(FirstName, LastName, PhoneNumber);
		          
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
		      	 
		
}

}

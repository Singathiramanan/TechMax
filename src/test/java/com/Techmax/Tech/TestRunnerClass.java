package com.TechMAX.Tech;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sales.techmax.genericUtility.BaseClass;
import com.sales.techmax.objectRepositoryUtility.CustomerPage;
import com.sales.techmax.objectRepositoryUtility.EmployeePage;
import com.sales.techmax.objectRepositoryUtility.HomePage;
import com.sales.techmax.objectRepositoryUtility.LoginPage;
import com.sales.techmax.objectRepositoryUtility.POSPage;
import com.sales.techmax.objectRepositoryUtility.ProductPage;
import com.sales.techmax.objectRepositoryUtility.SupplierPage;
import com.sales.techmax.objectRepositoryUtility.TransactionPage;

public class TestRunnerClass extends BaseClass {

	@Test(enabled=false)
	public void Verify__Customer_Updation_and_Customer_details_Test() throws Throwable {
		//Read the data from Excelfile
		String FirstName = eLib.getExcelData("Sheet1", 6, 2);
		String Lastname = eLib.getExcelData("Sheet1", 6, 3);
		//DataFormatter format=new DataFormatter();
		String value = eLib.getExcelData("Sheet1", 6, 4);
		
		//Read  in excel
		String uFirstName = eLib.getExcelData("Sheet1", 6, 5);
		String uLastNamee = eLib.getExcelData("Sheet1", 6, 6);
		String uphonenu=eLib.getExcelData("Sheet1", 6, 7);
		
		LoginPage login=new LoginPage(driver);
		ProductPage createProductObj=new ProductPage(driver);
        HomePage hp = new 	HomePage(driver);
        POSPage pp = new POSPage(driver);
		CustomerPage cpc=new CustomerPage(driver);
		TransactionPage tp=new TransactionPage(driver);
		EmployeePage ep=new EmployeePage(driver);
		ProductPage pg=new ProductPage(driver);
		
		//Navigate to customer major tab
		hp.getNavigateToCustomer().click();
		cpc.createcustomer(FirstName, Lastname, value);
		cpc.getSearchTextField().sendKeys(FirstName);
		cpc.getEllipsisButton().click();
		cpc.getEditButton().click();
		cpc.updateCustomer(uFirstName, uLastNamee, uphonenu);
		
		//Verify using search
		cpc.getSearchTextField().sendKeys(uFirstName);
	}
	
	@Test(enabled=false)
	public void Create_product_in_product_page_Test() throws Throwable {
		
		// Read the data from Excelfile 
		String ProductCode = jLib.getRanDomNumber(1000000);
		String Name = eLib.getExcelData("Sheet1", 1, 3);
		String Description = eLib.getExcelData("Sheet1", 1, 4);
		String Quantity = eLib.getExcelData("Sheet1", 1, 5);
		String OnHand = eLib.getExcelData("Sheet1", 1, 6);
		String Price = eLib.getExcelData("Sheet1", 1, 7);
		String SelectCategory = eLib.getExcelData("Sheet1", 1, 8);
		String SelectSupplier = eLib.getExcelData("Sheet1", 1, 9);
		String DateStockin = eLib.getExcelData("Sheet1", 1, 10);
		String quantity = eLib.getExcelData("Sheet1", 1, 11);
		String FirstName = eLib.getExcelData("Sheet1", 1, 12);
		String LastName = eLib.getExcelData("Sheet1", 1, 13);
		String PhoneNumber = eLib.getExcelData("Sheet1", 1, 14);
		
		LoginPage login=new LoginPage(driver);
		ProductPage createProductObj=new ProductPage(driver);
        HomePage hp = new 	HomePage(driver);
        POSPage pp = new POSPage(driver);
		CustomerPage cpc=new CustomerPage(driver);
		TransactionPage tp=new TransactionPage(driver);
		EmployeePage ep=new EmployeePage(driver);
		ProductPage pg=new ProductPage(driver);
		
		// navigate to product tab
				hp.getNavigateToProduct().click();
				
				pg.getCreateProductAddIcon().click();

				// enter all the details
				
	pg.CreateProduct(ProductCode, Name, Description, Quantity,OnHand,Price,SelectCategory,SelectSupplier);

	}
	
	@Test(enabled=false)
	public void CreateEmployeeWithMandatoryFieldsTest() throws Throwable
	{
		String employeeFirstName = eLib.getExcelData("Sheet3", 3, 1);
		String employeeLastName = eLib.getExcelData("Sheet3", 3, 2);
		String employeeGender = eLib.getExcelData("Sheet3", 3, 3);
		String employeeEmail = eLib.getExcelData("Sheet3", 3, 4);
		String employeePhoneNumber = eLib.getExcelData("Sheet3", 3, 5);
		String selectProvince= eLib.getExcelData("Sheet3", 3, 7);
		String selectCity= eLib.getExcelData("Sheet3", 3, 8);
		int ran = Integer.parseInt(jLib.getRanDomNumber(10000));
		long pnum = Long.parseLong(employeePhoneNumber);
		pnum=pnum-ran;
		String phnum=String.valueOf(pnum);
		String employeeRole = eLib.getExcelData("Sheet3", 3, 6);
		
		LoginPage login=new LoginPage(driver);
		ProductPage createProductObj=new ProductPage(driver);
        HomePage hp = new 	HomePage(driver);
        POSPage pp = new POSPage(driver);
		CustomerPage cpc=new CustomerPage(driver);
		TransactionPage tp=new TransactionPage(driver);
		EmployeePage ep=new EmployeePage(driver);
		
	// 6.click on employee major tab
	hp.getNavigateToEmployee().click();

	// 7.click on add icon in employee page
	ep.getAddEmployeeicon().click();

	// 8.enter the details
	ep.createEmployee(employeeFirstName, employeeLastName, employeeGender, employeeEmail, phnum, employeeRole, selectProvince, selectCity);


	}
	
	@Test(enabled=false)
	public void CreateNewSupplierVerifyTheSupplierCountInHomePageTest() throws Throwable
	{
		String CompanyName = eLib.getExcelData("Sheet4", 2, 1);

		String SelectProvince = eLib.getExcelData("Sheet4", 2, 2);

		String SelectCity = eLib.getExcelData("Sheet4", 2, 3);

		DataFormatter format = new DataFormatter();
		String ph = eLib.getExcelData("Sheet4", 2, 4);
		
		LoginPage login = new LoginPage(driver);
		ProductPage createProductObj = new ProductPage(driver);
		HomePage hp = new HomePage(driver);
		POSPage pp = new POSPage(driver);
		CustomerPage cpc = new CustomerPage(driver);
		SupplierPage sp = new SupplierPage(driver);
		
		        // navigate to supplier
				String oldcount = hp.getSupplierCount().getText();
				String[] num = oldcount.split(" ");
				int old = Integer.parseInt(num[0]);
				System.out.println(oldcount);
				hp.getNavigateToSupplier().click();
				sp.getCreateSupplierAddIcon().click();
				sp.CreateSupplier(CompanyName, SelectProvince, SelectCity, ph);

				hp.getNavigateToSalesAndInventoryIcon().click();
				String newcount = hp.getSupplierCount().getText();
				String[] num1 = newcount.split(" ");
				int newc = Integer.parseInt(num1[0]);
				System.out.println(newcount);
				if (old < newc) {
					System.out.println("TestPass");
				} else {
					System.out.println("Test FAIL");

	}
	}
	
	@Test(enabled=false)
	public void CreateSupplierTest() throws Throwable
	{
		String CompanyName=eLib.getExcelData("Sheet2", 1, 0);

		String SelectProvince=eLib.getExcelData("Sheet2", 1, 1);
				
		String SelectCity=eLib.getExcelData("Sheet2", 1, 2);
		
		String ph=eLib.getExcelData("Sheet2", 1, 3);
		
		LoginPage login=new LoginPage(driver);
		ProductPage createProductObj=new ProductPage(driver);
        HomePage hp = new 	HomePage(driver);
        POSPage pp = new POSPage(driver);
		CustomerPage cpc=new CustomerPage(driver);
		SupplierPage sp=new SupplierPage(driver);
		
		        //navigate to supplier
				hp.getNavigateToSupplier().click();
				sp.getCreateSupplierAddIcon().click();
				
				sp.CreateSupplier(CompanyName, SelectProvince, SelectCity, ph);
		
	}
	@Test
	public void Purchase_a_product_and_add_new_customer_and_verify_transaction_details_Test() throws Throwable
	{
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
		
		LoginPage login=new LoginPage(driver);
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





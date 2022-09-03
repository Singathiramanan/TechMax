package com.TechMAX.customer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sales.techmax.genericUtility.BaseClass;
import com.sales.techmax.objectRepositoryUtility.CustomerPage;
import com.sales.techmax.objectRepositoryUtility.HomePage;
@Listeners(com.sales.techmax.genericUtility.ItestListenerImpClass.class)
public class Verify__Customer_Updation_and_Customer_details_testngTest extends BaseClass {
	@Test(groups = "smokeTesting")
	public void Verify__Customer_Updation_and_Customer_details_Test() throws Throwable {
		// Read the data from Excelfile
		String FirstName = eLib.getExcelData("Sheet1", 6, 2);
		String Lastname = eLib.getExcelData("Sheet1", 6, 3);
		// DataFormatter format=new DataFormatter();
		String value = eLib.getExcelData("Sheet1", 6, 4);

		// Read in excel
		String uFirstName = eLib.getExcelData("Sheet1", 6, 5);
		String uLastNamee = eLib.getExcelData("Sheet1", 6, 6);
		String uphonenu = eLib.getExcelData("Sheet1", 6, 7);

		HomePage hp = new HomePage(driver);
		CustomerPage cpc = new CustomerPage(driver);

		// Navigate to customer major tab
		hp.getNavigateToCustomer().click();
		cpc.createcustomer(FirstName, Lastname, value);
		cpc.getSearchTextField().sendKeys(FirstName);
		cpc.getEllipsisButton().click();
		cpc.getEditButton().click();
		cpc.updateCustomer(uFirstName, uLastNamee, uphonenu);

		// Verify using search
		cpc.getSearchTextField().sendKeys(uFirstName);
		//Assert.assertEquals(false, true);
	}

}

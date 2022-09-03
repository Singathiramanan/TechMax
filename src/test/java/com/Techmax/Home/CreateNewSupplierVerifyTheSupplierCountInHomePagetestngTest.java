package com.TechMAX.home;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sales.techmax.genericUtility.BaseClass;
import com.sales.techmax.objectRepositoryUtility.HomePage;
import com.sales.techmax.objectRepositoryUtility.SupplierPage;
@Listeners(com.sales.techmax.genericUtility.ItestListenerImpClass.class)
public class CreateNewSupplierVerifyTheSupplierCountInHomePagetestngTest extends BaseClass {
	@Test(groups = "smokeTesting",retryAnalyzer = com.sales.techmax.genericUtility.IRetry.class)
	public void CreateNewSupplierVerifyTheSupplierCountInHomePageTest() throws Throwable
	{
		String CompanyName = eLib.getExcelData("Sheet4", 2, 1);

		String SelectProvince = eLib.getExcelData("Sheet4", 2, 2);

		String SelectCity = eLib.getExcelData("Sheet4", 2, 3);

		String ph = eLib.getExcelData("Sheet4", 2, 4);
		
		HomePage hp = new HomePage(driver);
		SupplierPage sp = new SupplierPage(driver);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(false, true);
		
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
				//if (old < newc) {
				//	System.out.println("TestPass");
			//	} else {
			//		System.out.println("Test FAIL");
			sa.assertEquals(old, newc);
			sa.assertAll();

	}
	}
	



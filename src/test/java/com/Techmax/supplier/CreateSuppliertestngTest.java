package com.TechMAX.supplier;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sales.techmax.genericUtility.BaseClass;
import com.sales.techmax.objectRepositoryUtility.HomePage;
import com.sales.techmax.objectRepositoryUtility.SupplierPage;

public class CreateSuppliertestngTest extends BaseClass{
	@Test(groups = "regressionTesting")
	public void CreateSupplierTest() throws Throwable
	{
		String CompanyName=eLib.getExcelData("Sheet2", 1, 0);

		String SelectProvince=eLib.getExcelData("Sheet2", 1, 1);
				
		String SelectCity=eLib.getExcelData("Sheet2", 1, 2);
		
		String ph=eLib.getExcelData("Sheet2", 1, 3);
		
        HomePage hp = new 	HomePage(driver);
		SupplierPage sp=new SupplierPage(driver);
		
		hp.getNavigateToSalesAndInventoryIcon().click();
	   String sc = hp.getSupplierCount().getText();
	   String scCont = sc.split(" ")[0];
	   int c1 = Integer.parseInt(scCont);
		        //navigate to supplier
				hp.getNavigateToSupplier().click();
				sp.getCreateSupplierAddIcon().click();
				
				sp.CreateSupplier(CompanyName, SelectProvince, SelectCity, ph);
				//click on home page
				hp.getNavigateToSalesAndInventoryIcon().click();
				String hc = hp.getSupplierCount().getText();
				String[] arr1 = hc.split(" ");
				   String count2 = arr1[0];
				   int c2 = Integer.parseInt(count2);
				
				Assert.assertEquals(c1+1, c2);
				
				
				
				
		
	}

}

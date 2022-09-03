package com.TechMAX.product;

import org.testng.annotations.Test;

import com.sales.techmax.genericUtility.BaseClass;
import com.sales.techmax.objectRepositoryUtility.HomePage;
import com.sales.techmax.objectRepositoryUtility.ProductPage;

public class Create_product_in_product_page_testngTest extends BaseClass{
	@Test(groups = "regressionTesting")
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
		
		
		
          HomePage hp = new HomePage(driver);
		ProductPage pg=new ProductPage(driver);
		
		// navigate to product tab
				hp.getNavigateToProduct().click();
				
				pg.getCreateProductAddIcon().click();

				// enter all the details
				
	pg.CreateProduct(ProductCode, Name, Description, Quantity,OnHand,Price,SelectCategory,SelectSupplier);

	}

}

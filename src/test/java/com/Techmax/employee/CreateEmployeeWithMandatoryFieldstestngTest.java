package com.TechMAX.employee;

import org.testng.annotations.Test;

import com.sales.techmax.genericUtility.BaseClass;
import com.sales.techmax.objectRepositoryUtility.EmployeePage;
import com.sales.techmax.objectRepositoryUtility.HomePage;

public class CreateEmployeeWithMandatoryFieldstestngTest extends BaseClass{
	@Test(groups = "smokeTesting")
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
		
		
        HomePage hp = new 	HomePage(driver);
		EmployeePage ep=new EmployeePage(driver);
		
	// 6.click on employee major tab
	hp.getNavigateToEmployee().click();

	// 7.click on add icon in employee page
	ep.getAddEmployeeicon().click();

	// 8.enter the details
	ep.createEmployee(employeeFirstName, employeeLastName, employeeGender, employeeEmail, phnum, employeeRole, selectProvince, selectCity);


	}
	

}

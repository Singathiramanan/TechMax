package org.sdet38.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws IOException {
		//steps 1:File Input Stream
		FileInputStream fis=new FileInputStream(".\\Data\\RTM- TechMAX.xlsx");
		
		//steps 2:load workbook
		Workbook workbook = WorkbookFactory.create(fis); 
		
		//steps 3:load sheet
		Sheet sh = workbook.getSheet("Sheet1");
		
		//steps 4:navigate to row
		for (int i = 1; i <=11; i++) {
			Row row = sh.getRow(i);
			Cell cel = row.getCell(2);
			String value = cel.getStringCellValue();
			System.out.println(value);
		}
		
		
	
		//steps 5:navigate to cell
		
		
		//steps 6:read the value inside the cell
		

	}

}

package com.TechMAX.Tech;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySupplierNameInAddProduct {
	public static void main(String[] args) throws IOException, AWTException {
		WebDriver driver=null;


		//Read the data from property file
		FileInputStream filepath=new FileInputStream(".\\Data\\commonDataProperties");
		Properties property=new Properties();
		property.load(filepath);
		String URL=property.getProperty("url");
		String USERNAME=property.getProperty("username");
		String PASSWORD=property.getProperty("password");
		String BROWSER=property.getProperty("Browser");
		//Launch the URL
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("INCORRECT BROWSER");

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);

		//login to the application
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		driver.findElement(By.xpath("//span[text()='Supplier']")).click();
		driver.findElement(By.cssSelector(".fas.fa-fw.fa-plus")).click();
		FileInputStream fis1=new FileInputStream(".\\Data\\Test_Data.xlsx");
		Workbook workbook =WorkbookFactory.create(fis1);

		//step 3:load the sheet
		Sheet sh = workbook.getSheet("Sheet2");


		//step 6:Read the value inside the cell
		String fn=sh.getRow(1).getCell(0).getStringCellValue();

		driver.findElement(By.name("companyname")).sendKeys(fn);
		WebElement dd1=driver.findElement(By.xpath("//select[@name='province']"));
		Select sel=new Select(dd1);
		String fn1=sh.getRow(1).getCell(1).getStringCellValue();
		sel.selectByVisibleText(fn1);
		//driver.findElement(By.id("province")).sendKeys(fn1);
		WebElement dd2=driver.findElement(By.xpath("//select[@name='city']"));
		Select sel1=new Select(dd2);
		String fn2=sh.getRow(1).getCell(2).getStringCellValue();
		sel1.selectByVisibleText(fn2);
		//driver.findElement(By.id("city")).sendKeys(fn2);
		//String fn3=sh.getRow(1).getCell(3).getStringCellValue();
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(1).getCell(3));
		driver.findElement(By.name("phonenumber")).sendKeys(value);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.cssSelector(".fas.fa-fw.fa-plus")).click();
		WebElement d1=driver.findElement(By.name("supplier"));
		Select s2=new Select(d1);

		List<WebElement> alloptions = s2.getOptions();
		for(WebElement option:alloptions)
		{
			if(option.getText().equals(fn))
			{
				System.out.println("Testcase pass");
				break;
			}

		}
		s2.selectByVisibleText(fn);
		String ProductCode = sh.getRow(1).getCell(4).toString();
		String Name = sh.getRow(1).getCell(5).getStringCellValue();
		String Description = sh.getRow(1).getCell(7).getStringCellValue();
		String Quantity = sh.getRow(1).getCell(8).toString();
		String OnHand = sh.getRow(1).getCell(9).toString();
		String Price = sh.getRow(1).getCell(10).toString();
		String SelectCategory = sh.getRow(1).getCell(11).toString();
		String SelectSupplier = sh.getRow(1).getCell(6).toString();
		String DateStockin = sh.getRow(1).getCell(12).toString();	






		//Enter all the details
		driver.findElement(By.name("prodcode")).sendKeys(ProductCode);
		driver.findElement(By.name("name")).sendKeys(Name);
		driver.findElement(By.cssSelector("[placeholder='Description']")).sendKeys(Description);
		driver.findElement(By.name("quantity")).sendKeys(Quantity);
		driver.findElement(By.name("onhand")).sendKeys(OnHand);
		driver.findElement(By.name("price")).sendKeys(Price);
		driver.findElement(By.name("category")).sendKeys(SelectCategory);
		driver.findElement(By.name("supplier")).sendKeys(SelectSupplier);
		//date
		
		WebElement datestock = driver.findElement(By.name("datestock"));
		datestock.click();
		Robot robot=new Robot();
		datestock.sendKeys(Keys.NUMPAD2);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		datestock.sendKeys(Keys.NUMPAD1);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		datestock.sendKeys(Keys.NUMPAD2);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		//click on save button
		 WebElement saveElement = driver.findElement(By.xpath("//div[@class='modal-header']/child::h5[@id='exampleModalLabel' and text()='Add Product']/ancestor::div[@class='modal-content']/descendant::button[@type='submit']"));
		
		 saveElement.click();
	}
}

package MockInterview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.TechMax.utility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class MakeMyTrip {

	@Test
	public void MakeMyTripTest() throws Throwable{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Bangalore");
//		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//div[@role='listbox']/descendant::p[contains(.,'Bengaluru')]")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("mumbai");;
		driver.findElement(By.xpath("//div[@role='listbox']/descendant::p[contains(.,'Mumbai')]")).click();
		String fmonth="Dec",fDate="02";
		driver.findElement(By.xpath("//div[@role='heading']/descendant::div[contains(.,'"+fmonth+"')]/ancestor::div[@role='heading']/following-sibling::div[@class='DayPicker-Body']/descendant::div[contains(@aria-label,'"+fmonth+" "+fDate+"')]")).click();
		driver.findElement(By.xpath("//div[@data-cy='returnArea']")).click();
		String month="Dec",Date="03";
		//WebElement mm = driver.findElement(By.xpath("//div[@role='heading']/descendant::div[contains(.,'Dec')]/child::span[contains(.,'2022')]"));
		driver.findElement(By.xpath("//div[@role='heading']/descendant::div[contains(.,'"+month+"')]/ancestor::div[@role='heading']/following-sibling::div[@class='DayPicker-Body']/descendant::div[contains(@aria-label,'"+month+" "+Date+"')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Search')]")).click();
		WebElement ele = driver.findElement(By.xpath("//p[contains(.,'Popular Filters')]/parent::div/descendant::span[contains(.,'more')]"));
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		List<WebElement> names = driver.findElements(By.xpath("//p[contains(.,'Popular Filters')]/parent::div/descendant::span[@title]"));
		for (WebElement webElement : names) {
			String text = webElement.getText();
			String no="";
			for(int i=0;i<text.length();i++){
				if(text.charAt(i)>=48 && text.charAt(i)<=57){
					no=no+text.charAt(i);
				}
			}
			if(Integer.parseInt(no)<=10){
				wait.until(ExpectedConditions.elementToBeClickable(webElement));
				webElement.click();
				Thread.sleep(5000);
			}
		}
		List<WebElement> fnames = driver.findElements(By.xpath("//span[@class='boldFont blackText']"));
		List<WebElement> depTime = driver.findElements(By.xpath("//div[@class='flexOne timeInfoLeft']/descendant::span"));
		List<WebElement> depLocation = driver.findElements(By.xpath("//div[@class='flexOne timeInfoLeft']/descendant::font"));
		List<WebElement> dstTime = driver.findElements(By.xpath("//div[@class='flexOne timeInfoRight']/descendant::span[1]"));
		List<WebElement> dstLocation = driver.findElements(By.xpath("//div[@class='flexOne timeInfoRight']/descendant::font"));
		List<WebElement> fare = driver.findElements(By.xpath("//p[@class='blackText fontSize16 blackFont']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//		ExcelUtility excel=new ExcelUtility();
		Workbook book = WorkbookFactory.create(new FileInputStream(".\\Data\\TestData.xlsx"));
		Sheet sheet = book.getSheet("Sheet3");
		for (int i = 0; i < fnames.size(); i++) {
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(fnames.get(i).getText());
			row.createCell(1).setCellValue(depTime.get(i).getText());
			row.createCell(2).setCellValue(depLocation.get(i).getText());
			row.createCell(3).setCellValue(dstTime.get(i).getText());
			row.createCell(4).setCellValue(dstLocation.get(i).getText());
			row.createCell(5).setCellValue(fare.get(i).getText());

			book.write(new FileOutputStream(".\\Data\\TestData.xlsx"));
		}
//		for(int j=0;j<6;j++){
//		for(int i=0;i<fnames.size();i++){
//			
//			excel.setDataExcel("Sheet3", i, j, fnames.get(i).getText());
//			excel.setDataExcel("Sheet3", i, j, depTime.get(i).getText());
//			excel.setDataExcel("Sheet3", i, j, depLocation.get(i).getText());
//			excel.setDataExcel("Sheet3", i, j, dstTime.get(i).getText());
//			excel.setDataExcel("Sheet3", i, j, dstLocation.get(i).getText());
//			excel.setDataExcel("Sheet3", i, j, fare.get(i).getText());
//			
//		}
//		}
		System.out.println("DataUpdated");
	}

}

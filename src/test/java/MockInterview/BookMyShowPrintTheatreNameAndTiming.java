package MockInterview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShowPrintTheatreNameAndTiming {
	@Test
	public void FetchTheatreAndTime() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the movie name");
		String movieName=sc.nextLine();
		Thread.sleep(5000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://in.bookmyshow.com/explore/home/bengaluru");
		driver.findElement(By.xpath("//span[.='Search for Movies, Events, Plays, Sports and Activities']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']")).sendKeys(movieName);
		driver.findElement(By.xpath("//ul[@class='sc-sPYgB gVUFKz']/descendant::span[.='"+movieName+"']")).click();
		driver.findElement(By.xpath("//h1[contains(.,'"+movieName+"')]/following-sibling::div[@class='styles__CtaWrapper-sc-qswwm9-8 JInhj']/descendant::span")).click();
		try{
		driver.findElement(By.xpath("//div[@class='sc-1k6uqqy-0 gZyDCA']/descendant::span[contains(.,'IMAX')]")).click();;
		Thread.sleep(5000);
		}catch (Exception e) {
			try{
		driver.findElement(By.xpath("//button[.='Not Now']")).click();
			}catch (Exception e1){
			int date=03;
			driver.findElement(By.xpath("//div[@class='slick-list draggable']/descendant::div[@class='date-numeric' and contains(.,'"+date+"')]")).click();
			List<WebElement> names = driver.findElements(By.xpath("//a[@class='__venue-name']"));
			List<WebElement> timeings;
			Workbook book = WorkbookFactory.create(new FileInputStream(".\\Data\\TestData.xlsx"));
			Sheet sh = book.getSheet("BookMYshoW");
			for(int i=0;i<names.size();i++){
				Row row = sh.createRow(i);
				timeings = driver.findElements(By.xpath("//a[contains(.,'"+names.get(i).getText()+"')]/ancestor::div[@class='listing-info']/following-sibling::div/descendant::div[contains(@class,'showtime-pill-container')]"));
				row.createCell(0).setCellValue(names.get(i).getText());
				for(int j=0;j<timeings.size();j++){
					row.createCell(j+1).setCellValue(timeings.get(j).getText());
				}
				book.write(new FileOutputStream(".\\Data\\TestData.xlsx"));
			}
			book.close();
			driver.quit();
			}
		}
		}
}

package MockInterview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetcgAllProductsAmount {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone",Keys.ENTER);
		//scrollByActions
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)", "");
		
		driver.findElement(By.xpath("//input[@id='low-price']")).sendKeys("1000");
		driver.findElement(By.xpath("//input[@id='high-price']")).sendKeys("5000");
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
		
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='sg-col-inner']/descendant::span[@class='a-price-whole']"));
		
		LinkedList<String> plist=new LinkedList<String>();
		for(WebElement we:price){
			String str = we.getText();
			plist.add(str);
		}
		//SortPrice
		Collections.sort(plist);
		for(String amt:plist){
			System.out.println(amt);
		}
		Collections.reverse(plist);
		
		for(String amt:plist){
			System.out.println(amt);
		}
		driver.quit();
	}
			

}

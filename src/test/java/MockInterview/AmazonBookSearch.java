package MockInterview;

import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBookSearch {
	@Test
	public void validateBook() throws InterruptedException{
		
		
//		String s="i am computer";
//		String str = s.replace(" ","");
//		System.out.println(str);
//		for (int i = 0; i < s.length(); i++) {
//			if(s.charAt(i)!=' ')
//			{
//				System.out.print(s.charAt(i));
//			}
//			
//			
//		}
//	}t
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");		
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[.='Kindle E-Readers & eBooks']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.='Kindle Unlimited']")).click();
		Thread.sleep(5000);
		WebElement ele1 = driver.findElement(By.xpath("//a[@aria-label='Indian language eBooks']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[.='Tamil']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.ScrollBy(0,1000)", "");
		driver.findElement(By.xpath("//span[.='Travel & Tourism']")).click();
		List<WebElement> price = driver.findElements(By.xpath("//div[@data-cel-widget='search_result_0']/following-sibling::div/descendant::span[@class='a-price-whole']"));
		for(WebElement book:price){
			String amount = book.getText();
			if(amount=="99"){
				book.click();
				break;
			}
		}
	}
}

package MockInterview;

import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAllPhone {

	@Test(enabled=true)
	public void FetchAllPhone() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nokia 105",Keys.ENTER);
		String page = driver.findElement(By.xpath("//a[@aria-label='Go to page 5']")).getText();
		int no = Integer.parseInt(page);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
		int count=0;
		while(no>=1){
			Thread.sleep(15000);
//			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			List<WebElement> names = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
			System.out.println(names.size());
			for(WebElement ele:names){
				String name = ele.getText();
				count++;
				
				System.out.println(count+" "+name);
			}
			no--;
			if(no<1)break;
			driver.findElement(By.xpath("//a[contains(.,'Next')]")).click();
		}
		driver.quit();
	}
	@Test(enabled=true)
	public void FlipkartBook() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//img[@alt='Travel']")).click();
		String From="Bangalore";
		WebElement ele = driver.findElement(By.xpath("//input[@name='0-departcity']"));
		ele.sendKeys(From);
		WebElement ele1 = driver.findElement(By.xpath("//span[.='"+From+"']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1).click().perform();
		String To="Chennai";
		driver.findElement(By.xpath("//input[@name='0-arrivalcity']")).sendKeys(To);
		WebElement ele2 = driver.findElement(By.xpath("//span[.='"+To+"']"));
		act.moveToElement(ele2).click().perform();
		int day=5;
		List<WebElement> months = driver.findElements(By.xpath("//div[@class='PgmDJX']/descendant::div[@class='_1oqlzu']"));
		for(WebElement month:months){
			if(month.getText().equals("December 2022")){
				driver.findElement(By.xpath("//div[@class='PgmDJX']/descendant::div[contains(.,'Dec')]/ancestor::table/descendant::div/child::button[.='"+day+"']")).click();
			}
		}
		driver.findElement(By.xpath("//input[@name='0-travellerclasscount']")).click();
		driver.findElement(By.xpath("//div[.='Adults']/ancestor::div[@class='_1Di8FC']/descendant::button[@class='_2KpZ6l _34K0qG _37Ieie']")).click();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _1QYQF8 _3dESVI']")).click();
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	

}

package MockInterview;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAllPhone {

	@Test
	public void FetchAllPhone() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nokia 105",Keys.ENTER);
		String page = driver.findElement(By.xpath("//a[@aria-label='Go to page 5']")).getText();
		int no = Integer.parseInt(page);
		int count=0;
		while(no>=1){
			List<WebElement> names = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
//			count += names.size();
			for(WebElement ele:names){
				String name = ele.getText();
				if(name.contains("Nokia")){
				count++;
				Thread.sleep(2000);
				System.out.println(count+" "+name);
				}
			}
//			System.out.println(names.size());
			System.out.println(count);
			Thread.sleep(5000);
			no--;
			if(no<1)break;
			driver.findElement(By.xpath("//a[contains(.,'Next')]")).click();
		}
		driver.quit();
	}
	@Test
	public void FlipkartBook(){
		
	}
	
	

}

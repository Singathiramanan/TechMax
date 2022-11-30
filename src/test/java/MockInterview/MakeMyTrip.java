package MockInterview;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	@Test
	public void MakeMyTripTest(){
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
		String fmonth="Dec",fDate="01";
		driver.findElement(By.xpath("//div[@role='heading']/descendant::div[contains(.,'"+fmonth+"')]/ancestor::div[@role='heading']/following-sibling::div[@class='DayPicker-Body']/descendant::div[contains(@aria-label,'"+fmonth+" "+fDate+"')]")).click();
		driver.findElement(By.xpath("//div[@data-cy='returnArea']")).click();
		String month="Dec",Date="02";
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
			if(Integer.parseInt(no)<10){
				webElement.click();
			}
		}
		List<WebElement> fnames = driver.findElements(By.xpath("//div[@id='listing-id']/descendant::p[contains(.,'1 Dec')]/following-sibling::div[@class='listingCardWrap']/descendant::span[@class='boldFont blackText']"));
		List<WebElement> fare = driver.findElements(By.xpath("//div[@id='listing-id']/descendant::p[contains(.,'1 Dec')]/following-sibling::div[@class='listingCardWrap']/descendant::p[@class='blackText fontSize16 blackFont']"));
		for (int i = 0; i < fnames.size(); i++) {
			System.out.println(fnames.get(i).getText()+" "+fare.get(i).getText());
		}
	}

}

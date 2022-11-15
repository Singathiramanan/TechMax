package MockInterview;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pepperFry {
	@Test
	public void pepper() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://pepperfry.com/");
		String catagory="Decor";
		driver.findElement(By.xpath("//div[@id='regPopUp']/a[@class='popup-close']")).click();
		WebElement ele = driver.findElement(By.xpath("//div[@id='menu_wrapper']/descendant::a[contains(.,'"+catagory+"')]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		Thread.sleep(5000);
		String cat = catagory.toLowerCase();
		String maincat = "Wall Art";
		WebElement ele2 = driver.findElement(By.xpath("//div[@id='megamenu']/child::div[@id='meta-"+cat+"']/descendant::div[@class='headerHover__col headerHover__maincat']/descendant::a[contains(.,'"+maincat+"')]"));
		act.moveToElement(ele2).perform();	
		Thread.sleep(5000);
		String subcat="Wallpaper & Decals";
		WebElement ele3 = driver.findElement(By.xpath("//div[@id='megamenu']/child::div[@id='meta-"+cat+"']/descendant::div[@class='headerHover__col headerHover__subcat']/descendant::a[contains(.,'"+subcat+"')]"));
		act.moveToElement(ele3).click().build().perform();
		driver.findElement(By.xpath("//label[@for='brandsnameSpace_Of_Joy']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(.,'White')]")).click();
		driver.quit();
		
	}
	

}

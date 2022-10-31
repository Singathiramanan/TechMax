package MockInterview;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rtyui {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.automationtesting.in/Register.html");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Siva");
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kumar");
			driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("28/10,veerakkavalasu,palani.");
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Siva@gmail.com");
			driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("7010509040");
			driver.findElement(By.xpath("//input[@value='Male']")).click();
			driver.findElement(By.xpath("//input[@value='Cricket']")).click();
			driver.findElement(By.xpath("//multi-select")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[.='English']")).click();
			Select select=new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
			select.selectByVisibleText("APIs");
			Select select1=new Select(driver.findElement(By.xpath("//select[@id='country']")));
			select1.selectByVisibleText("India");
			Select syear=new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
			syear.selectByVisibleText("1998");
			Select smonth=new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
			smonth.selectByVisibleText("April");
			Select sdate=new Select(driver.findElement(By.xpath("//select[@placeholder='Day']")));
			sdate.selectByVisibleText("29");
			Actions act =new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//button[@id='submitbtn']")));
			driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("Siv@2904");
			driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("Siv@2904");
			driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
			
	
	}

}

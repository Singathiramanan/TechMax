package MockInterview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartMobiles {
	@Test(enabled=false)
	public void MobilesNames(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("redmi12pro plus");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='col col-7-12']/descendant::div[@class='_4rR01T']"));
		System.out.println(names.size());
		LinkedList<String> listname=new LinkedList<String>();
		for (WebElement name : names) {
			listname.add(name.getText());
		}
		Collections.sort(listname);
		for(String n1:listname){
			System.out.println(n1);
		}
		driver.quit();
		
	}
	@Test(enabled=false)
	public void MobilePrices(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("redmi12pro plus");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='col col-7-12']/descendant::div[@class='_4rR01T']"));
		System.out.println(names.size());
		LinkedList<String> listprice=new LinkedList<String>();
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='col col-5-12 nlI3QM']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		for(WebElement price:prices){
			listprice.add(price.getText());
			
		}
		Collections.sort(listprice);
		for(int i=0;i<listprice.size();i++){
			String str = listprice.get(i);
			String str1="";
			for(int j=0;j<str.length();j++){
				if(str.charAt(j)>='0'&&str.charAt(j)<='9'){
					str1+=str.charAt(j);
				}
			}
			System.out.println(str1);
		}
		driver.quit();
		
	}
	@Test(enabled=true)
	public void NamePrice(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("redmi12pro plus");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='col col-7-12']/descendant::div[@class='_4rR01T']"));
		System.out.println(names.size());
		LinkedList<String> listname=new LinkedList<String>();
		for (WebElement name : names) {
			listname.add(name.getText());
		}
		for (String string : listname) {
			String str="";
			String price = driver.findElement(By.xpath("//div[.='"+string+"']/ancestor::div[@class='col col-7-12']/following-sibling::div/descendant::div[@class='_30jeq3 _1_WHN1']")).getText();
			for(int i=0;i<price.length();i++){
				if(price.charAt(i)<='9'&&price.charAt(i)>='0'){
					str+=price.charAt(i);
				}
			}
			System.out.println(string+" "+str);
		}
		driver.quit();
		
	}
	@Test(enabled=false)
	public void MaxPriceMobileName(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("redmi12pro plus");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='col col-7-12']/descendant::div[@class='_4rR01T']"));
		System.out.println(names.size());
		LinkedList<String> listprice=new LinkedList<String>();
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='col col-5-12 nlI3QM']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		for(WebElement price:prices){
			listprice.add(price.getText());
			
		}
		Collections.sort(listprice);
		String str = listprice.get(listprice.size()-1);
		List<WebElement> maxp = driver.findElements(By.xpath("//div[.='"+str+"']/ancestor::div[@class='col col-5-12 nlI3QM']/preceding-sibling::div/descendant::div[@class='_4rR01T']"));
		for (WebElement webElement : maxp) {
			System.out.println(webElement.getText()+" "+str);
		}
		driver.quit();
		
	}
}

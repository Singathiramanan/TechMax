package org.sdet38.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo {
	public static void main(String[] args) {
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).perform();
		driver.findElement(By.xpath("//span[.='From']/following-sibling::p")).click();
		driver.findElement(By.xpath("//div[@class='sc-cidDSM dOEpbS']/input")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li[1]")).click();
		//driver.findElement(By.xpath("//span[.='To']/following-sibling::p")).click();
		driver.findElement(By.xpath("//div[@class='sc-cidDSM dOEpbS']/input")).sendKeys("Delhi");
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li[1]")).click();
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		 driver.findElement(By.xpath("//div[@aria-label='Thu Oct 13 2022']")).click();
		 driver.findElement(By.xpath("//p[.=' Click to add a return flight for better discounts']")).click();
		 driver.findElement(By.xpath("//div[@aria-label='Thu Oct 20 2022']")).click();
		 act.moveByOffset(10, 10).perform();
		 driver.findElement(By.xpath("//span[@class='sc-kfPuZi dprjVP fswDownArrow fswDownArrowTraveller']")).click();
		 driver.findElement(By.xpath("//a[@class='sc-dtMgUX daltrV']")).click();
		 driver.findElement(By.xpath("//span[@class='sc-fHeRUh jHgPBA']")).click();
		 
	}

}

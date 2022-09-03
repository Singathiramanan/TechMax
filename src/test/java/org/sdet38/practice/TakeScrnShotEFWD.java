package org.sdet38.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScrnShotEFWD {
	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://192.168.0.190/domain/Sales_And_Inventory_System/pages/login.php");
		// Date date=new Date();
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScrnShot/"+"sdfghj"+".png");
		FileUtils.copyFile(src, dst);

	}

}

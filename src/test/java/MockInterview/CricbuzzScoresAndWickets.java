package MockInterview;

import org.testng.annotations.Test;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CricbuzzScoresAndWickets {
	@Test
	public void Cricbuzz() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		String Status = "Won";
		String innings="innings_2";
		WebElement matches = driver.findElement(By.xpath("//nav[@class='cb-mat-mnu']/descendant::a[contains(text(),'"+Status+"')]"));
		matches.click();
		driver.findElement(By.xpath("//a[.='Scorecard']")).click();
		List<WebElement> batsman = driver.findElements(By.xpath(
				"//div[.='Batter']/ancestor::div[@id='"+innings+"']/descendant::div[@class='cb-col cb-col-100 cb-scrd-itms']/div/a"));
		List<WebElement> runs = driver.findElements(By.xpath(
				"//div[.='Batter']/ancestor::div[@id='"+innings+"']/descendant::div[@class='cb-col cb-col-100 cb-scrd-itms']/div[@class='cb-col cb-col-8 text-right text-bold']"));
		List<WebElement> bowler = driver.findElements(By.xpath(
				"//div[.='Bowler']/ancestor::div[@id='innings_2']/descendant::div[@class='cb-col cb-col-100 cb-scrd-itms ']/div/a"));
		List<WebElement> wickets = driver.findElements(By.xpath(
				"//div[.='Bowler']/ancestor::div[@id='innings_2']/descendant::div[@class='cb-col cb-col-100 cb-scrd-itms ']/div[@class='cb-col cb-col-8 text-right text-bold']"));
		LinkedHashMap<String, String> map1 = new LinkedHashMap<>();
		LinkedHashMap<String, String> map2 = new LinkedHashMap<>();

		for (int i = 0; i < runs.size(); i++) {
			map1.put(batsman.get(i).getText(), runs.get(i).getText());

		}
		for (int i = 0; i < bowler.size(); i++) {
			map2.put(bowler.get(i).getText(), wickets.get(i).getText());

		}
		
		System.out.println();
		System.out.println("--Batters--");
		System.out.println();
		for (Entry<String, String> sc1 : map1.entrySet()) {
			System.out.println(sc1.getKey() + "--->" + sc1.getValue());
		}
		System.out.println();
		System.out.println("--Bowler--");
		System.out.println();
		for (Entry<String, String> sc2 : map2.entrySet()) {
			System.out.println(sc2.getKey() + "--->" + sc2.getValue());
		}
		//driver.close();
		driver.navigate().to("https://www.cricbuzz.com/");
		
		
		driver.quit();

	}

}

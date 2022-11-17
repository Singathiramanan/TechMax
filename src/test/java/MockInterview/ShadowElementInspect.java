package MockInterview;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ShadowElementInspect {
	@Test
	public void ShadowElement(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		WebElement fele = driver.findElement(By.xpath("//iframe[@id='pact']"));
		driver.switchTo().frame(fele);
		Shadow shadow=new Shadow(driver);//io.github.sugku dependency
		shadow.findElement("#tea").sendKeys("yes");
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		WebElement ele = (WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
//		String str="arguments[0].setAttribute('value','yes')";
//		js.executeScript(str, ele);
//		WebElement ele1 = (WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"div > h4\")");
//		System.out.println(ele1.getText());
		
	}

}

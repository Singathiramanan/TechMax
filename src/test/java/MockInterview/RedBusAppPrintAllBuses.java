package MockInterview;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.TechMax.utility.ItestLisImpClass.class)
public class RedBusAppPrintAllBuses {
	@Test
	public void PrintAllBusestest(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		Reporter.log("Lanching the browser",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Reporter.log("maximizzing the browser",true);
		driver.manage().window().maximize();
		Reporter.log("lanching the URL",true);
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/descendant::li[.='Bangalore']")).click();

		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/descendant::li[.='Chennai']")).click();
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		int date=14;
		driver.findElement(By.xpath("//td[@class='current day']/ancestor::tbody/descendant::td[.='"+date+"']")).click();
		
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		
		String found = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		String[] no = found.split(" ");
		int total=Integer.parseInt(no[0]);
		Reporter.log("Fetching no of bus present "+total,true);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int count=0;
		List<WebElement> busNames = null;
		while(total!=count){
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		busNames = driver.findElements(By.xpath("//ul[@class='bus-items']/descendant::div[@class='travels lh-24 f-bold d-color']"));
		count=busNames.size();
		}
		int i=1;
		Reporter.log("Fetching bus names",true);
		for(WebElement ele:busNames){
			String BusName = ele.getText();
			Reporter.log(i+")"+BusName,true);
			i++;
		}
		if(count==total){
			Reporter.log("Bus count is matching",true);
		}else{
			Assert.fail();
		}
		
		/*ExtentSparkReporter spark=new ExtentSparkReporter("E:\\Disk2\\Eclipse\\TechMax\\ExtentReports/"+new JavaUtility().getSystemDateInIST()+".html");
		spark.config().setDocumentTitle("RedbusApplicationBusesFound");
		spark.config().setReportName("venkat");
		spark.config().setTheme(Theme.DARK);
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Reporter", "venkat");
		reports.setSystemInfo("Browser", "chrome");
		ExtentTest test = reports.createTest("Redbus");
		if(total==count){
			test.log(Status.PASS, "Testcase is passed");
			test.pass("Bus count is matching");
			reports.flush();
		}else{
			System.out.println();
			test.log(Status.FAIL, "Testcase is failed");
			test.fail("Bus count is mismatching");
			reports.flush();
		}*/
		driver.quit();
	}
}

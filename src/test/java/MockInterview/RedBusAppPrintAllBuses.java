package MockInterview;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.TechMax.utility.JavaUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.TechMax.utility.ItestLisImpClass.class)
public class RedBusAppPrintAllBuses {
	@Test
	public void PrintAllBusestest(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/descendant::li[.='Bangalore']")).click();

		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/descendant::li[.='Chennai']")).click();
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		int date=13;
		driver.findElement(By.xpath("//td[@class='current day']/ancestor::tbody/descendant::td[.='"+date+"']")).click();
		
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		String found = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		String[] no = found.split(" ");
		int total=Integer.parseInt(no[0]);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int count=0;
		List<WebElement> busNames = null;
		while(total!=count){
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		busNames = driver.findElements(By.xpath("//ul[@class='bus-items']/descendant::div[@class='travels lh-24 f-bold d-color']"));
		count=busNames.size();
		}
		int i=1;
		for(WebElement ele:busNames){
			String BusName = ele.getText();
			System.out.println(i+")"+BusName);
			i++;
		}
		if(count==total){
			System.out.println("Bus count is matching");
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

package sample;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympic {

	public static void main(String[] args) {
		System.out.println("Enter player name");
		Scanner sc=new Scanner(System.in);
		String Player=sc.next();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://olympics.com/en/");
		

	}

}

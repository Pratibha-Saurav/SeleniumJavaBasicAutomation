package com.selenium.SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.amazon.com");
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

	}

}

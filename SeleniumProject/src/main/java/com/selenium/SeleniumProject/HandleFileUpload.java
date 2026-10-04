package com.selenium.SeleniumProject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUpload {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1200)");
		
		
		//type=file should be present for browse, attach, upload file then only it will work. always use absolute path with \\ not with / - this is escape char in java
		driver.findElement(By.xpath("//*[@id=\"singleFileInput\"]")).sendKeys("C:\\Users\\com\\Downloads\\upload.PNG");   //selenium does not handle desktop window popup so cant click
		driver.findElement(By.xpath("//form[@id='singleFileForm']//button")).click();
	}

}

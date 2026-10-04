package com.selenium.SeleniumProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FullTest {

	public static void main(String[] args) throws InterruptedException {
		
		//browser launch - maximize, delete cookies, title validation
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Automation Testing Practice")) 
		{
			System.out.println("Correct Title");
		} else {
			System.out.println("Incorrect Title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Enter Name']")).sendKeys("Pratibha");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("sahid nagar, 15");
		driver.findElement(By.linkText("Udemy Courses"));
		driver.findElement(By.partialLinkText("Udemy"));
		driver.findElement(By.cssSelector("body > div.content > div.content-outer > div.fauxborder-left.content-fauxborder-left > div.content-inner > div.main-outer > div.fauxborder-left.main-fauxborder-left"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		
		//selecting dropdowns
		WebElement dropdownElement = driver.findElement(By.id("country"));
		Select select = new Select(dropdownElement);
		select.selectByVisibleText("India");
		Thread.sleep(3000);
		
		//alert
		driver.findElement(By.id("alertBtn")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		
		if(alertText.equals("I am an alert box!")) {
			System.out.println("correct alert");
		}else {
			System.out.println("incorrect alert");
		}
		alert.accept();
		
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1200)");
		
		//file upload
		driver.findElement(By.xpath("//input[@id='singleFileInput']")).sendKeys("C:\\Users\\com\\Downloads\\upload.PNG");
		driver.findElement(By.xpath("//form[@id='singleFileForm']//button")).click();
		
		
		
		
		
		
		
		
		
		

	}

}

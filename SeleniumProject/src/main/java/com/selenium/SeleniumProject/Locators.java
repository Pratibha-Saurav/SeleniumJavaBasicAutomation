package com.selenium.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Locators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Enter Name']")).sendKeys("Pratibha");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("sahid nagar, 15");
		driver.findElement(By.linkText("Udemy Courses"));
		driver.findElement(By.partialLinkText("Udemy"));
		driver.findElement(By.cssSelector("body > div.content > div.content-outer > div.fauxborder-left.content-fauxborder-left > div.content-inner > div.main-outer > div.fauxborder-left.main-fauxborder-left"));
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("windows.scrollBy(0, 500):");
		
		WebElement element = driver.findElement(By.id("country"));
		Select select = new Select(element);
		select.selectByVisibleText("India");

	}

}

package com.selenium.SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://qaplayground.com/practice/drag-drop");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait for page load and other elements to be visible
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		//dynamic id input
		//id- test_123
		//id- test_456
		
		//dynamic id starts-with
		//id- test_535
		//id- test_test_789_test
		
		//dynamic id ends-with
		//id- 1234_test_t
		//id- 23456_test_t
		
		driver.findElement(By.xpath("//input[contains(@id,'test_'")).click();
		driver.findElement(By.xpath("//input[starts-with(@id,'test_'")).click();
		driver.findElement(By.xpath("//input[ends-with(@id,'_test_t'")).sendKeys("abc");
	}

}

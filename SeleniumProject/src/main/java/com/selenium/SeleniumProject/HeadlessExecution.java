package com.selenium.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessExecution {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("apple")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		
		driver.findElement(By.id("input1")).sendKeys("Pratibha");
		driver.findElement(By.id("btn1")).click();
		System.out.println(driver.getPageSource());
	}

}

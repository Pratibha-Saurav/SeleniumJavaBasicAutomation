package com.selenium.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Automation Testing Practice")) 
		{
			System.out.println("Correct Title");
		} else {
			System.out.println("Incorrect Title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		
		
		
		
		
		
		
		
		
		
		//driver.close();
		//driver.quit();
	}

}

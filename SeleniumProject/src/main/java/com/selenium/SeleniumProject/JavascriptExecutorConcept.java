package com.selenium.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement startBtn = driver.findElement(By.name("start"));
		flash(startBtn, driver);

	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("background-color");
		for(int i=0; i<10; i++) {
			changeColor("rgb(0,200,0)", element,driver);
			changeColor(bgcolor, element,driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = arguments[1];", element, color);
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
		}
	}

}

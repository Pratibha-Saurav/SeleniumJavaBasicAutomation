package com.selenium.SeleniumProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorConcept {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement startBtn = driver.findElement(By.name("start"));
		flash(startBtn, driver);
		
		drawBorder(startBtn, driver);   //draw a border for highlighting a bug
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\priya\\git\\SeleniumJavaBasicAutomation\\SeleniumProject\\Resources\\bug.png"));
		
		generateAlert(driver, "There is an issue with start button");
		driver.switchTo().alert().accept();
		
		//click any element using Js
		WebElement newTab = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
		clickElementByJS(newTab, driver);
		
		//browser refresh with selenium
		driver.navigate().refresh();
		
		//browser refresh with js
		refreshBrowserByJS(driver);
		
		//get title by Js
		System.out.println(getTitleByJS(driver));
		
		//scroll page down
		//scrollPageDown(driver);
		
		//scroll to the particular element
		WebElement lenovo = driver.findElement(By.id("lenovo"));
		scrollIntoView(lenovo, driver);
		
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("background-color");
		for(int i=0; i<3; i++) {
			changeColor("rgb(0,200,0)", element,driver);
			changeColor(bgcolor, element,driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = arguments[1];", element, color);
		
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}


	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	}

package com.selenium.SeleniumProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		
		
		//1. alerts - javascript popup - Alert api(accept,dismiss)
		//2. file upload popup - browse/attach button - type=file, sendkeys(path)
		//3. browser window popup - advertisment popup - windowhandler api - getwindowhandles()
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		//Scrolls the page by a specific number of pixels relative to wherever the viewport currently is.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		
		driver.findElement(By.id("PopUp")).click();
		Thread.sleep(3000);
		
		Set<String> handler = driver.getWindowHandles();  //set objects
		Iterator<String> it = handler.iterator();   //cannot use for loop
		
		String parentWindowId = it.next();
		System.out.println(parentWindowId);
		
		String childWindowId = it.next();
		System.out.println(childWindowId);
		driver.switchTo().window(childWindowId);
		
		Thread.sleep(2000);
		System.out.println("Child Window Popup title:" +driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println("parent window title:" +driver.getTitle());
	}

}

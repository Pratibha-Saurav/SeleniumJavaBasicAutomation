package com.selenium.SeleniumProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupHandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.automationtesting.co.uk/popups.html");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//button[@onclick='popup()']")).click();
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		String ParentWindowId = it.next();
		System.out.println("Parent Window ID:"+ ParentWindowId);
		String ChildWindowId = it.next();
		System.out.println("Child Window ID:"+ ChildWindowId);
		
		driver.switchTo().window(ChildWindowId);
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs("Expected Title"));
		
		/*
		 * WebElement popup = driver.findElement(By.
		 * xpath("//p[contains(text(), 'This is a selenium popup window')]")); String
		 * actualText = popup.getText(); String expectedText =
		 * "This is a selenium popup window";
		 * 
		 * //Assert.assertEquals(actualText, expectedText,
		 * "The popup text did not match!"); Assert.assertTrue(popup.isDisplayed(),
		 * "The popup text did not match!");
		 */
		
		System.out.println("Child popup window url"+driver.getCurrentUrl());
		//System.out.println("Child popup window title"+driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(ParentWindowId);
		System.out.println("Parent window title"+driver.getTitle());
	}

}

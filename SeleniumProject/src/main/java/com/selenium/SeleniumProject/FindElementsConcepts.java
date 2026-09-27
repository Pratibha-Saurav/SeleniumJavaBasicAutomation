package com.selenium.SeleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcepts {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaplayground.com/practice/drag-drop");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		
		//size of linklist
		System.out.println(linkList.size());
		
		for(int i=0; i<linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);
		
		}
	}

}

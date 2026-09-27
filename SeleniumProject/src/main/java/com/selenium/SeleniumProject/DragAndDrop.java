package com.selenium.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaplayground.com/practice/drag-drop");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//div[@class='drag-drop-module__m7ivAa__draggableItem ']"))).moveToElement(driver.findElement(By.xpath("//div[@class='drag-drop-module__m7ivAa__dropZone  ']"))).release().build().perform();
		
		String dropText = driver.findElement(By.xpath("//span[@id='result-s01']")).getText();
		
		if(dropText.equals("Item dropped into zone ✓")) {
			
			System.out.println("item dropped successfully");
		
		}else {
			System.out.println("item not dropped");
		}
		
		

	}

}

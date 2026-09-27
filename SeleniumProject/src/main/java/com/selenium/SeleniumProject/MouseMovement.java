package com.selenium.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//div[@dir='auto' and normalize-space()='Add-ons']"))).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[normalize-space(.)='SpiceMax'])[1]")).click();
	}

}

package com.selenium.SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//isDispalyed() method applicable for all element
		boolean b1 = driver.findElement(By.name("start")).isDisplayed();
		System.out.println(b1);
		
		//isEnabled() method 
		boolean b2 = driver.findElement(By.id("btn1")).isEnabled();
		System.out.println(b2);
		
		//isSelected() method only applicable for checkbox, dropdown, radiobox
		boolean b3 = driver.findElement(By.xpath("//td[normalize-space()='$10.99']/following-sibling::td/input[@type='checkbox']")).isSelected();
		System.out.println(b3);

	}

}

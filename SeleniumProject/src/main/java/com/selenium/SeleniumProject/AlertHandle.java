package com.selenium.SeleniumProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		
		if(alertText.equals("I am an alert box!")) {		//alertText stored in string var then only can compare with .equals coz object can not be compared
			
			System.out.println("correct alert message");
		} else {
			System.out.println("incorrect alert message");
		}
		
		alert.accept();   //click ok
		//alert.dismiss(); //click cancel
		
	}

}

package com.selenium.SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Method 1
		
		//*[@id="productTable"]/tbody/tr[1]/td[2]
		//*[@id="productTable"]/tbody/tr[2]/td[2]
		//*[@id="productTable"]/tbody/tr[3]/td[2]
		//*[@id="productTable"]/tbody/tr[4]/td[2]
		//*[@id="productTable"]/tbody/tr[5]/td[2]
		
		
//		String before_xpath = "//*[@id=\"productTable\"]/tbody/tr[";
//		String after_xpath = "]/td[2]";		
//		
//		for(int i=1; i<=5; i++) {
//			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
//			System.out.println(name);
//			Thread.sleep(3000);
//			if(name.contains("Tablet")) {
//				//*[@id="productTable"]/tbody/tr[4]/td[2]
//				driver.findElement(By.xpath("//*[@id=\"productTable\"]/tbody/tr["+i+"]/td[4]/input")).click();
//			}
//		}
		
		//Method 2
		driver.findElement(By.xpath("//tr[td[contains(text(),'Smartwatch')] and td[contains(text(),'$7.99')]]//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//tr[td[contains(text(),'Laptop')]and td[contains(text(),'$19.99')]]//input[@type='checkbox']")).click();
	}

}

package com.selenium.SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.get("https://www.facebook.com/");
		
		clickOn(driver, driver.findElement(By.xpath("//span[text()='लॉग इन करें']")),Duration.ofSeconds(20));  //login button
		
	}
		public static void clickOn(WebDriver driver, WebElement locator, Duration i) {
			new WebDriverWait(driver, i).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
			locator.click();
		}
		
		
	}



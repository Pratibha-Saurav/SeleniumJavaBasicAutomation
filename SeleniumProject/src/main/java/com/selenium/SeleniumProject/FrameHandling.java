package com.selenium.SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameHandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.get("https://qaplayground.com/practice");
		
		driver.findElement(By.xpath("//a[@data-testid='new-practice-card-iframes']")).click();
		driver.switchTo().frame("basic-frame");   	//if there is a frame first we need to switch to that frame then perform the action
		driver.findElement(By.id("iframe-name-input")).sendKeys("Pratibha");
		driver.findElement(By.id("iframe-submit-btn")).click();
		driver.switchTo().defaultContent();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//iframe handle
		
		driver.switchTo().frame("form-frame");
		WebElement PrefLang = driver.findElement(By.id("iframe-lang-select"));
		Select select2 = new Select(PrefLang);
		select2.selectByVisibleText("Java");
		
		driver.findElement(By.id("iframe-agree-chk")).click();
		driver.findElement(By.id("iframe-save-btn")).click();
		driver.switchTo().defaultContent();
	}

}

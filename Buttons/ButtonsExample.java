package com.demoqaElements.Buttons;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonsExample {
WebDriver driver;
	
	@BeforeClass
	public void driverInitialize() {
		try {
	   driver = new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   driver.get("https://demoqa.com/");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void FunctionMethod() {
		try {
			//scrollDown
			JavascriptExecutor js1 = (JavascriptExecutor) driver;  
			js1.executeScript("window.scrollBy(0,250)", "");
				
			Thread.sleep(7000);
			//Elements	
			driver.findElement(By.xpath("//div[@class='card-body'][1]")).click();
			Thread.sleep(2000);
			//Button
			driver.findElement(By.xpath("//li[@id='item-4'][1]")).click();
			Thread.sleep(2000);
			
			//double_click
			WebElement double_click = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
			Actions act = new Actions(driver);
			act.doubleClick(double_click).perform();
			Thread.sleep(2000);
			
			//right_click
			WebElement right_click = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
			Actions action = new Actions(driver);
			action.contextClick(right_click).perform();
			Thread.sleep(2000);
			
			//click
			WebElement click_action = driver.findElement(By.xpath("//button[@id='doubleClickBtn']/../../div[3]/button"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", click_action);
			
			//Closing the Application
			driver.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
}

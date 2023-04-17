package com.demoqaElements.links;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Links_api_call_BadRequest {
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
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,250)", "");
				
			Thread.sleep(7000);
			//Elements	
			driver.findElement(By.xpath("//div[@class='card-body'][1]")).click();
			Thread.sleep(2000);
			//scrollDown
			JavascriptExecutor js1 = (JavascriptExecutor) driver;  
			js1.executeScript("window.scrollBy(0,250)", "");
			//Links
			driver.findElement(By.xpath("//li[@id='item-5'][1]")).click();
			Thread.sleep(2000);
			
			//Click_On_BadRequest_Link
			driver.findElement(By.linkText("Bad Request")).click();
			Thread.sleep(2000);
			
			//Closing Application
			driver.quit();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
}

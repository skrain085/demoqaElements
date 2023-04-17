package com.demoqaElements.WebTable;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTable_Add_New_User {

WebDriver driver;
	
	@BeforeMethod
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
			//ClickOn_WebTable
			driver.findElement(By.xpath("//li[@id='item-3'][1]")).click();
			Thread.sleep(2000);
			//Adding New User
			driver.findElement(By.id("addNewRecordButton")).click();
			Thread.sleep(2000);
			//EnterFirstName
			driver.findElement(By.id("firstName")).sendKeys("manu");
			Thread.sleep(2000);
			//EnterLastName
			driver.findElement(By.id("lastName")).sendKeys("Bavir");
			Thread.sleep(2000);
			//Enter_EmailAddress
			driver.findElement(By.id("userEmail")).sendKeys("manu.bavir@gmail.com");
			Thread.sleep(2000);
			//Enter_Age
			driver.findElement(By.id("age")).sendKeys("25");
			Thread.sleep(2000);
			//Enter_Salary
			driver.findElement(By.id("salary")).sendKeys("50000");
			Thread.sleep(2000);
			//Enter_Department
			driver.findElement(By.id("department")).sendKeys("Math");
			Thread.sleep(2000);
			//Click_On_Submit_Button
			driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	@AfterMethod
	public void closeApplication() {
		//Closing the Application
		driver.close();
	}
}



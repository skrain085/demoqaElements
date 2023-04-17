package com.demoqaElements.TextBox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxExample {

WebDriver driver;
	
	@BeforeClass
	public void driverInitialize() {
		try {
	   driver = new FirefoxDriver();
	   driver.manage().window().maximize();
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
		//TextBox
		driver.findElement(By.xpath("//li[@id='item-0'][1]")).click();
		Thread.sleep(2000);
		//fullName
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("sachin mahir");
		Thread.sleep(2000);
		//EmailAddess
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("sachinmahir@gmail.com");
		Thread.sleep(2000);
		//currentAddress
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("153,main street,Bangalore");
		Thread.sleep(2000);
		//permanentAddress
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("23,1st cross street,Bangalore");
		
		//scrollDown
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollBy(0,250)", "");
		
		Thread.sleep(2000);
		//submit
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		driver.close();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

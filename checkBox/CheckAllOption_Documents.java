package com.demoqaElements.checkBox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckAllOption_Documents {
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
			//checkBox
			driver.findElement(By.xpath("//li[@id='item-1'][1]")).click();
			Thread.sleep(2000);
			//Click on DownArrow to open the check box tree
			driver.findElement(By.xpath("//button[@title='Toggle']")).click();
			Thread.sleep(2000);
			//Click on CheckBox_Documents
			driver.findElement(By.xpath("//label[@for='tree-node-documents']/span")).click();
			Thread.sleep(2000);
			//close the Application
			driver.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
}

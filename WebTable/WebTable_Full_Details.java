package com.demoqaElements.WebTable;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTable_Full_Details {

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
			
			List <WebElement> table = driver.findElements(By.xpath("//div[@class='rt-table']"));
			
			 Iterator<WebElement> list = table.iterator();
			 while(list.hasNext()) {
				 System.out.print(list.next().getText());
			 }
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


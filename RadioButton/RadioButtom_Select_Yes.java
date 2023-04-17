package com.demoqaElements.RadioButton;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtom_Select_Yes {
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
			//RadioButton
			driver.findElement(By.xpath("//li[@id='item-2'][1]")).click();
			Thread.sleep(7000);
			//Click_Yes
			WebElement radioEle = driver.findElement(By.xpath("//input[@name='like'][@type='radio'][@id='yesRadio']"));
			boolean select = radioEle.isSelected();
			System.out.print(select);
			// performing click operation if element is not already selected
			if (select == false) {
				JavascriptExecutor js = (JavascriptExecutor) driver;  
				js.executeScript("arguments[0].click();", radioEle);
			}
			Thread.sleep(2000);
			
			//close the Application
			driver.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	}

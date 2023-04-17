package com.demoqaElements.BrokenImage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenImageExample {
	WebDriver driver;
	HttpURLConnection huc = null;
	int respCode = 200;
		
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
		public void FunctionMethod() throws InterruptedException {
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
				//BrokenLinks
				driver.findElement(By.xpath("//li[@id='item-6'][1]")).click();
				Thread.sleep(2000);
				//Finding webElement with tag a
				List <WebElement> list = driver.findElements(By.tagName("img"));
				
				for(WebElement value:list) {
					String url = value.getAttribute("src");
				System.out.println(url);
				
				
				if(url==null || url.isEmpty()) {
					System.out.println("URL is empty");
				}
				try {
					URL newurl = new URL(url);
					
					URLConnection urlConnection = newurl.openConnection();
					
					huc = (HttpURLConnection)(urlConnection);

					huc.setRequestMethod("HEAD");

					huc.connect();

					respCode = huc.getResponseCode();
					System.out.println(respCode);
				
				if(respCode>200) {
					System.out.println("It is a broken Image");
				}else {
					System.out.println("It is a valid Image");
				}
				
				
				}catch(MalformedURLException e) {
					System.out.println(e.getMessage());
				}
				
				}
				
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
	}
		
		@AfterMethod
		public void closeApplication() {
			//Closing the Application
			driver.close();
		}
}

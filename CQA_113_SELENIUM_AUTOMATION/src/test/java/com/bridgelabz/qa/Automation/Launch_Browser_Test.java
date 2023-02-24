package com.bridgelabz.qa.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Launch_Browser_Test {
	WebDriver driver;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void launch_browser(){	
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.findElement(By.name("login")).click();
		String title =driver.getTitle();
		System.out.println("Current page title is:"+title);
		String url =driver.getCurrentUrl();
		System.out.println("Current page URL is: "+url);
		String sourcecode =driver.getPageSource();
		System.out.println("Current page sourcecode is: "+sourcecode);
		driver.close();
	}
	
	@Test
	public void browser_navigation() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
	}	
}

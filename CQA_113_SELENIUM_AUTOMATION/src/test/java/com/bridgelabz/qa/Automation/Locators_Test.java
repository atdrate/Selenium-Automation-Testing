package com.bridgelabz.qa.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators_Test {
	WebDriver driver;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test
	public void locator(){	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
    	driver.findElement(By.id("email")).sendKeys("subodhnagalwade@gmail.com");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("SUBODH");
		driver.findElement(By.xpath("//input[@placeholder='Email address or phone number'][@aria-label='Email address or phone number']")).sendKeys("SUBODH");
		driver.findElement(By.xpath("//button[contains(@id,'u_0')]")).click();
		driver.findElement(By.xpath("//button[contains(@name,'log')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Email address or phone number']")).sendKeys("SUBODH");
		driver.findElement(By.name("pass")).sendKeys("SUBODH@12");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Forgotten password?")).click();
		driver.findElement(By.partialLinkText("Forgotten")).click();
	}

}

package com.bridgelabz.qa.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FB_Login_Test {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void loginFB() throws InterruptedException{	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("subodhnagalwade@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("subodh@197");
		driver.findElement(By.name("login")).click();
		Thread.sleep(7000);
		String actualtitle =driver.getTitle();
		System.out.println("Current page title is: "+actualtitle);
		String expectedtittle = "Log in to Facebook";
		System.out.println("expected page title is: "+expectedtittle);
		if(actualtitle.equals(expectedtittle))
		{
			System.out.println("Tittle validation success");	
		}
		else {
			System.out.println("Tittle validation failed");
		}
		driver.close();
	}

}

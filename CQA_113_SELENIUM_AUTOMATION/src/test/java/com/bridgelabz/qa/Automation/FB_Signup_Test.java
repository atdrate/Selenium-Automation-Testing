package com.bridgelabz.qa.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FB_Signup_Test {
WebDriver driver;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void signupFB() {	
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/r.php?locale=en_GB&display=page']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("SUBODH");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("nagalwade");
		driver.findElement(By.cssSelector("input[aria-label='Mobile number or email address']")).sendKeys("subodhnagalwade@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("subodhnagalwade@gmail.com");
		driver.findElement(By.cssSelector("input[data-type='password']")).sendKeys("SUBODH@12");	
		driver.findElement(By.id("day")).sendKeys("26");
		driver.findElement(By.id("month")).sendKeys("Feb");
		driver.findElement(By.name("birthday_year")).sendKeys("1997");
		driver.findElement(By.cssSelector("input[value='2']")).click();
		driver.findElement(By.xpath("//button[contains(@id,'u_0_s')]")).click();
	
	
	}
}

package com.bridgelabz.qa.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNg_Priority {
	WebDriver driver;

	@Test(priority = 1)
	public void open_Browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Launching Google Chrome browser");
		driver.get("https://www.facebook.com/login/");
	}

	@Test(priority = 2)
	public void login_Facebook() {
		driver.findElement(By.id("email")).sendKeys("subodhnagalwade@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("subodh@1");
		driver.findElement(By.name("login")).click();
		System.out.println("Login in to Facebook account");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 3, dependsOnMethods = "login_Facebook")
	public void watch_Notifications() {
		driver.findElement(By.xpath("//a[@href='/watch/?ref=tab']")).click();
	}

	@Test(priority = 4)
	public void close_Browser() {
		driver.close();
		System.out.println("Closing Google Chrome browser");
	}
}

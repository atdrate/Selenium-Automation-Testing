package com.bridgelabz.qa.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handling_Frames_Test {
	WebDriver driver;

	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void using_Index() throws InterruptedException {
		driver.get("file:///C:/Users/AZ/Desktop/Page2.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("t2")).sendKeys("Subodh");
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.id("t1")).sendKeys("Subodh2");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}

	@Test
	public void using_ID_Attribute_Of_Frame() throws InterruptedException {
		driver.get("file:///C:/Users/AZ/Desktop/Page2.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("t2")).sendKeys("Subodh");
		Thread.sleep(3000);
		driver.switchTo().frame("f1");
		Thread.sleep(3000);
		driver.findElement(By.id("t1")).sendKeys("Subodh2");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}

	@Test
	public void using_Name_Attribute_Of_Frame() throws InterruptedException {
		driver.get("file:///C:/Users/AZ/Desktop/Page2.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("t2")).sendKeys("Subodh");
		Thread.sleep(3000);
		driver.switchTo().frame("n1");
		Thread.sleep(3000);
		driver.findElement(By.id("t1")).sendKeys("Subodh2");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}

	@Test
	public void using_Address_Of_Frame() throws InterruptedException {
		driver.get("file:///C:/Users/AZ/Desktop/Page2.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("t2")).sendKeys("Subodh");
		Thread.sleep(3000);
		WebElement f = driver.findElement(By.className("c1"));
		driver.switchTo().frame(f);
		Thread.sleep(3000);
		driver.findElement(By.id("t1")).sendKeys("Subodh2");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}
}

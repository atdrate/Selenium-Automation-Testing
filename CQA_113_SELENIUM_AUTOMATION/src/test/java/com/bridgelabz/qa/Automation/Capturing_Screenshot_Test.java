package com.bridgelabz.qa.Automation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Capturing_Screenshot_Test {
	@Test
	public void screenshot() throws IOException{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
	WebDriver  driver=new ChromeDriver();
	driver.get("https://www.facebook.com/login/");
	driver.manage().window().maximize();
	driver.findElement(By.id("email")).sendKeys("SUBODH");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	File destinationFile = new File("./Screenshot/","facebook1"+".png");
	FileHandler.copy(sourceFile, destinationFile);
	driver.close();
	}
}

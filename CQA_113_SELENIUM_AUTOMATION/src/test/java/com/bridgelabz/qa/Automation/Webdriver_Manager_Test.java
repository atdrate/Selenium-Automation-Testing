package com.bridgelabz.qa.Automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdriver_Manager_Test {
	@Test
	public void webDriverManager_Test(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://bldev.bridgelabz.com/webinar");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement firstResult = new WebDriverWait(driver,Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
	}
}

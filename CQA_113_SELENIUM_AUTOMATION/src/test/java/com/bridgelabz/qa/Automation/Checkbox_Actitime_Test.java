package com.bridgelabz.qa.Automation;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Actitime_Test {
	WebDriver driver;

	@Test
	public void link_Presents() throws InterruptedException, IOException{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("manager");
		driver.findElement(By.xpath("//a[@href='javascript:void(0)']")).click();
		driver.findElement(By.id("container_tasks")).click();
		Thread.sleep(3000);
		List<WebElement> allCheckbox = driver.findElements(By.cssSelector("div[class='checkbox inactive']"));
		WebElement firstResult = new WebDriverWait(driver,Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='checkbox inactive']")));
		int totalCheckbox = allCheckbox.size();
		System.out.println("total number of checkboxes present on the web page is : "+totalCheckbox);
		Thread.sleep(5000);
		  for (WebElement checkbox : allCheckbox) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
		  }
		  Thread.sleep(5000);
	}	
}

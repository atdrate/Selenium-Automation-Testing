package com.bridgelabz.qa.Automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion_Google_Search_Test {
	@Test
	public void autoSuggestion() throws InterruptedException{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("selenium");
		List<WebElement> allOptions = 
		driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
		int count = allOptions.size();
		System.out.println("Number of values present in the dropdown is :"  + count);
		String expectedValue="selenium interview questions";
		for (WebElement option : allOptions) {
			String text = option.getText();
			System.out.println(" "+text);
			if (text.equalsIgnoreCase(expectedValue)) {
				option.click();
				break;
				}
		}
	
	}

}

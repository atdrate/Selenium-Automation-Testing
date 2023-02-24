package com.bridgelabz.qa.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validation_Test {
	WebDriver driver;

	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void tittle_validation() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String actualtitle = driver.getTitle();
		System.out.println("Current page title is: " + actualtitle);
		String expectedtittle = "Facebook – log in or sign up";
		System.out.println("expected page title is: " + expectedtittle);
		if (actualtitle.equals(expectedtittle)) {
			System.out.println("Tittle validation success");
		} else {
			System.out.println("Tittle validation failed");
		}
		driver.close();
	}

	@Test
	public void url_validation() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String actualurl = driver.getCurrentUrl();
		System.out.println("Current page url is: " + actualurl);
		String expectedurl = "https://www.facebook.com/";
		System.out.println("expected page url is: " + expectedurl);
		if (actualurl.equals(expectedurl)) {
			System.out.println("Url validation success");
		} else {
			System.out.println("Url validation failed");
		}
		driver.close();
	}

	@Test
	public void page_validation_using_web_element() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.name("email"));
		if (element.isDisplayed()) {
			System.out.println("Element is displayed successfully");
		} else {
			System.out.println("Element is not displayed");
		}
		driver.close();
	}

	@Test
	public void error_msg_validation_using_web_element() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("login")).click();
		String expectedError = "Find your account and log in.";
		WebElement element = driver.findElement(By.linkText("Find your account and log in."));
		String actualerror = element.getText();
		if (actualerror.equals(expectedError)) {
			System.out.println("Error validation success");
		} else {
			System.out.println("Error validation failed");
		}
		driver.close();
	}

	@Test
	public void password_Error_Message() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("subodh@gmail.com");
		driver.findElement(By.name("login")).click();
		String expectedError = "Forgotten password?";
		System.out.println("expected error is:" + expectedError);
		WebElement element = driver.findElement(By.linkText("Forgotten password?"));
		String actualError = element.getText();
		driver.close();
		if (actualError.equals(expectedError)) {

			System.out.println("error message is validated");

		}
		else {
			System.out.println("error message is not validated");
		}
	}

	@Test
	public void email_entered_isnt_connected_to_an_account() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("sruan");
		driver.findElement(By.name("pass")).sendKeys("sub24");
		driver.findElement(By.name("login")).click();
		String expectedError = "Find your account and log in.";
		System.out.println("expected error is:" + expectedError);
		WebElement element = driver.findElement(By.linkText("Find your account and log in."));
		String actualError = element.getText();
		driver.close();
		if (actualError.equals(expectedError))
		{
			System.out.println("error message is validated");
		} 
		else
		{
			System.out.println("error message is not validated");
		}
	}
}

package com.bridgelabz.qa.Automation;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Open_Browser_By_userInput_Test {
	WebDriver driver;
	@BeforeTest
	public void open_Browser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter browser  1-Chrome 2-Edge 3-Firefox ");
		char ch =sc.next().charAt(0);	
		
		switch(ch) {
		case '1':
			System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
			  driver=new ChromeDriver();
		    break;
		case '2':
			System.setProperty("webdriver.edge.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		    break;
		case '3':
			System.setProperty("webdriver.gecko.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		    break;
		    default:
		    	System.out.println("Enter valid browser  ");
		}
	}
	@Test
	public void loginFB(){	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("subodhnagalwade@gmail.com");
	}
}

package com.bridgelabz.qa.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScript_Executor_Test {
	WebDriver driver;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void enter_Text_Into_Disabled_Field() throws InterruptedException{	
		driver.get("file:///C:/Users/AZ/Desktop/Disabled_Field.html");
		driver.manage().window().maximize();
	    JavascriptExecutor js =(JavascriptExecutor) driver;
	    js.executeScript("document.getElementById('t1').value='Subodh'");
	    Thread.sleep(3000);
	    js.executeScript("document.getElementById('t2').value=''");
	    Thread.sleep(3000);
	    js.executeScript("document.getElementById('t2').value='CQA'");
	    Thread.sleep(3000);
	    js.executeScript("document.getElementById('t2').type='button'");
	    Thread.sleep(3000);
	}
	
	@Test
	public void scroll_Down_On_Web_Page() throws InterruptedException{	
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(3000);
	    js.executeScript("window.scrollBy(0,-500)");
	    Thread.sleep(3000);
	}
	
	@Test
	public void scroll_Down_till_Bottom_Of_Web_Page() throws InterruptedException{	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.linkText("Help"));
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X coordinate is " +x);
		System.out.println("Y coordinate is " +y);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		
	}
}

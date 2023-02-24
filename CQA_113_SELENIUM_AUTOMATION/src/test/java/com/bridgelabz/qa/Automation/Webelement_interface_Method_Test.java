package com.bridgelabz.qa.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Webelement_interface_Method_Test {
WebDriver driver;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test
	public void webelement_Clear_And_Sendkey_Method() throws InterruptedException{	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("subodhnagalwade@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("subodhnagalwade@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
	}
	
	@Test
	public void webelement_Click_Method() throws InterruptedException{	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
	}
	
	@Test
	public void get_size() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email"));
		Dimension size=email.getSize();
		System.out.println("Height="+size.getHeight());
	    System.out.println("Width="+size.getWidth());
	    driver.close();
	}
	
	@Test
	public void get_text() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement login=driver.findElement(By.name("login"));
		String text=login.getText();
		System.out.println("The text of given element is: "+text);
		driver.close();
	}
	
	@Test
	public void get_css_value() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
    	String csscolour=driver.findElement(By.name("login")).getCssValue("color");
      System.out.println(csscolour);
	}
	
	@Test
	public void get_TagName() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		 String tagname= driver.findElement(By.id("email")).getTagName();
		    System.out.println("Tagname-"+tagname);
	}
	
	@Test
	public void get_Location() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	    Point point= driver.findElement(By.id("email")).getLocation();
	    System.out.println("X: " +point.x);
	    System.out.println("y: " +point.y);
	}
	
	@Test
	public void get_Attribute() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	    String attri= driver.findElement(By.id("email")).getAttribute("type");
	    System.out.println("Attribute value is: " +attri);
	}
	
	@Test
	public void is_Enabled() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	    boolean e= driver.findElement(By.name("login")).isEnabled();
		System.out.println("isEnabled " +e);
	}
	
	@Test
	public void is_Displayed() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		boolean d= driver.findElement(By.name("login")).isDisplayed();
		System.out.println("isDisplayed " +d);
	}
	
	@Test
	public void is_Selected() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		boolean s= driver.findElement(By.name("login")).isSelected();
		System.out.println("isSelected " +s);
	}
}
	
	
	
	
	

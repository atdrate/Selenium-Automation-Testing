package com.bridgelabz.qa.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Action_Class_Method_Test {
	WebDriver driver;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void action_Class_Method() throws InterruptedException{	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	    Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.id("email"));
		actions.contextClick(element).perform();
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.id("pass"));
		Thread.sleep(3000);
		actions.moveToElement(element1).click().perform();
		Thread.sleep(3000);
		actions.doubleClick(element).perform();
		Thread.sleep(3000);	
	}
	
	@Test
	public void drag_And_Drop() throws InterruptedException{	
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
	    driver.switchTo().frame(0);
	    WebElement pick = driver.findElement(By.id("draggable"));
	    WebElement drop = driver.findElement(By.id("droppable"));
	    Thread.sleep(3000);
	    Actions actions = new Actions(driver);
	    actions.dragAndDrop(pick, drop).perform();
	    actions.clickAndHold(pick).perform();
	    actions.moveToElement(drop).release().perform();
	}
	
	@Test
	public void keyboard_Operation_Test() throws InterruptedException{	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	    Actions actions = new Actions(driver);
	    WebElement element = driver.findElement(By.id("email"));
	    actions.keyDown(Keys.SHIFT).perform();
	    actions.sendKeys("subodh");
	    actions.keyUp(Keys.SHIFT).perform();   
	}
}

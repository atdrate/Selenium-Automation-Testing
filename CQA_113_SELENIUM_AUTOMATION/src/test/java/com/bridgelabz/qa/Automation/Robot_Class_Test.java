package com.bridgelabz.qa.Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Robot_Class_Test {
	@Test
	public void mouse_and_Keyboard_Operation() throws AWTException,InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		WebDriver  driver=new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		Robot robot = new Robot();
		robot.mouseMove(300,500);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(3000);
		robot.mouseWheel(300);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_W);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_W);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

}

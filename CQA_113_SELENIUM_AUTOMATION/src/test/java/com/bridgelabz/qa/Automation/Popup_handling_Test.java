package com.bridgelabz.qa.Automation;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Popup_handling_Test {
WebDriver driver;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AZ\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void simple_Alert_popup_Test() throws InterruptedException{	
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);	
		Alert alert =  driver.switchTo().alert();
        alert.accept();	
	}
	
	@Test
	public void cinfirmation_Alert_popup_Test() throws InterruptedException{	
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(3000);	
		Alert alert =  driver.switchTo().alert();
        alert.accept();
	}
	
	@Test
	public void prompt_Alert_popup_Test() throws InterruptedException{	
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(3000);	
		Alert alert =  driver.switchTo().alert();
		alert.sendKeys("Subodh");
		Thread.sleep(3000);
        alert.accept();	
	}
	@Test
	public void hidden_Division_popup_Test() throws InterruptedException{	
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='flex flex-middle  t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thu Feb 02 2023']")).click();
	}
	
	@Test
	public void file_Upload_popup_Test() throws InterruptedException, IOException{	
		driver.get("https://www.freepdfconvert.com/pdf-to-word");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Choose PDF file")).click();
		Runtime.getRuntime().exec("C:\\Users\\AZ\\Documents\\Cqa_113.exe");	
	}
	
	@Test
	public void file_Upload_Using_Sendkey_Test() throws InterruptedException, IOException{	
		driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='file'][@multiple='']")).sendKeys("C:\\\\Users\\\\AZ\\\\Documents\\\\Cqa_113.exe");
		driver.findElement(By.xpath("//button[@type='button'][@ng-click='uploader.uploadAll()']")).click();	
	}
	
	@Test
	public void get_Window_ID_Test() throws InterruptedException{	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	    String windowid = driver.getWindowHandle();
	    System.out.println("Current window ID " +windowid);		
	}
		
	@Test
    public void child_Browser_Popup() throws InterruptedException {
        driver.get("https://www.irctc.co.in/nget/profile/user-registration");
        driver.manage().window().maximize();
        String parentId = driver.getWindowHandle();
        System.out.println("The current window id is: " + parentId);
        driver.findElement(By.xpath("//a[@aria-label='Menu Flight. Website will be opened in new tab']")).click();
        Set<String> allWindowID = driver.getWindowHandles();
        System.out.println("The current window id are: " + allWindowID);
        int count = allWindowID.size();
        System.out.println("The current window open by selenium are: " + count);
        for (String windowHandale : allWindowID) {
            driver.switchTo().window(windowHandale);
            String title = driver.getTitle();
            System.out.println("The tital is: " + title);
            if (windowHandale.equals(parentId)) {
                driver.close();
            }
        }
        driver.quit();
    }
	
}

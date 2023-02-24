package com.bridgelabz.qa.Automation;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_Download_Popup {

	@Test
	public void file_Download_using_firefox() throws InterruptedException, IOException{	
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		FirefoxProfile profile = new FirefoxProfile();
		String key = "browser.helperApps.neverAsk.saveToDisk";
		String value = "application/zip";
		profile.setPreference(key, value);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", "C:\\Users\\AZ\\Downloads");
		DesiredCapabilities cap =new DesiredCapabilities();
		 driver = new FirefoxDriver();
		driver.get("http://www.seleniumhq.org/download/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.8.0/selenium-java-4.8.0.zip']")).click();
		Thread.sleep(3000);
		driver.manage().window().maximize();	
	}
	
	@Test
	public void file_Download_using_Chrome() throws InterruptedException, IOException{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "C:\\Users\\AZ\\Downloads");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		DesiredCapabilities cap =  new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
	    driver = new ChromeDriver(); 
		driver.get("http://www.seleniumhq.org/download/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://github.com/SeleniumHQ/selenium/releases/download/selenium-4.8.0/selenium-java-4.8.0.zip']")).click();
		Thread.sleep(3000);
		
	
	}
}

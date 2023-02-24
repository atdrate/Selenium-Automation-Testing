package com.bridgelabz.qa.Automation;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link_Present_On_Webpage_Test {
	@Test
	public void link_Presents() throws InterruptedException, IOException{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int totalLinks = allLinks.size();
		System.out.println("total number of links present on the web page is : "+totalLinks);
		int visibleLinkCount = 0;
		int hiddenLinkCount = 0;
		for (WebElement link : allLinks) {
		if (link.isDisplayed()) {
		visibleLinkCount++;
		System.out.println(visibleLinkCount+" --> "+link.getText());
		}else{
		hiddenLinkCount++;
		}
		}
		System.out.println("Total number of visible links :" + visibleLinkCount);
		System.out.println("Total number of hidden links :" + hiddenLinkCount);
		driver.close();
	}
}

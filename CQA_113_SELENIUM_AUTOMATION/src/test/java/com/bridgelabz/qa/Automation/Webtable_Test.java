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

public class Webtable_Test {
	WebDriver driver;
	@Test
	public void webtable_Operation() throws InterruptedException, IOException{	
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("file:///C:/Users/AZ/Desktop/WebTable.html");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
		int totalRows = allRows.size();
		System.out.println("total number of rows present in the table is :"+ totalRows);
		List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
		int totalColumns = allColumns.size();
		System.out.println("Total number of columns in the table is :" + totalColumns);
		List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
		int totalCells = allCells.size();
		System.out.println("Total number of cells present in the table is :" + totalCells);
		int countNumberValue = 0;
		int sum=0;
		for (WebElement cell : allCells) {
		String cellValue = cell.getText();
		try{
		int number = Integer.parseInt(cellValue);
		System.out.print(" "+number);
		countNumberValue++;
		sum = sum+number;
		}catch (Exception e) {
		}
		}
		System.out.println("Total count of numeric values is :"+countNumberValue);
		System.out.println("Total sum of all the numeric values is :"+sum);
		driver.close();
	}
	
	@Test
    public void sum_Of_Marks() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
        driver.get("file:///C:/Users/AZ/Desktop/WebTable_StudentMarks.html");
        driver.manage().window().maximize();
        List<WebElement> marksCell = driver.findElements(By.xpath("/html/body/table/tbody/tr[2]/td[3]|/html/body/table/tbody/tr[3]/td[3]|/html/body/table/tbody/tr[4]/td[3]"));
        int totalCells = marksCell.size();
        System.out.println("Total Number of Cells Present in the Table are:" + totalCells);
        int countNumberValue = 0;
        int sum=0;
        for (WebElement cell : marksCell) {
        String cellValue = cell.getText();
        try{
        int number = Integer.parseInt(cellValue);
        System.out.println(""+number);
        countNumberValue++;
        sum = sum+number;
        }catch (Exception e) {
        }
        }
        System.out.println("Total count of numeric values is :"+countNumberValue);
        System.out.println("Total sum of all the Marks is :"+sum);
        
        WebElement element = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[3]"));
        String expectedMarks = "100";
        String actualMarks = element.getText();
        System.out.println("The Expected Marks are:" + expectedMarks);
        System.out.println("The Actual Marks are :" + actualMarks);
        driver.close();
        if (actualMarks.equals(expectedMarks)) 
        {
            System.out.println("Total Marks from table is same as sum of Marks" );
        } 
        else 
        {
            System.out.println("Total Marks from table is not same as sum of Marks");
        }
    }
}

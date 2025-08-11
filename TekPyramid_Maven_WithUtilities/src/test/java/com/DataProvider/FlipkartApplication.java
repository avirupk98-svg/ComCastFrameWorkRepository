package com.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlipkartApplication 
{
	@Test(dataProvider="getData")
	public void searchMultipleProducts(String brandName, String productName) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Search Text Box
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(brandName,Keys.ENTER);
		
		
		Thread.sleep(5000);
		driver.close();
		
		
		
		
		// : //span[@class='VU-ZEz']/../../../descendant::div[@class='Nx9bqj CxhGGd']
		
	//	Correct: //span[text()='DELL Inspiron Intel Core Ultra 5 125H - (16 GB/512 GB SSD/Windows 11 Home) Inspiron 16 Plus Laptop']/../../../div[4]/div[1]/div[1]/div[1]
		
		//Better: //span[contains(text(),'DELL Inspiron 15 MSO')]/../../../descendant::div[contains(text(),'₹')]
		
		//Souvik's Xpath( From Product List): //div[.='Samsung Guru Music 2 B310ED']/ancestor::div[@class='yKfJKb row']/descendant::div[@class='Nx9bqj _4b5DiR']
	}
	
	@DataProvider
	public Object[][] getData()
	
	{
		Object[][] objArray=new Object[2][2];
		objArray[0][0]="Samsung";
		objArray[0][1]="Samsung Galaxy F05 (Twilight Blue, 64 GB)";
		
		objArray[1][0]="Samsung";
		objArray[1][1]="";
		
		return objArray;
		
	}
}

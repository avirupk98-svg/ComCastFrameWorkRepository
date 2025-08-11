package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CarDekho {
	
	@Test
	public void CarDekhoCarPrintTest()
	
		{
		
		WebDriver driver=new ChromeDriver();
		
		
		
		//li[@class='gsc_col-xs-12 gsc_col-sm-5 gsc_col-md-3']
		
		//h2[text()='Electric cars']/descendant::li[@class='gsc_col-xs-12 gsc_col-sm-5 gsc_col-md-3']
		
		//All electric cars:
		//h2[normalize-space()='Electric cars']/following-sibling::div/descendant::div[contains(@class,'contentHold') and contains(@class,'gsc_row')]/descendant::div[@class='card shadowWPadding posR ']
		
		driver.get("https://www.cardekho.com/");
		
		driver.manage().window().maximize();
		
		//1st xpath
		//List<WebElement> electricCars=driver.findElements(By.xpath("//h2[normalize-space()='Electric cars']/following-sibling::div/descendant::div[contains(@class,'contentHold') and contains(@class,'gsc_row')]/descendant::div[@class='card shadowWPadding posR ']"));
		
		//2nd XPath
		
		List<WebElement> electricCars=driver.findElements(By.xpath("//h2[text()='Electric cars']/following-sibling::div/descendant::li[@class='gsc_col-xs-12 gsc_col-sm-5 gsc_col-md-3']"));
		
		for(int i=0;i<3;i++)
		{
			WebElement eachCar=electricCars.get(i);
			WebElement eachCarName=eachCar.findElement(By.xpath(".//a[@class='slink  title ']"));
			
			WebElement eachCarPrice=eachCar.findElement(By.xpath("//div[@class='price']"));
			
			System.out.println("Electric Car Name is : "+eachCarName.getAttribute("Title"));
			
			System.out.println("Electric Car Price is : "+eachCarPrice.getText());
			
			System.out.println("******************");
			
			
			
		}
		}
	}



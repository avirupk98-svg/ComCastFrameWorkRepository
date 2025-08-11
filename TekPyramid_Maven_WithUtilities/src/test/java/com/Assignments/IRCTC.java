package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IRCTC {
	
	@Test
	
		public void IRCTC()
		{
			WebDriver driver=new ChromeDriver();
			
			driver.get(null);
			
			List<WebElement>trains= driver.findElements(By.xpath("//div[@class='col-sm-5 col-xs-11 train-heading']"));
			
			
			
			
			
			
			
			
		}
	

}

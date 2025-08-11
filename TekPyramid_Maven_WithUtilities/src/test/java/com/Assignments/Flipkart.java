package com.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart {
	
	//parallel execution in xml syntax along with listener implementation
	
	@Test
	public void FlipkartTest() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='Electronics']")).click();
	
		//h2[@class='T1JLc9' and text()='Laptops']/following-sibling::div[@class='QK95RB']
	
		//driver.findElement(By.xpath("//h2[@class='T1JLc9' and text()='Laptops']/following-sibling::div[@class='QK95RB']")).click();
	
		//driver.findElement(By.xpath("//h2[@class='T1JLc9' and text()='Laptops']/following-sibling::div[@class='QK95RB']")).click();
		
		driver.findElement(By.xpath("//span[@class='TSD49J' and text()='Electronics']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@title='Laptops']")).click();
//		
//		//a[@class='wjcEIp']|//div[@class='Nx9bqj']
//		
//		
//		//List<WebElement> products= driver.findElements(By.xpath("//a[@class='wjcEIp']|//div[@class='Nx9bqj']"));
//		
//		//List<WebElement> products= driver.findElements(By.xpath("//a[@class='wjcEIp']|//div[@class='Nx9bqj']|//div[@class='XQDdHH']"));
//		
//		//a[@class='wjcEIp']|//div[@class='Nx9bqj']|//div[@class='XQDdHH'] 
		
		
		
// Correct Code: 1st approach with pipeline operator
//		
//		List<WebElement> products= driver.findElements(By.xpath("//a[@class='wjcEIp']|//div[@class='Nx9bqj']|//div[contains(@class,'XQDdHH')]"));
//	
//		for(WebElement product:products)
//		{
//			System.out.println(product.getText());
//		}
		
		
		//2nd Approach (incomplete)
		
//		List<WebElement> names = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
//		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));
//		List<WebElement> ratings = driver.findElements(By.xpath("//div[@class='XQDdHH']"));
		
		
		//2nd Approach Proper start
		
		List<WebElement> productsAll=driver.findElements(By.xpath("//div[@class='slAVV4 qt3Pmj']"));
		
		System.out.println("All Laptop Details");
		
//		for( int i=1;i<=productsAll.size();i++)
//		{
//			WebElement productName= driver.findElement(By.xpath("(//div[@class='slAVV4 qt3Pmj']/descendant::a[@class='wjcEIp'])["+i+"]"));
//			WebElement productPrice= driver.findElement(By.xpath("(//div[@class='slAVV4 qt3Pmj']/descendant::div[@class='Nx9bqj'])["+i+"]"));
//		//	WebElement productRating= driver.findElement(By.xpath("//div[@class='slAVV4 qt3Pmj']/descendant::div[contains(@class,'XQDdHH')]"));
//			
//			System.out.println("***********************");
//			System.out.println("Laptop Name: "+ productName.getAttribute("Title"));
//			
//			System.out.println("Laptop Price: "+ productPrice.getText());
//			
			
		//	System.out.println("Laptop Rating: "+ productRating.getText())

			
//		}
//		
		
		
		for(WebElement product: productsAll)
		{
			WebElement productName=product.findElement(By.xpath(".//a[@class='wjcEIp']"));
			WebElement productPrice=product.findElement(By.xpath(".//div[@class='Nx9bqj']"));
			
			
			
		  System.out.println("Product Name is : "+ productName.getAttribute("title"));
		  System.out.println("Product Price is : "+ productPrice.getText());
		  
		  
		  try {
			  
			  WebElement rating= product.findElement(By.xpath(".//div[contains(@class,'XQDdHH')]"));
			  
			  System.out.println("Product Rating is : "+ rating.getText());
		  }
		  
		  catch(NoSuchElementException e){
			  System.out.println("This product has no rating");
		  }
		  
		  System.out.println("******************************");
		  
		  
			
			
			//
		}
	
		
//
//		
//		
//		}
//		
//		
//		
		
		
		
		
	}		
		
		
	}



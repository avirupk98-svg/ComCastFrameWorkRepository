package com.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VTigerLogin_DataProviderFromDifferentClass_Test{
	
	@Test(dataProvider="loginData", dataProviderClass =DataProvider_Test.class)
	public void Login(String userName, String password)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
	//Sending Username and Password
		
		driver.findElement(By.name("user_name")).sendKeys(userName);	
		
		driver.findElement(By.name("user_password")).sendKeys(password);	
		
		
		driver.findElement(By.id("submitButton")).click();
		
		
	}

}

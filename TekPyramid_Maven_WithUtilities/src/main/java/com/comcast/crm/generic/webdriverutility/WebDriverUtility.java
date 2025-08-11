package com.comcast.crm.generic.webdriverutility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	//***DropDown Select
	public void selectDropDown(WebElement ele, String text)
	{
		
		Select ss=new Select(ele);
		
		ss.selectByVisibleText(text);
			
	}
	
	//***DropDown Select
	public void selectDropDown(WebElement ele, int index)
	{
		Select ss=new Select(ele);
		
		ss.selectByIndex(index);
		
		
		
	}
	//***DropDown Select
	public void selectDropDownPartialText(WebElement ele, String text)
	{
		Select ss=new Select(ele);
		
		ss.selectByVisibleText(text);
		
		
		
	}
	
	public void switchToTabOnTitle(WebDriver driver, String titlePartial)
	{
		Set<String> windows=  driver.getWindowHandles();	
		for(String indWindow: windows)
		{
			driver.switchTo().window(indWindow);
			
			
			String currentTitle=driver.getTitle();
			
			if(currentTitle.contains(titlePartial))
					{
						break;
					}
		}
		 

}
	
	public void switchToTabOnURL(WebDriver driver, String PartialURL)
	{
		Set<String> windows=  driver.getWindowHandles();	
		for(String indWindow: windows)
		{
			driver.switchTo().window(indWindow);
			
			
			String currentURL=driver.getCurrentUrl();
			
			if(currentURL.contains(PartialURL))
					{
						break;
					}
		}
		 

}


	
	

}

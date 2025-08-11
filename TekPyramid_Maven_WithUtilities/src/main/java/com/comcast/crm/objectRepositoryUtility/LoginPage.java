package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 

{	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	//	PageFactory.initElements(driver, this);
		
		PageFactory.initElements(driver,this);
		
		
	}
	
	//Elements that are required inside Login Page
	@FindBy(name="user_name")
		private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement passWord;
	
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public void login()
	{
		userName.sendKeys("admin");
		passWord.sendKeys("admin");
		loginButton.click();
		
	}
	
}

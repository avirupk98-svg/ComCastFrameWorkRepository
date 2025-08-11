package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Plus Icon Element
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactLink;
	
	public WebElement getCreateContactLink() {
		return CreateContactLink;
		
		
	}

}

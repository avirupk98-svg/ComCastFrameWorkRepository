package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{	
	WebDriver driver;
	public ContactInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_First Name']")
	private WebElement FirstName;
	
	//@FindBy(xpath="//span[@id='dtlview_Last Name']")
	@FindBy(xpath="//td[@id='mouseArea_Last Name']")
	private WebElement LastName;
	
	@FindBy(xpath="//span[@id='dtlview_Support Start Date']")
	private WebElement SupportStartDate;
	
	@FindBy(xpath="//span[@id='dtlview_Support End Date']")
	private WebElement SupportEndDate;
	public WebElement getFirstName() {
		return FirstName;
	}



	public WebElement getLastName() {
		return LastName;
	}

	

	public WebElement getSupportStartDate() {
		return SupportStartDate;
	}

	public WebElement getSupportEndDate() {
		return SupportEndDate;
	}
	
}

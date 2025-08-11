package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPopUpPage {
	
	WebDriver driver;
	String orgName;
	public OrganizationsPopUpPage(WebDriver driver)
	{
		this.driver=driver;
		driver.manage().window().maximize();
		
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchButton;
	
//	@FindBy(xpath="//a[text()='"+orgName+"']")
//	private WebElement organizationNameLink;
	
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}

	public void searchOrganization(String orgName)
	{
		searchTextBox.sendKeys(orgName);
		searchButton.click();
		
	}
}

package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage {
	
	WebDriver driver;
	WebDriverUtility wdLib=new WebDriverUtility();
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//input[@name='accountname']")
		private WebElement OrganizationNameInput;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneNumberInput;
	
	public WebElement getOrganizationNameInput() {
		return OrganizationNameInput;
	}



	public WebElement getSaveButton() {
		return saveButton;
	}


	@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
	
	@FindBy(name="industry")
	 private WebElement industryDropDown;
	
	
	
	
	
	

	public void createOrganization(String orgName)
	{
		OrganizationNameInput.sendKeys(orgName);
		
		saveButton.click();
	}
	
	public void createOrganization(String orgName, String industry)
	{
		OrganizationNameInput.sendKeys(orgName);
		
		wdLib.selectDropDown(industryDropDown, industry);
		
		saveButton.click();
	}
	
	public void createOrganization1(String orgName, String PhoneNumber)
	{

		OrganizationNameInput.sendKeys(orgName);
		
		phoneNumberInput.sendKeys(PhoneNumber);
		
		saveButton.click();
		
	}
	
	
	
	
	
	
}


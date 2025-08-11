package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Elements on the page
	
	//Header Text
	WebDriver driver;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement OrgNameVerify;
	
	@FindBy(xpath="//span[@id='dtlview_Industry']")
	private WebElement IndustryNameVerify;
	
	
	
	
	
	//Verify Header Text
	public Boolean verifyHeaderMessage(String orgName)
	{
		String header=headerText.getText();
		return header.contains(orgName);
	}
	

	public WebElement getHeaderText() {
		return headerText;
		
		
	}
	
	public WebElement getOrgNameVerify() {
		return OrgNameVerify;
	}


	public WebElement getIndustryNameVerify() {
		return IndustryNameVerify;
	}
	
	
	
}

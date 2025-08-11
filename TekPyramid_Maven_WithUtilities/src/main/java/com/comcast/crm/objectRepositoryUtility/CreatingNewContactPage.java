package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewContactPage {
	
	WebDriver driver;
	WebDriverUtility wdLib=new WebDriverUtility();
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastNameTextBox;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath="//input[@name='support_start_date']")
	private WebElement supportStartDate;
	
	@FindBy(xpath="//input[@name='support_end_date']")
	private WebElement supportEndDate;
	
	//OrganizationName_Plus Icon
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif' and @alt='Select'])[1]")
	private WebElement OrgNamePlusIcon;
	
	
	
	public WebElement getOrgNamePlusIcon() {
		return OrgNamePlusIcon;
	}



	



	public WebElement getSupportStartDate() {
		return supportStartDate;
	}



	public WebElement getSupportEndDate() {
		return supportEndDate;
	}



	public WebElement getLastNameTextBox() {
		return LastNameTextBox;
	}

	

	public WebElement getSaveButton() {
		return saveButton;
	}
	
		
		
	

	
	public void createContact(String lastName)
	{
		LastNameTextBox.sendKeys(lastName);
		saveButton.click();
	}
	
	public void createContact(String lastName, String SupportDate, String EndDate)
	{
		supportStartDate.clear();
		LastNameTextBox.sendKeys(lastName);
		supportStartDate.sendKeys(SupportDate);
		supportEndDate.clear();
		supportEndDate.sendKeys(EndDate);
	}
	
	public void createContactWithOrganization(String lastName, String orgName ) throws InterruptedException
	{
		LastNameTextBox.sendKeys(lastName);
		String parentWindow=driver.getWindowHandle();
		OrgNamePlusIcon.click();


		wdLib.switchToTabOnURL(driver,"Accounts&action");
		
		// On the child window

				OrganizationsPopUpPage orgPopUp = new OrganizationsPopUpPage(driver);

				// Sending Organization NAME IN THE Search Textfield

				orgPopUp.getSearchTextBox().sendKeys(orgName);

				Thread.sleep(3000);

				// Clicking on the'Search' Button

				orgPopUp.getSearchButton().click();

				driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
				
				

				driver.switchTo().window(parentWindow);

		
	}

	
	
	
	
	
}

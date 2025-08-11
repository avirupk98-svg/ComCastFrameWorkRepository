package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//	@FindBy(xpath="//a[text()='Organizations' and @href='index.php?module=Accounts&action=index']")
//	 	private WebElement OrganizationTab;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
		private WebElement orgLink;
	
	@FindBy(xpath="//a[text()='Contacts']")
		private WebElement contactLink;
	
	@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement SignOutLink;
	
	public WebElement getSignOutLink() {
		return SignOutLink;
	}



	public WebElement getUserProfileIcon() {
		return UserProfileIcon;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement UserProfileIcon;
		
	
	

	public WebElement getContactLink() {
		return contactLink;
	}



	public WebElement getOrgLink() {
		return orgLink;
	}
	
	public void logOut() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(UserProfileIcon).perform();
		Thread.sleep(3000);
		SignOutLink.click();
	}
	
}

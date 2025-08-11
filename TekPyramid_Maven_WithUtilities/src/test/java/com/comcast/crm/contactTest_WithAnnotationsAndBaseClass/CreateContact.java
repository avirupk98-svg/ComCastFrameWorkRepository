package com.comcast.crm.contactTest_WithAnnotationsAndBaseClass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.objectRepositoryUtility.ContactInformationPage;
import com.comcast.crm.objectRepositoryUtility.ContactsPage;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsPopUpPage;

public class CreateContact extends BaseClass {
	
	@Test
	

	public void creatContactTest() throws EncryptedDocumentException, IOException
	{
		
			
		//Click on Contacts tab on the HomePage
		
		ExcelUtility eLib1=new ExcelUtility();	
		HomePage hp=new HomePage(driver);
		
		hp.getContactLink().click();
		
		//Click on 'Create Contact' icon (Plus Icon)
		
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactLink().click();
		
	   //Read TestScript Data from Excel
		
		String lastName=eLib1.getDataFromExcel("VTiger_Contact", 3, 2)+jLib.getRandomNumber();
		
		 System.out.println(lastName);
		 
		 CreatingNewContactPage cnp= new CreatingNewContactPage(driver);
		 
		 cnp.createContact(lastName);
		 
		 
		 
		 //Verify the TestCase
		 
		 String actualLastName= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 
		 //Verifying the Header message on OrganizationInformation Page 
		 
		 System.out.println("Verification 1");
		 if(actualLastName.contains(lastName))
		 {
			 System.out.println(lastName+" is displayed in the Header==PASS");
		 }
		 
		 else
			 
		 {
			 System.out.println(lastName+" is NOT displayed in the Header==FAIL");
		 }
			 
		 //Verifying textBox on OrganizationInformation Page 
		 
		String actualLastName1= driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		 
		 System.out.println("Verification 2");
		 
			 if(actualLastName1.equals(lastName))
			 {
				
				 System.out.println(lastName+" is getting displayed on the TextBox on OrganiationInformation page==PASS");
			 }
			 else
				 System.out.println(lastName+" is NOT getting displayed on the TextBox on OrganiationInformation page==FAIL");

}

	
	@Test
	public void createContactWithSupportDate_TC5()
			throws EncryptedDocumentException, IOException, InterruptedException {

		// Click on Contacts tab on the HomePage

		HomePage home = new HomePage(driver);
		home.getContactLink().click();

		// Click on 'Create Contact' icon (Plus Icon)

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactLink().click();

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=' '", ccp.getSupportEndDate());

		// Read TestScript Data from Excel

		ExcelUtility eLib = new ExcelUtility();
		String lastName = eLib.getDataFromExcel("VTiger_Contact", 6, 2);

		// Generating random number

		int random = jLib.getRandomNumber();

		// Contact Name with random number

		String lastName_New = lastName + random;

		// Add Support Start Date and Support End Date

//		ccp.getSupportStartDate().sendKeys(Keys.CONTROL, "a");
//		ccp.getSupportStartDate().sendKeys(Keys.DELETE);

		String date = jLib.getDate();

		String futureDate = jLib.getRequiredDate(30);

		ccp.createContact(lastName_New, date, futureDate);

		// Click on Save

		ccp.getSaveButton().click();

		// Verify the TestCase

		// String headerInfo=
		// driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		// Verifying textBox on Contact Information Page

		ContactInformationPage cip = new ContactInformationPage(driver);
		WebElement lastName_cip = cip.getLastName();

		
		  WebElement supportEndDate_cip=cip.getSupportEndDate(); WebElement
		  supportStartDate_cip=cip.getSupportStartDate();
		  
		  
		  String lastName_actual=lastName_cip.getText();
		  
		  String supportEndDate_actual=supportEndDate_cip.getText();
		  
		  String supportStartDate_actual=supportStartDate_cip.getText();
		  
		  System.out.println("Verifying TestCase 5");
		  
		  if (supportEndDate_actual.equals(futureDate)) {
		  System.out.println(supportEndDate_actual+" Support End Date matches with given date==Pass"); }
		  else
		  { System.out.println("Support End Date doesn't match with given date==FAIL");
		  }
		  
		  if (supportStartDate_actual.equals(date)) {
		  System.out.println(supportStartDate_actual+" Support Start Date match with given date==Pass"); } 
		  else
		  {
		  System.out.println("Support Start Date doesn't match with given date==FAIL");
		  }
		  
		  
		  Thread.sleep(10000); driver.close();
		  
		 		 
	}

	@Test
	public void CreateContactWithOrganization_Integration_TC06()
			throws EncryptedDocumentException, IOException, InterruptedException {

		int random1 = jLib.getRandomNumber(); // ***Used JavaUtility method

		// Creating Organization

		String orgName = eLib.getDataFromExcel("VTiger_Contact", 9, 2) + random1;

		// Click on Organizations tab on the HomePage

		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();
		

		// Click on 'Create Organization' icon (Plus Icon)

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();

		// New Page : Creating New Organization Page
		CreateNewOrganizationPage newOrganization = new CreateNewOrganizationPage(driver);
		newOrganization.createOrganization(orgName);
		

		
	

		
		// Read TestScript Data from Excel

		String lastName = eLib.getDataFromExcel("VTiger_Contact", 9, 3) + jLib.getRandomNumber();
		
		
		Thread.sleep(3000);
		
		homePage.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactLink().click();
		
		
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);

		cnp.createContactWithOrganization(lastName, orgName);
		
		cnp.getSaveButton().click();

		// Verify

		System.out.println("Verification for CreateContactWithOrganization_Integration_TC06");

		WebElement orgNameData = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']"));

		String orgNameActual = orgNameData.getText();
		
		System.out.println(orgNameActual);
		
		System.out.println(orgName);

		Thread.sleep(2000);
		if (orgNameActual.contains(orgName)) {
			System.out.println(orgName + "is displayed coorectly==PASS");
		} else {
			System.out.println(orgName + "is NOT displayed coorectly==FAIL");
		}

	}


}

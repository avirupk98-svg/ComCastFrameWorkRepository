package com.comcast.crm.orgTest_WithAnnotationsAndBaseClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.listenerUtility.ListenerImplClass;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateOrganization extends BaseClass {

	@Test
	public void CreateOrganizationTC1() throws EncryptedDocumentException, IOException, InterruptedException {

		// Generating random number

		int random1 = jLib.getRandomNumber(); // ***Used JavaUtility method

		ListenerImplClass.test.log(Status.INFO, "Reading data from Excel");
		String OrgName = eLib.getDataFromExcel("Vtiger_Org", 3, 2) + random1;
		
		
		System.out.println(OrgName);

		// Click on Organizations tab on the HomePage

		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();
		
		ListenerImplClass.test.log(Status.INFO, "Navigated to the organization page");

		// Click on 'Create Organization' icon (Plus Icon)

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();
		
		ListenerImplClass.test.log(Status.INFO, "Navigated to Create organization page");

		// New Page : Creating New Organization Page
		CreateNewOrganizationPage newOrganization = new CreateNewOrganizationPage(driver);
		newOrganization.createOrganization(OrgName);
		
		ListenerImplClass.test.log(Status.INFO, OrgName+ "new Organization created");

		// Verifying textBox on OrganizationInformation Page

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String headerText = oip.getHeaderText().getText();
		boolean status = headerText.contains(OrgName);
		Assert.assertEquals(status, false); //Failing this TC to check Extent report

	}

	@Test
	public void CreateOrgWithIndustry() throws EncryptedDocumentException, IOException, InterruptedException {

		// Generating random number

		int random1 = jLib.getRandomNumber(); // ***Used JavaUtility method

		String OrgName = eLib.getDataFromExcel("Vtiger_Org", 3, 2) + random1;

		System.out.println(OrgName);

		// Click on Organizations tab on the HomePage

		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();

		// Click on 'Create Organization' icon (Plus Icon)

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();

		// New Page : Creating New Organization Page

		CreateNewOrganizationPage newOrganization = new CreateNewOrganizationPage(driver);
		newOrganization.createOrganization(OrgName, "Technology");

		// Verifying textBox on OrganizationInformation Page

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		// Verify Organization Name and Industry on Organization Information Page

		String actualOrgName = oip.getOrgNameVerify().getText();

		String actualIndustry = oip.getIndustryNameVerify().getText();

		Assert.assertEquals(actualOrgName, OrgName);

		// Need to fetch Industry value from excel

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(actualIndustry, "Technology");
		soft.assertAll();

	}

	@Test
	public void CreateOrganizationWithPhoneNumber_TC3() throws EncryptedDocumentException, IOException {
		int random1 = jLib.getRandomNumber(); // ***Used JavaUtility method

		String OrgName = eLib.getDataFromExcel("Vtiger_Org", 9, 2) + random1;

		String PhoneNumber = eLib.getDataFromExcel("VTiger_org", 9, 3);

		// System.out.println(OrgName);
		
		Reporter.log("Organization with "+ OrgName+ "is created successfully",true);
		
//Click on Organizations tab on the HomePage

		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();

		// Click on 'Create Organization' icon (Plus Icon)

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();

		CreateNewOrganizationPage newOrgPage = new CreateNewOrganizationPage(driver);
		newOrgPage.createOrganization1(OrgName, PhoneNumber);

		// Verify the TestCase

		// Verifying PhoneNumber on OrganizationInformation Page

		String actualPhoneNumber = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();

		System.out.println("Verification 1_TC3");

//		 if(actualPhoneNumber.equals(PhoneNumber))
//		 {
//			
//			 System.out.println(PhoneNumber+" is getting displayed on the TextBox on OrganiationInformation page==PASS");
//		 }
//		 else
//			 System.out.println(PhoneNumber+" is NOT getting displayed on the TextBox on OrganiationInformation page==FAIL");
//			 

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualPhoneNumber, PhoneNumber);
		soft.assertAll();

	}

}

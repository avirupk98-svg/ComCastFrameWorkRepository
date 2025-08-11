package com.comcast.crm.orgTest_WithAnnotationsAndBaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateOrganizationWithPhoneNumber extends BaseClass {

	@Test		   	
	public void CreateOrganizationWithPhoneNumber_TC3() throws EncryptedDocumentException, IOException
	{
	 int random1= jLib.getRandomNumber(); // ***Used JavaUtility method
	 
	 String OrgName=eLib.getDataFromExcel("Vtiger_Org", 9, 2)+random1;
	 
	 String PhoneNumber=eLib.getDataFromExcel("VTiger_org", 9, 3 );
	 
		 
		 //System.out.println(OrgName);
		 
	//Click on Organizations tab on the HomePage
		
			HomePage homePage=new HomePage(driver);
			homePage.getOrgLink().click();
			
			//Click on 'Create Organization' icon (Plus Icon)
			
			OrganizationPage op=new OrganizationPage(driver);
			op.getCreateOrganizationBtn().click();
		 
		CreateNewOrganizationPage newOrgPage=new CreateNewOrganizationPage(driver);
		newOrgPage.createOrganization1(OrgName, PhoneNumber);
		
		
		
		 
 
		 //Verify the TestCase
		 
		 //Verifying PhoneNumber on OrganizationInformation Page 
		 
		String actualPhoneNumber= driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		 
		 System.out.println("Verification 1_TC3");
		 
			 if(actualPhoneNumber.equals(PhoneNumber))
			 {
				
				 System.out.println(PhoneNumber+" is getting displayed on the TextBox on OrganiationInformation page==PASS");
			 }
			 else
				 System.out.println(PhoneNumber+" is NOT getting displayed on the TextBox on OrganiationInformation page==FAIL");
				 
		 
		
		 	
			 
		
		
		
	}
		
}



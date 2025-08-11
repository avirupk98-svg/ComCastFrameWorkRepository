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
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.PropertyFileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateOrganizationTest_TC1 extends BaseClass
{
	@Test 
	public void CreateOrganization() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		
		
		
		
		
	
		
		 //Generating random number
		 
		 int random1= jLib.getRandomNumber(); // ***Used JavaUtility method
		 
		 String OrgName=eLib.getDataFromExcel("Vtiger_Org", 3, 2)+random1;
		 
		 System.out.println(OrgName);
		

		
	
		
		//Click on Organizations tab on the HomePage
		
		HomePage homePage=new HomePage(driver);
		homePage.getOrgLink().click();
		
		
		
		//Click on 'Create Organization' icon (Plus Icon)
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();
		
		//New Page : Creating New Organization Page
				CreateNewOrganizationPage newOrganization=new CreateNewOrganizationPage(driver);
				newOrganization.createOrganization(OrgName);
		
		 
	
			 
		 //Verifying textBox on OrganizationInformation Page 
		 
		
		 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		 
		Boolean checkHeader= oip.verifyHeaderMessage(OrgName);
		 
		 
		 if(checkHeader==true)
		 {
			 System.out.println(OrgName+" is displayed on Organization Informaption Page== Test Case passed");
		 }
		 
		 else
		 {
			 System.out.println(OrgName+" is NOT displayed on Organization Information Page== Test Case F");
		 }
		 
		 
		 
		 
		  
		  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

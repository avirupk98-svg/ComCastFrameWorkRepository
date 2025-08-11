package com.comcast.crm.contactTest_WithAnnotationsAndBaseClass;

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
import com.comcast.crm.objectRepositoryUtility.ContactsPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;

public class CreateContactTest_TC4  extends BaseClass
{
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

}	
		
		
		
		
		
		
		
		
		



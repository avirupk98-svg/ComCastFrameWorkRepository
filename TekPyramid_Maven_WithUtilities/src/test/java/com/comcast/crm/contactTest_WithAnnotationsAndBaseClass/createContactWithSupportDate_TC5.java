package com.comcast.crm.contactTest_WithAnnotationsAndBaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.objectRepositoryUtility.ContactInformationPage;
import com.comcast.crm.objectRepositoryUtility.ContactsPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;

public class createContactWithSupportDate_TC5 extends BaseClass {
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
}

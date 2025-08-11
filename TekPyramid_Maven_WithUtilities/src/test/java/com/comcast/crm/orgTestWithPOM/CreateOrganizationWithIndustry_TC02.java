package com.comcast.crm.orgTestWithPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.PropertyFileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateOrganizationWithIndustry_TC02 
{
public static void main(String[] args) throws Throwable {
		
		
		
		
		PropertyFileUtility propFile=new PropertyFileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		
		String URL=propFile.getDataFromPropertyFile("Url");
		String USERNAME=propFile.getDataFromPropertyFile("User_Name");
		String PASSWORD=propFile.getDataFromPropertyFile("Password");
		String Browser=propFile.getDataFromPropertyFile("Browser");
		
		WebDriver driver=new ChromeDriver();
		
		
		if (Browser.equals("Chrome"))
			driver=new ChromeDriver();
		else if(Browser.equals("FireFox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		
		driver.get(URL);
		
		driver.manage().window().maximize();
		
		 //Generating random number
		 
		 int random1= jLib.getRandomNumber(); // ***Used JavaUtility method
		 
		 String OrgName=eLib.getDataFromExcel("Vtiger_Org", 3, 2)+random1;
		 
		 System.out.println(OrgName);
		

		
		LoginPage lp=new LoginPage(driver);
		lp.login();
		
		
		//Click on Organizations tab on the HomePage
		
		HomePage homePage=new HomePage(driver);
		homePage.getOrgLink().click();
		
		
		
		//Click on 'Create Organization' icon (Plus Icon)
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();
		
		//New Page : Creating New Organization Page
				CreateNewOrganizationPage newOrganization=new CreateNewOrganizationPage(driver);
				newOrganization.createOrganization(OrgName, "Technology");
		
		 
	
			 
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
		 
		 
		 
		 //Verify Organization Name and Industry on Organization Information Page
		 
		String actualOrgName= oip.getOrgNameVerify().getText();
		
		String actualIndustry=oip.getIndustryNameVerify().getText();
		
		if(actualOrgName.equals(OrgName))
			System.out.println(OrgName+" is getting displayed correctly on Organization Information page==Passed");
		else	
			System.out.println(OrgName+" is NOT displayed correctly on Organization Information page==FAILED");
		
		//Need to fetch Industry value from excel
		if(actualIndustry.equals("Technology"))
			System.out.println(actualIndustry+" is getting displayed correctly on Organization Information page==Passed");
		else	
			System.out.println(actualIndustry+" is NOT displayed correctly on Organization Information page==FAILED");
		  
		
		
		Thread.sleep(9000);
	driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}




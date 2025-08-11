package com.comcast.crm.orgTest;

import java.io.FileInputStream;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.PropertyFileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateOrganizationTest_TC1 
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
		

		//Sending Username and Password
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);	
//		
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);	
//		
//		
//		driver.findElement(By.id("submitButton")).click();
//		
//		Thread.sleep(2000);
		
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
		newOrganization.createOrganization(OrgName);
		
		
		
		
		
	 
		
		 
		  //Read TestScript Data from Excel
			
			//FileInputStream fis2=new FileInputStream("E:\\TekPyramid\\TestData\\TestScript Data\\TestScriptData2.xlsx");
			
		
		/*Workbook wb1 = WorkbookFactory.create(fis2);
		  
		  Sheet Sh_Org=wb1.getSheet("Vtiger_Org");
		   Row row1=  Sh_Org.getRow(3);
		   	Cell cell1= row1.getCell(2);
		   	
		 
		   	
	
		 
		*/
		 
		  
		 
		 
		 
		 
		
		 
	     
		 	
 
		 
		 
		 
		 
		 
		 
		 
		 //Verify the TestCase
		 
		 String headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 
		 //Verifying the Header message on OrganizationInformation Page 
		 
		 System.out.println("Verification 1");
		 if(headerInfo.contains(OrgName))
		 {
			 System.out.println(OrgName+" is displayed in the Header==PASS");
		 }
		 
		 else
			 
		 {
			 System.out.println(OrgName+" is NOT displayed in the Header==FAIL");
		 }
			 
		 //Verifying textBox on OrganizationInformation Page 
		 
		String actualOrgName= driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		 
		 System.out.println("Verification 2");
		 
			 if(actualOrgName.equals(OrgName))
			 {
				
				 System.out.println(OrgName+" is getting displayed on the TextBox on OrganiationInformation page==PASS");
			 }
			 else
				 System.out.println(OrgName+" is NOT getting displayed on the TextBox on OrganiationInformation page==FAIL");
				 
		 
		 
		 
		 
		 
		 
		  
		  
		
		
		Thread.sleep(9000);
	driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

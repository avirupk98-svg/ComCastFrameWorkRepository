package com.comcast.crm.contactTestWithPOM;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrganization_Integration_TC06 
{
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
	
	Properties prop=new Properties();
	
	FileInputStream fis1=new FileInputStream("E:\\TekPyramid\\CommonData_VTiger2_Assg.properties");
	
    prop.load(fis1);
	
	WebDriver driver=null;
	
	//Capturing all common data from the Properties file
	
	String URL=prop.getProperty("Url");
	
	String Browser=prop.getProperty("Browser");
	
	String USER=prop.getProperty("UserName");
	
	String PASSWORD=prop.getProperty("Password");
	
	if (Browser.equals("Chrome"))
		driver=new ChromeDriver();
	else if(Browser.equals("FireFox"))
		driver=new FirefoxDriver();
	else
		driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	
	
	driver.get(URL);
	
	driver.manage().window().maximize();
	

	//Sending Username and Password
	
	driver.findElement(By.name("user_name")).sendKeys(USER);	
	
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);	
	
	
	driver.findElement(By.id("submitButton")).click();
	
	Thread.sleep(2000);
	
	
	//Creating Organization
	
	//Click on Organizations tab on the HomePage
	
			driver.findElement(By.linkText("Organizations")).click();
			
			
			//Click on 'Create Organization' icon (Plus Icon)
			
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			
			 //Read TestScript Data from Excel
			
			FileInputStream fis2=new FileInputStream("E:\\TekPyramid\\TestData\\TestScript Data\\TestScriptData2.xlsx");
			
			 //Generating random number
			 
			 Random random=new Random();
			 int random1=random.nextInt(1000);  
			
			Workbook wb1 = WorkbookFactory.create(fis2);
			  
			  Sheet Sh_Contact=wb1.getSheet("Vtiger_Contact");
			   Row row1=  Sh_Contact.getRow(9);
			   	Cell cell_LastName= row1.getCell(3);
			   	
			   	Cell cell_Organization= row1.getCell(2);
			   	
			 
			 //Contact Name with random number  	
			 String  lastName=cell_LastName.getStringCellValue()+random1;
			 
			 
			 //Organization name with random integer  	
			 String  OrgName=cell_Organization.getStringCellValue()+random1;
			 
			 
			 
			 System.out.println(OrgName);
			 
	 
			 
			 
			 driver.findElement(By.name("accountname")).sendKeys(OrgName);
			 
			 Thread.sleep(2000);
			 
			 //Click on Save
			 
			 driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
			 
 Thread.sleep(2000);	
	
	//Click on Contacts tab on the HomePage
	
	driver.findElement(By.linkText("Contacts")).click();
	
	
	//Click on 'Create Contact' icon (Plus Icon)
	
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	
   
	 
	// System.out.println(lastName);
	 
	 driver.findElement(By.name("lastname")).sendKeys(lastName);
	 
	 //Locating the Plus icon for OrganizationName on Contacts Page
	 
	 driver.findElement(By.xpath("//input[@name='account_name']/following::img[1]")).click();
	 
	 //Switching to child window
	 
	 String parentWindow=driver.getWindowHandle();
	 
	Set<String> windows= driver.getWindowHandles();
	
	for(String indWindow: windows)
	{
		driver.switchTo().window(indWindow);
		String currentUrl=driver.getCurrentUrl();
		
		if(currentUrl.contains("module=Accounts"))
		  break;
	 

}
	
driver.manage().window().maximize();

	//On the child window
    //Sending Organization NAME IN THE Search Textfield
	driver.findElement(By.name("search_text")).sendKeys(OrgName);
	
	//Click on 'Search' button
	
	driver.findElement(By.name("search")).click();
	
	driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
	
	
	
	driver.switchTo().window(parentWindow);
	
	//Click on Save button on Contact page
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		

}
	
}

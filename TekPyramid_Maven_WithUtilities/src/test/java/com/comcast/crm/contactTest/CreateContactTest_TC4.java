package com.comcast.crm.contactTest;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactTest_TC4 
{
public static void main(String[] args) throws IOException, InterruptedException {
		
		
		
		
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
		
		//Click on Contacts tab on the HomePage
		
		driver.findElement(By.linkText("Contacts")).click();
		
		
		//Click on 'Create Contact' icon (Plus Icon)
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
	   //Read TestScript Data from Excel
		
		FileInputStream fis2=new FileInputStream("E:\\TekPyramid\\TestData\\TestScript Data\\TestScriptData2.xlsx");
		
		 //Generating random number
		 
		 Random random=new Random();
		 int random1=random.nextInt(1000);  
		
		Workbook wb1 = WorkbookFactory.create(fis2);
		  
		  Sheet Sh_Contact=wb1.getSheet("Vtiger_Contact");
		   Row row1=  Sh_Contact.getRow(3);
		   	Cell cell_LastName= row1.getCell(2);
		   	
		 
		 //Contact Name with random number  	
		 String  lastName=cell_LastName.getStringCellValue()+random1;
		 
		 
		 
		 System.out.println(lastName);
		 
 
		 
		 
		 driver.findElement(By.name("lastname")).sendKeys(lastName);
		 
		 
		 //Click on Save
		 
		 driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		 
		 
		 //Verify the TestCase
		 
		 String headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 
		 //Verifying the Header message on OrganizationInformation Page 
		 
		 System.out.println("Verification 1");
		 if(headerInfo.contains(lastName))
		 {
			 System.out.println(lastName+" is displayed in the Header==PASS");
		 }
		 
		 else
			 
		 {
			 System.out.println(lastName+" is NOT displayed in the Header==FAIL");
		 }
			 
		 //Verifying textBox on OrganizationInformation Page 
		 
		String actualLastName= driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		 
		 System.out.println("Verification 2");
		 
			 if(actualLastName.equals(lastName))
			 {
				
				 System.out.println(lastName+" is getting displayed on the TextBox on OrganiationInformation page==PASS");
			 }
			 else
				 System.out.println(lastName+" is NOT getting displayed on the TextBox on OrganiationInformation page==FAIL");
				 
		 
		 
		 
		 
		 
		 
		  
		  
		
		
	Thread.sleep(9000);
	driver.close();
	
	
}

}	
		
		
		
		
		
		
		
		
		



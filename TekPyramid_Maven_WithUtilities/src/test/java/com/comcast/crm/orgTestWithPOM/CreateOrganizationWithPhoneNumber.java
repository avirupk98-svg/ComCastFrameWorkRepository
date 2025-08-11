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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganizationWithPhoneNumber {

	public static void main(String[] args) throws InterruptedException, IOException {
		
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
		
		//Click on Organizations tab on the HomePage
		
		driver.findElement(By.linkText("Organizations")).click();
		
		
		//Click on 'Create Organization' icon (Plus Icon)
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
	   //Read TestScript Data from Excel
		
		FileInputStream fis2=new FileInputStream("E:\\TekPyramid\\TestData\\TestScript Data\\TestScriptData2.xlsx");
		
		 
		
		Workbook wb1 = WorkbookFactory.create(fis2);
		  
		  Sheet Sh_Org=wb1.getSheet("Vtiger_Org");
		   Row row1=  Sh_Org.getRow(9);
		   	Cell cell1= row1.getCell(2);
		   	
		    //Generating random number
			 
			 Random random=new Random();
			 int random1=random.nextInt(1000);  
		 
		 // Enter Organization name with random number  	
		 String  OrgName=cell1.getStringCellValue()+random1;
		 
		   	
		   	//Reading Test Script Data for TC3(Phone Number)
		   	
		   	Row row_TC3=  Sh_Org.getRow(9);
		   	   Cell cell_Phone= row_TC3.getCell(3);
		   	   	String phone=	cell_Phone.toString();
		   	   	
		   	   	System.out.println(phone);
		   	   
		   	
		 
		 
		 
		 //System.out.println(OrgName);
		 
 
		 
		 
		 driver.findElement(By.name("accountname")).sendKeys(OrgName);
		 
		 
		 //Enter Phone Number : TC3
		 
		 driver.findElement(By.id("phone")).sendKeys(phone);
		 
		 
		 
		 
		 //Click on Save
		 
		 driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		 
		 
		 //Verify the TestCase
		 
		 String headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 
		 
			 
		 //Verifying PhoneNumber on OrganizationInformation Page 
		 
		String actualPhoneNumber= driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		 
		 System.out.println("Verification 1_TC3");
		 
			 if(actualPhoneNumber.equals(phone))
			 {
				
				 System.out.println(phone+" is getting displayed on the TextBox on OrganiationInformation page==PASS");
			 }
			 else
				 System.out.println(phone+" is NOT getting displayed on the TextBox on OrganiationInformation page==FAIL");
				 
		 
		 
		 
		 
		 
		 
		  
		  
		
		
		Thread.sleep(9000);
	driver.close();
		
		
		
		


	}

}

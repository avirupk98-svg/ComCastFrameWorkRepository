package com.comcast.crm.orgTest;

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

public class CreateOrganizationWithIndustry_TC02 
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
		
		//Click on Organizations tab on the HomePage
		
		driver.findElement(By.linkText("Organizations")).click();
		
		
		//Click on 'Create Organization' icon (Plus Icon)
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
		//Generating random number
		 
		 Random random=new Random();
		 int random1=random.nextInt(1000);  
		
		
	   //Read TestScript Data from Excel for Test Case2
		
		FileInputStream fis2=new FileInputStream("E:\\TekPyramid\\TestData\\TestScript Data\\TestScriptData2.xlsx");
		
		 
		
		Workbook wb1 = WorkbookFactory.create(fis2);
		  
		  Sheet Sh_Org=wb1.getSheet("Vtiger_Org");
		   Row row_tc2=  Sh_Org.getRow(6);
		   	Cell cell_Org= row_tc2.getCell(2);
		   	
		    //Fetch TestScript Data for Test Case2
			 
			// Row row_tc2=Sh_Org.getRow(6);
			 
			 Cell cell_ind=row_tc2.getCell(3);
			 
			 String industry_excel=cell_ind.toString();
			 
			 String type_excel=row_tc2.getCell(4).toString();
			 
			 
					 
		   	
		   	
		   	
		 
		   	
		 String  OrgName=cell_Org.getStringCellValue()+random1;
		 
		 
		 
		 //System.out.println(OrgName);
		 
		 
		 driver.findElement(By.name("accountname")).sendKeys(OrgName);
		 
		 
		
		 
		
		 
		WebElement industry1= driver.findElement(By.xpath("//select[@name='industry']"));
		
		WebElement type1= driver.findElement(By.xpath("//select[@name='accounttype']"));
		
		Select ss1=new Select(industry1);
		
		ss1.selectByVisibleText(industry_excel);
		
		Select ss2=new Select(type1);
		
		ss2.selectByVisibleText(type_excel);
		
		
		 
		 
		 
		 
		 //Click on Save
		 
		 driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		 
		 
		 //Verify the TestCase : Verify the data in the 2 dropdowns on OrganizationInfo Page
		 
		 
		 String actualIndustry=driver.findElement(By.xpath("//font[text()='Consulting']")).getText();
		 
		 if(actualIndustry.equals(industry_excel))
			 System.out.println(industry_excel+" is getting displayed correctly on Organization Information page==Passed");
		 
		 String actualType=driver.findElement(By.id("dtlview_Type")).getText(); 
		 
		 if(actualType.equals(type_excel))
			 System.out.println(type_excel+" is getting displayed correctly on Organization Information page==Passed");
		  
		
		
	//	Thread.sleep(9000);
	//driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}




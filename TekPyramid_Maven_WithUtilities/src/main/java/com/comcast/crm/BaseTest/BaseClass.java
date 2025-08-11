package com.comcast.crm.BaseTest;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.PropertyFileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;

public class BaseClass 
{
	
	public PropertyFileUtility propFile=new PropertyFileUtility();
	public	WebDriverUtility wLib=new WebDriverUtility();
	
	public ExcelUtility eLib=new ExcelUtility();
	
	public	JavaUtility jLib=new JavaUtility();
	public	WebDriver driver=null;
	public static WebDriver sdriver=null; 
	@BeforeClass
	public void configBC() throws Throwable
	{	
		System.out.println("Launch the Browser");
	
		String Browser=propFile.getDataFromPropertyFile("Browser");
	
		if (Browser.equals("Chrome"))
			driver=new ChromeDriver();
		else if(Browser.equals("FireFox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
		sdriver=driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

	}
		
	@BeforeMethod
	public void configBM() throws Throwable
	{
		System.out.println("Login to the Application");
		String URL=propFile.getDataFromPropertyFile("Url");
		String USERNAME=propFile.getDataFromPropertyFile("User_Name");
		String PASSWORD=propFile.getDataFromPropertyFile("Password");
		
		driver.get(URL);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		LoginPage lp=new LoginPage(driver);
		
		lp.login();
		
		
		
		
	}
	
	@AfterMethod
	public void logOut() throws InterruptedException
	{
		System.out.println("LogOut");
		HomePage hp=new HomePage(driver);
		hp.logOut();
	}
	
	@AfterClass
	public void configAC() throws InterruptedException
	{	
		System.out.println("Closing the driver");
		Thread.sleep(8000);
		driver.close();
	}
	
}

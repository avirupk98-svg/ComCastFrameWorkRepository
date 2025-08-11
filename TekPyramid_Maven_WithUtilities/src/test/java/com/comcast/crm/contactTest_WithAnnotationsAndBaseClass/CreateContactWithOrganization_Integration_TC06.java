package com.comcast.crm.contactTest_WithAnnotationsAndBaseClass;

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
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectRepositoryUtility.ContactsPage;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsPopUpPage;

public class CreateContactWithOrganization_Integration_TC06 extends BaseClass {

	@Test
	public void CreateContactWithOrganization_Integration_TC06()
			throws EncryptedDocumentException, IOException, InterruptedException {

		int random1 = jLib.getRandomNumber(); // ***Used JavaUtility method

		// Creating Organization

		String orgName = eLib.getDataFromExcel("VTiger_Contact", 9, 2) + random1;

		// Click on Organizations tab on the HomePage

		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();

		// Click on 'Create Organization' icon (Plus Icon)

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();

		// New Page : Creating New Organization Page
		CreateNewOrganizationPage newOrganization = new CreateNewOrganizationPage(driver);
		newOrganization.createOrganization(orgName);

		// Click on Contacts tab on the HomePage & Click on 'Create Contact' icon (Plus
		// Icon)

		Thread.sleep(4000);
		homePage.getContactLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactLink().click();

		// Read TestScript Data from Excel

		String lastName = eLib.getDataFromExcel("VTiger_Contact", 9, 3) + jLib.getRandomNumber();

		System.out.println(lastName);

		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);

		cnp.getLastNameTextBox().sendKeys(lastName);

		String parentWindow = driver.getWindowHandle();

		// Locating the Plus icon for OrganizationName on Contacts Page
		cnp.getOrgNamePlusIcon().click();

		// Switching to child window
		wLib.switchToTabOnURL(driver, "Accounts&action");

		// On the child window

		OrganizationsPopUpPage orgPopUp = new OrganizationsPopUpPage(driver);

		// Sending Organization NAME IN THE Search Textfield

		orgPopUp.getSearchTextBox().sendKeys(orgName);

		Thread.sleep(3000);

		// Clicking on the'Search' Button

		orgPopUp.getSearchButton().click();

		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		driver.switchTo().window(parentWindow);

		Thread.sleep(Duration.ofSeconds(3));

		cnp.getSaveButton().click();

		// Verify

		System.out.println("Verification for CreateContactWithOrganization_Integration_TC06");

		WebElement orgNameData = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']"));

		String orgNameActual = orgNameData.getText();
		
		System.out.println(orgNameActual);
		
		System.out.println(orgName);

		Thread.sleep(2000);
		if (orgNameActual.contains(orgName)) {
			System.out.println(orgName + "is displayed coorectly==PASS");
		} else {
			System.out.println(orgName + "is NOT displayed coorectly==FAIL");
		}

	}

}

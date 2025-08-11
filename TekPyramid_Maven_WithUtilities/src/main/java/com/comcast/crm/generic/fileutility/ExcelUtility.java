package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	
	public String getDataFromExcel(String sheet,int row, int column ) throws EncryptedDocumentException, IOException
	{
		//Read TestScript Data from Excel
		
		FileInputStream fis1 =new FileInputStream("./Test Data/TestScriptData2.xlsx");
		Workbook wb1= WorkbookFactory.create(fis1);
		  
		  Sheet Sh_Org=wb1.getSheet(sheet);
		  Row row1=  Sh_Org.getRow(row);
		  Cell cell1= row1.getCell(column);
		  
		   String data= cell1.getStringCellValue();
		   
		return data;
		
		 
	}
	
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 =new FileInputStream("/TekPyramid_Maven_WithUtilities/Config App Data/TestScriptData2.xlsx");
		Workbook wb1= WorkbookFactory.create(fis1);
		
		Sheet sheet1=wb1.getSheet(sheet);
		
		int lastRow=sheet1.getLastRowNum();
		
		return lastRow;
		
	}
	
	public void writeDataBackToExcel(String sheet, int row, int column, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 =new FileInputStream("/TekPyramid_Maven_WithUtilities/Config App Data/TestScriptData2.xlsx");
		Workbook wb1= WorkbookFactory.create(fis1);
		
		Cell cellNew=wb1.getSheet(sheet).getRow(row).createCell(column);
		cellNew.setCellValue(data);
		
			
		
		
	}
}

package com.DataProvider;

import org.testng.annotations.DataProvider;

public class DataProvider_Test 
{
	@DataProvider(name = "loginData")
	public Object[][] getData()
	{
		
		Object[][] objArray=new Object[2][2];
		
		objArray[0][0]="admin";
		objArray[0][1]="admin";
		
		objArray[1][0]="admin1";
		objArray[1][1]="admin5";
		
		
		
		return objArray;
		
	}
}

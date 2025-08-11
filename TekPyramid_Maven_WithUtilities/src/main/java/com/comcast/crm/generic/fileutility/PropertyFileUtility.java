package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		
		String path=".\\ConfigAppData\\CommonData.properties";
		FileInputStream fis=new FileInputStream(path);
		
		//String path="./TekPyramid_Maven_WithUtilities/ConfigAppData/CommonData.properties";
		
		
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String data=prop.getProperty(key);
		return data;
		
		
	
	}

}

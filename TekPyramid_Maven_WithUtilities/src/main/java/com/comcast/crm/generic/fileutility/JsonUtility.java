package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.cj.xdevapi.JsonParser;

public class JsonUtility {
	
	public String getDataFromJSON(String key) throws IOException, ParseException
	{
		FileReader fileReader=new FileReader("./TekPyramid_Maven_WithUtilities/Config App Data/CommonData.json");
		
		JSONParser parser=new JSONParser();
		
		Object obj=parser.parse(fileReader);
		
		JSONObject map=	(JSONObject)obj;
		
		String data=map.get(key).toString();
		
		return data;
		
		
		
		
		
		
	}

}

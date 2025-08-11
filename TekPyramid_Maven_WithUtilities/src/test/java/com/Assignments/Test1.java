package com.Assignments;

import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;

public class Test1 extends BaseClass{
	@Test
	public void Method1()
	{
		System.out.println("Method1 in Test1 class");
	}
	
	@Test
	public void Method2()
	{
		System.out.println("Method2 in Test1 class");
	}
	
//	for (int i = 0; i < names.size(); i++) {
//	    String name = names.get(i).getText();
//	    String price = prices.size() > i ? prices.get(i).getText() : "N/A";
//	    String rating = ratings.size() > i ? ratings.get(i).getText() : "N/A";
//
//	    System.out.println("Name: " + name + " | Price: " + price + " | Rating: " + rating);
	
}

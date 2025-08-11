package com.comcast.crm.generic.webdriverutility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomNum=random.nextInt(2000);
		return randomNum;
		
		
	}
	
	public String getDate()
	{
		
		Calendar calendar=Calendar.getInstance();
		Date date=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date1=	sdf.format(date);
		return date1;
		
	}
	
	public String getRequiredDate(int days)
	{
		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(d);
//		System.out.println(date);
		Calendar calendar=Calendar.getInstance();
		calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH,days);
		Date dateFuture=calendar.getTime();
		String dateFuture1=sdf.format(dateFuture);
		return dateFuture1;
		
	}
	

}

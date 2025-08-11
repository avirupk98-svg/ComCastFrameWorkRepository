package practice.Listenerstest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;

@Listeners(com.comcast.crm.listenerUtility.ListenerImplClass.class)
public class InvoiceTest extends BaseClass {
	
	@Test
	public void createInvoiceTest()
	{
		System.out.println("Create Invoice Test");
		
		String actualTitle=driver.getTitle();
		
		Assert.assertEquals(actualTitle, "Login"); //Will get failed
		
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
	}
	
	@Test
	public void createInvoiceWithContactTest()
	{
		System.out.println("Execute Create Invoice with ContactTest");
		
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		
	}

}

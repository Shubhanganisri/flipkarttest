package SmokeTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Testsecnarios.LoginTest;
import junit.framework.Assert;

@TestMethodOrder(Order.Annotation.class)

public class VerificationJunit {
	
	private static StringBuilder ouput= new StringBuilder("");
	
	@Test
	@order(1)
	public void VerifyingPrice()
	{
		LoginTest.main(null);
		Assert.assertEquals(LoginTest.actualPrice, LoginTest.expectedPrice);
		
	
	}
	
	public void VerfyingName()
	{
		
		Assert.assertEquals(LoginTest.actualName,LoginTest.expectedName);		
	}
	

	@Before
	public void setup()
	{
	 System.out.println("setup");	
	}
	
	@After
	public void close()
	{
		 System.out.println("close");	

	}

}

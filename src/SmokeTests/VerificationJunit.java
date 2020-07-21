package SmokeTests;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Testsecnarios.LoginTest;
import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VerificationJunit {

	public static String actualPrice = null;
	public static String expectedPrice = null;
	public static String actualName = null;
	public static String expectedName = null;


	@Test
	public void CheckIfOrderisGettingPlaced() {
		LoginTest.main(null);
		System.out.println("order placed");
	}

	@Test
	public void VerfyingName() {
		System.out.println("Name at Search Page: "+actualName);
		System.out.println("Name at CheckoutPage: "+expectedName);
		Assert.assertEquals(actualName, expectedName);
		
	}

	@Test
	public void VerifyingPrice() {
		System.out.println("Price at Search Page: "+actualPrice);
		System.out.println("Price at CheckoutPage: "+expectedPrice);
		Assert.assertEquals(actualPrice, expectedPrice);
	}


}

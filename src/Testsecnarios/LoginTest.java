package Testsecnarios;

import java.util.Properties;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.jna.platform.unix.X11.Window;

import SmokeTests.VerificationJunit;

public class LoginTest {

	public static void main(String[] args) {

		WebDriver driver = null;

		ReadPropertyFiles rpf = new ReadPropertyFiles();
		Properties prop = rpf.getPropertyObject();

		String browserType = prop.getProperty("Browser");
		String Loginid = prop.getProperty("UserName");
		String Password = prop.getProperty("Password");

		String URL = "https://www.flipkart.com";

		// step 1 : open browser
		driver = Utilities.DriverFactory.open(browserType);

		// Step 2 : open web page
		driver.get(URL);
		driver.manage().window().maximize();

		// step3:Login:enter email or phone no and password
		WebElement Loginidbox = driver.findElement(By.cssSelector(prop.getProperty("Loginidbox")));
		WebElement Passwordbox = driver.findElement(By.cssSelector(prop.getProperty("Passwordbox")));
		Loginidbox.sendKeys(Loginid);
		Passwordbox.sendKeys(Password);

		// click on login button
		WebElement LoginButton = driver.findElement(By.cssSelector(prop.getProperty("LoginButton")));
		LoginButton.submit();

		// waiting thread for full loading of page
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Searching the item
		WebElement EnterSearchItem = driver.findElement(By.cssSelector(prop.getProperty("EnterSearchItem")));
		EnterSearchItem.sendKeys("Camera");

		WebElement ClickSearch = driver.findElement(By.xpath(prop.getProperty("ClickSearch")));
		ClickSearch.submit();

		// waiting thread for full loading of new page
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");

		// waiting thread
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// find price of item you are clicking and store in actualPrice
		String actualPrice = driver.findElement(By.xpath("//div[contains(text(),'1,199')]")).getText();
		VerificationJunit.actualPrice = actualPrice.substring(1);
		System.out.println(VerificationJunit.actualPrice);

		// find name of item and store in actualName;
		VerificationJunit.actualName = driver
				.findElement(By
						.xpath("//div[contains(text(),'Richuzers Point And Shoot Digital Camera For Kids Best Gift For Kids')]"))
				.getText();
		System.out.println(VerificationJunit.actualName);
		
		// clicking the item
		WebElement ClickProduct = driver.findElement(By.xpath(prop.getProperty("ClickProduct")));
		ClickProduct.click();

						/* ---------------- NExt page----------------- */
		
		// focus at next page
		String winHandleBefore = driver.getWindowHandle();

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// scroll down and waiting thread
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// press Add to cart
		WebElement ClickAddToCart = driver.findElement(By.xpath(prop.getProperty("ClickAddToCart")));
		ClickAddToCart.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// read price and store in expectedPrice
		String expectedPrice = driver.findElement(By.xpath("//span[contains(text(),'1,199')]")).getText();
		VerificationJunit.expectedPrice = expectedPrice.substring(1);
		System.out.println(VerificationJunit.expectedPrice);
		// read name and store in expectedName
		VerificationJunit.expectedName = driver.findElement(By.xpath("//a[contains(text(),'Richuzers Point And Shoot Digital Camera For Kids Best Gift For Kids')]")).getText();

		// click on place order
		WebElement ClickPlaceOrder = driver.findElement(By.xpath(prop.getProperty("ClickPlaceOrder")));
		ClickPlaceOrder.click();

		//driver.close();
	}

}

package Testsecnarios;

import java.util.Properties;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.jna.platform.unix.X11.Window;

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
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();

		// step3:Login:enter email or phone no and password
		WebElement Loginidbox = driver.findElement(By.cssSelector("input[type='text'][class='_2zrpKA _1dBPDZ']"));
		WebElement Passwordbox = driver
				.findElement(By.cssSelector("input[type='password'][class='_2zrpKA _3v41xv _1dBPDZ']"));
		Loginidbox.sendKeys(Loginid);
		Passwordbox.sendKeys(Password);

		// click on login button
		driver.findElement(By.cssSelector("button[class='_2AkmmA _1LctnI _7UHT_c'][type='submit']")).submit();
		// waiting thread for full loading of page
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Searching the item
		driver.findElement(By.cssSelector("input[type='text'][class='LM6RPg']")).sendKeys("Camera");
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).submit();

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
		// clicking the item
		//driver.findElement(By.cssSelector("img[class='_1Nyybr _30XEf0'][alt='Richuzers Point And Shoot Digital Camera For Kids Best Gift For Kids']"))
				//.click();
		
		
		driver.findElement(By.xpath("//img[@alt='Richuzers Point And Shoot Digital Camera For Kids Best Gift For Kids']")).click();
		
		
		/* ---------------- NExt page----------------- */
		// focus at next page
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

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

		// press Add to cart
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
           driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// click on place order
		driver.findElement(By.xpath("//*[@class='_2AkmmA iwYpF9 _7UHT_c']")).click();

		// find from drop down menu and click on logout 
		
		// create JUNIT class and do assertion of name,price,
		
		// close windows and driver
		
		//driver.close();		
	}

}

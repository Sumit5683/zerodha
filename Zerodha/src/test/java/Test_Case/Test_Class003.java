package Test_Case;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.objects.Home_Page;
import page.objects.Login_page1;
import page.objects.Login_page;
import page.objects.ProfileId_dropdown;

public class Test_Class003 extends Base_class {
	SoftAssert softassert = new SoftAssert();
	
	String url = "https://kite.zerodha.com/";
	String exp_order_title = "Orders / Kite";
	String exp_order_url = "https://kite.zerodha.com/orders";
	String exp_Holding_title = "Holdings / Kite";
	String exp_Holding_url = "https://kite.zerodha.com/holdings";
	String exp_Funds_title = "Funds / Kite";
	String exp_Funds_url = "https://kite.zerodha.com/funds";
	String exp_Dashboard_title = "Dashboard / Kite";
	String exp_Dashboard_url = "https://kite.zerodha.com/dashboard";
	String exp_Positions_title = "Positions / Kite";
	String exp_Positions_url = "https://kite.zerodha.com/positions";

	@BeforeMethod
	public void Logintest() {
		Login_page log1 = new Login_page(driver);
		log1.setUserName();
		log1.setPassword();
		log1.submit();
		Login_page1 log2 = new Login_page1(driver);
		log2.setPIN();
		log2.Continue();
	}

	@Test(priority = 1)
	public void Dashboard_Test() {
		Home_Page home = new Home_Page(driver);
		home.Click_dashboard();
		softassert.assertEquals(driver.getTitle(), exp_Dashboard_title);
		softassert.assertEquals(driver.getCurrentUrl(), exp_Dashboard_url);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void Orders_Test() {
		Home_Page home = new Home_Page(driver);
		home.Click_orders();
		softassert.assertEquals(driver.getTitle(), exp_order_title);
		softassert.assertEquals(driver.getCurrentUrl(), exp_order_url);
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void Holdings_Test() {
		Home_Page home = new Home_Page(driver);
		home.Click_holdings();
		softassert.assertEquals(driver.getTitle(), exp_Holding_title);
		softassert.assertEquals(driver.getCurrentUrl(), exp_Holding_url);
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void Positions_Test() {
		Home_Page home = new Home_Page(driver);
		home.Click_positions();
		softassert.assertEquals(driver.getTitle(), exp_Positions_title);
		softassert.assertEquals(driver.getCurrentUrl(), exp_Positions_url);
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void Funds_Test() {
		Home_Page home = new Home_Page(driver);
		home.Click_funds();
		softassert.assertEquals(driver.getTitle(), exp_Funds_title);
		softassert.assertEquals(driver.getCurrentUrl(), exp_Funds_url);
		softassert.assertAll();
	}

	@AfterMethod
	public void logout1() throws InterruptedException {
		Home_Page home = new Home_Page(driver);
		Thread.sleep(1000);
		home.Click_profileId();
		ProfileId_dropdown ID = new ProfileId_dropdown(driver);
		ID.click_Logout();
		driver.findElement(By.xpath("//a[text()='Change user']")).click();
	}

}

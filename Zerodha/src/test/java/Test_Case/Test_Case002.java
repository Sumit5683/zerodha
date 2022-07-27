package Test_Case;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.objects.Home_Page;
import page.objects.Login_page1;
import page.objects.Login_page;
import page.objects.ProfileId_dropdown;

public class Test_Case002 extends Base_class {

	@BeforeMethod
	public void login() {
		Login_page log = new Login_page(driver);
		log.setUserName();
		log.setPassword();
		log.submit();

		Login_page1 log1 = new Login_page1(driver);
		log1.setPIN();
		log1.Continue();
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

	@Test(priority = 1)
	public void validate_orders() {
		System.out.println("***Vadlidating ORDERS***");

		Home_Page home = new Home_Page(driver);
		String exp_text = "Orders";

		if (exp_text.equals(home.Verify_orders())) {
			System.out.println("Actual and expected text matched");
		} else {
			System.out.println("Actual and expected text not matched");
		}

		home.Click_orders();
		String exp_title = "Orders / Kite";
		String exp_url = "https://kite.zerodha.com/orders";

		if (exp_title.equals(driver.getTitle()) && exp_url.equals(driver.getCurrentUrl())) {
			System.out.println("Actual and expected title and url matched");
		} else {
			System.out.println("Actual and expected title and url is not matched");
		}
	}

	@Test(priority = 2)
	public void validate_holdings() {
		System.out.println("\n***Vadlidating HOLDINGS***");

		Home_Page home = new Home_Page(driver);
		String exp_text = "Holdings";

		if (exp_text.equals(home.Verify_holdings())) {
			System.out.println("Actual and expected text matched");
		} else {
			System.out.println("Actual and expected text is not matched");
		}

		home.Click_holdings();
		String exp_title = "Holdings / Kite";
		String exp_url = "https://kite.zerodha.com/holdings";

		if (exp_title.equals(driver.getTitle()) && exp_url.equals(driver.getCurrentUrl())) {
			System.out.println("Actual and expected title and url matched");
		} else {
			System.out.println("Actual and expected title and url is not matched");
		}
	}

	@Test(priority = 3)
	public void validate_funds() {
		System.out.println("\n***Vadlidating FUNDS***");

		Home_Page home = new Home_Page(driver);
		String exp_text = "Funds";

		if (exp_text.equals(home.Verify_funds())) {
			System.out.println("Actual and expected text matched");
		} else {
			System.out.println("Actual and expected text is not matched");
		}

		home.Click_funds();
		String exp_title = "Funds / Kite";
		String exp_url = "https://kite.zerodha.com/funds";

		if (exp_title.equals(driver.getTitle()) && exp_url.equals(driver.getCurrentUrl())) {
			System.out.println("Actual and expected title and url matched");
		} else {
			System.out.println("Actual and expected title and url is not matched");
		}
	}

}

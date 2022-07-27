package Test_Case;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import page.objects.Home_Page;
import page.objects.Login_page1;
import page.objects.Login_page;
import page.objects.ProfileId_dropdown;

public class Test_Case001  {
	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("http://kite.zerodha.com.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Login_page log = new Login_page(driver);
		log.setUserName();
		log.setPassword();
		log.submit();
		
		Login_page1 log1 = new Login_page1(driver);
		log1.setPIN();
		log1.Continue();
		
		Home_Page home = new Home_Page(driver);
		String exp_profileID="OKP335";
		String exp_dashboard="Dashboard";
		String exp_orders="Orders";
		String exp_holdings="Holdings";
		String exp_position="Positions";
		String exp_funds="Funds";
		if(exp_profileID.equals(home.Verify_profileId()) && exp_dashboard.equals(home.Verify_dashboard()) && exp_orders.equals(home.Verify_orders()) 
				&& exp_holdings.equals(home.Verify_holdings()) && exp_position.equals(home.Verify_positions()) && exp_funds.equals(home.Verify_funds())) {
			System.out.println("Test is Pass");
		}
		else {
			System.out.println("test is fail");
		}
		
		WebElement share1 = driver.findElement(By.xpath("//span[text()='TATASTLLP']"));
		Actions act = new Actions(driver);
		act.moveToElement(share1).perform();
		WebElement buy1 = driver.findElement(By.xpath("//button[text()='B ']"));
		act.moveToElement(buy1).click().perform();
		
		home.Click_profileId();
		ProfileId_dropdown ID = new ProfileId_dropdown(driver);
		ID.click_Logout();
		
		
	}
	
	
	

}

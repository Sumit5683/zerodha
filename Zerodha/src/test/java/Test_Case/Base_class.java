package Test_Case;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base_class {
	WebDriver driver;
	@Parameters("browser")
	
	@BeforeClass 
	public void setup(String browser) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		FirefoxOptions opt1 = new FirefoxOptions();
		opt1.addArguments("--disable-notifications");
//		EdgeOptions opt2 = new EdgeOptions();
//		opt2.addArguments("--disable-notifications");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(opt);
		}

		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver(opt1);
		}
		if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.get("http://kite.zerodha.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void quit() {
		driver.close();
	}

}

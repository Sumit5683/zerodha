package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	@FindBy (xpath="//span[text()='OKP335']") private WebElement profileId;
	@FindBy (xpath="//span[text()='Dashboard']") private WebElement dashboard;
	@FindBy (xpath="//span[text()='Orders']") private WebElement orders;
	@FindBy (xpath="//span[text()='Holdings']") private WebElement holdings;
	@FindBy (xpath="//span[text()='Positions']") private WebElement positions;
	@FindBy (xpath="//span[text()='Funds']") private WebElement funds;
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String Verify_profileId() {
		String x = profileId.getText();
		return x;
	}
	public String Verify_dashboard() {
		String x = dashboard.getText();
		return x;
	}
	public String Verify_orders() {
		String x = orders.getText();
		return x;
	}
	public String Verify_holdings() {
		String x = holdings.getText();
		return x;
	}
	public String Verify_positions() {
		String x = positions.getText();
		return x;
	}
	public String Verify_funds() {
		String x = funds.getText();
		return x;
	}
	
	public void Click_profileId() {
		profileId.click();
	}
	public void Click_dashboard() {
		dashboard.click();
	}
	public void Click_orders() {
		orders.click();
	}
	public void Click_holdings() {
		holdings.click();
	}
	public void Click_positions() {
		positions.click();
	}
	public void Click_funds() {
		funds.click();
	}
	public void Fundskeys() {
		funds.sendKeys("12345");
	}
	
}

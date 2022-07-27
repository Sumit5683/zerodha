package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page1 {
	
	@FindBy (xpath = "//input[@id='pin']") private WebElement PIN;
	@FindBy (xpath = "//button[@type='submit']") private WebElement Continue;
	
	public Login_page1 (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setPIN() {
		PIN.sendKeys("7654321");
	}
	
	public void Continue() {
		Continue.click();
	}

}

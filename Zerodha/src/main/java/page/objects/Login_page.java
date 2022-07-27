package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	@FindBy (xpath ="//input[@type='text']" ) private WebElement Username;
	@FindBy (xpath ="//input[@type='password']" ) private WebElement Password;
	@FindBy (xpath ="//button[@type='submit']" ) private WebElement LoginButton;
	
	public Login_page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName() {
		Username.sendKeys("OKP335");
	}
	public void setPassword() {
		Password.sendKeys("WSX12345");
	}
	public void submit() {
		LoginButton.click();
	}
	
	



}

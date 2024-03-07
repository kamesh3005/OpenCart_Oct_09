package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "input-email")
	WebElement email_address;
	@FindBy(id = "input-password")
	WebElement input_pass;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login_butt;

	public void setemailId(String email) {
		email_address.sendKeys(email);

	}

	public void setPassword(String pass) {
		input_pass.sendKeys(pass);

	}

	public void click_loginButton() {

		login_butt.click();
	}
}

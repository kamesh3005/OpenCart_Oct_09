package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistationPage extends BasePage {

	public AccountRegistationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-firstname")
	WebElement first_name;
	@FindBy(id = "input-lastname")
	WebElement last_name;
	@FindBy(id = "input-email")
	WebElement email_id;
	@FindBy(id = "input-password")
	WebElement password;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement private_policy;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement continue_click;
	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement succsfull_Message;

	public void setFirstname(String fname) {

		first_name.sendKeys(fname);
	}

	public void setLastname(String lname) {
		last_name.sendKeys(lname);
	}

	public void setEmail(String rEmail) {

		email_id.sendKeys(rEmail);
	}

	public void setPassword(String pass) {

		password.sendKeys(pass);
	}

	public void clickPrivatePolicy() {

		private_policy.click();
	}

	public void clickContinue() {

		continue_click.click();
	}

	public String getConformMess() {

		try {

			return (succsfull_Message.getText());
		} catch (Exception e) {

			return (e.getMessage());
		}
	}
}

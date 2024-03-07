package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement link_myAccount;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement link_register;
	@FindBy(xpath = "//li//a[contains(@href,'/login&language')]")
	WebElement login;

	public void clickMyaccount() {

		link_myAccount.click();
	}

	public void clickRegister() {

		link_register.click();
	}

	public void clickLogin() {

		login.click();
	}

}

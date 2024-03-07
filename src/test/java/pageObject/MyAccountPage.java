package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@id='content']/h2[contains(.,'My Account')]")
	WebElement myAccout;
	@FindBy(xpath = "//aside[@id='column-right']/descendant::a[13]")
	WebElement linklogout;

	public boolean setMyaccountExist() {
		try {
			return (myAccout.isDisplayed());

		} catch (Exception e) {

			return false;
		}

	}

	public void clcikLogout() {

		linklogout.click();
	}

}

package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	MyAccountPage ap;

	@Test()

	public void loginTest() {
		try {
			logger.info("********Staring TC_002_LoginTestTest***********");

			lp = new LoginPage(driver);
			hp = new HomePage(driver);
			hp.clickMyaccount();
			logger.info("clicked on my account");
			hp.clickLogin();
			logger.info("Provide Login Detials");

			lp.setemailId(rb.getString("email"));
			lp.setPassword(rb.getString("password"));
			lp.click_loginButton();
			logger.info("Click on Login Button");

			ap = new MyAccountPage(driver);
			boolean targetPage = ap.setMyaccountExist();
			Assert.assertTrue(targetPage);
		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("********Finesh TC_002_LoginTestTest***********");

	}

}

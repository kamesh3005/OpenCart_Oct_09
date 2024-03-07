package testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	LoginPage lp;
	MyAccountPage ap;
	HomePage hp;

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDDT(String uname, String pass, String res) {

		logger.info("*******Starting TC_003_LoginDDT**************");

		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on my account");
		hp.clickLogin();
		logger.info("Provide Login Detials");

		lp.setemailId(uname);
		lp.setPassword(pass);
		lp.click_loginButton();
		logger.info("Click on Login Button");
		ap = new MyAccountPage(driver);
		boolean targetPage = ap.setMyaccountExist();
		if (res.equals("Valid")) {
			ap.clcikLogout();
			if (targetPage == true) {

				Assert.assertTrue(targetPage);
			} else {

				Assert.assertTrue(false);
			}
		}
		if (res.equals("Invalid")) {
			ap.clcikLogout();
			if (targetPage == false) {

				Assert.assertTrue(true);
			} else {

				Assert.assertTrue(true);
			}
		}
		logger.info("********Finesh TC_003_LoginDDT***********");

	}

}

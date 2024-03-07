package testCase;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistationPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC_001_AccountRegistationTest extends BaseClass {
	HomePage hp;
	AccountRegistationPage ap;

	@Test(groups = {"regression"})

	void test_accout_registation() {
		logger.debug("applications logs.....");
		logger.info("********Staring TC_001_AccountRegistationTest***********");
		try {
			hp = new HomePage(driver);
			hp.clickMyaccount();
			logger.info("click on My account link");
			hp.clickRegister();
			logger.info("click on My Registation link");

			ap = new AccountRegistationPage(driver);
			logger.info("Providing Customer Data");

			ap.setFirstname(randomeString().toUpperCase());
			ap.setLastname(randomeString().toUpperCase());
			ap.setEmail(randomeString() + "@gmail.com");
			ap.setPassword(randomeAlphaNumeric());
			ap.clickPrivatePolicy();
			ap.clickContinue();
			logger.info("Clicked on continue");

			String conformMess = ap.getConformMess();
			logger.info("Validating expected message");
			Assert.assertEquals(conformMess, "Register Account", "Not getting  expected message");
		} catch (Exception e) {
			logger.error("test failed");
			Assert.fail();

		}
		logger.info("********Fineshed TC_001_AccountRegistationTest***********");

	}

}

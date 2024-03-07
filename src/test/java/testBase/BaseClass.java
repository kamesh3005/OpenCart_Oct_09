package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;// for logging
	public ResourceBundle rb;

	@BeforeClass
	@Parameters("browser")

	public void setup(String br) {

		rb = ResourceBundle.getBundle("config");// Load Config.properties file

		logger = LogManager.getLogger(this.getClass());// logging

		// ChromeOptions options = new ChromeOptions();// To disable the chrome is
		// controlled by automation tool
		// options.setExperimentalOption("excludeSwitches", new String[] {
		// "enable-automation" });
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("firfox")) {

			driver = new FirefoxDriver();
		} else {

			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get("https://demo.opencart.com");
		driver.get(rb.getString("appUrl"));
		driver.manage().window().maximize();

	}

	@AfterClass

	public void tearDown() {
		driver.close();

	}

	// To generated the Random string at the runtime
	public String randomeString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeAlphaNumeric() {

		String st = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(4);

		return (st + "@" + num);
	}

	public String captureScreen(String tname) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt = new Date();
		String timeStamp = df.format(dt);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshort/" + tname + "_" + timeStamp + ".png";

		try {
			File f = new File(destination);
			FileUtils.copyFile(source, f);
		} catch (Exception e) {

			e.getMessage();
		}
		return destination;
	}

}

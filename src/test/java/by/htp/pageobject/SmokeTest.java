package by.htp.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.pageobject.page.LoginPage;
import by.htp.pageobject.page.MailPage;

public class SmokeTest {
	private static WebDriver driver;
	private static MailPage mailPage;

	@BeforeClass
	public static void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "c://driver//geckodriver.exe");
		driver = new FirefoxDriver();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		mailPage = loginPage.login();
	}

	@Test
	public void sentBoxTest() {
		 mailPage.open();
		 mailPage.selectSentBox();
	}

	@Test
	public void sendMailTest() {
		mailPage.openEmailTemplate();
		mailPage.composeEmail();
	}

	@AfterClass
	public static void closeBrowser() {
		 driver.quit();
	}
}

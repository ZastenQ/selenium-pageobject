package by.htp.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {

	private final String url = "https://mail.ru/";

	private final By loginLocator = By.xpath("//*[@id='mailbox__login']");
	private final By passwordLocator = By.xpath("//*[@id='mailbox__password']");
	private final By submitLocator = By.xpath("//*[@id='mailbox__auth__button']");

	private final String login = "tathtp@mail.ru";
	private final String password = "Klopik123";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().get(url);
	}

	public MailPage login() {

		WebElement loginField = this.getDriver().findElement(loginLocator);
		loginField.sendKeys(login);

		WebElement passwordField = this.getDriver().findElement(passwordLocator);
		passwordField.sendKeys(password);

		WebElement submitButton = this.getDriver().findElement(submitLocator);
		submitButton.click();

		return new MailPage(driver);
	}

}

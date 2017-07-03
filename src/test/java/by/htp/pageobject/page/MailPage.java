package by.htp.pageobject.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailPage extends Page {

	private final String url = "https://e.mail.ru/messages/sent/";
	private final String urlSent = "https://e.mail.ru/messages/sent/?page=2";

	private final By sentMailLocator = By.xpath("//*[@class='b-datalist__item__subj']");

	private final By writeLetterLocator = By.xpath("//*[@data-name='compose']");
	private final By sendButtonLocator = By.xpath("//div[@data-name='send']");

	private final By toEmailLocator = By.xpath("//textarea[@data-original-name='To']");
	private final By subjectEmailLocator = By.xpath("//*[@name='Subject']");
	private final By textEmailLocator = By
			.xpath("//*[@class='compose__editor']//*[@class='w100']//div[@class='compose__editor__container']");

	private final String toEmail = "tathtp@mail.ru";
	private final String subjectEmail = "[HTP_JAVA_TAT3] Homework: Email from Mail.ru - Victor Zastenchik";
	private final String textEmail = "Hello! This is a test e-mail from mail.ru";

	public MailPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().findElement(By.xpath("//iframe"));
		getDriver().get(url);
	}

	public void selectSentBox() {
		List<WebElement> sentMail = new ArrayList<WebElement>();
		sentMail = getDriver().findElements(sentMailLocator);
		if (getDriver().findElement(By.xpath("//div[@data-name='next']")).isDisplayed()) {
			getDriver().get(urlSent);
			sentMail.addAll(getDriver().findElements(sentMailLocator));
		}
		System.out.println(sentMail.size());
	}

	public void openEmailTemplate() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().findElement(By.xpath("//iframe"));
		getDriver().findElement(writeLetterLocator).click();
	}

	private void waitElement() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void composeEmail() {
		WebElement to = getDriver().findElement(toEmailLocator);
		waitElement();
		to.sendKeys(toEmail);

		WebElement subj = getDriver().findElement(subjectEmailLocator);
		subj.sendKeys(subjectEmail);

		WebElement text = getDriver().findElement(textEmailLocator);
		text.sendKeys(Keys.TAB);
		text.sendKeys(textEmail);

		getDriver().findElement(sendButtonLocator).click();
	}
}

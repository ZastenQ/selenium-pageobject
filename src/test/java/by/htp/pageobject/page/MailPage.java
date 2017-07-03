package by.htp.pageobject.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailPage extends Page {

	private final String url = "https://e.mail.ru/messages/sent/";
	private final String urlSent = "https://e.mail.ru/messages/sent/?page=2";

	private final By sentMailLocator = By.xpath("//*[@class='b-datalist__item__subj']");

	public MailPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().findElement(By.xpath("//iframe"));
		getDriver().get(url);
		//
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
}

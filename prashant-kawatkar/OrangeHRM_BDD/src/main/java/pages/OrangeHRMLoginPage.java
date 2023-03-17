package pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMLoginPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	static Logger logger = Logger.getLogger(OrangeHRMLoginPage.class);

	public OrangeHRMLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[.=' Login ']")
	WebElement loginButton;

	public void loginToOrangeHRM(String uName, String pass) {
		wait.until(ExpectedConditions.visibilityOf(userName));
		logger.info("Entering user name");
		userName.sendKeys(uName);
		wait.until(ExpectedConditions.visibilityOf(password));
		logger.info("Entering user password");
		password.sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		loginButton.click();
	}
}

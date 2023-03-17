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

public class OrangeHRMAdminDashboard {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	static final Logger logger = Logger.getLogger(OrangeHRMAdminDashboard.class);

	public OrangeHRMAdminDashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitementTab;

	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminTab;
	
	@FindBy(xpath = "//span[normalize-space()='Leave']")
	WebElement leaveTab;

	@FindBy(className = "oxd-userdropdown-name")
	WebElement userProfile;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement userLogout;

	public void clickOnRecruitementTab() {
		wait.until(ExpectedConditions.elementToBeClickable(recruitementTab));
		recruitementTab.click();
	}

	public void clickOnAdminTab() {
		wait.until(ExpectedConditions.elementToBeClickable(adminTab));
		adminTab.click();
	}

	public void clickOnLeaveTab() {
		wait.until(ExpectedConditions.elementToBeClickable(leaveTab));
		leaveTab.click();
	}

	public void clickOnUserProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(userProfile));
		userProfile.click();
	}

	public void clickOnUserLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(userLogout));
		userLogout.click();
	}

}

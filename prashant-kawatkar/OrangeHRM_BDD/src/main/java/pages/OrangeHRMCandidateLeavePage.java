package pages;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMCandidateLeavePage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	static final Logger logger = Logger.getLogger(OrangeHRMCandidateLeavePage.class);

	public OrangeHRMCandidateLeavePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@FindBy(xpath = "//span[text()='Entitlements ']")
	WebElement entitlementsTab;

	@FindBy(xpath = "//a[text()='My Entitlements']")
	WebElement myEntitlementsLink;

	@FindBy(xpath = "//a[text()='Apply']")
	WebElement applyLeaveButton;

	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	WebElement leaveType;

	@FindBy(xpath = "//div[@role='listbox']/div/span")
	List<WebElement> leaveTypeList;

	@FindBy(xpath = "//label[text()='From Date']/parent::div/parent::div/descendant::input")
	WebElement fromDateInput;

	@FindBy(xpath = "//label[text()='To Date']/parent::div/parent::div/descendant::input")
	WebElement toDateInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement applyButton;

	public void clickOnEntitlementsTab() {
		wait.until(ExpectedConditions.elementToBeClickable(entitlementsTab));
		entitlementsTab.click();
	}

	public void clickOnApplyLeaveLink() {
		wait.until(ExpectedConditions.elementToBeClickable(applyLeaveButton));
		applyLeaveButton.click();
	}

	public void selectLeaveType() {
		wait.until(ExpectedConditions.visibilityOf(leaveType));
		leaveType.click();

		for (WebElement leaveType : leaveTypeList) {
			if (leaveType.getText().contains("Personal")) {
				wait.until(ExpectedConditions.visibilityOf(leaveType));
				leaveType.click();
				break;
			}
		}
	}

	public void enterFromDateAndToDate(String fromDate, String toDate) {
		wait.until(ExpectedConditions.visibilityOf(fromDateInput));
		fromDateInput.sendKeys(fromDate);
	}

	public void clickOnApplyButton() {

	}
}

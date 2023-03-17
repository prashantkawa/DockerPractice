package pages;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMAdminLeavePage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	static final Logger logger = Logger.getLogger(OrangeHRMAdminLeavePage.class);

	public OrangeHRMAdminLeavePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@FindBy(xpath = "//span[text()='Entitlements ']")
	WebElement entitlementsButton;

	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li")
	List<WebElement> entitlementsList;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']/descendant::input")
	WebElement employeeNameInput;

	@FindBy(xpath = "//div[@role='listbox']/div/span")
	List<WebElement> employeeList;

	@FindBy(xpath = "//div[text()='-- Select --']")
	WebElement leaveType;

	@FindBy(xpath = "//div[@role='listbox']/div/span")
	List<WebElement> leaveTypeList;

	@FindBy(xpath = "//label[text()='Entitlement']/parent::div/parent::div/descendant::input")
	WebElement entitlement;

	@FindBy(xpath = "//div[@class='orangehrm-modal-footer']/button[text()=' Confirm ']")
	WebElement confirmButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='oxd-table-card']/div/div[3]/div")
	List<WebElement> empNameLeaveData;

	public void clickOnEntitlementTab() {
		wait.until(ExpectedConditions.elementToBeClickable(entitlementsButton));
		entitlementsButton.click();
	}

	public void selectEntitlement() {
		
		for (WebElement entitlement : entitlementsList) {
			if (entitlement.getText().equals("Add Entitlements")) {
				wait.until(ExpectedConditions.visibilityOf(entitlement));
				entitlement.click();
				break;
			}
		}
	}

	public void selectEmployeeName(String empName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		employeeNameInput.click();

		employeeNameInput.sendKeys(empName);
		// Thread.sleep(5000);

		for (WebElement employee : employeeList) {
			if (employee.getText().contains("Andrew Flintoff")) {
				employee.click();
				break;
			}
		}
	}

	public void selectLeaveType() {
		wait.until(ExpectedConditions.visibilityOf(leaveType));
		leaveType.click();

		for (WebElement leaveType : leaveTypeList) {
			if (leaveType.getText().equals("CAN - Personal")) {
				wait.until(ExpectedConditions.visibilityOf(leaveType));
				leaveType.click();
				break;
			}
		}
	}

	public void selectLeavePeriod() {
	}

	public void enterEntitlements(String entitlement) {
		wait.until(ExpectedConditions.visibilityOf(this.entitlement));
		this.entitlement.sendKeys(entitlement);
	}

	public void clickOnSaveButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

	public void clickOnConfirmButton() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
		confirmButton.click();
	}

	public void clickOnApproveLeaveButton() {
		String empName = "Andrew  Flintoff";
		
		WebElement approveLeaveButton = driver
				.findElement(By.xpath("//div[text()='" + empName + "']/../../div[9]/div/button[text()=' Approve ']"));
		wait.until(ExpectedConditions.elementToBeClickable(approveLeaveButton));
		approveLeaveButton.click();

	}

}

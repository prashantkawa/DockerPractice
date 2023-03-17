package pages;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMAdmin_AdminPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	static final Logger logger = Logger.getLogger(OrangeHRMAdmin_AdminPage.class);

	public OrangeHRMAdmin_AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@FindBy(xpath = "//span[text()='User Management ']")
	WebElement userManagementTab;

	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li/a")
	WebElement users;

	@FindBy(xpath = "//div[@class='orangehrm-header-container']/button")
	WebElement addButton;

	@FindBy(xpath = "//label[text()='User Role']/parent::div/parent::div/descendant::div[@class='oxd-select-text-input']")
	WebElement userRole;

	@FindBy(xpath = "//div[@role='listbox']/div/span")
	List<WebElement> userRoleList;

	@FindBy(xpath = "//label[text()='Status']/parent::div/parent::div/descendant::div[@class='oxd-select-text-input']")
	WebElement status;

	@FindBy(xpath = "//div[@role='listbox']/div/span")
	List<WebElement> statusList;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement employeeName;

	@FindBy(xpath = "//div[@role='listbox']/div/span")
	List<WebElement> employeeNameList;

	@FindBy(xpath = "//label[text()='Username']/parent::div/parent::div/descendant::input")
	WebElement userName;

	@FindBy(xpath = "//label[text()='Password']/parent::div/parent::div/descendant::input")
	WebElement password;

	@FindBy(xpath = "//label[text()='Confirm Password']/parent::div/parent::div/descendant::input")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;

	public void clickOnUserManagementTab() {
		wait.until(ExpectedConditions.elementToBeClickable(userManagementTab));
		userManagementTab.click();
	}

	public void selectUsersOption() {
		wait.until(ExpectedConditions.elementToBeClickable(users));
		users.click();
	}

	public void clickOnAddButton() {
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}

	public void selectUserRole() {
		wait.until(ExpectedConditions.visibilityOf(userRole));
		userRole.click();

		for (WebElement usrRole : userRoleList) {
			if (usrRole.getText().equals("ESS")) {
				wait.until(ExpectedConditions.visibilityOf(usrRole));
				usrRole.click();
				break;
			}
		}
	}

	public void selectStatus() {
		wait.until(ExpectedConditions.visibilityOf(status));
		status.click();

		for (WebElement userStatus : statusList) {
			if (userStatus.getText().equals("Enabled")) {
				wait.until(ExpectedConditions.visibilityOf(userStatus));
				userStatus.click();
				break;
			}
		}
	}
	
	
	public void selectEmployeeName(String ename) {
		wait.until(ExpectedConditions.visibilityOf(userRole));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		employeeName.click();
		employeeName.sendKeys(ename);

		for (WebElement employeeName : employeeNameList) {
			if (employeeName.getText().contains("Andrew Flintoff")) {
				wait.until(ExpectedConditions.visibilityOf(employeeName));
				new Actions(driver).moveToElement(employeeName).click().perform();
				break;
			}
		}
	}

	public void enterUserName(String uname) {
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(uname);
	}

	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);
	}

	public void enterConfirmPassword(String cpass) {
		wait.until(ExpectedConditions.visibilityOf(confirmPassword));
		confirmPassword.sendKeys(cpass);
	}

	public void clickOnSaveButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

}

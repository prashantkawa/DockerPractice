package pages;

import java.time.Duration;
import java.util.List;
import common.Helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMAdminRecruitementPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Helper helper;

	static final Logger logger = Logger.getLogger(OrangeHRMAdminRecruitementPage.class);

	public OrangeHRMAdminRecruitementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		helper = new Helper();
	}

	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
	WebElement dashboardTxt;

	@FindBy(xpath = "//div[@class='orangehrm-paper-container']/div/button")
	WebElement addButton;

	@FindBy(name = "firstName")
	WebElement firstName;

	@FindBy(name = "middleName")
	WebElement middleName;

	@FindBy(name = "lastName")
	WebElement lastName;

	@FindBy(className = "oxd-select-text-input")
	WebElement vacancyDropdown;

	@FindBy(xpath = "//div[@role='listbox']/div/span")
	List<WebElement> vacancyRoleList;

	@FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']/label[text()='Email']/parent::div/parent::div/div[2]/input")
	WebElement email;

	@FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']/label[text()='Contact Number']/parent::div/parent::div/div[2]/input")
	WebElement contactNumber;

	@FindBy(className = "oxd-file-input-div")
	WebElement resumeBrowseButton;

	@FindBy(xpath = "//div[@class='orangehrm-recruitment-status']/p")
	WebElement applicationStatus;

	@FindBy(xpath = "//button[normalize-space()='Reject']")
	WebElement rejectButton;

	@FindBy(xpath = "//button[normalize-space()='Shortlist']")
	WebElement shortlistButton;

	@FindBy(xpath = "//div[@class='orangehrm-recruitment-actions']/button[2]")
	WebElement scheduleInterviewButton;

	@FindBy(xpath = "//label[text()='Interview Title']/parent::div/parent::div//descendant::input")
	WebElement interviewTitle;

	@FindBy(xpath = "//label[text()='Interviewer']/parent::div/parent::div//descendant::input")
	WebElement interviewerInput;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-option']/span")
	List<WebElement> interviewerList;

	@FindBy(xpath = "//div[@class='oxd-date-input']/input")
	WebElement date;

	@FindBy(xpath = "//div[@class='oxd-time-input']/input")
	WebElement time;

	@FindBy(xpath = "input[@name='pm']")
	WebElement pm;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='submit']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='orangehrm-recruitment-actions']/button[3]")
	WebElement markInterviewPassedButton;

	@FindBy(xpath = "//descendant::textarea")
	WebElement markInterviewPassesNotes;

	@FindBy(xpath = "//div[@class='orangehrm-recruitment-actions']/button[3]")
	WebElement offerJobButton;

	@FindBy(xpath = "//descendant::textarea")
	WebElement offerJobNotes;

	@FindBy(xpath = "//div[@class='oxd-form-actions']/button[2]")
	WebElement offerJobSaveButton;

	@FindBy(xpath = "//button[text()=' Hire ']")
	WebElement hireButton;

	// Verifying used logged in or failed to login
	public void verifyLogin() {
		wait.until(ExpectedConditions.visibilityOf(dashboardTxt));
		String dashboardText = dashboardTxt.getText();

		if (dashboardText.equals("Dashboard")) {
			logger.info("Logged in successfully");
		} else {
			logger.info("Login failed, Pleas try login again");
		}
	}

	// Clicking on add button to create candidate profile
	public void clickOnAddButton() {
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}

	// Selecting candidate Personal details as First Name, Middle Name and Last Name
	public void enterCandidatePersonalDetails(String fname, String mname, String lname) {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(fname);
		wait.until(ExpectedConditions.visibilityOf(middleName));
		middleName.sendKeys(mname);
		wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.sendKeys(lname);
	}

	// Selecting candidate Vacancy details
	public void selectVacancyFor() {
		wait.until(ExpectedConditions.elementToBeClickable(vacancyDropdown));
		vacancyDropdown.click();

		for (WebElement vacancyRole : vacancyRoleList) {
			if (vacancyRole.getText().equals("Senior QA Lead")) {
				wait.until(ExpectedConditions.elementToBeClickable(vacancyRole));
				vacancyRole.click();
				break;
			}
		}

	}

	// Entering candidate contact details
	public void enterContactDetails(String emailD, String contactD) {
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(emailD);
		wait.until(ExpectedConditions.visibilityOf(contactNumber));
		contactNumber.sendKeys(contactD);
	}

	public void uploadResume() {

	}

	// Clicking on save button
	public void clickOnSaveButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		boolean b = saveButton.isDisplayed();
		logger.info(b);
		saveButton.click();
	}

	// Verifying application status after saving candidate details
	public void verifyApplicationStatus() {
		wait.until(ExpectedConditions.visibilityOf(applicationStatus));
		if (applicationStatus.getText().contains("Application Initiated")
				|| applicationStatus.getText().contains("Shortlisted")
				|| applicationStatus.getText().contains("Interview Scheduled")
				|| applicationStatus.getText().contains("Interview Passed")
				|| applicationStatus.getText().contains("Job Offered")
				|| applicationStatus.getText().contains("Hired")) {
			logger.info("Saved successfully");
		} else {
			logger.error("Failed to save, Please try again");
		}
	}

	// Clicking on shortlist button to short list the candidate profile
	public void clickOnShortlist() {
		wait.until(ExpectedConditions.elementToBeClickable(shortlistButton));
		shortlistButton.click();
	}

	// Clicking on Schedule Interview button to schedule the interview for newly
	// created candidate
	public void clickOnScheduleInterview() {
		wait.until(ExpectedConditions.elementToBeClickable(scheduleInterviewButton));
		scheduleInterviewButton.click();
	}

	// Entering Interview Title details
	public void enterInterviewTitle(String title) {
		wait.until(ExpectedConditions.visibilityOf(interviewTitle));
		interviewTitle.sendKeys(title);
	}

	// Selecting Interviewer details to take the interview of that candidate
	public void selectInterviewer(String interviewer) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		this.interviewerInput.sendKeys(interviewer);

		for (WebElement interviewerOpt : interviewerList) {
			if (interviewerOpt.getText().contains("Jordan Mathews")) {
				new Actions(driver).moveToElement(interviewerOpt).click().perform();
				break;
			}
		}

	}

	// Selecting the date for the Interview
	public void selectInterviewDate(String date) {
		wait.until(ExpectedConditions.visibilityOf(this.date));
		this.date.sendKeys(date);
	}

	// Selecting the time for the Interview
	public void selectInterviewTime(String time) {
		wait.until(ExpectedConditions.visibilityOf(this.time));
		this.time.click();
		this.time.clear();
		this.time.sendKeys(time);
	}

	// Clicking on save button
	public void clickScheduleInterviewSaveButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

	// Clicking on Mark interview passed button
	public void clickOnMarkInterviewPassedButton() {
		wait.until(ExpectedConditions.elementToBeClickable(markInterviewPassedButton));
		markInterviewPassedButton.click();
	}

	// Entering notes for Mark interview passed
	public void enterNotes(String notes) {
		wait.until(ExpectedConditions.visibilityOf(markInterviewPassesNotes));
		markInterviewPassesNotes.sendKeys(notes);
	}

	// Clicking on Mark interview passed Save button
	public void clickOnMarkInterviewPassSaveButton() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

	// Clicking on Offer job button
	public void clickOnOfferJobButton() {
		wait.until(ExpectedConditions.elementToBeClickable(offerJobButton));
		offerJobButton.click();
	}

	// Entering notes to offer job
	public void enterNotesToOfferJob(String notes) {
		wait.until(ExpectedConditions.visibilityOf(offerJobNotes));
		offerJobNotes.sendKeys(notes);
	}

	// Clicking on Offer job Save button
	public void clickOnOfferJobSaveButton() {
		wait.until(ExpectedConditions.elementToBeClickable(offerJobSaveButton));
		offerJobSaveButton.click();
	}

	public void clickOnHireButton() {
		wait.until(ExpectedConditions.elementToBeClickable(hireButton));
		hireButton.click();
	}

}

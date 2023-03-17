package steps;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import common.SelectDriverToTest;
import io.cucumber.java.en.*;
import pages.OrangeHRMAdminDashboard;
import pages.OrangeHRMAdminLeavePage;
import pages.OrangeHRMAdminRecruitementPage;
import pages.OrangeHRMAdmin_AdminPage;
import pages.OrangeHRMCandidateLeavePage;
import pages.OrangeHRMLoginPage;

public class OrangeHRMSteps {

	WebDriver driver;
	OrangeHRMAdminDashboard adminDashboard;
	OrangeHRMAdminRecruitementPage recruitementPage;
	OrangeHRMLoginPage loginPage;
	OrangeHRMAdminLeavePage leavePage;
	OrangeHRMAdmin_AdminPage adminPage;
	OrangeHRMCandidateLeavePage candidateLeavePage;
	
	public void initBrowser() {
		
	}
	
	@BeforeSuite
	@Given("I open browser {string}")
	public void i_open_browser(String browser) {
		driver = SelectDriverToTest.getDriver(browser);
		driver.manage().window().maximize();
	}

	@Given("I enter url {string}")
	public void i_enter_url(String url) {
		driver.get(url);
		adminDashboard = new OrangeHRMAdminDashboard(driver);
		recruitementPage = new OrangeHRMAdminRecruitementPage(driver);
		loginPage = new OrangeHRMLoginPage(driver);
		leavePage = new OrangeHRMAdminLeavePage(driver);
		adminPage = new OrangeHRMAdmin_AdminPage(driver);
		candidateLeavePage = new OrangeHRMCandidateLeavePage(driver);
		
	}

	@When("I enter admin username {string} and password {string} to login")
	public void i_enter_admin_username_and_password_to_login(String userName, String password) {

		loginPage.loginToOrangeHRM(userName, password);

	}

	@Then("I verify user logged in successfully")
	public void i_verify_user_logged_in_successfully() {

		recruitementPage.verifyLogin();

	}

	@Then("I click on Recruitement tab")
	public void i_click_on_recruitement_tab() {
		adminDashboard.clickOnRecruitementTab();
	}

	@Then("I click on Add button to recruite")
	public void i_click_on_add_button_to_recruite() {
		recruitementPage.clickOnAddButton();
	}

	@When("I enter FirstName {string} And MiddleName {string} And LastName {string}")
	public void i_enter_first_name_and_middle_name_and_last_name(String fname, String mname, String lname) {
		recruitementPage.enterCandidatePersonalDetails(fname, mname, lname);
	}

	@And("I enter Email {string} And Contact Number {string}")
	public void i_enter_email_and_contact_number(String email, String contactNumber) {
		recruitementPage.enterContactDetails(email, contactNumber);
	}

	@And("I select Vacancy for")
	public void i_select_vacancy_for() {
		recruitementPage.selectVacancyFor();
	}

	@And("I click on resume browse button and upload the resume")
	public void i_click_on_resume_browse_button_and_upload_the_resume() {
		recruitementPage.uploadResume();
	}

	@When("I click on Save button")
	public void i_click_on_save_button() {
		recruitementPage.clickOnSaveButton();
	}

	@Then("I verify Application status")
	public void i_verify_application_status() {
		recruitementPage.verifyApplicationStatus();
	}

	@Then("I click on Shortlist button")
	public void i_click_on_shortlist_button() {
		recruitementPage.clickOnShortlist();
	}

	@Then("I click on Schedule Interview button")
	public void i_click_on_schedule_interview_button() {
		recruitementPage.clickOnScheduleInterview();
	}

	@When("I enter Interview Title {string}")
	public void i_enter_interview_title(String interviewTitle) {
		recruitementPage.enterInterviewTitle(interviewTitle);
	}

	@And("I select Interviewer {string}")
	public void i_select_interviewer(String interviewer) throws InterruptedException {
		recruitementPage.selectInterviewer(interviewer);
	}

	@And("I select Date {string}")
	public void i_select_date(String date) {
		recruitementPage.selectInterviewDate(date);
	}

	@And("I select Time {string}")
	public void i_select_time(String time) {
		recruitementPage.selectInterviewTime(time);
	}

	@Then("I verify interview scheduled status")
	public void i_verify_interview_scheduled_status() {
		recruitementPage.verifyApplicationStatus();
	}

	@Then("I click on Mark Interview Passed button")
	public void i_click_on_mark_interview_passed_button() {
		recruitementPage.clickOnMarkInterviewPassedButton();
	}

	@When("I enter Notes {string}")
	public void i_enter_notes(String notes) {
		recruitementPage.enterNotes(notes);
	}

	@Then("I verify interview passed status")
	public void i_verify_interview_passed_status() {
		recruitementPage.verifyApplicationStatus();
	}

	@Then("I click on offer job button")
	public void i_click_on_offer_job_button() {
		recruitementPage.clickOnOfferJobButton();
	}

	@Then("I verify offer job status")
	public void i_verify_offer_job_status() {
		recruitementPage.verifyApplicationStatus();
	}

	@Then("I click on Hire button")
	public void i_click_on_hire_button() {
		recruitementPage.clickOnHireButton();
	}

	@Then("I verify Hire status")
	public void i_verify_hire_status() {
		recruitementPage.verifyApplicationStatus();
	}

	@Then("I click on Admin tab")
	public void i_click_on_admin_tab() {
		adminDashboard.clickOnAdminTab();
	}

	@Then("I click on User management tab")
	public void i_click_on_user_management_tab() {
		adminPage.clickOnUserManagementTab();
	}

	@Then("I select users")
	public void i_select_users() {
		adminPage.selectUsersOption();
	}

	@Then("I click on Add button")
	public void i_click_on_add_button() {
		adminPage.clickOnAddButton();
	}

	@When("I select user role")
	public void i_select_user_role() {
		adminPage.selectUserRole();
	}

	@And("I select user status")
	public void i_select_user_status() {
		adminPage.selectStatus();
	}

	@And("I select employee name as {string}")
	public void i_select_employee_name_as(String ename) {
		adminPage.selectEmployeeName(ename);
	}

	@And("I enter username {string}")
	public void i_enter_username(String uname) {
		adminPage.enterUserName(uname);
	}

	@And("I enter password {string}")
	public void i_enter_password(String pass) {
		adminPage.enterPassword(pass);
	}

	@And("I enter confirm password {string}")
	public void i_enter_confirm_password(String cpass) {
		adminPage.enterConfirmPassword(cpass);
	}

	@Then("I click on Add user Save button")
	public void i_click_on_add_user_save_button() {
		adminPage.clickOnSaveButton();
	}

	@Then("I click on Leave tab")
	public void i_click_on_leave_tab() {
		adminDashboard.clickOnLeaveTab();
	}

	@Then("I click on Entitlements tab")
	public void i_click_on_entitlements_tab() {
		leavePage.clickOnEntitlementTab();
	}

	@When("I select entitlement from list")
	public void i_select_entitlement_from_list() {
		leavePage.selectEntitlement();
	}

	@And("I select Employee name {string}")
	public void i_select_employee_name(String ename) {
		leavePage.selectEmployeeName(ename);
	}

	@And("I select Leave type")
	public void i_select_leave_type() {
		leavePage.selectLeaveType();
	}

	@And("I select Leave period")
	public void i_select_leave_period() {
		leavePage.selectLeavePeriod();
	}

	@And("I enter Entitlements {string}")
	public void i_enter_entitlements(String entitlementDays) {
		leavePage.enterEntitlements(entitlementDays);
	}

	@Then("I click on Add leave Save button")
	public void i_click_on_add_leave_save_button() {
		leavePage.clickOnSaveButton();
	}

	@And("I confirm the submit")
	public void i_confirm_the_submit() {
		leavePage.clickOnConfirmButton();
	}

	@Then("I click on User profile")
	public void i_click_on_user_profile() {
		adminDashboard.clickOnUserProfile();
	}

	@Then("I click on User logout button")
	public void i_click_on_user_logout_button() {
		adminDashboard.clickOnUserLogout();
	}

	@When("I enter candidate username {string} And password {string} And click on Login")
	public void i_enter_candidate_username_and_password_and_click_on_login(String uname, String pass) {
		loginPage.loginToOrangeHRM(uname, pass);
	}

	@Then("I click on Apply link")
	public void i_click_on_apply_link() {
		candidateLeavePage.clickOnApplyLeaveLink();
	}

	@Then("I select candidate Leave type")
	public void i_select_candidate_leave_type() {
		candidateLeavePage.selectLeaveType();
	}

	@Then("I select leave from date {string} And to date {string}")
	public void i_select_leave_from_date_and_to_date(String fromDate, String toDate) {
		candidateLeavePage.enterFromDateAndToDate(fromDate, toDate);
	}

	@Then("I click on Apply button")
	public void i_click_on_apply_button() {
		candidateLeavePage.clickOnApplyButton();
	}

	@Then("I click on Approve leave button")
	public void i_click_on_approve_leave_button() {
		leavePage.clickOnApproveLeaveButton();
	}

}

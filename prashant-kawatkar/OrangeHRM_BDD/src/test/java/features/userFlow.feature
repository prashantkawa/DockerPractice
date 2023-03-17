@User_Flow
Feature:
  Verify that Orange HRM page is loading and able to create user flow

  @OrangeHRMAssignment
  Scenario Outline: Validate orange HRM user flow
  	Given I open browser <browser>
    And I enter url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I enter admin username <userName> and password <password> to login
    Then I verify user logged in successfully

		Then I click on Recruitement tab
		Then I click on Add button to recruite
		When I enter FirstName <fName> And MiddleName <midName> And LastName <lName>
		And I enter Email <email> And Contact Number <contactNumber>
		And I select Vacancy for
		And I click on resume browse button and upload the resume
		When I click on Save button
		Then I verify Application status

		Then I click on Shortlist button
		When I click on Save button
		Then I verify Application status

		Then I click on Schedule Interview button
		When I enter Interview Title <title>
		And I select Interviewer <interviewer>
		And I select Date <date>
		And I select Time <time>
		When I click on Save button
		Then I verify interview scheduled status

		Then I click on Mark Interview Passed button
		When I enter Notes <notes>
		When I click on Save button
		Then I verify interview passed status

		Then I click on offer job button
		When I enter Notes <notes>
		When I click on Save button
		Then I verify offer job status

		Then I click on Hire button
		When I enter Notes <notes>
		When I click on Save button
		Then I verify Hire status

		Then I click on Admin tab
		Then I click on Add button
		When I select user role
		And I select user status
		And I select employee name as <empName>
		And I enter username <uname>
		And I enter password <pass>
		And I enter confirm password <pass>
		Then I click on Add user Save button
		
		Then I click on Leave tab
		Then I click on Entitlements tab
		When I select entitlement from list
		And I select Employee name <empName>
		And I select Leave type
		And I select Leave period
		And I enter Entitlements <LeaveDays>
		Then I click on Add leave Save button
		And I confirm the submit
		
		Then I click on User profile
		Then I click on User logout button
		
		When I enter candidate username <uname> And password <pass> And click on Login
		Then I verify user logged in successfully
		
		Then I click on Leave tab
		Then I click on Apply link
		Then I select candidate Leave type
		Then I select leave from date <LFDate> And to date <LTDate>
		Then I click on Apply button
		
		Then I click on User profile
		Then I click on User logout button

		Then I enter admin username <userName> and password <password> to login
    Then I verify user logged in successfully
    Then I click on Leave tab
    Then I click on Approve leave button

		Examples:  
    |browser|userName |password   |fName|midName|lName |email					 |contactNumber|title |interviewer|date				 |time			|notes |empName|LeaveDays|uname		|pass			 |LFDate			|LTDate			 |
    |"chrome"|"admin"	|"admin123"	|"Andrew"|""			|"Flintoff"|"andrewf@test.com"|"1234567890" |"test"|"jo"	|"2023-02-10"|"01:00 PM"|"test"|"and"	 |"10"		 |"andrewf"|"Andrew@123"|"2023-02-21"|"2023-02-22"|
    
    
    
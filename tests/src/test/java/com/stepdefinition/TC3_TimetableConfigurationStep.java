package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;
import com.opencsv.exceptions.CsvException;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_TimetableConfigurationStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("the user is logged into the School Admin Dashboard")
	public void theUserIsLoggedIntoTheSchoolAdminDashboard()
			throws FileNotFoundException, IOException, InterruptedException, AWTException {

//		enterUrl(getPropertyFileValue("schooladminurl1"));
//		pom.getStudentInformationPage().SchoolAdminLogin();

	}

	@When("the user configures subject hours in the {string} page")
	public void theUserConfiguresSubjectHoursInThePage(String string)
			throws FileNotFoundException, InterruptedException, IOException, CsvException {
		pom.getTimetableConfigurationPage().ConfigureSubjectHours();

	}

	@When("the user configures holiday information for the academic year in the {string} page")
	public void theUserConfiguresHolidayInformationForTheAcademicYearInThePage(String string)
			throws FileNotFoundException, IOException, CsvException, AWTException, InterruptedException {

		pom.getTimetableConfigurationPage().ConfigureHolidays();

	}

	@When("the user navigates to the {string} page in the School Admin Dashboard")
	public void theUserNavigatesToThePageInTheSchoolAdminDashboard(String string)
			throws FileNotFoundException, IOException, CsvException {

		pom.getTimetableConfigurationPage().NavigateToManageTimetable();

	}

	@When("the user enters all the required credentials for creating the timetable")
	public void theUserEntersAllTheRequiredCredentialsForCreatingTheTimetable()
			throws FileNotFoundException, IOException, CsvException, InterruptedException, AWTException {

		pom.getTimetableConfigurationPage().RequiredCredentialsForTimetableCreation();

	}

	@When("the user configures and publishes the timetable")
	public void theUserConfiguresAndPublishesTheTimetable() throws InterruptedException {

		pom.getTimetableConfigurationPage().ConfiguresAndPublishesTheTimetable();
	}

	@Then("the user verifies the successful popup message")
	public void theUserVerifiesTheSuccessfulPopupMessage() {

		pom.getTimetableConfigurationPage().VerifiesTheSuccessfulPopupMessage();

	}

}

package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;
import com.opencsv.exceptions.CsvException;
import com.pagemanager.PageObjectManager;
import com.pages.StudentInformationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class TC1_StudentInformationStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	// 1. School Admin Login

	@Given("the user is logged into the school admin dashboard")
	public void theUserIsLoggedIntoTheSchoolAdminDashboard()
			throws FileNotFoundException, IOException, InterruptedException, AWTException {

		enterUrl(getPropertyFileValue("schooladminurl"));
		pom.getStudentInformationPage().SchoolAdminLogin();
	}

	// 2. Teacher Dashboard Login

	@Given("the user is logged into the teacher dashboard")
	public void theUserIsLoggedIntoTheTeacherDashboard()
			throws FileNotFoundException, InterruptedException, IOException {

		driver.switchTo().newWindow(WindowType.TAB);
		switchToNewTab1(driver);

		enterUrl(getPropertyFileValue("teacherdashboardurl"));
		Thread.sleep(3000);
		pom.getStudentInformationPage().TeacherLogin();

	}

	// 3. Principal Dashboard Login

	@Given("the user is logged into the principal dashboard")
	public void theUserIsLoggedIntoThePrincipalDashboard() throws FileNotFoundException, IOException {

		driver.switchTo().newWindow(WindowType.TAB);
		switchToNewTab1(driver);

		enterUrl(getPropertyFileValue("principaldashboardurl"));
		pom.getStudentInformationPage().PrincipalLogin();

		switchToNewTabByIndex(driver, 0);

	}

	// 4. Cretae New Student Using Csv

	@When("the user navigates to the create student profile page in the School Admin Dashboard")
	public void theUserNavigatesToTheCreateStudentProfilePageInTheSchoolAdminDashboard() {

		pom.getCreateNewStudentPage().NavigateToTheCreateStudentProfilePage();
	}

	@When("the user creates a new student profile in the School Admin Dashboard")
	public void theUserCreatesANewStudentProfileInTheSchoolAdminDashboard()
			throws InterruptedException, IOException, AWTException, CsvException {

		pom.getCreateNewStudentPage().CreateNewStudentProfile();

		Thread.sleep(3000);

	}
	// 5. School Admin Dashboard

	@When("the user navigates to the Student Management of School Admin Dashboard")
	public void theUserNavigatesToTheStudentManagementOfSchoolAdminDashboard()
			throws FileNotFoundException, AWTException, IOException {

		pom.getStudentInformationPage().NaviagteToTheStudentManagement();

	}

	@Then("the user verifies Student ID with Student Id in the CSV File")
	public void theUserVerifiesStudentIDWithStudentIdInTheCSVFile() throws FileNotFoundException, IOException {
		pom.getStudentInformationPage().VerifyStudentID();

	}

	@Then("the user identifies and records the Student Details in School Admin Dashboard")
	public void theUserIdentifiesAndRecordsTheStudentDetailsInSchoolAdminDashboard() throws IOException {

		pom.getStudentInformationPage().IdentifyAndRecordTheStudentDetails();
	}

	@Then("the user identifies and records the Parent Details in School Admin Dashboard")
	public void theUserIdentifiesAndRecordsTheParentDetailsInSchoolAdminDashboard() throws InterruptedException {

		pom.getStudentInformationPage().IdentifyAndRecordTheParentDetailsInSchoolAdminDashboard();

	}

	@Then("the user identifies and records the Class Details in School Admin Dashboard")
	public void theUserIdentifiesAndRecordsTheClassDetailsInSchoolAdminDashboard() throws InterruptedException {
		pom.getStudentInformationPage().IdentifyAndRecordTheClassDetailsInSchoolAdminDashboard();
		switchToNewTabByIndex(driver, 1);

	}

	@Then("the user should verify the Student Details in School Admin Dashboard with CSV File")
	public void theUserShouldVerifyTheStudentDetailsInSchoolAdminDashboardWithCSVFile() {

		pom.getStudentInformationPage().VerifyTheStudentDetailsInSchoolAdminDashboardWithCSVFile();
	}

	@Then("the user should verify the Parent Details in School Admin Dashboard with CSV File")
	public void theUserShouldVerifyTheParentDetailsInSchoolAdminDashboardWithCSVFile() {

		pom.getStudentInformationPage().VerifyTheParentDetailsInSchoolAdminDashboardWithCSVFile();
	}

	@Then("the user should verify the Class Details in School Admin Dashboard with CSV File")
	public void theUserShouldVerifyTheClassDetailsInSchoolAdminDashboardWithCSVFile() {
		pom.getStudentInformationPage().VerifyTheClassDetailsInSchoolAdminDashboardWithCSVFile();

	}

	// 6. Teacher Dashboard

	@When("the user navigates to the Student Details page in the Teacher Dashboard")
	public void theUserNavigatesToTheStudentDetailsPageInTheTeacherDashboard()
			throws FileNotFoundException, IOException {

		pom.getStudentInformationPage().NaviagteToTheStudentDetailsPage();
	}

	@Then("the user verifies Student ID in the Teacher Dashboard with Student Id in the CSV File")
	public void theUserVerifiesStudentIDInTheTeacherDashboardWithStudentIdInTheCSVFile()
			throws FileNotFoundException, IOException {

		pom.getStudentInformationPage().VerifyStudentIDInTheTeacherDashboard();

	}

	@Then("the user identifies and records the student details in Teacher Dashboard")
	public void theUserIdentifiesAndRecordsTheStudentDetailsInTeacherDashboard() {
		pom.getStudentInformationPage().IdentifyAndRecordTheStudentDetailsInTeacherDashboard();

	}

	@Then("the user identifies and records the Parent Details in Teacher Dashboard")
	public void theUserIdentifiesAndRecordsTheParentDetailsInTeacherDashboard() throws InterruptedException {
		pom.getStudentInformationPage().IdentifyAndRecordTheParentDetailsInTeacherDashboard();

	}

	@Then("the user identifies and records the Class Details in Teacher Dashboard")
	public void theUserIdentifiesAndRecordsTheClassDetailsInTeacherDashboard() throws InterruptedException {
		pom.getStudentInformationPage().IdentifyAndRecordTheClassDetailsInTeacherDashboard();

	}

	@Then("the user should verify the Student Details in Teacher Dashboard with CSV File")
	public void theUserShouldVerifyTheStudentDetailsInTeacherDashboardWithCSVFile() {

		pom.getStudentInformationPage().VerifyTheStudentDetailsInTeacherDashboardWithCSVFile();

	}

	@Then("the user should verify the Parent Details in Teacher Dashboard with CSV File")
	public void theUserShouldVerifyTheParentDetailsInTeacherDashboardWithCSVFile() {
		pom.getStudentInformationPage().VerifyTheParentDetailsInTeacherDashboardWithCSVFile();

	}

	@Then("the user should verify the Class Details in Teacher Dashboard with CSV File")
	public void theUserShouldVerifyTheClassDetailsInTeacherDashboardWithCSVFile() {
		pom.getStudentInformationPage().VerifyTheClassDetailsInTeacherDashboardWithCSVFile();
		switchToNewTabByIndex(driver, 2);

	}

	// 7. Principal Dashboard

	@When("the user navigates to the Student Page of Principal Dashboard")
	public void theUserNavigatesToTheStudentPageOfPrincipalDashboard() throws FileNotFoundException, IOException {

		pom.getStudentInformationPage().NaviagteToTheStudentPageOfPrincipalDashboard();

	}

	@Then("the user verifies Student ID in the Principal Dashboard with Student Id in the CSV File")
	public void theUserVerifiesStudentIDInThePrincipalDashboardWithStudentIdInTheCSVFile()
			throws FileNotFoundException, IOException, InterruptedException {

		pom.getStudentInformationPage().VerifyStudentIDInThePrincipalDashboard();
	}

	@Then("the user identifies and records the student details in Principal Dashboard")
	public void theUserIdentifiesAndRecordsTheStudentDetailsInPrincipalDashboard() {
		pom.getStudentInformationPage().IdentifyAndRecordTheStudentDetailsInPrincipalDashboard();

	}

	@Then("the user identifies and records the Parent Details in Principal Dashboard")
	public void theUserIdentifiesAndRecordsTheParentDetailsInPrincipalDashboard() throws InterruptedException {

		pom.getStudentInformationPage().IdentifyAndRecordTheParentDetailsInPrincipalDashboard();

	}

	@Then("the user identifies and records the Class Details in Principal Dashboard")
	public void theUserIdentifiesAndRecordsTheClassDetailsInPrincipalDashboard() throws InterruptedException {

		pom.getStudentInformationPage().IdentifyAndRecordTheClassDetailsInPrincipalDashboard();
	}

	@Then("the user should verify the Student Details in Principal Dashboard with CSV File")
	public void theUserShouldVerifyTheStudentDetailsInPrincipalDashboardWithCSVFile() {

		pom.getStudentInformationPage().VerifyTheStudentDetailsInPrincipalDashboardWithCSVFile();

	}

	@Then("the user should verify the Parent Details in Principal Dashboard with CSV File")
	public void theUserShouldVerifyTheParentDetailsInPrincipalDashboardWithCSVFile() {

		pom.getStudentInformationPage().VerifyTheParentDetailsInPrincipalDashboardWithCSVFile();
	}

	@Then("the user should verify the Class Details in Principal Dashboard with CSV File")
	public void theUserShouldVerifyTheClassDetailsInPrincipalDashboardWithCSVFile() {
		pom.getStudentInformationPage().VerifyTheClassDetailsInPrincipalDashboardWithCSVFile();

	}

}

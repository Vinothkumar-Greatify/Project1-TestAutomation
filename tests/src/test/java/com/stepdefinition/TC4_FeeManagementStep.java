package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_FeeManagementStep {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @author mullai
	 * @see Create School Fee, AddOn Fee, Fee Discount
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws CsvException
	 */

	@When("the user creates new School Fees")
	public void theUserCreatesNewSchoolFees() throws FileNotFoundException, IOException, CsvException {

		pom.getFeeManagementPage().CreatesNewSchoolFees();

	}

	@Then("the user should see the created School Fees")
	public void theUserShouldSeeTheCreatedSchoolFees() {

		pom.getFeeManagementPage().VerifySchoolFeesCreated();

	}

	@Then("the user publish the School fees")
	public void theUserPublishTheSchoolFees() throws InterruptedException {

		pom.getFeeManagementPage().PublishTheSchoolFees();
	}

	@When("the user creates new Add-On Fees")
	public void theUserCreatesNewAddOnFees()
			throws FileNotFoundException, IOException, CsvException, AWTException, InterruptedException {

		pom.getFeeManagementPage().CreatesNewAddOnFees();

	}

	@Then("the user should see the created Add-On Fees")
	public void theUserShouldSeeTheCreatedAddOnFees() {

		pom.getFeeManagementPage().VerifyAddOnFeeCreated();
	}

	@When("the user creates new Fee Discount")
	public void theUserCreatesNewFeeDiscount() throws FileNotFoundException, IOException, CsvException, AWTException {

		pom.getFeeManagementPage().CreatesNewFeeDiscount();

	}

	@Then("the user should see the created Fee Discount")
	public void theUserShouldSeeTheCreatedFeeDiscount() {

		pom.getFeeManagementPage().VerifyCreatedFeeDiscount();

	}

	/**
	 * @author mullai
	 * @see Updates
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws CsvException
	 * @throws InterruptedException
	 */

	@When("the user updates the School Fees")
	public void theUserUpdatesTheSchoolFees()
			throws FileNotFoundException, IOException, CsvException, InterruptedException {

		pom.getFeeManagementPage().UpdatesTheSchoolFees();
	}

	@Then("the user should see the updated School Fees")
	public void theUserShouldSeeTheUpdatedSchoolFees() {

		pom.getFeeManagementPage().VerifySchoolFeesUpdated();

	}

	@When("the user updates the Add-On Fees")
	public void theUserUpdatesTheAddOnFees() {
	}

	@Then("the user should see the updated Add-On Fees")
	public void theUserShouldSeeTheUpdatedAddOnFees() {
	}

	@When("the user updates the Fee Discount")
	public void theUserUpdatesTheFeeDiscount() {
	}

	@Then("the user should see the updated Fee Discount")
	public void theUserShouldSeeTheUpdatedFeeDiscount() {
	}

	/**
	 * @author mullai
	 * @see Delete
	 */

	@When("the user deletes the School Fees")
	public void theUserDeletesTheSchoolFees() {

		pom.getFeeManagementPage().DeletesTheSchoolFees();
	}

	@Then("the user should verify that the School Fees are deleted")
	public void theUserShouldVerifyThatTheSchoolFeesAreDeleted() {

		pom.getFeeManagementPage().VerifyThatTheSchoolFeesAreDeleted();

	}

	@When("the user deletes the Add-On Fees")
	public void theUserDeletesTheAddOnFees() {

		pom.getFeeManagementPage().DeletesTheAddOnFees();
	}

	@Then("the user should verify that the Add-On Fee is deleted")
	public void theUserShouldVerifyThatTheAddOnFeeIsDeleted() {

		pom.getFeeManagementPage().VerifyAddOnFeeIsDeleted();

	}

	@When("the user deletes the Fee Discount")
	public void theUserDeletesTheFeeDiscount()
			throws InterruptedException, FileNotFoundException, IOException, CsvException {
		pom.getFeeManagementPage().DeletesTheFeeDiscount();
	}

	@Then("the user should verify that the Fee Discount is deleted")
	public void theUserShouldVerifyThatTheFeeDiscountIsDeleted() {

		pom.getFeeManagementPage().VerifyFeeDiscountIsDeleted();

	}

}

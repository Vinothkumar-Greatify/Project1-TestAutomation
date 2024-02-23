package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;
import com.opencsv.exceptions.CsvException;

public class FeeManagementPage extends BaseClass {

	int selectClass = 0;

	Scanner scanner;
	int rowNum = 1;

	public FeeManagementPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * 1. creates new School Fees
	 */

	@FindBy(id = "leadManagementSection")
	private WebElement admissionAndFeesMainMenu;
	@FindBy(id = "sideFee")
	private WebElement manageFeesMainMenu;

	public WebElement getAdmissionAndFeesMainMenu() {
		return admissionAndFeesMainMenu;
	}

	public void setAdmissionAndFeesMainMenu(WebElement admissionAndFeesMainMenu) {
		this.admissionAndFeesMainMenu = admissionAndFeesMainMenu;
	}

	public WebElement getManageFeesMainMenu() {
		return manageFeesMainMenu;
	}

	public void setManageFeesMainMenu(WebElement manageFeesMainMenu) {
		this.manageFeesMainMenu = manageFeesMainMenu;
	}

	@FindBy(xpath = "//button[text()='Add Fee']")
	private WebElement btnAddFee;
	@FindBy(id = "names1")
	private WebElement txtFeeName;
	@FindBy(id = "names2")
	private WebElement txtFeeAmount;
	@FindBy(css = ".mySelect.for.class_select.standards.select2-hidden-accessible")
	private WebElement ddnSelectClass;
	@FindBy(id = "add_fee_pickers1")
	private WebElement datePickerAddFee;
	@FindBy(id = "names5")
	private WebElement txtBreakdownFeeName;
	@FindBy(css = "#add_fee p:nth-child(2) > label")
	private WebElement checkboxGST;
	@FindBy(css = ".fees_break_amount")
	private WebElement txtBreakdownFeeAmount;
	@FindBy(css = ".mandatory_fees_create")
	private WebElement btnMandatoryFeesCreate;

	@FindBy(css = ".swal-button--confirm")
	private WebElement btnSuccess;
	@FindBy(css = ".swal-text")
	private WebElement txtSuccessMsz;

	public WebElement getBtnSuccess() {
		return btnSuccess;
	}

	public void setBtnSuccess(WebElement btnSuccess) {
		this.btnSuccess = btnSuccess;
	}

	public WebElement getTxtSuccessMsz() {
		return txtSuccessMsz;
	}

	public void setTxtSuccessMsz(WebElement txtSuccessMsz) {
		this.txtSuccessMsz = txtSuccessMsz;
	}

	public WebElement getBtnAddFee() {
		return btnAddFee;
	}

	public void setBtnAddFee(WebElement btnAddFee) {
		this.btnAddFee = btnAddFee;
	}

	public WebElement getTxtFeeName() {
		return txtFeeName;
	}

	public void setTxtFeeName(WebElement txtFeeName) {
		this.txtFeeName = txtFeeName;
	}

	public WebElement getTxtFeeAmount() {
		return txtFeeAmount;
	}

	public void setTxtFeeAmount(WebElement txtFeeAmount) {
		this.txtFeeAmount = txtFeeAmount;
	}

	public WebElement getDdnSelectClass() {
		return ddnSelectClass;
	}

	public void setDdnSelectClass(WebElement ddnSelectClass) {
		this.ddnSelectClass = ddnSelectClass;
	}

	public WebElement getDatePickerAddFee() {
		return datePickerAddFee;
	}

	public void setDatePickerAddFee(WebElement datePickerAddFee) {
		this.datePickerAddFee = datePickerAddFee;
	}

	public WebElement getTxtBreakdownFeeName() {
		return txtBreakdownFeeName;
	}

	public void setTxtBreakdownFeeName(WebElement txtBreakdownFeeName) {
		this.txtBreakdownFeeName = txtBreakdownFeeName;
	}

	public WebElement getCheckboxGST() {
		return checkboxGST;
	}

	public void setCheckboxGST(WebElement checkboxGST) {
		this.checkboxGST = checkboxGST;
	}

	public WebElement getTxtBreakdownFeeAmount() {
		return txtBreakdownFeeAmount;
	}

	public void setTxtBreakdownFeeAmount(WebElement txtBreakdownFeeAmount) {
		this.txtBreakdownFeeAmount = txtBreakdownFeeAmount;
	}

	public WebElement getBtnMandatoryFeesCreate() {
		return btnMandatoryFeesCreate;
	}

	public void setBtnMandatoryFeesCreate(WebElement btnMandatoryFeesCreate) {
		this.btnMandatoryFeesCreate = btnMandatoryFeesCreate;
	}

	/*
	 * 2. updates the School Fees
	 */

	@FindBy(css = ".edit_text.edit_year")
	private WebElement btnEditMandatoryFee;
	@FindBy(id = "manage_fee_name1")
	private WebElement txtEditFeeName;
	@FindBy(id = "manage_fee_amount1")
	private WebElement txtEditFeeAmount;
	@FindBy(css = ".select2-hidden-accessible")
	private WebElement ddnEditSelectClass;
	@FindBy(id = "edit_fee_pickers1")
	private WebElement datepickerEditDate;
	@FindBy(id = "edit_title1")
	private WebElement txtEditMandatoryFeeName;
	@FindBy(id = "edit_amount1")
	private WebElement txtEditMandatoryFeeAmount;
	@FindBy(css = ".mandatory_fees_created89")
	private WebElement btnEditMandatoryFeeUpdate;
	@FindBy(css = "#manage_fee_edit p:nth-child(2) > label")
	private WebElement radiobtnEditGST;
	@FindBy(id = "pills-home-tab")
	private WebElement schoolFeesTab;

	public WebElement getSchoolFeesTab() {
		return schoolFeesTab;
	}

	public void setSchoolFeesTab(WebElement schoolFeesTab) {
		this.schoolFeesTab = schoolFeesTab;
	}

	/**
	 * Handling Dynamic Web Table
	 */

	@FindBy(xpath = "//table[@id='DataTables_Table_0']")
	private WebElement table;

	public WebElement getTable() {
		return table;
	}

	public void setTable(WebElement table) {
		this.table = table;
	}

	public WebElement getBtnEditMandatoryFee() {
		return btnEditMandatoryFee;
	}

	public void setBtnEditMandatoryFee(WebElement btnEditMandatoryFee) {
		this.btnEditMandatoryFee = btnEditMandatoryFee;
	}

	public WebElement getTxtEditFeeName() {
		return txtEditFeeName;
	}

	public void setTxtEditFeeName(WebElement txtEditFeeName) {
		this.txtEditFeeName = txtEditFeeName;
	}

	public WebElement getTxtEditFeeAmount() {
		return txtEditFeeAmount;
	}

	public void setTxtEditFeeAmount(WebElement txtEditFeeAmount) {
		this.txtEditFeeAmount = txtEditFeeAmount;
	}

	public WebElement getDdnEditSelectClass() {
		return ddnEditSelectClass;
	}

	public void setDdnEditSelectClass(WebElement ddnEditSelectClass) {
		this.ddnEditSelectClass = ddnEditSelectClass;
	}

	public WebElement getDatepickerEditDate() {
		return datepickerEditDate;
	}

	public void setDatepickerEditDate(WebElement datepickerEditDate) {
		this.datepickerEditDate = datepickerEditDate;
	}

	public WebElement getTxtEditMandatoryFeeName() {
		return txtEditMandatoryFeeName;
	}

	public void setTxtEditMandatoryFeeName(WebElement txtEditMandatoryFeeName) {
		this.txtEditMandatoryFeeName = txtEditMandatoryFeeName;
	}

	public WebElement getTxtEditMandatoryFeeAmount() {
		return txtEditMandatoryFeeAmount;
	}

	public void setTxtEditMandatoryFeeAmount(WebElement txtEditMandatoryFeeAmount) {
		this.txtEditMandatoryFeeAmount = txtEditMandatoryFeeAmount;
	}

	public WebElement getBtnEditMandatoryFeeUpdate() {
		return btnEditMandatoryFeeUpdate;
	}

	public void setBtnEditMandatoryFeeUpdate(WebElement btnEditMandatoryFeeUpdate) {
		this.btnEditMandatoryFeeUpdate = btnEditMandatoryFeeUpdate;
	}

	public WebElement getRadiobtnEditGST() {
		return radiobtnEditGST;
	}

	public void setRadiobtnEditGST(WebElement radiobtnEditGST) {
		this.radiobtnEditGST = radiobtnEditGST;
	}

	/*
	 * 3. Publish the School Fees
	 */

	@FindBy(css = ".swal-button--confirm")
	private WebElement btnConfirm;
	@FindBy(xpath = "//button[contains(.,'OK')]")
	private WebElement btnAlertOk;

	public WebElement getBtnConfirm() {
		return btnConfirm;
	}

	public void setBtnConfirm(WebElement btnConfirm) {
		this.btnConfirm = btnConfirm;
	}

	public WebElement getBtnAlertOk() {
		return btnAlertOk;
	}

	public void setBtnAlertOk(WebElement btnAlertOk) {
		this.btnAlertOk = btnAlertOk;
	}

	/*
	 * 4. deletes the School Fees
	 */

	@FindBy(css = ".delete-add")
	private WebElement btnDelete;
	@FindBy(css = ".swal-button--confirm")
	private WebElement btnConfirm2;
	@FindBy(xpath = "//button[contains(.,'OK')]")
	private WebElement btnAlertOk2;

	public WebElement getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(WebElement btnDelete) {
		this.btnDelete = btnDelete;
	}

	public WebElement getBtnConfirm2() {
		return btnConfirm2;
	}

	public void setBtnConfirm2(WebElement btnConfirm2) {
		this.btnConfirm2 = btnConfirm2;
	}

	public WebElement getBtnAlertOk2() {
		return btnAlertOk2;
	}

	public void setBtnAlertOk2(WebElement btnAlertOk2) {
		this.btnAlertOk2 = btnAlertOk2;
	}

	/*
	 * 5. creates new Add-On Fees
	 */

	@FindBy(id = "pills-profile-tab")
	private WebElement tabAddOnFees;
	@FindBy(css = "#pills-profile .year_btn")
	private WebElement btnAddFees;
	@FindBy(id = "names7")
	private WebElement txtAddOnFeeName;
	@FindBy(id = "names8")
	private WebElement txtAddOnFeeAmount;
	@FindBy(id = "add_fee_pickers2")
	private WebElement datePickerAddOnFee;
	@FindBy(css = ".group p:nth-child(2) > label")
	private WebElement radiobtnGST;
	@FindBy(xpath = "//label[contains(.,' Upload as CSV')]")
	private WebElement btnUploadCSV;
	@FindBy(css = ".add_on_fee_create")
	private WebElement btnCreate;
	@FindBy(xpath = "//button[contains(.,'OK')]")
	private WebElement btnSuccessOk;

	public WebElement getBtnSuccessOk() {
		return btnSuccessOk;
	}

	public void setBtnSuccessOk(WebElement btnSuccessOk) {
		this.btnSuccessOk = btnSuccessOk;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public void setBtnCreate(WebElement btnCreate) {
		this.btnCreate = btnCreate;
	}

	public WebElement getBtnUploadCSV() {
		return btnUploadCSV;
	}

	public void setBtnUploadCSV(WebElement btnUploadCSV) {
		this.btnUploadCSV = btnUploadCSV;
	}

	public WebElement getRadiobtnGST() {
		return radiobtnGST;
	}

	public void setRadiobtnGST(WebElement radiobtnGST) {
		this.radiobtnGST = radiobtnGST;
	}

	public WebElement getTabAddOnFees() {
		return tabAddOnFees;
	}

	public void setTabAddOnFees(WebElement tabAddOnFees) {
		this.tabAddOnFees = tabAddOnFees;
	}

	public WebElement getBtnAddFees() {
		return btnAddFees;
	}

	public void setBtnAddFees(WebElement btnAddFees) {
		this.btnAddFees = btnAddFees;
	}

	public WebElement getTxtAddOnFeeName() {
		return txtAddOnFeeName;
	}

	public void setTxtAddOnFeeName(WebElement txtAddOnFeeName) {
		this.txtAddOnFeeName = txtAddOnFeeName;
	}

	public WebElement getTxtAddOnFeeAmount() {
		return txtAddOnFeeAmount;
	}

	public void setTxtAddOnFeeAmount(WebElement txtAddOnFeeAmount) {
		this.txtAddOnFeeAmount = txtAddOnFeeAmount;
	}

	public WebElement getDatePickerAddOnFee() {
		return datePickerAddOnFee;
	}

	public void setDatePickerAddOnFee(WebElement datePickerAddOnFee) {
		this.datePickerAddOnFee = datePickerAddOnFee;
	}

	/*
	 * 6. updates the Add-On Fees
	 */

	@FindBy(xpath = "//div[contains(text(),'Addon fee created successfully')]")
	private WebElement txtSuccessMsz1;

	public WebElement getTxtSuccessMsz1() {
		return txtSuccessMsz1;
	}

	public void setTxtSuccessMsz1(WebElement txtSuccessMsz1) {
		this.txtSuccessMsz1 = txtSuccessMsz1;
	}

	/*
	 * 7. deletes the Add-On Fees
	 */
	@FindBy(css = ".odd:nth-child(1) > td:nth-child(7) .delete-add")

	private WebElement btnDeleteAddOnFee;
	@FindBy(xpath = "//button[contains(.,'Yes, I am sure!')]")
	private WebElement btnConfirmDelete;
	@FindBy(css = ".swal-text")
	private WebElement txtSuccessMsz2;
	@FindBy(xpath = "//button[contains(.,'OK')]")
	private WebElement btnSuccessMsz2;

	public WebElement getBtnConfirmDelete() {
		return btnConfirmDelete;
	}

	public void setBtnConfirmDelete(WebElement btnConfirmDelete) {
		this.btnConfirmDelete = btnConfirmDelete;
	}

	public WebElement getTxtSuccessMsz2() {
		return txtSuccessMsz2;
	}

	public void setTxtSuccessMsz2(WebElement txtSuccessMsz2) {
		this.txtSuccessMsz2 = txtSuccessMsz2;
	}

	public WebElement getBtnSuccessMsz2() {
		return btnSuccessMsz2;
	}

	public void setBtnSuccessMsz2(WebElement btnSuccessMsz2) {
		this.btnSuccessMsz2 = btnSuccessMsz2;
	}

	public WebElement getBtnDeleteAddOnFee() {
		return btnDeleteAddOnFee;
	}

	public void setBtnDeleteAddOnFee(WebElement btnDeleteAddOnFee) {
		this.btnDeleteAddOnFee = btnDeleteAddOnFee;
	}

	/*
	 * 8. creates new Fee Discount
	 */

	@FindBy(id = "pills-time-table")
	private WebElement concessionTab;
	@FindBy(css = "#pills-table .year_btn")
	private WebElement btnAddDiscount;
	@FindBy(id = "discount1")
	private WebElement ddnClassName;
	@FindBy(id = "discount2")
	private WebElement ddnFeeName;
	@FindBy(id = "discount3")
	private WebElement txtDiscountName;
	@FindBy(id = "discount4")
	private WebElement txtDiscountPercent;
	@FindBy(id = "discount5")
	private WebElement txtDiscountAmount;
	@FindBy(id = "add_fee_pickers4")
	private WebElement datepickerDiscount;
	@FindBy(css = "div:nth-child(3) > .in_text label")
	private WebElement uploadCSV;
	@FindBy(css = ".swal-button")
	private WebElement btnAlertOk1;
	@FindBy(css = ".discount_fee_create")
	private WebElement btnCreate1;

	public WebElement getUploadCSV() {
		return uploadCSV;
	}

	public void setUploadCSV(WebElement uploadCSV) {
		this.uploadCSV = uploadCSV;
	}

	public WebElement getBtnAlertOk1() {
		return btnAlertOk1;
	}

	public void setBtnAlertOk1(WebElement btnAlertOk1) {
		this.btnAlertOk1 = btnAlertOk1;
	}

	public WebElement getBtnCreate1() {
		return btnCreate1;
	}

	public void setBtnCreate1(WebElement btnCreate1) {
		this.btnCreate1 = btnCreate1;
	}

	public WebElement getConcessionTab() {
		return concessionTab;
	}

	public void setConcessionTab(WebElement concessionTab) {
		this.concessionTab = concessionTab;
	}

	public WebElement getBtnAddDiscount() {
		return btnAddDiscount;
	}

	public void setBtnAddDiscount(WebElement btnAddDiscount) {
		this.btnAddDiscount = btnAddDiscount;
	}

	public WebElement getDdnClassName() {
		return ddnClassName;
	}

	public void setDdnClassName(WebElement ddnClassName) {
		this.ddnClassName = ddnClassName;
	}

	public WebElement getDdnFeeName() {
		return ddnFeeName;
	}

	public void setDdnFeeName(WebElement ddnFeeName) {
		this.ddnFeeName = ddnFeeName;
	}

	public WebElement getTxtDiscountName() {
		return txtDiscountName;
	}

	public void setTxtDiscountName(WebElement txtDiscountName) {
		this.txtDiscountName = txtDiscountName;
	}

	public WebElement getTxtDiscountPercent() {
		return txtDiscountPercent;
	}

	public void setTxtDiscountPercent(WebElement txtDiscountPercent) {
		this.txtDiscountPercent = txtDiscountPercent;
	}

	public WebElement getTxtDiscountAmount() {
		return txtDiscountAmount;
	}

	public void setTxtDiscountAmount(WebElement txtDiscountAmount) {
		this.txtDiscountAmount = txtDiscountAmount;
	}

	public WebElement getDatepickerDiscount() {
		return datepickerDiscount;
	}

	public void setDatepickerDiscount(WebElement datepickerDiscount) {
		this.datepickerDiscount = datepickerDiscount;
	}

	/*
	 * 9. updates the Fee Discount
	 */

	/*
	 * 10. deletes the Fee Discount
	 */

//	@FindBy(css = ".delete_text:nth-child(1)")
//	@FindBy(xpath = "//table[@id='DataTables_Table_1']/tbody/tr/td[7]/div")

	@FindBy(css = "#DataTables_Table_1 .odd:nth-child(1) > td:nth-child(7) .delete-add")

	private WebElement btnDeleteDiscount;
	@FindBy(id = "DataTables_Table_1_info")
	private WebElement tableInfo;

	public WebElement getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(WebElement tableInfo) {
		this.tableInfo = tableInfo;
	}

	@FindBy(xpath = "//button[contains(.,'Yes, I am sure!')]")
	private WebElement btnConfirmDelete1;
	@FindBy(css = ".swal-text")
	private WebElement txtSuccessMsz3;
	@FindBy(xpath = "//button[contains(.,'OK')]")
	private WebElement btnSuccessMsz3;
	@FindBy(id = "DataTables_Table_1")
	private WebElement table1;

	public WebElement getTable1() {
		return table1;
	}

	public void setTable1(WebElement table1) {
		this.table1 = table1;
	}

	public WebElement getBtnDeleteDiscount() {
		return btnDeleteDiscount;
	}

	public void setBtnDeleteDiscount(WebElement btnDeleteDiscount) {
		this.btnDeleteDiscount = btnDeleteDiscount;
	}

	public WebElement getBtnConfirmDelete1() {
		return btnConfirmDelete1;
	}

	public void setBtnConfirmDelete1(WebElement btnConfirmDelete1) {
		this.btnConfirmDelete1 = btnConfirmDelete1;
	}

	public WebElement getTxtSuccessMsz3() {
		return txtSuccessMsz3;
	}

	public void setTxtSuccessMsz3(WebElement txtSuccessMsz3) {
		this.txtSuccessMsz3 = txtSuccessMsz3;
	}

	public WebElement getBtnSuccessMsz3() {
		return btnSuccessMsz3;
	}

	public void setBtnSuccessMsz3(WebElement btnSuccessMsz3) {
		this.btnSuccessMsz3 = btnSuccessMsz3;
	}

	/**
	 * Method Starts Here
	 * 
	 * @throws CsvException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	public void CreatesNewSchoolFees() throws FileNotFoundException, IOException, CsvException {

		explicitWaitClickable(20, getAdmissionAndFeesMainMenu());
		clickWithMultipleRetry(getAdmissionAndFeesMainMenu(), 10, 500);
		explicitWaitClickable(20, getManageFeesMainMenu());
		clickWithRetry(getManageFeesMainMenu());

		explicitWaitClickable(20, getBtnAddFee());
		clickWithRetry(getBtnAddFee());

		String cell = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 0);
		System.out.println(cell);
		explicitWaitClickable(20, getTxtFeeName());
		clickWithRetry(getTxtFeeName());
		EnterInTextbox(getTxtFeeName(), cell);

		String cell1 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 1);
		System.out.println(cell1);
		explicitWaitClickable(20, getTxtFeeAmount());
		clickWithRetry(getTxtFeeAmount());
		EnterInTextbox(getTxtFeeAmount(), cell1);

		/**
		 * Select the dropdown using text
		 */
		String cell2 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 2);
		System.out.println(cell2);

		/**
		 * Select the dropdoen using index
		 */

//		selectDdnByIndex(getDdnSelectClass(), 1);

		/**
		 * Selecting all the options in the dropdown except 1st option
		 */

		List<WebElement> allOption = getAllOption(getDdnSelectClass());
		int size = allOption.size();
		System.out.println(size);

		boolean firstOptionSkipped = false;

		for (WebElement option : allOption) {
			try {
				// Skip the first option
				if (!firstOptionSkipped) {
					firstOptionSkipped = true;
					continue;
				}

				explicitWaitClickable(5, option);
				clickWithRetry(option);
			} catch (Exception e) {
				System.out.println("Handling Exception");
			}
		}

		/**
		 * Handling Date Picker
		 */
		String desiredDate;
		String desiredMonth;
		String desiredYear;

		desiredDate = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 3);
		System.out.println(desiredDate);
		desiredMonth = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 4);
		System.out.println(desiredMonth);
		desiredYear = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 5);
		System.out.println(desiredYear);

		// Assume 'driver' is your WebDriver instance
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the datepicker input field and click on it
		getDatePickerAddFee().click();

		// Wait for the DateTimePicker widget to be visible
		WebElement dateTimePickerWidget = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootstrap-datetimepicker-widget")));

		WebElement pickerswitch = dateTimePickerWidget.findElement(By.className("picker-switch"));
		pickerswitch.click();

		WebElement monthSelector = dateTimePickerWidget.findElement(By.className("datepicker-months"));
		WebElement findElement = monthSelector.findElement(By.className("picker-switch"));
		findElement.click();

		// Select the desired year
		WebElement yearSelector = dateTimePickerWidget.findElement(By.className("datepicker-years"));

		WebElement yearOption = yearSelector.findElement(By.xpath("//span[text()='" + desiredYear + "']"));

		explicitWaitClickable(10, yearOption);
		clickWithRetry(yearOption);

		// Select the desired month

		WebElement monthOption = monthSelector.findElement(By.xpath("//span[text()='" + desiredMonth + "']"));

		explicitWaitClickable(10, monthOption);
		clickWithRetry(monthOption);

		// Select the desired date
		WebElement dateSelector = dateTimePickerWidget.findElement(By.className("datepicker-days"));

		/*
		 * WebElement dateOption = dateSelector
		 * .findElement(By.xpath("//td[@class='day' and text()='" + desiredDate +
		 * "']"));
		 */

		WebElement dateOption = dateSelector.findElement(By.xpath(
				"//td[contains(@class, 'day') and contains(@class, 'weekend') and text()='" + desiredDate + "']"));

		explicitWaitClickable(10, dateOption);
		clickWithRetry(dateOption);

		getCheckboxGST().click();

		String BreakdownFeeName = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 6);
		System.out.println(BreakdownFeeName);
		EnterInTextbox(getTxtBreakdownFeeName(), BreakdownFeeName);

		String cell7 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 7);
		System.out.println(cell7);
		EnterInTextbox(getTxtBreakdownFeeAmount(), cell7);

		explicitWaitClickable(10, getBtnMandatoryFeesCreate());
		clickWithRetry(getBtnMandatoryFeesCreate());

	}

	public void VerifySchoolFeesCreated() {

		explicitWaitClickable(100, getBtnSuccess());
		String popuptext = getText(getTxtSuccessMsz());
		HighlightOutput(popuptext);
		Assert.assertEquals("Assertion Failed", popuptext, "Mandatory fee created successfully");
		clickWithRetry(getBtnSuccess());

	}

	public void PublishTheSchoolFees() throws InterruptedException {

		/**
		 * Dynamic Web Table
		 */

		int maxRetries = 3;
		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {

				List<WebElement> publishCount = getTable().findElements(By.linkText("Publish Now"));
				int publishCountSize = publishCount.size();
				System.out.println(publishCountSize);

				for (int i = 1; i <= 1; i++) {
					WebElement publishButton = getTable().findElement(By.linkText("Publish Now"));
					explicitWaitClickable(10, publishButton);
					clickWithRetry(publishButton);
					explicitWaitClickable(20, getBtnConfirm());
					clickWithRetry(getBtnConfirm());
					explicitWaitClickable(20, getBtnAlertOk());
					clickWithRetry(getBtnAlertOk());

				}

				break;

			} catch (StaleElementReferenceException e) {
				System.out.println("Handling stale element reference - Attempt " + attempt);
				Thread.sleep(500);
			}
		}

	}

	public void UpdatesTheSchoolFees() throws FileNotFoundException, IOException, CsvException, InterruptedException {

		explicitWaitClickable(20, getSchoolFeesTab());
		clickWithRetry(getSchoolFeesTab());

		/**
		 * Dynamic Web Table
		 */

		int maxRetries = 3;
		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {

				List<WebElement> editBtnCount = getTable().findElements(By.cssSelector(".edit_text.edit_year"));
				int editBtnCountSize = editBtnCount.size();
				System.out.println(editBtnCountSize);

				for (int i = 1; i <= 1; i++) {
					WebElement editButton = getTable().findElement(By.cssSelector(".edit_text.edit_year"));
					explicitWaitClickable(10, editButton);
					clickWithRetry(editButton);

				}

				break;

			} catch (StaleElementReferenceException e) {
				System.out.println("Handling stale element reference - Attempt " + attempt);
				Thread.sleep(500);
			}
		}

		String cell = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 8);
		System.out.println(cell);
		getTxtEditFeeName().clear();
		EnterInTextbox(getTxtEditFeeName(), cell);

		String cell1 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 9);
		System.out.println(cell1);
		getTxtEditFeeAmount().clear();
		EnterInTextbox(getTxtEditFeeAmount(), cell1);

		/**
		 * Handling Date Picker
		 */
		String desiredDate;
		String desiredMonth;
		String desiredYear;

		desiredDate = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 10);
		System.out.println(desiredDate);
		desiredMonth = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 11);
		System.out.println(desiredMonth);
		desiredYear = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 12);
		System.out.println(desiredYear);

		// Assume 'driver' is your WebDriver instance
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the datepicker input field and click on it
		getDatepickerEditDate().click();

		// Wait for the DateTimePicker widget to be visible
		WebElement dateTimePickerWidget = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootstrap-datetimepicker-widget")));

		WebElement pickerswitch = dateTimePickerWidget.findElement(By.className("picker-switch"));
		pickerswitch.click();

		WebElement monthSelector = dateTimePickerWidget.findElement(By.className("datepicker-months"));
		WebElement findElement = monthSelector.findElement(By.className("picker-switch"));
		findElement.click();

		// Select the desired year
		WebElement yearSelector = dateTimePickerWidget.findElement(By.className("datepicker-years"));

		WebElement yearOption = yearSelector.findElement(By.xpath("//span[text()='" + desiredYear + "']"));

		explicitWaitClickable(10, yearOption);
		clickWithRetry(yearOption);

		// Select the desired month

		WebElement monthOption = monthSelector.findElement(By.xpath("//span[text()='" + desiredMonth + "']"));

		explicitWaitClickable(10, monthOption);
		clickWithRetry(monthOption);

		// Select the desired date
		WebElement dateSelector = dateTimePickerWidget.findElement(By.className("datepicker-days"));

		WebElement dateOption = dateSelector.findElement(By.xpath(
				"//td[contains(@class, 'day') and contains(@class, 'weekend') and text()='" + desiredDate + "']"));

		explicitWaitClickable(10, dateOption);
		clickWithRetry(dateOption);
		/**
		 * GST Radio Button
		 */
		getRadiobtnEditGST().click();

		String BreakdownFeeName = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 13);
		System.out.println(BreakdownFeeName);
		getTxtEditMandatoryFeeName().clear();
		EnterInTextbox(getTxtEditMandatoryFeeName(), BreakdownFeeName);

		String cell7 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 14);
		System.out.println(cell7);
		getTxtEditMandatoryFeeAmount().clear();
		EnterInTextbox(getTxtEditMandatoryFeeAmount(), cell7);

		explicitWaitClickable(10, getBtnEditMandatoryFeeUpdate());
		clickWithRetry(getBtnEditMandatoryFeeUpdate());

	}

	public void VerifySchoolFeesUpdated() {

		explicitWaitClickable(100, getBtnSuccess());
		String popuptext = getText(getTxtSuccessMsz());
		HighlightOutput(popuptext);
		Assert.assertEquals("Assertion Failed", popuptext, "Fee Updated Successfully");
		clickWithRetry(getBtnSuccess());

	}

	public void DeletesTheSchoolFees() {

		explicitWaitClickable(20, getSchoolFeesTab());
		clickWithRetry(getSchoolFeesTab());

		explicitWaitClickable(10, getBtnDelete());
		clickWithRetry(getBtnDelete());
		explicitWaitClickable(10, getBtnConfirm2());
		clickWithRetry(getBtnConfirm2());

	}

	public void VerifyThatTheSchoolFeesAreDeleted() {

		explicitWaitClickable(100, getBtnAlertOk2());
		String popuptext = getText(getTxtSuccessMsz());
		HighlightOutput(popuptext);
		Assert.assertEquals("Assertion Failed", popuptext, "Fee deleted successfully");
		clickWithRetry(getBtnAlertOk2());

	}

	public void CreatesNewAddOnFees()
			throws FileNotFoundException, IOException, CsvException, AWTException, InterruptedException {

		explicitWaitClickable(10, getTabAddOnFees());
		clickWithRetry(getTabAddOnFees());
		explicitWaitClickable(10, getBtnAddFees());
		clickWithRetry(getBtnAddFees());

		String cell = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 15);
		System.out.println(cell);
		explicitWaitClickable(10, getTxtAddOnFeeName());
		clickWithRetry(getTxtAddOnFeeName());
		EnterInTextbox(getTxtAddOnFeeName(), cell);

		String cell1 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 16);
		System.out.println(cell1);
		explicitWaitClickable(10, getTxtAddOnFeeAmount());
		clickWithRetry(getTxtAddOnFeeAmount());
		EnterInTextbox(getTxtAddOnFeeAmount(), cell1);

		/**
		 * Handling Date Picker
		 */

		String desiredDate;
		String desiredMonth;
		String desiredYear;

		desiredDate = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 17);
		System.out.println(desiredDate);
		desiredMonth = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 18);
		System.out.println(desiredMonth);
		desiredYear = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 19);
		System.out.println(desiredYear);

		// Assume 'driver' is your WebDriver instance
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the datepicker input field and click on it
		getDatePickerAddOnFee().click();

		// Wait for the DateTimePicker widget to be visible
		WebElement dateTimePickerWidget = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootstrap-datetimepicker-widget")));

		WebElement pickerswitch = dateTimePickerWidget.findElement(By.className("picker-switch"));
		pickerswitch.click();

		WebElement monthSelector = dateTimePickerWidget.findElement(By.className("datepicker-months"));
		WebElement findElement = monthSelector.findElement(By.className("picker-switch"));
		findElement.click();

		// Select the desired year
		WebElement yearSelector = dateTimePickerWidget.findElement(By.className("datepicker-years"));

		WebElement yearOption = yearSelector.findElement(By.xpath("//span[text()='" + desiredYear + "']"));

		explicitWaitClickable(10, yearOption);
		clickWithRetry(yearOption);

		// Select the desired month

		WebElement monthOption = monthSelector.findElement(By.xpath("//span[text()='" + desiredMonth + "']"));

		explicitWaitClickable(10, monthOption);
		clickWithRetry(monthOption);

		// Select the desired date
		WebElement dateSelector = dateTimePickerWidget.findElement(By.className("datepicker-days"));

		WebElement dateOption = dateSelector.findElement(By.xpath(
				"//td[contains(@class, 'day') and contains(@class, 'weekend') and text()='" + desiredDate + "']"));

		explicitWaitClickable(10, dateOption);
		clickWithRetry(dateOption);

		/*
		 * GST Radio button
		 */

		explicitWaitClickable(10, getRadiobtnGST());
		clickWithRetry(getRadiobtnGST());

		/*
		 * Handling Upload CSV
		 */

		explicitWaitClickable(20, getBtnUploadCSV());
		clickWithRetry(getBtnUploadCSV());
		String cell2 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 20);
		System.out.println(cell2);

		Robot robot = new Robot();

		robot.delay(1000);

//		command_TabRobot(robot);
//		robot.delay(1000);

		openSearchTabRobot(robot);
		robot.delay(1000);

		StringSelection stringSelection = new StringSelection(cell2);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		pasteTextRobot(robot);

		robot.delay(1000);

		EnterRobot(robot);

		robot.delay(1000);

		EnterRobot(robot);

		explicitWaitClickable(20, getBtnSuccessOk());
		clickWithRetry(getBtnSuccessOk());

		/*
		 * Create Button
		 */

		explicitWaitClickable(20, getBtnCreate());
		clickWithRetry(getBtnCreate());

	}

	public void VerifyAddOnFeeCreated() {

		explicitWaitClickable(100, getBtnSuccessOk());
		String popuptext = getText(getTxtSuccessMsz1());
		HighlightOutput(popuptext);
		Assert.assertEquals("Assertion Failed", popuptext, "Addon fee created successfully");
		clickWithRetry(getBtnSuccessOk());

	}

	public void DeletesTheAddOnFees() {

		explicitWaitClickable(10, getTabAddOnFees());
		clickWithRetry(getTabAddOnFees());

		explicitWaitClickable(20, getBtnDeleteAddOnFee());
		clickWithRetry(getBtnDeleteAddOnFee());
		explicitWaitClickable(20, getBtnConfirmDelete());
		clickWithRetry(getBtnConfirmDelete());

	}

	public void VerifyAddOnFeeIsDeleted() {

		explicitWaitClickable(100, getBtnSuccessMsz2());
		String popuptext = getText(getTxtSuccessMsz2());
		HighlightOutput(popuptext);
		Assert.assertEquals("Assertion Failed", popuptext, "Add on fee deleted successfully");
		clickWithRetry(getBtnSuccessMsz2());

	}

	public void CreatesNewFeeDiscount() throws FileNotFoundException, IOException, CsvException, AWTException {

		int ddnClassName = 0;
		int ddnFeeName = 1;

		explicitWaitClickable(20, getConcessionTab());
		clickWithRetry(getConcessionTab());
		explicitWaitClickable(20, getBtnAddDiscount());
		clickWithRetry(getBtnAddDiscount());

		/**
		 * Select the dropdown using Index
		 */

		selectDdnByIndex(getDdnClassName(), ddnClassName);
		selectDdnByIndex(getDdnFeeName(), ddnFeeName);

		String cell = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 21);
		System.out.println(cell);
		EnterInTextbox(getTxtDiscountName(), cell);

		String cell1 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 22);
		System.out.println(cell1);
		EnterInTextbox(getTxtDiscountPercent(), cell1);

		String cell2 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 23);
		System.out.println(cell2);
		EnterInTextbox(getTxtDiscountAmount(), cell2);

		/**
		 * Handling Date Picker
		 */

		String desiredDate;
		String desiredMonth;
		String desiredYear;

		desiredDate = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 24);
		System.out.println(desiredDate);
		desiredMonth = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 25);
		System.out.println(desiredMonth);
		desiredYear = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 26);
		System.out.println(desiredYear);

		// Assume 'driver' is your WebDriver instance
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the datepicker input field and click on it
		getDatepickerDiscount().click();

		// Wait for the DateTimePicker widget to be visible
		WebElement dateTimePickerWidget = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootstrap-datetimepicker-widget")));

		WebElement pickerswitch = dateTimePickerWidget.findElement(By.className("picker-switch"));
		pickerswitch.click();

		WebElement monthSelector = dateTimePickerWidget.findElement(By.className("datepicker-months"));
		WebElement findElement = monthSelector.findElement(By.className("picker-switch"));
		findElement.click();

		// Select the desired year
		WebElement yearSelector = dateTimePickerWidget.findElement(By.className("datepicker-years"));

		WebElement yearOption = yearSelector.findElement(By.xpath("//span[text()='" + desiredYear + "']"));

		explicitWaitClickable(10, yearOption);
		clickWithRetry(yearOption);

		// Select the desired month

		WebElement monthOption = monthSelector.findElement(By.xpath("//span[text()='" + desiredMonth + "']"));

		explicitWaitClickable(10, monthOption);
		clickWithRetry(monthOption);

		// Select the desired date
		WebElement dateSelector = dateTimePickerWidget.findElement(By.className("datepicker-days"));

		WebElement dateOption = dateSelector.findElement(By.xpath(
				"//td[contains(@class, 'day') and contains(@class, 'weekend') and text()='" + desiredDate + "']"));

		explicitWaitClickable(10, dateOption);
		clickWithRetry(dateOption);

		/*
		 * Handling Upload CSV
		 */

		explicitWaitClickable(20, getUploadCSV());
		clickWithRetry(getUploadCSV());
		String cell3 = readSpecificCell(getPropertyFileValue("manageFee"), rowNum, 27);
		System.out.println(cell3);

		Robot robot = new Robot();

		robot.delay(1000);

//		command_TabRobot(robot);
//		robot.delay(500);

		openSearchTabRobot(robot);
		robot.delay(1000);

		StringSelection stringSelection = new StringSelection(cell3);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		pasteTextRobot(robot);

		robot.delay(1000);

		EnterRobot(robot);

		robot.delay(1000);

		EnterRobot(robot);

		explicitWaitClickable(20, getBtnAlertOk1());
		clickWithRetry(getBtnAlertOk1());
		explicitWaitClickable(20, getBtnCreate1());
		clickWithRetry(getBtnCreate1());

	}

	public void VerifyCreatedFeeDiscount() {

		explicitWaitClickable(100, getBtnSuccessMsz2());
		String popuptext = getText(getTxtSuccessMsz2());
		HighlightOutput(popuptext);
		Assert.assertTrue("Assertion Failed", popuptext.contains("Discount added successfully"));
		clickWithRetry(getBtnSuccessMsz2());

	}

	public void DeletesTheFeeDiscount() throws InterruptedException, FileNotFoundException, IOException, CsvException {

		explicitWaitClickable(20, getConcessionTab());
		clickWithRetry(getConcessionTab());

		List<WebElement> deleteBtns = driver

				.findElements(By.cssSelector(".odd:nth-child(1) > td:nth-child(7) .delete-add"));

		for (WebElement deleteBtn : deleteBtns) {
			try {
				explicitWaitClickable(5, deleteBtn);
				clickWithRetry(deleteBtn);

			} catch (Exception e) {
				System.out.println("Handling stale element reference for delete button");
			}
		}

		explicitWaitClickable(20, getBtnConfirmDelete1());
		clickWithRetry(getBtnConfirmDelete1());

	}

	public void VerifyFeeDiscountIsDeleted() {

		explicitWaitClickable(100, getBtnSuccessMsz3());
		String popuptext = getText(getTxtSuccessMsz3());
		HighlightOutput(popuptext);
		Assert.assertEquals("Assertion Failed", popuptext, "Fee discount deleted successfully");
		clickWithRetry(getBtnSuccessMsz3());

	}
}

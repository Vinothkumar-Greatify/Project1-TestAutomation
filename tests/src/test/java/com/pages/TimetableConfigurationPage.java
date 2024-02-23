package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import javax.xml.xpath.XPath;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v120.systeminfo.model.Size;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;
import com.opencsv.exceptions.CsvException;

public class TimetableConfigurationPage extends SchoolAdminOnboardPage {

	/**
	 * @author mullai
	 * @see When new school is onboarded. Timetable Configuration Page will
	 *      configure the timetable and publish the timetable.
	 * 
	 *      Timetable configuration page should Run with School Admin Onboard page.
	 */

	Scanner scanner;
//	String subjectHour;
//	String subjectMinutes;

//	int rowNum;

	/*
	 * Dynamic Table Column Index
	 */

	int columnIndex = 5;

	/*
	 * Days count (Monday to Friday)
	 */

	int checkboxCount = 5;

	public TimetableConfigurationPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * 1. Configure Subject hours in Subject mapping page
	 */

	@FindBy(css = "#schoolManagementSection")
	private WebElement schoolOperationMainMenu;
	@FindBy(css = "#sideSchool")
	private WebElement schoolConfigurationMainMenu;
	@FindBy(css = "#pills-profile-tab")
	private WebElement classTab;
	@FindBy(xpath = "//button[contains(text(),'Subject Mapping')]")
	private WebElement subjectMappingTab;
	@FindBy(css = "#sideClass")
	private WebElement manageClassMainMenu;

	public WebElement getManageClassMainMenu() {
		return manageClassMainMenu;
	}

	public void setManageClassMainMenu(WebElement manageClassMainMenu) {
		this.manageClassMainMenu = manageClassMainMenu;
	}

	public WebElement getSchoolOperationMainMenu() {
		return schoolOperationMainMenu;
	}

	public void setSchoolOperationMainMenu(WebElement schoolOperationMainMenu) {
		this.schoolOperationMainMenu = schoolOperationMainMenu;
	}

	public WebElement getSchoolConfigurationMainMenu() {
		return schoolConfigurationMainMenu;
	}

	public void setSchoolConfigurationMainMenu(WebElement schoolConfigurationMainMenu) {
		this.schoolConfigurationMainMenu = schoolConfigurationMainMenu;
	}

	public WebElement getClassTab() {
		return classTab;
	}

	public void setClassTab(WebElement classTab) {
		this.classTab = classTab;
	}

	public WebElement getSubjectMappingTab() {
		return subjectMappingTab;
	}

	public void setSubjectMappingTab(WebElement subjectMappingTab) {
		this.subjectMappingTab = subjectMappingTab;
	}

	/*
	 * Dynamic Web-Table Handling
	 */

	@FindBy(xpath = "//table[@id='DataTables_Table_9']")
	private WebElement table;

	@FindBy(css = ".create_btn.update_subject_mapping")
	private WebElement btnUpdate;

	@FindBy(css = ".swal-button.swal-button--confirm")
	private WebElement btnSuccess;

	public WebElement getTable() {
		return table;
	}

	public void setTable(WebElement table) {
		this.table = table;
	}

	public WebElement getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(WebElement btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public WebElement getBtnSuccess() {
		return btnSuccess;
	}

	public void setBtnSuccess(WebElement btnSuccess) {
		this.btnSuccess = btnSuccess;
	}

	/*
	 * 2. Configure Holidays in Manage Calendar page
	 */

	@FindBy(id = "sideCalendar")
	private WebElement calendarMainMenu;

	@FindBy(xpath = "//p[contains(.,'Upload CSV')]")
	private WebElement btnUploadCSV;

	@FindBy(css = ".swal-button.swal-button--confirm")
	private WebElement btnSuccessPopup;

	public WebElement getCalendarMainMenu() {
		return calendarMainMenu;
	}

	public void setCalendarMainMenu(WebElement calendarMainMenu) {
		this.calendarMainMenu = calendarMainMenu;
	}

	public WebElement getBtnUploadCSV() {
		return btnUploadCSV;
	}

	public void setBtnUploadCSV(WebElement btnUploadCSV) {
		this.btnUploadCSV = btnUploadCSV;
	}

	public WebElement getBtnSuccessPopup() {
		return btnSuccessPopup;
	}

	public void setBtnSuccessPopup(WebElement btnSuccessPopup) {
		this.btnSuccessPopup = btnSuccessPopup;
	}

	/*
	 * 3. Navigate to Manage Timetable
	 */

	@FindBy(css = "#sideManageTimetable")
	private WebElement manageTimetableMainMenu;

	public WebElement getManageTimetableMainMenu() {
		return manageTimetableMainMenu;
	}

	public void setManageTimetableMainMenu(WebElement manageTimetableMainMenu) {
		this.manageTimetableMainMenu = manageTimetableMainMenu;
	}

	@FindBy(css = ".timetable_generate_config")
	private WebElement btnConfigureTimetable;

	public WebElement getBtnConfigureTimetable() {
		return btnConfigureTimetable;
	}

	public void setBtnConfigureTimetable(WebElement btnConfigureTimetable) {
		this.btnConfigureTimetable = btnConfigureTimetable;
	}

	@FindBy(id = "categoryies")
	private WebElement ddnCategories;
	@FindBy(xpath = "//label[contains(.,'Monday')]")
	private WebElement checkBoxMonday;
	@FindBy(xpath = "//label[contains(.,'Tuesday')]")
	private WebElement checkBoxTuesday;
	@FindBy(xpath = "//label[contains(.,'Wednesday')]")
	private WebElement checkBoxWednesday;
	@FindBy(xpath = "//label[contains(.,'Thursday')]")
	private WebElement checkBoxThursday;
	@FindBy(xpath = "//label[contains(.,'Friday')]")
	private WebElement checkBoxFriday;
	@FindBy(xpath = "//label[contains(.,'Saturday')]")
	private WebElement checkBoxSaturday;
	@FindBy(xpath = "//label[contains(.,'Sunday')]")
	private WebElement checkBoxSunday;
	@FindBy(id = "schoolStartTime")
	private WebElement txtSchoolStartTime;
	@FindBy(id = "totalPeriod")
	private WebElement txtTotalPeriod;
	@FindBy(id = "periodDuration")
	private WebElement txtPeriodDuration;
	@FindBy(id = "interval1")
	private WebElement ddnInterval;
	@FindBy(id = "intervalMins1")
	private WebElement txtIntervalMins;
	@FindBy(id = "intervalAfter1")
	private WebElement ddnBreakAfter;
	@FindBy(css = ".configNewTimetable")
	private WebElement btnConfigNewTimetable;

	public WebElement getDdnBreakAfter() {
		return ddnBreakAfter;
	}

	public void setDdnBreakAfter(WebElement ddnBreakAfter) {
		this.ddnBreakAfter = ddnBreakAfter;
	}

	public WebElement getBtnConfigNewTimetable() {
		return btnConfigNewTimetable;
	}

	public void setBtnConfigNewTimetable(WebElement btnConfigNewTimetable) {
		this.btnConfigNewTimetable = btnConfigNewTimetable;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public WebElement getDdnCategories() {
		return ddnCategories;
	}

	public void setDdnCategories(WebElement ddnCategories) {
		this.ddnCategories = ddnCategories;
	}

	public WebElement getCheckBoxMonday() {
		return checkBoxMonday;
	}

	public void setCheckBoxMonday(WebElement checkBoxMonday) {
		this.checkBoxMonday = checkBoxMonday;
	}

	public WebElement getCheckBoxTuesday() {
		return checkBoxTuesday;
	}

	public void setCheckBoxTuesday(WebElement checkBoxTuesday) {
		this.checkBoxTuesday = checkBoxTuesday;
	}

	public WebElement getCheckBoxWednesday() {
		return checkBoxWednesday;
	}

	public void setCheckBoxWednesday(WebElement checkBoxWednesday) {
		this.checkBoxWednesday = checkBoxWednesday;
	}

	public WebElement getCheckBoxThursday() {
		return checkBoxThursday;
	}

	public void setCheckBoxThursday(WebElement checkBoxThursday) {
		this.checkBoxThursday = checkBoxThursday;
	}

	public WebElement getCheckBoxFriday() {
		return checkBoxFriday;
	}

	public void setCheckBoxFriday(WebElement checkBoxFriday) {
		this.checkBoxFriday = checkBoxFriday;
	}

	public WebElement getCheckBoxSaturday() {
		return checkBoxSaturday;
	}

	public void setCheckBoxSaturday(WebElement checkBoxSaturday) {
		this.checkBoxSaturday = checkBoxSaturday;
	}

	public WebElement getCheckBoxSunday() {
		return checkBoxSunday;
	}

	public void setCheckBoxSunday(WebElement checkBoxSunday) {
		this.checkBoxSunday = checkBoxSunday;
	}

	public WebElement getTxtSchoolStartTime() {
		return txtSchoolStartTime;
	}

	public void setTxtSchoolStartTime(WebElement txtSchoolStartTime) {
		this.txtSchoolStartTime = txtSchoolStartTime;
	}

	public WebElement getTxtTotalPeriod() {
		return txtTotalPeriod;
	}

	public void setTxtTotalPeriod(WebElement txtTotalPeriod) {
		this.txtTotalPeriod = txtTotalPeriod;
	}

	public WebElement getTxtPeriodDuration() {
		return txtPeriodDuration;
	}

	public void setTxtPeriodDuration(WebElement txtPeriodDuration) {
		this.txtPeriodDuration = txtPeriodDuration;
	}

	public WebElement getDdnInterval() {
		return ddnInterval;
	}

	public void setDdnInterval(WebElement ddnInterval) {
		this.ddnInterval = ddnInterval;
	}

	public WebElement getTxtIntervalMins() {
		return txtIntervalMins;
	}

	public void setTxtIntervalMins(WebElement txtIntervalMins) {
		this.txtIntervalMins = txtIntervalMins;
	}

	/*
	 * 4. Configures And Publishes The Timetable
	 */

	@FindBy(id = "buildTimetable")
	private WebElement btnBuildTimetable;
	@FindBy(css = ".cancel_btn")
	private WebElement btnReconfigureBuild;
	@FindBy(xpath = "//button[contains(.,'Publish Timetable')]")
	private WebElement btnPublishTimetable;

	public WebElement getBtnReconfigureBuild() {
		return btnReconfigureBuild;
	}

	public void setBtnReconfigureBuild(WebElement btnReconfigureBuild) {
		this.btnReconfigureBuild = btnReconfigureBuild;
	}

	public WebElement getBtnBuildTimetable() {
		return btnBuildTimetable;
	}

	public void setBtnBuildTimetable(WebElement btnBuildTimetable) {
		this.btnBuildTimetable = btnBuildTimetable;
	}

	public WebElement getBtnPublishTimetable() {
		return btnPublishTimetable;
	}

	public void setBtnPublishTimetable(WebElement btnPublishTimetable) {
		this.btnPublishTimetable = btnPublishTimetable;
	}

	/*
	 * 5. Success Popup
	 */

	@FindBy(xpath = "//div[contains(text(),'TimeTable Published Successfully')]")
	private WebElement txtSuccessPopup;

	public WebElement getTxtSuccessPopup() {
		return txtSuccessPopup;
	}

	public void setTxtSuccessPopup(WebElement txtSuccessPopup) {
		this.txtSuccessPopup = txtSuccessPopup;
	}

	@FindBy(css = ".swal-button--confirm")
	private WebElement btnSuccessfullPopup;

	public WebElement getBtnSuccessfullPopup() {
		return btnSuccessfullPopup;
	}

	public void setBtnSuccessfullPopup(WebElement btnSuccessfullPopup) {
		this.btnSuccessfullPopup = btnSuccessfullPopup;
	}

	public void ConfigureSubjectHours() throws InterruptedException, FileNotFoundException, IOException, CsvException {

		explicitWaitClickable(30, getSchoolOperationMainMenu());
		clickWithRetry(getSchoolOperationMainMenu());

		explicitWaitClickable(20, getManageClassMainMenu());
		clickWithRetry(getManageClassMainMenu());

		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);

		explicitWaitClickable(20, getSchoolConfigurationMainMenu());
		clickWithRetry(getSchoolConfigurationMainMenu());

		explicitWaitClickable(20, getClassTab());
		clickWithRetry(getClassTab());

		explicitWaitClickable(20, getSubjectMappingTab());
		clickWithRetry(getSubjectMappingTab());

		/**
		 * Verify the datas are available in the Table. Otherwise reload the page
		 */

		WebElement table = driver.findElement(By.id("DataTables_Table_9"));
		List<WebElement> rowCounts = table.findElements(By.tagName("tr"));
		int size = rowCounts.size();
		System.out.println(size);
		if (size == 0) {
			driver.navigate().refresh();
		}

		/*
		 * Scanner used to get the Subject Hours
		 */

//		scanner = new Scanner(System.in);
//		System.out.println("Enter Row Num: ");
//		rowNum = scanner.nextInt();
//		System.out.println("You have entered " + rowNum + " as Row Number");

//		scanner = new Scanner(System.in);
//		System.out.println("Enter Subject Hours: ");
//		String subjectHour = scanner.next();
//		System.out.println("You have entered " + subjectHour + " as Subject Hours");

//		System.out.println("Enter Subject Minutes: ");
//		String subjectMinutes = scanner.next();
//		System.out.println("You have entered " + subjectMinutes + " as Subject Minutes");

//		System.out.println("Enter Column Index: ");
//		int columnIndex = scanner.nextInt();
//		System.out.println("You have entered " + columnIndex + " as Column Index");

		// scanner.close();

		/*
		 * Handling Dynamic Web Table
		 */

		List<WebElement> rows = getTable().findElements(By.tagName("tr"));
		int numberOfRows = rows.size();
		System.out.println(numberOfRows);

		Thread.sleep(5000);

		for (int rowIndex = 0; rowIndex < numberOfRows - 1; rowIndex++) {

			WebElement actionColumn = table
					.findElement(By.xpath(".//tr[" + (rowIndex + 1) + "]/td[" + (columnIndex + 1) + "]"));

			WebElement editButton = actionColumn.findElement(By.cssSelector(".edit_std_sub"));

			explicitWaitClickable(10, editButton);

			clickWithRetry(editButton);

			/*
			 * Get Hours
			 */

			String subjectHour = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 1);
			System.out.println(subjectHour);

			List<WebElement> hours = driver.findElements(By.xpath("//input[@placeholder=\"Hrs\"]"));

			for (WebElement hour : hours) {
				try {
					explicitWaitClickable(5, hour);
					clickWithRetry(hour);
					eleClear(hour);
					EnterInTextbox(hour, subjectHour);
				} catch (Exception e) {
					System.out.println("Handling stale element reference for minutes");
				}
			}

			/*
			 * Get Minutes
			 */

			String subjectMinutes = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 2);
			System.out.println();

			List<WebElement> minutes = driver.findElements(By.xpath("//input[@placeholder=\"Mins\"]"));

			for (WebElement min : minutes) {
				try {
					explicitWaitClickable(5, min);
					clickWithRetry(min);
					eleClear(min);
					EnterInTextbox(min, subjectMinutes);
				} catch (Exception e) {
					System.out.println("Handling stale element reference for minutes");
				}
			}

			getBtnUpdate().click();

			int maxRetries = 5;
			for (int attempt = 1; attempt <= maxRetries; attempt++) {
				try {
					clickWithRetry(getBtnSuccess());
					break;
				} catch (Exception e) {
					System.out.println("Handling Exception - Attempt " + attempt);
					Thread.sleep(500);
				}
			}

		}

	}

	public void ConfigureHolidays()
			throws FileNotFoundException, IOException, CsvException, AWTException, InterruptedException {

		getCalendarMainMenu().click();

		explicitWaitClickable(10, getBtnUploadCSV());
		getBtnUploadCSV().click();

		/*
		 * Upload Calendar CSV File from local machine
		 */

		String cell1 = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 3);
		System.out.println(cell1);

		Robot robot = new Robot();

		robot.delay(1000);

//		command_TabRobot(robot);
		robot.delay(1000);

		openSearchTabRobot(robot);
		robot.delay(1000);

		StringSelection stringSelection = new StringSelection(cell1);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		pasteTextRobot(robot);

		robot.delay(1000);

		EnterRobot(robot);

		robot.delay(1000);

		EnterRobot(robot);

		explicitWaitClickable(10, getBtnSuccessPopup());
		clickWithRetry(getBtnSuccessPopup());
//		getBtnSuccessPopup().click();

	}

	public void NavigateToManageTimetable() throws FileNotFoundException, IOException, CsvException {

//		explicitWaitClickable(20, getSchoolOperationMainMenu());
//		clickWithRetry(getSchoolOperationMainMenu());

		explicitWaitClickable(10, getManageTimetableMainMenu());
		clickWithRetry(getManageTimetableMainMenu());

		explicitWaitClickable(10, getBtnConfigureTimetable());
		clickWithRetry(getBtnConfigureTimetable());

	}

	public void RequiredCredentialsForTimetableCreation()
			throws FileNotFoundException, IOException, CsvException, InterruptedException, AWTException {

//		scanner = new Scanner(System.in);
//		System.out.println("Enter Row Num: ");
//		rowNum = scanner.nextInt();
//		System.out.println("You have entered " + rowNum + " as Row Number");

		String cell1 = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 4);
		System.out.println(cell1);
		explicitWaitClickable(10, getDdnCategories());
		selectDdnByText(getDdnCategories(), cell1);

		/*
		 * Selecting the Check Box from Monday to Friday
		 */

//		List<WebElement> checkboxs = driver.findElements(By.cssSelector(".checkbox-custom-label"));
//		int checkboxCount = checkboxs.size();
//		System.out.println(checkboxCount);

		for (int i = 1; i <= checkboxCount; i++) {

			try {

				WebElement checkBox = driver
						.findElement(By.xpath("(//label[@class=\"checkbox-custom-label\"])[" + i + "]"));
				checkBox.click();

			} catch (ElementClickInterceptedException e) {
				System.out.println("Handling Element Click Intercepted Exception");
				Thread.sleep(500);
			}

		}

//
//		for (WebElement checkbox : checkboxs) {
//
//			int maxRetries = 5;
//			for (int attempt = 1; attempt <= maxRetries; attempt++) {
//				try {
//					checkbox.click();
//					break;
//				} catch (ElementClickInterceptedException e) {
//					System.out.println("Handling stale element reference - Attempt " + attempt);
//					Thread.sleep(500);
//				}
//			}
//		}

//		explicitWaitClickable(10, getCheckBoxMonday());
//		clickWithRetry(getCheckBoxMonday());
//		explicitWaitClickable(10, getCheckBoxTuesday());
//		clickWithRetry(getCheckBoxTuesday());
//		explicitWaitClickable(10, getCheckBoxWednesday());
//		clickWithRetry(getCheckBoxWednesday());
//		explicitWaitClickable(10, getCheckBoxThursday());
//		clickWithRetry(getCheckBoxThursday());
//		explicitWaitClickable(10, getCheckBoxFriday());
//		clickWithRetry(getCheckBoxFriday());

		String cell2 = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 5);
		System.out.println(cell2);
		explicitWaitClickable(10, getTxtSchoolStartTime());

		getTxtSchoolStartTime().click();
		getTxtSchoolStartTime().clear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='09:00';", getTxtSchoolStartTime());

		Robot robot = new Robot();
		tabRobot(robot);

		String cell3 = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 6);
		System.out.println(cell3);
		EnterInTextbox(getTxtTotalPeriod(), cell3);

		String cell4 = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 7);
		System.out.println(cell4);
		EnterInTextbox(getTxtPeriodDuration(), cell4);

		String cell5 = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 8);
		System.out.println(cell5);
		selectDdnByText(getDdnInterval(), cell5);

		String cell6 = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 9);
		System.out.println(cell6);
		EnterInTextbox(getTxtIntervalMins(), cell6);

		String cell7 = readSpecificCell(getPropertyFileValue("manageTimetableCSV"), rowNum, 10);
		System.out.println(cell7);
		selectDdnByValue(getDdnBreakAfter(), cell7);

		explicitWaitClickable(10, getBtnConfigNewTimetable());
		clickWithRetry(getBtnConfigNewTimetable());
	}

	public void ConfiguresAndPublishesTheTimetable() throws InterruptedException {

		/*
		 * For Reconfiguration
		 * 
		 * 
		 * explicitWaitClickable(10, getBtnReconfigureBuild());
		 * clickWithRetry(getBtnReconfigureBuild());
		 */

		explicitWaitClickable(10, getBtnBuildTimetable());
		clickWithRetry(getBtnBuildTimetable());

		String javascriptCode = "$('.home').animate({ scrollTop: parseInt($('html').scrollTop() + 10)} );";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javascriptCode);

		explicitWaitClickable(10, getBtnPublishTimetable());
		clickWithRetry(getBtnPublishTimetable());

	}

	public void VerifiesTheSuccessfulPopupMessage() {

		explicitWaitClickable(10, getBtnSuccessfullPopup());

		String successPopupMsz = getText(getTxtSuccessPopup());
		System.out.println(successPopupMsz);
		Assert.assertEquals("TimeTable Published Successfully", successPopupMsz);
		HighlightOutput("Assertion Passed Success Popup Message ID is " + successPopupMsz);

		clickWithRetry(getBtnSuccessfullPopup());

	}
}

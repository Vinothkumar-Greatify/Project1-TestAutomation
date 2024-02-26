package com.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;
import com.google.common.collect.ImmutableMap;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;
import com.opencsv.exceptions.CsvException;

public class SchoolAdminOnboardPage extends BaseClass {

	Scanner scanner;
	String schoolname;
	String schoolID;
	String schoolPassword;
	String schoolAdminURL;
	int rowNum = 1;

	public SchoolAdminOnboardPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * 1. Super Admin Login
	 */

	@FindBy(id = "user_id")
	private WebElement txtUserID;
	@FindBy(id = "user_password")
	private WebElement txtUserPassword;
	@FindBy(css = ".login_btn")
	private WebElement btnLogin;

	public WebElement getTxtUserID() {
		return txtUserID;
	}

	public void setTxtUserID(WebElement txtUserID) {
		this.txtUserID = txtUserID;
	}

	public WebElement getTxtUserPassword() {
		return txtUserPassword;
	}

	public void setTxtUserPassword(WebElement txtUserPassword) {
		this.txtUserPassword = txtUserPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}

	/*
	 * 2. Navigate to Manage School Page
	 */

	@FindBy(xpath = "//span[contains(text(),'Manage School')]")
	private WebElement clkManageSchoolMainMenu;

	public WebElement getClkManageSchoolMainMenu() {
		return clkManageSchoolMainMenu;
	}

	public void setClkManageSchoolMainMenu(WebElement clkManageSchoolMainMenu) {
		this.clkManageSchoolMainMenu = clkManageSchoolMainMenu;
	}

	// 3. Generates New School Profile Invite

	@FindBy(xpath = "//button[@class=\"invitebtn\" and @data-target=\"#invit_modal\"]")
	private WebElement btnInviteSchool;
	@FindBy(id = "invite_schoolname")
	private WebElement txtSchoolName;
	@FindBy(id = "invite_schoolsite")
	private WebElement txtSchoolSiteName;
	@FindBy(id = "invite_schoolemail")
	private WebElement txtSchoolEmail;
	@FindBy(id = "school_module_all")
	private WebElement checkboxSelectAll;
	@FindBy(id = "invite_schoolcommission")
	private WebElement txtSchoolCommission;
	@FindBy(id = "invite_schoolsms_credits")
	private WebElement txtSMSCredit;
	@FindBy(id = "invite_schoolwa_credits")
	private WebElement txtWhatsappCredit;
	@FindBy(id = "school_account_id")
	private WebElement txtAccountID;
	@FindBy(id = "school_commission_amount")
	private WebElement txtCommisionAmount;
	@FindBy(id = "invite-send-btn")
	private WebElement btnSendNow;

	public WebElement getBtnSendNow() {
		return btnSendNow;
	}

	public void setBtnSendNow(WebElement btnSendNow) {
		this.btnSendNow = btnSendNow;
	}

	public WebElement getBtnInviteSchool() {
		return btnInviteSchool;
	}

	public void setBtnInviteSchool(WebElement btnInviteSchool) {
		this.btnInviteSchool = btnInviteSchool;
	}

	public WebElement getTxtSchoolName() {
		return txtSchoolName;
	}

	public void setTxtSchoolName(WebElement txtSchoolName) {
		this.txtSchoolName = txtSchoolName;
	}

	public WebElement getTxtSchoolSiteName() {
		return txtSchoolSiteName;
	}

	public void setTxtSchoolSiteName(WebElement txtSchoolSiteName) {
		this.txtSchoolSiteName = txtSchoolSiteName;
	}

	public WebElement getTxtSchoolEmail() {
		return txtSchoolEmail;
	}

	public void setTxtSchoolEmail(WebElement txtSchoolEmail) {
		this.txtSchoolEmail = txtSchoolEmail;
	}

	public WebElement getCheckboxSelectAll() {
		return checkboxSelectAll;
	}

	public void setCheckboxSelectAll(WebElement checkboxSelectAll) {
		this.checkboxSelectAll = checkboxSelectAll;
	}

	public WebElement getTxtSchoolCommission() {
		return txtSchoolCommission;
	}

	public void setTxtSchoolCommission(WebElement txtSchoolCommission) {
		this.txtSchoolCommission = txtSchoolCommission;
	}

	public WebElement getTxtSMSCredit() {
		return txtSMSCredit;
	}

	public void setTxtSMSCredit(WebElement txtSMSCredit) {
		this.txtSMSCredit = txtSMSCredit;
	}

	public WebElement getTxtWhatsappCredit() {
		return txtWhatsappCredit;
	}

	public void setTxtWhatsappCredit(WebElement txtWhatsappCredit) {
		this.txtWhatsappCredit = txtWhatsappCredit;
	}

	public WebElement getTxtAccountID() {
		return txtAccountID;
	}

	public void setTxtAccountID(WebElement txtAccountID) {
		this.txtAccountID = txtAccountID;
	}

	public WebElement getTxtCommisionAmount() {
		return txtCommisionAmount;
	}

	public void setTxtCommisionAmount(WebElement txtCommisionAmount) {
		this.txtCommisionAmount = txtCommisionAmount;
	}

	/*
	 * 4. Verify Success Message In Super Admin
	 */

	@FindBy(xpath = "//button[contains(.,'OK')]")
	private WebElement btnSuccess;
	@FindBy(xpath = "//div[contains(text(),'School Invite sent successfully')]")
	private WebElement successText;

	public WebElement getSuccessText() {
		return successText;
	}

	public void setSuccessText(WebElement successText) {
		this.successText = successText;
	}

	public WebElement getBtnSuccess() {
		return btnSuccess;
	}

	public void setBtnSuccess(WebElement btnSuccess) {
		this.btnSuccess = btnSuccess;
	}

	/*
	 * 5. Fetch username and password from Mailosaur
	 */

	/*
	 * 6. Login To The respective School Admin Dashboard
	 */

	@FindBy(id = "name1")
	private WebElement userID;
	@FindBy(id = "name2")
	private WebElement userPassword;
	@FindBy(css = ".login_btn")
	private WebElement btnLoginSA;

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}

	public String getSchoolPassword() {
		return schoolPassword;
	}

	public void setSchoolPassword(String schoolPassword) {
		this.schoolPassword = schoolPassword;
	}

	public String getSchoolAdminURL() {
		return schoolAdminURL;
	}

	public void setSchoolAdminURL(String schoolAdminURL) {
		this.schoolAdminURL = schoolAdminURL;
	}

	public WebElement getUserID() {
		return userID;
	}

	public void setUserID(WebElement userID) {
		this.userID = userID;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(WebElement userPassword) {
		this.userPassword = userPassword;
	}

	public WebElement getBtnLoginSA() {
		return btnLoginSA;
	}

	public void setBtnLoginSA(WebElement btnLoginSA) {
		this.btnLoginSA = btnLoginSA;
	}

	/*
	 * 7. Verify the Mail-Id and School Name on Onboard Page
	 */

	@FindBy(id = "user-name")
	private WebElement schoolname1;

	public WebElement getSchoolname1() {
		return schoolname1;
	}

	public void setSchoolname1(WebElement schoolname1) {
		this.schoolname1 = schoolname1;
	}

	/*
	 * 8. Onboard the new school using the CSV File
	 */

	@FindBy(css = ".profile_default_img")
	private WebElement schoolLogo;
	@FindBy(css = ".syllabus")
	private WebElement syllabusDropdown;
	@FindBy(id = "name4")
	private WebElement affiliationNumber;
	@FindBy(css = ".medium_of_school")
	private WebElement mediumofSchoolDropdown;
	@FindBy(id = "name6")
	private WebElement contactPersonName;
	@FindBy(id = "mobile_code")
	private WebElement mobileNumber;
	@FindBy(id = "name8")
	private WebElement websiteAddress;
	@FindBy(id = "name9")
	private WebElement latitude;
	@FindBy(id = "name10")
	private WebElement longitude;

	@FindBy(id = "name11")
	private WebElement address1;
	@FindBy(id = "name12")
	private WebElement address2;
	@FindBy(id = "name13")
	private WebElement countryDropdown;
	@FindBy(css = ".state")
	private WebElement stateDropdown;
	@FindBy(css = ".city")
	private WebElement cityDropdown;
	@FindBy(id = "name16")
	private WebElement pincode;
	@FindBy(css = ".Continue-btn.cont-btn-1.school_details")
	private WebElement btnContinue;

	/*
	 * Subject Onboard
	 */

	@FindBy(css = ".upload_filed")
	private WebElement subjectUploadField;
	@FindBy(css = ".swal-button.swal-button--confirm")
	private WebElement OKBtnSubField;
	@FindBy(css = ".Continue-btn.cont-btn-2.cont_btn_sub")
	private WebElement btnContinueSubField;

	/*
	 * Teacher Onboard
	 */

	@FindBy(xpath = "(//p[contains(text(),'Upload CSV Files')])[1]")
	private WebElement teacherUploadField;
	@FindBy(css = ".swal-button.swal-button--confirm")
	private WebElement OKBtnTeacherField;
	@FindBy(css = ".Continue-btn.cont-btn-3.cont_btn_teacher")
	private WebElement btnContinueTeacherField;

	/*
	 * Class Onboard
	 */

	@FindBy(xpath = "(//p[contains(text(),'Upload CSV Files')])[2]")
	private WebElement classUploadField;
	@FindBy(css = ".swal-button.swal-button--confirm")
	private WebElement OKBtnClassField;
	@FindBy(css = ".Continue-btn.cont-btn-4.cont_btn_class")
	private WebElement btnContinueClassField;

	/*
	 * Student Onboard
	 */

	@FindBy(xpath = "(//p[contains(text(),'Upload CSV Files')])[3]")
	private WebElement studentUploadField;
	@FindBy(css = ".swal-button.swal-button--confirm")
	private WebElement OKBtnStudentField;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement btnSubmitStudentField;

	public WebElement getStudentUploadField() {
		return studentUploadField;
	}

	public void setStudentUploadField(WebElement studentUploadField) {
		this.studentUploadField = studentUploadField;
	}

	public WebElement getOKBtnStudentField() {
		return OKBtnStudentField;
	}

	public void setOKBtnStudentField(WebElement oKBtnStudentField) {
		OKBtnStudentField = oKBtnStudentField;
	}

	public WebElement getBtnSubmitStudentField() {
		return btnSubmitStudentField;
	}

	public void setBtnSubmitStudentField(WebElement btnSubmitStudentField) {
		this.btnSubmitStudentField = btnSubmitStudentField;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public WebElement getSubjectUploadField() {
		return subjectUploadField;
	}

	public void setSubjectUploadField(WebElement subjectUploadField) {
		this.subjectUploadField = subjectUploadField;
	}

	public WebElement getOKBtnSubField() {
		return OKBtnSubField;
	}

	public void setOKBtnSubField(WebElement oKBtnSubField) {
		OKBtnSubField = oKBtnSubField;
	}

	public WebElement getBtnContinueSubField() {
		return btnContinueSubField;
	}

	public void setBtnContinueSubField(WebElement btnContinueSubField) {
		this.btnContinueSubField = btnContinueSubField;
	}

	public WebElement getTeacherUploadField() {
		return teacherUploadField;
	}

	public void setTeacherUploadField(WebElement teacherUploadField) {
		this.teacherUploadField = teacherUploadField;
	}

	public WebElement getOKBtnTeacherField() {
		return OKBtnTeacherField;
	}

	public void setOKBtnTeacherField(WebElement oKBtnTeacherField) {
		OKBtnTeacherField = oKBtnTeacherField;
	}

	public WebElement getBtnContinueTeacherField() {
		return btnContinueTeacherField;
	}

	public void setBtnContinueTeacherField(WebElement btnContinueTeacherField) {
		this.btnContinueTeacherField = btnContinueTeacherField;
	}

	public WebElement getClassUploadField() {
		return classUploadField;
	}

	public void setClassUploadField(WebElement classUploadField) {
		this.classUploadField = classUploadField;
	}

	public WebElement getOKBtnClassField() {
		return OKBtnClassField;
	}

	public void setOKBtnClassField(WebElement oKBtnClassField) {
		OKBtnClassField = oKBtnClassField;
	}

	public WebElement getBtnContinueClassField() {
		return btnContinueClassField;
	}

	public void setBtnContinueClassField(WebElement btnContinueClassField) {
		this.btnContinueClassField = btnContinueClassField;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void setBtnContinue(WebElement btnContinue) {
		this.btnContinue = btnContinue;
	}

	public WebElement getSchoolLogo() {
		return schoolLogo;
	}

	public void setSchoolLogo(WebElement schoolLogo) {
		this.schoolLogo = schoolLogo;
	}

	public WebElement getSyllabusDropdown() {
		return syllabusDropdown;
	}

	public void setSyllabusDropdown(WebElement syllabusDropdown) {
		this.syllabusDropdown = syllabusDropdown;
	}

	public WebElement getAffiliationNumber() {
		return affiliationNumber;
	}

	public void setAffiliationNumber(WebElement affiliationNumber) {
		this.affiliationNumber = affiliationNumber;
	}

	public WebElement getMediumofSchoolDropdown() {
		return mediumofSchoolDropdown;
	}

	public void setMediumofSchoolDropdown(WebElement mediumofSchoolDropdown) {
		this.mediumofSchoolDropdown = mediumofSchoolDropdown;
	}

	public WebElement getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(WebElement contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(WebElement mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public WebElement getWebsiteAddress() {
		return websiteAddress;
	}

	public void setWebsiteAddress(WebElement websiteAddress) {
		this.websiteAddress = websiteAddress;
	}

	public WebElement getLatitude() {
		return latitude;
	}

	public void setLatitude(WebElement latitude) {
		this.latitude = latitude;
	}

	public WebElement getLongitude() {
		return longitude;
	}

	public void setLongitude(WebElement longitude) {
		this.longitude = longitude;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public void setAddress1(WebElement address1) {
		this.address1 = address1;
	}

	public WebElement getAddress2() {
		return address2;
	}

	public void setAddress2(WebElement address2) {
		this.address2 = address2;
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public void setCountryDropdown(WebElement countryDropdown) {
		this.countryDropdown = countryDropdown;
	}

	public WebElement getStateDropdown() {
		return stateDropdown;
	}

	public void setStateDropdown(WebElement stateDropdown) {
		this.stateDropdown = stateDropdown;
	}

	public WebElement getCityDropdown() {
		return cityDropdown;
	}

	public void setCityDropdown(WebElement cityDropdown) {
		this.cityDropdown = cityDropdown;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public void setPincode(WebElement pincode) {
		this.pincode = pincode;
	}

	/*
	 * 9. Verify the success popup message
	 */

	@FindBy(xpath = "//h6[contains(text(),'Successfully Onboarded!')]")
	private WebElement txtSuccessOnboard;
	@FindBy(css = ".Credentials_btn")
	private WebElement btnSuccessOnboard;

	public WebElement getTxtSuccessOnboard() {
		return txtSuccessOnboard;
	}

	public void setTxtSuccessOnboard(WebElement txtSuccessOnboard) {
		this.txtSuccessOnboard = txtSuccessOnboard;
	}

	public WebElement getBtnSuccessOnboard() {
		return btnSuccessOnboard;
	}

	public void setBtnSuccessOnboard(WebElement btnSuccessOnboard) {
		this.btnSuccessOnboard = btnSuccessOnboard;
	}

	/*
	 * Methods Start's
	 */

	public void LogintoSuperAdminDashboard() throws FileNotFoundException, IOException, InterruptedException {

		explicitWaitClickable(10, getTxtUserID());
		clickWithRetry(getTxtUserID());
		EnterInTextbox(getTxtUserID(), getPropertyFileValue("superadminusername"));
		EnterInTextbox(getTxtUserPassword(), getPropertyFileValue("superadminpassword"));
		eleClick(getBtnLogin());
		Thread.sleep(5000);

	}

	public void NavigatetoManageSchoolsPage() {

		explicitWaitClickable(10, getClkManageSchoolMainMenu());
		clickWithRetry(getClkManageSchoolMainMenu());

	}

	public void GeneratesNewSchoolProfileInvite() throws FileNotFoundException, IOException, CsvException {

		explicitWaitClickable(20, getBtnInviteSchool());
		clickWithRetry(getBtnInviteSchool());

//		scanner = new Scanner(System.in);
//		System.out.println("Enter the row number:");
//		rowNum = scanner.nextInt();
//		System.out.println("You have entered " + rowNum + " as Row number");
		// scanner.close();

		explicitWaitClickable(20, getTxtSchoolName());
		clickWithRetry(getTxtSchoolName());
		schoolname = readSpecificCell(getPropertyFileValue("inviteschool"), rowNum, 0);
		EnterInTextbox(getTxtSchoolName(), schoolname);
		System.out.println(schoolname);

		explicitWaitClickable(20, getTxtSchoolSiteName());
		clickWithRetry(getTxtSchoolSiteName());
		String cell1 = readSpecificCell(getPropertyFileValue("inviteschool"), rowNum, 1);
		EnterInTextbox(getTxtSchoolSiteName(), cell1);
		System.out.println(cell1);

		explicitWaitClickable(20, getTxtSchoolEmail());
		clickWithRetry(getTxtSchoolEmail());
		String cell2 = readSpecificCell(getPropertyFileValue("inviteschool"), rowNum, 2);
		EnterInTextbox(getTxtSchoolEmail(), schoolname + cell2);
		System.out.println(cell2);

		explicitWaitClickable(20, getCheckboxSelectAll());
		clickWithRetry(getCheckboxSelectAll());

		explicitWaitClickable(20, getTxtSchoolCommission());
		clickWithRetry(getTxtSchoolCommission());
		String cell3 = readSpecificCell(getPropertyFileValue("inviteschool"), rowNum, 3);
		EnterInTextbox(getTxtSchoolCommission(), cell3);
		System.out.println(cell3);

		explicitWaitClickable(20, getTxtSMSCredit());
		clickWithRetry(getTxtSMSCredit());
		String cell4 = readSpecificCell(getPropertyFileValue("inviteschool"), rowNum, 4);
		EnterInTextbox(getTxtSMSCredit(), cell4);
		System.out.println(cell4);

		explicitWaitClickable(20, getTxtWhatsappCredit());
		clickWithRetry(getTxtWhatsappCredit());
		String cell5 = readSpecificCell(getPropertyFileValue("inviteschool"), rowNum, 5);
		EnterInTextbox(getTxtWhatsappCredit(), cell5);
		System.out.println(cell5);

		explicitWaitClickable(20, getTxtAccountID());
		clickWithRetry(getTxtAccountID());
		String cell6 = readSpecificCell(getPropertyFileValue("inviteschool"), rowNum, 6);
		EnterInTextbox(getTxtAccountID(), cell6);
		System.out.println(cell6);

		explicitWaitClickable(20, getTxtCommisionAmount());
		clickWithRetry(getTxtCommisionAmount());
		String cell7 = readSpecificCell(getPropertyFileValue("inviteschool"), rowNum, 7);
		EnterInTextbox(getTxtCommisionAmount(), cell7);
		System.out.println(cell7);

		/*
		 * Delete used data from csv
		 */

		DeleteRowFromCSV(getPropertyFileValue("inviteschool"), rowNum);

		explicitWaitClickable(20, getBtnSendNow());
		clickWithRetry(getBtnSendNow());

	}

	public void VerifySuccessMessageInSuperAdmin() {

		explicitWaitClickable(100, getBtnSuccess());
		String popuptext = getText(getSuccessText());
		HighlightOutput(popuptext);
		Assert.assertEquals("Assertion Failed", popuptext, "School Invite sent successfully");
		clickWithRetry(getBtnSuccess());

	}

	public void FetchUsernameAndPasswordFromMailosaur() throws IOException, MailosaurException, SocketException {

		String apiKey = getPropertyFileValue("mailosaurAPIKey");
		String serverId = getPropertyFileValue("mailosaurServerID");
		String serverDomain = getPropertyFileValue("mailosaurServerDomain");

		MailosaurClient mailosaur = new MailosaurClient(apiKey);

		SearchCriteria criteria = new SearchCriteria();

		criteria.withSentTo(schoolname + serverDomain);

		Message message = mailosaur.messages().get(serverId, criteria);

		assertNotNull(message);
		assertEquals("Invitation To Onboard", message.subject());

		String htmlData = message.html().body();

		// System.out.println(htmlData);

		String regex = "<p.*?>Password<\\/p>\\s*<p.*?>([a-zA-Z0-9!@&*#$]+)<\\/p>";
		String hcschoolRegex = "<p.*?>(HCSCHOOL\\w+)</p>";
		String hrefRegex = "<a\\s+href=\"([^\"]+)\">";

		Pattern pattern = Pattern.compile(regex);
		Pattern hcschoolPattern = Pattern.compile(hcschoolRegex);
		Pattern hrefPattern = Pattern.compile(hrefRegex);

		Matcher matcher = pattern.matcher(htmlData);
		Matcher hcschoolMatcher = hcschoolPattern.matcher(htmlData);
		Matcher hrefMatcher = hrefPattern.matcher(htmlData);

		if (matcher.find()) {
			schoolPassword = matcher.group(1);
			System.out.println("Extracted Password: " + schoolPassword);
		} else {
			System.out.println("Password not found in the HTML data.");
		}

		if (hcschoolMatcher.find()) {
			schoolID = hcschoolMatcher.group(1);
			System.out.println("User Name: " + schoolID);
		} else {
			System.out.println("User Name not found in the HTML");

		}
		if (hrefMatcher.find()) {
			schoolAdminURL = hrefMatcher.group(1);
			System.out.println("Extracted URL: " + schoolAdminURL);
		} else {
			System.out.println("No URL found");
		}
	}

	public void LogIntoSchoolAdminDashboard() {

		enterUrl(schoolAdminURL);

		explicitWaitClickable(10, getUserID());
		clickWithRetry(getUserID());
		EnterInTextbox(getUserID(), schoolID);
//		EnterInTextbox(getUserID(), "HCSCHOOL0295");

		explicitWaitClickable(10, getUserPassword());
		clickWithRetry(getUserPassword());
		EnterInTextbox(getUserPassword(), schoolPassword);
//		EnterInTextbox(getUserPassword(), "34I5L4IK5MU");

		explicitWaitClickable(10, getBtnLoginSA());
		clickWithRetry(getBtnLoginSA());

	}

	public void VerifySchoolNameAndMailIDOnOnboardPage() throws FileNotFoundException, IOException {

		String schoolname1 = getText(getSchoolname1());
		HighlightOutput(schoolname1);
		Assert.assertEquals("Assertion Failed", schoolname1, schoolname);

	}

	public void OnboardSchoolUsingCSVFile()
			throws FileNotFoundException, IOException, AWTException, InterruptedException, CsvException {

//		scanner = new Scanner(System.in);
//		System.out.println("Enter the row number:");
//		rowNum = scanner.nextInt();
//		System.out.println("You have entered " + rowNum + " as Row number");
//		scanner.close();

		String currentUrl = driver.getCurrentUrl();
		if (currentUrl == schoolAdminURL) {
			System.out.println(schoolAdminURL);
		} else {

			Thread.sleep(3000);
			explicitWaitClickable(20, getSchoolLogo());
		}

		/*
		 * Upload Image From Local Machine
		 */

		explicitWaitClickable(20, getSchoolLogo());
		clickWithRetry(getSchoolLogo());

		String cell1 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 0);
		System.out.println(cell1);

		Robot robot = new Robot();

		robot.delay(1000);

		command_TabRobot(robot);
		robot.delay(500);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection = new StringSelection(cell1);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

//        driver.switchTo().defaultContent();

//		command_TabRobot(robot);

		// Select Values From Dropdown

		explicitWaitClickable(20, getSyllabusDropdown());
		clickWithRetry(getSyllabusDropdown());
		String cell2 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 1);
		selectDdnByText(getSyllabusDropdown(), cell2);
		System.out.println(cell2);

		String cell3 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 2);
		EnterInTextbox(getAffiliationNumber(), cell3);
		System.out.println(cell3);

		explicitWaitClickable(20, getMediumofSchoolDropdown());
		clickWithRetry(getMediumofSchoolDropdown());
		String cell4 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 3);
		selectDdnByValue(getMediumofSchoolDropdown(), cell4);
		System.out.println(cell4);

		String cell5 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 4);
		EnterInTextbox(getContactPersonName(), cell5);
		System.out.println(cell5);

		String cell6 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 5);
		EnterInTextbox(getMobileNumber(), cell6);
		System.out.println(cell6);

		String cell7 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 6);
		EnterInTextbox(getWebsiteAddress(), cell7);
		System.out.println(cell7);

		String cell8 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 7);
		EnterInTextbox(getLatitude(), cell8);
		System.out.println(cell8);

		String cell9 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 8);
		EnterInTextbox(getLongitude(), cell9);
		System.out.println(cell9);

		String cell10 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 9);
		EnterInTextbox(getAddress1(), cell10);
		System.out.println(cell10);

		String cell11 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 10);
		EnterInTextbox(getAddress2(), cell11);
		System.out.println(cell11);

		explicitWaitClickable(20, getCountryDropdown());
		clickWithRetry(getCountryDropdown());
		String cell12 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 11);
		selectDdnByText(getCountryDropdown(), cell12);
		System.out.println(cell12);

		explicitWaitClickable(20, getStateDropdown());
		clickWithRetry(getStateDropdown());
		String cell13 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 12);
		selectDdnByText(getStateDropdown(), cell13);
		System.out.println(cell13);

		explicitWaitClickable(20, getCityDropdown());
		clickWithRetry(getCityDropdown());
		String cell14 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 13);
		selectDdnByText(getCityDropdown(), cell14);
		System.out.println(cell14);

		String cell15 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 14);
		EnterInTextbox(getPincode(), cell15);
		System.out.println(cell15);

		explicitWaitClickable(20, getBtnContinue());
		clickWithRetry(getBtnContinue());

		/*
		 * Subject CSV Upload From Local Machine
		 */

		explicitWaitClickable(20, getSubjectUploadField());
		clickWithRetry(getSubjectUploadField());
		String cell16 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 15);
		System.out.println(cell16);

		// Robot robot = new Robot();

		robot.delay(1000);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection1 = new StringSelection(cell16);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		explicitWaitClickable(20, getOKBtnSubField());
		clickWithRetry(getOKBtnSubField());

		Thread.sleep(500);

		explicitWaitClickable(20, getBtnContinueSubField());
		clickWithRetry(getBtnContinueSubField());

		Thread.sleep(500);

		/*
		 * Teacher CSV Upload From Local Machine
		 */

		scrollDownJs(getBtnContinueTeacherField());

		explicitWaitClickable(20, getTeacherUploadField());
		clickWithRetry(getTeacherUploadField());
		String cell17 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 16);
		System.out.println(cell17);

		robot.delay(1000);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection2 = new StringSelection(cell17);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		explicitWaitClickable(20, getOKBtnTeacherField());
		clickWithRetry(getOKBtnTeacherField());

		Thread.sleep(500);

		explicitWaitClickable(20, getBtnContinueTeacherField());
		clickWithRetry(getBtnContinueTeacherField());

		Thread.sleep(500);

		/*
		 * Class CSV Upload From Local Machine
		 */

		scrollDownJs(getBtnContinueClassField());

		explicitWaitClickable(20, getClassUploadField());
		clickWithRetry(getClassUploadField());
		String cell18 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 17);
		System.out.println(cell18);

		robot.delay(1000);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection3 = new StringSelection(cell18);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection3, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		explicitWaitClickable(20, getOKBtnClassField());
		clickWithRetry(getOKBtnClassField());

		Thread.sleep(500);

		explicitWaitClickable(20, getBtnContinueClassField());
		clickWithRetry(getBtnContinueClassField());

		Thread.sleep(500);

		/*
		 * Student CSV Upload From Local Machine
		 */

		explicitWaitClickable(20, getStudentUploadField());
		clickWithRetry(getStudentUploadField());
		String cell19 = readSpecificCell(getPropertyFileValue("onboardSchoolDetails"), rowNum, 18);
		System.out.println(cell19);

		robot.delay(1000);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection4 = new StringSelection(cell19);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection4, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		/*
		 * Delete used data from csv
		 */

		DeleteRowFromCSV(getPropertyFileValue("onboardSchoolDetails"), rowNum);

		explicitWaitClickable(20, getOKBtnStudentField());
		clickWithRetry(getOKBtnStudentField());

		Thread.sleep(3000);

		explicitWaitClickable(20, getBtnSubmitStudentField());
		clickWithRetry(getBtnSubmitStudentField());

		Thread.sleep(500);

	}

	public void SuccessfullOnboardPopup() {

		explicitWaitClickable(100, getBtnSuccessOnboard());
		String popuptext = getText(getTxtSuccessOnboard());
		HighlightOutput(popuptext);
		Assert.assertEquals("Assertion Failed", popuptext, "Successfully Onboarded!");
		clickWithRetry(getBtnSuccessOnboard());

	}

}

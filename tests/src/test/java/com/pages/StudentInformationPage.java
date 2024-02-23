package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import javax.management.loading.PrivateClassLoader;

import org.hamcrest.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;
import com.fasterxml.jackson.databind.JsonNode;

import org.json.JSONObject;
import org.junit.Assert;

public class StudentInformationPage extends CreateNewStudentPage {

	Map<String, String> studentInfoJsonMap1;
	Map<String, String> parentInfoJsonMap1;
	Map<String, String> classInfoJsonMap1;

	Map<String, String> studentInfoJsonMap2;
	Map<String, String> parentInfoJsonMap2;
	Map<String, String> classInfoJsonMap2;

	Map<String, String> studentInfoJsonMap3;
	Map<String, String> parentInfoJsonMap3;
	Map<String, String> classInfoJsonMap3;

	// String NewStudentID = "STD10";
	// String standard = "6";

	public StudentInformationPage() {
		PageFactory.initElements(driver, this);
	}

	// 1. Login to school admin dashboard
	@FindBy(xpath = "//input[@id='name1']")
	private WebElement txtUserName;
	@FindBy(id = "name2")
	private WebElement txtUserPassword;
	@FindBy(className = "login_btn")
	private WebElement btnLogin;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtUserPassword() {
		return txtUserPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	// user should naviagte to the student management School Admin Dashboard

	@FindBy(id = "schoolManagementSection")
	private WebElement menubarSchoolOpearations;
	@FindBy(xpath = "//span[text()='Manage Students']")
	private WebElement manageStd;
	@FindBy(xpath = "(//input[@class=\"search__field\"])[1]")
	private WebElement searchTab;
	@FindBy(css = "div.edit_text.view")
	// @FindBy(xpath = "//*[@class='sorting_1']")
	private WebElement hylinkSTDID;

	public WebElement getMenubarSchoolOpearations() {
		return menubarSchoolOpearations;
	}

	public WebElement getManageStd() {
		return manageStd;
	}

	public WebElement getSearchTab() {
		return searchTab;
	}

	public WebElement getHylinkSTDID() {
		return hylinkSTDID;
	}

	// Verify Std ID
	@FindBy(className = "student_id_class")
	private WebElement StdId;

	public WebElement getStdId() {
		return StdId;
	}

	// Identify And Record The Student Details

	@FindBy(className = "details-info")
	private WebElement STDDetails;

	public WebElement getSTDDetails() {
		return STDDetails;
	}

	// Identify And Record The Parent Details In School Admin Dashboard

	@FindBy(css = ".nav-item:nth-child(2) > #pills-home-tab")
	private WebElement studentDetailsTab;

	@FindBy(css = ".main_tables:nth-child(1) > .parent_details_bg:nth-child(2)")
	private WebElement parentDetails1;

	public WebElement getStudentDetailsTab() {
		return studentDetailsTab;
	}

	public void setStudentDetailsTab(WebElement studentDetailsTab) {
		this.studentDetailsTab = studentDetailsTab;
	}

	public WebElement getParentDetails1() {
		return parentDetails1;
	}

	public void setParentDetails1(WebElement parentDetails1) {
		this.parentDetails1 = parentDetails1;
	}

	// Identify And Record The Class Details In School Admin Dashboard

	@FindBy(css = ".main_tables:nth-child(1) > .parent_details_bg:nth-child(4)")
	private WebElement classDetails1;

	public WebElement getClassDetails1() {
		return classDetails1;
	}

	public void setClassDetails1(WebElement classDetails1) {
		this.classDetails1 = classDetails1;
	}

	// 2. Teacher Dashboard Login
	@FindBy(xpath = "//input[@type='tel']")
	private WebElement mobileNumField;
	@FindBy(xpath = "//button[text()='Send OTP']")
	private WebElement btnSendOTP;
	@FindBy(xpath = "//button[@class='login_btn otp_btn']")
	private WebElement btnVerifyOTP;

	public WebElement getMobileNumField() {
		return mobileNumField;
	}

	public WebElement getBtnSendOTP() {
		return btnSendOTP;
	}

	public WebElement getBtnVerifyOTP() {
		return btnVerifyOTP;
	}

	// Naviagte To The Student Details Page
	@FindBy(xpath = "//p[contains(text(),'Class Management')]")
	private WebElement menubarClassManagement;
	@FindBy(xpath = "//a[@href='students_list']")
	private WebElement menubarStudent;
	@FindBy(xpath = "(//a[contains(text(),'Student details')])[1]")
	private WebElement clkStudentDetails;
	@FindBy(className = "search__field")
	private WebElement searchtab;
	@FindBy(xpath = "//a[@onclick='studentView()']")
	private WebElement clkStdId;
	@FindBy(css = ".classesdropdwn")
	private WebElement stdDropdown;

	public WebElement getStdDropdown() {
		return stdDropdown;
	}

	public void setStdDropdown(WebElement stdDropdown) {
		this.stdDropdown = stdDropdown;
	}

	public WebElement getMenubarStudent() {
		return menubarStudent;
	}

	public WebElement getClkStudentDetails() {
		return clkStudentDetails;
	}

	public WebElement getSearchtab() {
		return searchtab;
	}

	public WebElement getClkStdId() {
		return clkStdId;
	}

	public WebElement getMenubarClassManagement() {
		return menubarClassManagement;
	}

	// Verify Student ID In The Teacher Dashboard

	@FindBy(className = "studentid")
	private WebElement studentId;

	public WebElement getStudentId() {
		return studentId;
	}

	// Identify And Record The Student Details In Teacher Dashboard
	@FindBy(css = ".student_info.student_info2")
	private WebElement studentInfo;

	public WebElement getStudentInfo() {
		return studentInfo;
	}

	// Identify and Record Parent Details in the Teacher Dashboard

	@FindBy(css = ".parent_detail")
	private WebElement parentDetails2;

	public WebElement getParentDetails2() {
		return parentDetails2;
	}

	public void setParentDetails2(WebElement parentDetails2) {
		this.parentDetails2 = parentDetails2;
	}

	@FindBy(linkText = "Student details")
	private WebElement StudentdetailsTAB;

	public WebElement getStudentdetailsTAB() {
		return StudentdetailsTAB;
	}

	public void setStudentdetailsTAB(WebElement studentdetailsTAB) {
		StudentdetailsTAB = studentdetailsTAB;
	}

	// 3. PrincipalLogin

	@FindBy(id = "principalId")
	private WebElement principalId;
	@FindBy(id = "principalPassword")
	private WebElement principalPass;
	@FindBy(className = "login_btn")
	private WebElement login_btn;

	public WebElement getPrincipalId() {
		return principalId;
	}

	public WebElement getPrincipalPass() {
		return principalPass;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}

	// Naviagte To The Student Page Of Principal Dashboard

	@FindBy(xpath = "//span[contains(.,'Students')]")
	private WebElement studentPage;
	@FindBy(className = "search__field")
	private WebElement SearchTab1;
	@FindBy(css = ".edit_text.student-details")
	private WebElement studentID;

	public WebElement getStudentPage() {
		return studentPage;
	}

	public WebElement getSearchTab1() {
		return SearchTab1;
	}

	public WebElement getStudentID() {
		return studentID;
	}

	@FindBy(id = "classes_dropdwn")
	private WebElement classDropdown;

	public WebElement getClassDropdown() {
		return classDropdown;
	}

	public void setClassDropdown(WebElement classDropdown) {
		this.classDropdown = classDropdown;
	}

	// Verify Student ID In The Principal Dashboard

	@FindBy(xpath = "//p[@class=\"student-details_id\"]")
	private WebElement stdDetailsID;

	public WebElement getStdDetailsID() {
		return stdDetailsID;
	}

	// Identify And Record The Student Details In Principal Dashboard

	@FindBy(className = "student-details-bio")
	private WebElement studentDetails;

	public WebElement getStudentDetails() {
		return studentDetails;
	}

	// Identify and record the parent details in Principal Dashboard

	@FindBy(css = ".parent_details_bg:nth-child(1) > .parent_time_sheet")
	private WebElement parentDetails3;

	public WebElement getParentDetails3() {
		return parentDetails3;
	}

	public void setParentDetails3(WebElement parentDetails3) {
		this.parentDetails3 = parentDetails3;
	}

	// Identify and record the class details in Principal Dashboard

	@FindBy(css = ".class_detail > .parent_time_sheet")
	private WebElement classDetails3;

	public WebElement getClassDetails3() {
		return classDetails3;
	}

	public void setClassDetails3(WebElement classDetails3) {
		this.classDetails3 = classDetails3;
	}

	// verify the recorded class details in Principal Dashboard with School Admin
	public void SchoolAdminLogin() throws FileNotFoundException, IOException, InterruptedException, AWTException {
		explicitWaitClickable(10, getTxtUserName());
		clickWithRetry(getTxtUserName());
		EnterInTextbox(getTxtUserName(), getPropertyFileValue("sausername"));
		EnterInTextbox(getTxtUserPassword(), getPropertyFileValue("sapassword"));
		eleClick(getBtnLogin());
		Thread.sleep(5000);
	}

	public void NaviagteToTheStudentManagement() throws AWTException, FileNotFoundException, IOException {

		// explicitWaitClickable(20, getMenubarSchoolOpearations());
		// clickWithRetry(getMenubarSchoolOpearations());
		explicitWaitClickable(20, getManageStd());
		clickWithRetry(getManageStd());
		explicitWaitClickable(20, getSearchTab());
		clickWithRetry(getSearchTab());
		EnterInTextbox(getSearchTab(), NewStudentID);

		By elementLocator = By.cssSelector("div.edit_text.view");
		int maxAttempts = 5;
		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			try {
				WebElement element = driver.findElement(elementLocator);
				element.click();
				break;
			} catch (Exception e) {
				System.out.println("StaleElementReferenceException. Retrying...");
				if (attempt == maxAttempts) {
					throw e;
				}
			}
		}

	}

	public void VerifyStudentID() throws FileNotFoundException, IOException {
		String StdID = getText(getStdId());
		Assert.assertTrue("Assertion Failed", StdID.contains(NewStudentID));
		HighlightOutput("Assertion Passed Student ID is " + StdID);

	}

	public void IdentifyAndRecordTheStudentDetails() throws IOException {

		String Std_Details = getText(getSTDDetails());

		System.out.println(Std_Details);

		String[] keyValuePairs = Std_Details.split("\\n");

		studentInfoJsonMap1 = new TreeMap<>();

		// int Size = keyValuePairs.length / 2;

		// String[] arr1 = new String[Size];

		// for (int i = 0, j = 0; i < keyValuePairs.length - 1; i += 2, j++) {

		for (int i = 0; i < keyValuePairs.length - 1; i += 2) {

			String key = keyValuePairs[i];
			String value = keyValuePairs[i + 1];
			studentInfoJsonMap1.put(key, value);
			// arr1[j] = value;
		}

		// System.out.println("Array values are :" + Arrays.toString(arr1));

		JSONObject jsonObject1 = new JSONObject(studentInfoJsonMap1);

		String jsonString = jsonObject1.toString();

		HighlightOutput("JSON String of Student Info in School Admin Dashboard: " + jsonString);

	}

	public void IdentifyAndRecordTheParentDetailsInSchoolAdminDashboard() throws InterruptedException {

		explicitWaitClickable(20, getStudentDetailsTab());
		clickWithRetry(getStudentDetailsTab());

		Thread.sleep(3000);

		String textContentByJs = getTextContentByJs(getParentDetails1());
		System.out.println(textContentByJs);

		String result = textContentByJs.replaceAll("(?m)^\\s+", "").trim();

		/*
		 * "(?m)^\\s+" : is used to matches one or more leading whitespaces at the
		 * beginning of each line.
		 */

		System.out.println(result);

		String[] keyValuePairs = result.split("\n");

		parentInfoJsonMap1 = createMapFromKeyValuePairs(keyValuePairs);

		JSONObject jsonObject1 = new JSONObject(parentInfoJsonMap1);

		String jsonString = jsonObject1.toString();

		HighlightOutput("JSON String of Parent Info in School Admin Dashboard: " + jsonString);

	}

	public void IdentifyAndRecordTheClassDetailsInSchoolAdminDashboard() throws InterruptedException {

		Thread.sleep(3000);

		String textContentByJs = getTextContentByJs(getClassDetails1());
		System.out.println(textContentByJs);

		String result = textContentByJs.replaceAll("(?m)^\\s+", "").trim();

		/*
		 * "(?m)^\\s+" : is used to matches one or more leading whitespaces at the
		 * beginning of each line.
		 */

		System.out.println(result);

		String[] keyValuePairs = result.split("\n");

		classInfoJsonMap1 = createMapFromKeyValuePairs(keyValuePairs);

		JSONObject jsonObject1 = new JSONObject(classInfoJsonMap1);

		String jsonString = jsonObject1.toString();

		HighlightOutput("JSON String of Class Info in School Admin Dashboard: " + jsonString);

		// System.out.println("JSON String of Class Info in School Admin: " +
		// jsonString);

	}

	public void VerifyTheStudentDetailsInSchoolAdminDashboardWithCSVFile() {

		System.out.println("CSV Data: " + CsvMapData);
		System.out.println("Student Details of School Admin Dashboard: " + studentInfoJsonMap1);

		for (Map.Entry<String, String> entry : studentInfoJsonMap1.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();

			if (CsvMapData.containsKey(key)) {
				String value2 = CsvMapData.get(key);
				HighlightOutput1("Matched Key: ");
				System.out.println(key);
				HighlightOutput1("Value in School Admin Dashboard: ");
				System.out.println(value1);
				HighlightOutput1("Value in CSV File: ");
				System.out.println(value2);
			} else {
				String value2 = CsvMapData.get(key);
				HighlightOutput2("Mismatched Key: ");
				System.out.println(key);
				HighlightOutput2("Value in School Admin Dashboard: ");
				System.out.println(value1);
				HighlightOutput2("Value in CSV File: ");
				System.out.println(value2);
			}
		}

	}

	public void VerifyTheParentDetailsInSchoolAdminDashboardWithCSVFile() {

		System.out.println("CSV Data: " + CsvMapData);
		System.out.println("Parent Details of School Admin Dashboard: " + parentInfoJsonMap1);

		for (Map.Entry<String, String> entry : parentInfoJsonMap1.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();

			if (CsvMapData.containsKey(key)) {
				String value2 = CsvMapData.get(key);
				HighlightOutput1("Matched Key: ");
				System.out.println(key);
				HighlightOutput1("Value in School Admin Dashboard: ");
				System.out.println(value1);
				HighlightOutput1("Value in CSV File: ");
				System.out.println(value2);
			} else {
				String value2 = CsvMapData.get(key);
				HighlightOutput2("Mismatched Key: ");
				System.out.println(key);
				HighlightOutput2("Value in School Admin Dashboard: ");
				System.out.println(value1);
				HighlightOutput2("Value in CSV File: ");
				System.out.println(value2);

			}
		}

	}

	public void VerifyTheClassDetailsInSchoolAdminDashboardWithCSVFile() {

		System.out.println("CSV Data: " + CsvMapData);
		System.out.println("Class Details of School Admin Dashboard: " + classInfoJsonMap1);

		for (Map.Entry<String, String> entry : classInfoJsonMap1.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();

			if (CsvMapData.containsKey(key)) {
				String value2 = CsvMapData.get(key);
				HighlightOutput1("Matched Key: ");
				System.out.println(key);
				HighlightOutput1("Value in School Admin Dashboard: ");
				System.out.println(value1);
				HighlightOutput1("Value in CSV File: ");
				System.out.println(value2);
			} else {
				String value2 = CsvMapData.get(key);
				HighlightOutput2("Mismatched Key: ");
				System.out.println(key);
				HighlightOutput2("Value in School Admin Dashboard: ");
				System.out.println(value1);
				HighlightOutput2("Value in CSV File: ");
				System.out.println(value2);

			}
		}

	}

	public void TeacherLogin() throws InterruptedException, FileNotFoundException, IOException {

		EnterInTextbox(getMobileNumField(), getPropertyFileValue("teachermobnum"));
		explicitWaitClickable(30, getBtnSendOTP());
		clickWithRetry(getBtnSendOTP());
		Thread.sleep(30000);
		explicitWaitClickable(10, getBtnVerifyOTP());
		clickWithRetry(getBtnVerifyOTP());

	}

	public void NaviagteToTheStudentDetailsPage() throws FileNotFoundException, IOException {

		explicitWaitClickable(20, getMenubarClassManagement());
		clickWithRetry(getMenubarClassManagement());

		explicitWaitClickable(20, getMenubarStudent());
		clickWithRetry(getMenubarStudent());

		explicitWaitClickable(20, getClkStudentDetails());
		clickWithRetry(getClkStudentDetails());

		explicitWaitClickable(20, getStdDropdown());
		clickWithRetry(getStdDropdown());

		selectOptionByPartialText(driver, getStdDropdown(), standard);

		explicitWaitClickable(20, getSearchtab());
		clickWithRetry(getSearchtab());

		EnterInTextbox(getSearchtab(), NewStudentID);

		explicitWaitClickable(20, getClkStdId());
		clickWithRetry(getClkStdId());

	}

	public void VerifyStudentIDInTheTeacherDashboard() throws FileNotFoundException, IOException {
		String StdID2 = getText(getStudentId());
		Assert.assertEquals(StdID2, NewStudentID);
		HighlightOutput("Assertion Passed Student ID is " + StdID2);

	}

	public void IdentifyAndRecordTheStudentDetailsInTeacherDashboard() {

		getAttributeByJs(getStudentInfo());

		String Std_Details = getText(getStudentInfo());

		System.out.println(Std_Details);

		String[] keyValuePairs = Std_Details.split("\\n");

		studentInfoJsonMap2 = new TreeMap<>();

		// int Size = keyValuePairs.length / 2;

		// String[] arr1 = new String[Size];

		// for (int i = 0, j = 0; i < keyValuePairs.length - 1; i += 2, j++) {

		for (int i = 0; i < keyValuePairs.length - 1; i += 2) {
			String key = keyValuePairs[i];
			String value = keyValuePairs[i + 1];
			studentInfoJsonMap2.put(key, value);
			// arr1[j] = value;
		}

		// System.out.println("Array values are :" + Arrays.toString(arr1));

		JSONObject jsonObject = new JSONObject(studentInfoJsonMap2);

		String jsonString = jsonObject.toString();

		HighlightOutput("JSON String of Student Info in Teacher Dashboard: " + jsonString);

	}

	public void IdentifyAndRecordTheParentDetailsInTeacherDashboard() throws InterruptedException {

		explicitWaitClickable(20, getStudentdetailsTAB());
		clickWithRetry(getStudentdetailsTAB());

		Thread.sleep(3000);

		String textContentByJs = getTextContentByJs(getParentDetails2());
		System.out.println(textContentByJs);

		Pattern pattern = Pattern.compile("([a-zA-Z ]+) (.+)$");

		/*
		 * The square brackets [a-zA-Z ] represent a character class that includes
		 * uppercase letters (A-Z), lowercase letters (a-z), and the space character.
		 * The . represents any character And + means one or more occurrences. The $
		 * asserts the position at the end of the string.
		 */

		parentInfoJsonMap2 = new HashMap<>();

//		Split the input into lines
		String[] lines = textContentByJs.split("\n");

//		Process each line
		for (String line : lines) {
			// Matcher is used to search the pattern
			Matcher matcher = pattern.matcher(line);

			// If a match is found, extract key and value and put them in the map
			if (matcher.find()) {
				String key = matcher.group(1).trim();
				String value = matcher.group(2).trim();
				parentInfoJsonMap2.put(key, value);
			}
		}

		JSONObject jsonObject = new JSONObject(parentInfoJsonMap2);

		String jsonString = jsonObject.toString();

		HighlightOutput("JSON String of Parent Info in Teacher Dashboard: " + jsonString);

	}

	public void IdentifyAndRecordTheClassDetailsInTeacherDashboard() throws InterruptedException {

	}

	public void VerifyTheStudentDetailsInTeacherDashboardWithCSVFile() {

		System.out.println("CSV Data: " + CsvMapData);
		System.out.println("Student Details of Teacher Dashboard: " + studentInfoJsonMap2);

		for (Map.Entry<String, String> entry : studentInfoJsonMap2.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();

			if (CsvMapData.containsKey(key)) {
				String value2 = CsvMapData.get(key);
				HighlightOutput1("Matched Key: ");
				System.out.println(key);
				HighlightOutput1("Value in Teacher Dashboard: ");
				System.out.println(value1);
				HighlightOutput1("Value in CSV File: ");
				System.out.println(value2);
			} else {
				String value2 = CsvMapData.get(key);
				HighlightOutput2("Mismatched Key: ");
				System.out.println(key);
				HighlightOutput2("Value in Teacher Dashboard: ");
				System.out.println(value1);
				HighlightOutput2("Value in CSV File: ");
				System.out.println(value2);

			}
		}
	}

	public void VerifyTheParentDetailsInTeacherDashboardWithCSVFile() {
		System.out.println("CSV Data: " + CsvMapData);
		System.out.println("Parent Details of Teacher Dashboard: " + parentInfoJsonMap2);

		for (Map.Entry<String, String> entry : parentInfoJsonMap2.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();

			if (CsvMapData.containsKey(key)) {
				String value2 = CsvMapData.get(key);
				HighlightOutput1("Matched Key: ");
				System.out.println(key);
				HighlightOutput1("Value in Teacher Dashboard: ");
				System.out.println(value1);
				HighlightOutput1("Value in CSV File: ");
				System.out.println(value2);
			} else {
				String value2 = CsvMapData.get(key);
				HighlightOutput2("Mismatched Key: ");
				System.out.println(key);
				HighlightOutput2("Value in Teacher Dashboard: ");
				System.out.println(value1);
				HighlightOutput2("Value in CSV File: ");
				System.out.println(value2);

			}
		}

	}

	public void VerifyTheClassDetailsInTeacherDashboardWithCSVFile() {

	}

	public void PrincipalLogin() throws FileNotFoundException, IOException {
		explicitWaitClickable(10, getPrincipalId());
		clickWithRetry(getPrincipalId());
		EnterInTextbox(getPrincipalId(), getPropertyFileValue("principalid"));
		EnterInTextbox(getPrincipalPass(), getPropertyFileValue("principalpassword"));
		explicitWaitClickable(10, getLogin_btn());
		clickWithRetry(getLogin_btn());
	}

	public void NaviagteToTheStudentPageOfPrincipalDashboard() throws FileNotFoundException, IOException {

		explicitWaitClickable(30, getStudentPage());
		clickWithRetry(getStudentPage());

		explicitWaitClickable(30, getClassDropdown());
		clickWithRetry(getClassDropdown());

		By elementLocator1 = By.id("classes_dropdwn");
		int maxAttempts1 = 5;
		for (int attempt = 1; attempt <= maxAttempts1; attempt++) {
			try {
				WebElement element = driver.findElement(elementLocator1);
				element.click();
			} catch (Exception e) {
				System.out.println("ElementClickInterceptedException. Retrying...");
				if (attempt == maxAttempts1) {
				}
			}
		}

		selectOptionByPartialText(driver, getClassDropdown(), standard);

		// selectDdnByText(getClassDropdown(), standard);

		explicitWaitClickable(30, getSearchTab1());
		// clickWithRetry(getSearchTab1());

		By elementLocator = By.className("search__field");
		int maxAttempts = 5;
		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			try {
				WebElement element = driver.findElement(elementLocator);
				element.click();
			} catch (Exception e) {
				System.out.println("ElementClickInterceptedException. Retrying...");
				if (attempt == maxAttempts) {
				}
			}
		}

		EnterInTextbox(getSearchTab1(), NewStudentID);
		explicitWaitClickable(20, getStudentID());
		clickWithRetry(getStudentID());
	}

	public void VerifyStudentIDInThePrincipalDashboard()
			throws FileNotFoundException, IOException, InterruptedException {
		Thread.sleep(3000);
		String StdID3 = getText(getStdDetailsID());
		Assert.assertEquals(StdID3, NewStudentID);
		HighlightOutput("Assertion Passed Student ID is " + StdID3);
		// Assert.assertTrue("Assertion Failed",
		// StdID.contains(getPropertyFileValue("stdid")));

	}

	public void IdentifyAndRecordTheStudentDetailsInPrincipalDashboard() {
		// getAttributeByJs(getStudentDetails());

		String Std_Details = getText(getStudentDetails());
		System.out.println(Std_Details);

		// Regular Expression Concept (Regex)

//		Pattern Class is used to define the pattern
		Pattern pattern = Pattern.compile("([a-zA-Z ]+) (.+)$");

		/*
		 * The square brackets [a-zA-Z ] represent a character class that includes
		 * uppercase letters (A-Z), lowercase letters (a-z), and the space character.
		 * The . represents any character And + means one or more occurrences. The $
		 * asserts the position at the end of the string.
		 */

//		Create a map to store key-value pairs
		studentInfoJsonMap3 = new HashMap<>();

//		Split the input into lines
		String[] lines = Std_Details.split("\n");

//		Process each line
		for (String line : lines) {
			// Matcher is used to search the pattern
			Matcher matcher = pattern.matcher(line);

			// If a match is found, extract key and value and put them in the map
			if (matcher.find()) {
				String key = matcher.group(1).trim();
				String value = matcher.group(2).trim();
				studentInfoJsonMap3.put(key, value);
			}
		}

		JSONObject jsonObject = new JSONObject(studentInfoJsonMap3);

		String jsonString = jsonObject.toString();

		HighlightOutput("JSON String of Student Info in Principal Dashboard: " + jsonString);

	}

	public void IdentifyAndRecordTheParentDetailsInPrincipalDashboard() throws InterruptedException {

		Thread.sleep(3000);

		String textContentByJs = getTextContentByJs(getParentDetails3());
		System.out.println(textContentByJs);

		String result = textContentByJs.replaceAll("(?m)^\\s+", "").trim();

		/*
		 * "(?m)^\\s+" : is used to matches one or more leading whitespaces at the
		 * beginning of each line.
		 */

		System.out.println(result);

		String[] keyValuePairs = result.split("\n");

		parentInfoJsonMap3 = createMapFromKeyValuePairs(keyValuePairs);

		JSONObject jsonObject1 = new JSONObject(parentInfoJsonMap3);

		String jsonString = jsonObject1.toString();

		HighlightOutput("JSON String of Parent Info in Principal Dashboard: " + jsonString);

	}

	public void IdentifyAndRecordTheClassDetailsInPrincipalDashboard() throws InterruptedException {

		Thread.sleep(3000);

		String textContentByJs = getTextContentByJs(getClassDetails3());
		System.out.println(textContentByJs);

		String result = textContentByJs.replaceAll("(?m)^\\s+", "").trim();

		/*
		 * "(?m)^\\s+" : is used to matches one or more leading whitespaces at the
		 * beginning of each line.
		 */

		System.out.println(result);

		String[] keyValuePairs = result.split("\n");

		classInfoJsonMap3 = createMapFromKeyValuePairs(keyValuePairs);

		JSONObject jsonObject1 = new JSONObject(classInfoJsonMap3);

		String jsonString = jsonObject1.toString();

		HighlightOutput("JSON String of Class Info in Principal Dashboard: " + jsonString);

	}

	public void VerifyTheStudentDetailsInPrincipalDashboardWithCSVFile() {
		System.out.println("CSV Data: " + CsvMapData);
		System.out.println("Student Details of Principal Dashboard: " + studentInfoJsonMap3);

		for (Map.Entry<String, String> entry : studentInfoJsonMap3.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();

			if (CsvMapData.containsKey(key)) {
				String value2 = CsvMapData.get(key);
				HighlightOutput1("Matched Key: ");
				System.out.println(key);
				HighlightOutput1("Value in Principal Dashboard: ");
				System.out.println(value1);
				HighlightOutput1("Value in CSV File: ");
				System.out.println(value2);
			} else {
				String value2 = CsvMapData.get(key);
				HighlightOutput2("Mismatched Key: ");
				System.out.println(key);
				HighlightOutput2("Value in Principal Dashboard: ");
				System.out.println(value1);
				HighlightOutput2("Value in CSV File: ");
				System.out.println(value2);

			}
		}
	}

	public void VerifyTheParentDetailsInPrincipalDashboardWithCSVFile() {
		System.out.println("CSV Data: " + CsvMapData);
		System.out.println("Parent Details of Principal Dashboard: " + parentInfoJsonMap3);

		for (Map.Entry<String, String> entry : parentInfoJsonMap3.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();

			if (CsvMapData.containsKey(key)) {
				String value2 = CsvMapData.get(key);
				HighlightOutput1("Matched Key: ");
				System.out.println(key);
				HighlightOutput1("Value in Principal Dashboard: ");
				System.out.println(value1);
				HighlightOutput1("Value in CSV File: ");
				System.out.println(value2);
			} else {

				String value2 = CsvMapData.get(key);
				HighlightOutput2("Mismatched Key: ");
				System.out.println(key);
				HighlightOutput2("Value in Principal Dashboard: ");
				System.out.println(value1);
				HighlightOutput2("Value in CSV File: ");
				System.out.println(value2);

			}
		}
	}

	public void VerifyTheClassDetailsInPrincipalDashboardWithCSVFile() {
		System.out.println("CSV Data: " + CsvMapData);
		System.out.println("Class Details of Principal Dashboard: " + classInfoJsonMap3);

		for (Map.Entry<String, String> entry : classInfoJsonMap3.entrySet()) {
			String key = entry.getKey();
			String value1 = entry.getValue();

			if (CsvMapData.containsKey(key)) {
				String value2 = CsvMapData.get(key);
				HighlightOutput1("Matched Key: ");
				System.out.println(key);
				HighlightOutput1("Value in Principal Dashboard: ");
				System.out.println(value1);
				HighlightOutput1("Value in CSV File: ");
				System.out.println(value2);
			} else {

				String value2 = CsvMapData.get(key);
				HighlightOutput2("Mismatched Key: ");
				System.out.println(key);
				HighlightOutput2("Value in Principal Dashboard: ");
				System.out.println(value1);
				HighlightOutput2("Value in CSV File: ");
				System.out.println(value2);

			}
		}
	}

}

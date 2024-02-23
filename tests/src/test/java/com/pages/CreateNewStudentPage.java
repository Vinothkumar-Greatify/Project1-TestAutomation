package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.opencsv.CSVParser;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;

public class CreateNewStudentPage extends BaseClass {

	public CreateNewStudentPage() {
		PageFactory.initElements(driver, this);
	}

	public static String NewStudentID;
	public static String standard;
	public static Map<String, String> CsvMapData;

	// Navigate To The Create Student Profile Page

	@FindBy(id = "schoolManagementSection")
	private WebElement menubarSchoolOpearations;
	@FindBy(xpath = "//span[text()='Manage Students']")
	private WebElement manageStd;

	@FindBy(css = ".year_btn.add_student_btn")
	private WebElement addStudentBtn;

	public WebElement getAddStudentBtn() {
		return addStudentBtn;
	}

	public void setAddStudentBtn(WebElement addStudentBtn) {
		this.addStudentBtn = addStudentBtn;
	}

	public WebElement getMenubarSchoolOpearations() {
		return menubarSchoolOpearations;
	}

	public WebElement getManageStd() {
		return manageStd;
	}

	public void setMenubarSchoolOpearations(WebElement menubarSchoolOpearations) {
		this.menubarSchoolOpearations = menubarSchoolOpearations;
	}

	public void setManageStd(WebElement manageStd) {
		this.manageStd = manageStd;
	}

	// Create New Student Profile

	@FindBy(css = "#name1")
	private WebElement stdNameField;
	@FindBy(id = "add_date_pickers")
	private WebElement date_picker;
	@FindBy(css = ".student_gender")
	private WebElement stdGenderDropdown;
	@FindBy(id = "name4")
	private WebElement stdIDField;
	@FindBy(id = "name5")
	private WebElement stdRollNumField;
	@FindBy(id = "name6")
	private WebElement admissionNumField;
	@FindBy(id = "name7")
	private WebElement stdMobileNumField;

	@FindBy(id = "name8")
	private WebElement academicYearDropdown;
	@FindBy(id = "name9")
	private WebElement chooseClassDropdown;
	@FindBy(css = ".student_blood_grp_add")
	private WebElement bloodGrpDropdown;
	@FindBy(id = "name11")
	private WebElement parentIDField;
	@FindBy(id = "name12")
	private WebElement addressField;

	@FindBy(css = ".student_location_add")
	private WebElement stdLocationField;
	@FindBy(id = "name13")
	private WebElement fatherNameField;
	@FindBy(id = "name14")
	private WebElement fatherEmailField;
	@FindBy(id = "name15")
	private WebElement fatherMobileNumField;
	@FindBy(id = "name16")
	private WebElement fatherAlternateMobileNumField;
	@FindBy(id = "name17")
	private WebElement motherNameField;
	@FindBy(id = "name18")
	private WebElement motherEmailField;
	@FindBy(id = "name19")
	private WebElement motherMobileNumField;
	@FindBy(id = "name20")
	private WebElement motherAlternateMobileNumField;
	@FindBy(id = "name21")
	private WebElement fatherOccupation;
	@FindBy(id = "name22")
	private WebElement motherOccupation;
	@FindBy(id = "name23")
	private WebElement fatherAnnualIncomeField;
	@FindBy(id = "name24")
	private WebElement motherAnnualIncomeField;
	@FindBy(id = "name25")
	private WebElement emergencyContactNumField;

	@FindBy(css = "#add_student_view p:nth-child(2) > label")
	private WebElement rteRadioBtn;
	@FindBy(css = ".info_titl:nth-child(2) label > #name25")
	private WebElement previousSchoolNameField;
	@FindBy(css = ".school_board_add")
	private WebElement chooseBoardDropdown;
	@FindBy(id = "name26")
	private WebElement markObtainedField;
	@FindBy(id = "name27")
	private WebElement previousYearClsField;
	@FindBy(id = "name28")
	private WebElement previousYearPercentageField;
	@FindBy(id = "name29")
	private WebElement previousYearRepresentative;

	@FindBy(xpath = "//button[@onclick='']")
	private WebElement continueBtn;

	@FindBy(xpath = "//label[@for=\"address_proof\"]")
	private WebElement addressProffHyplink;

	@FindBy(xpath = "//label[@for=\"birth_cert\"]")
	private WebElement birthCertificateHyplink;

	@FindBy(xpath = "//label[@for=\"pass_img\"]")
	private WebElement photoImgHyplink;

	@FindBy(xpath = "//label[@for=\"aadhar_img\"]")
	private WebElement aadharImgHyplink;

	@FindBy(xpath = "//label[@for=\"domicile_cert\"]")
	private WebElement domicileCertificateHyplink;

	public WebElement getBirthCertificateHyplink() {
		return birthCertificateHyplink;
	}

	public void setBirthCertificateHyplink(WebElement birthCertificateHyplink) {
		this.birthCertificateHyplink = birthCertificateHyplink;
	}

	public WebElement getPhotoImgHyplink() {
		return photoImgHyplink;
	}

	public void setPhotoImgHyplink(WebElement photoImgHyplink) {
		this.photoImgHyplink = photoImgHyplink;
	}

	public WebElement getAadharImgHyplink() {
		return aadharImgHyplink;
	}

	public void setAadharImgHyplink(WebElement aadharImgHyplink) {
		this.aadharImgHyplink = aadharImgHyplink;
	}

	public WebElement getDomicileCertificateHyplink() {
		return domicileCertificateHyplink;
	}

	public void setDomicileCertificateHyplink(WebElement domicileCertificateHyplink) {
		this.domicileCertificateHyplink = domicileCertificateHyplink;
	}

	@FindBy(css = ".suff_btn.add_student.submit")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[@class=\"swal-button-container\"]")
	private WebElement clkOKBtn;

	public WebElement getClkOKBtn() {
		return clkOKBtn;
	}

	public void setClkOKBtn(WebElement clkOKBtn) {
		this.clkOKBtn = clkOKBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}

	public WebElement getAddressProffHyplink() {
		return addressProffHyplink;
	}

	public void setAddressProffHyplink(WebElement addressProffHyplink) {
		this.addressProffHyplink = addressProffHyplink;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public void setContinueBtn(WebElement continueBtn) {
		this.continueBtn = continueBtn;
	}

	public WebElement getRteRadioBtn() {
		return rteRadioBtn;
	}

	public void setRteRadioBtn(WebElement rteRadioBtn) {
		this.rteRadioBtn = rteRadioBtn;
	}

	public WebElement getPreviousSchoolNameField() {
		return previousSchoolNameField;
	}

	public void setPreviousSchoolNameField(WebElement previousSchoolNameField) {
		this.previousSchoolNameField = previousSchoolNameField;
	}

	public WebElement getChooseBoardDropdown() {
		return chooseBoardDropdown;
	}

	public void setChooseBoardDropdown(WebElement chooseBoardDropdown) {
		this.chooseBoardDropdown = chooseBoardDropdown;
	}

	public WebElement getMarkObtainedField() {
		return markObtainedField;
	}

	public void setMarkObtainedField(WebElement markObtainedField) {
		this.markObtainedField = markObtainedField;
	}

	public WebElement getPreviousYearClsField() {
		return previousYearClsField;
	}

	public void setPreviousYearClsField(WebElement previousYearClsField) {
		this.previousYearClsField = previousYearClsField;
	}

	public WebElement getPreviousYearPercentageField() {
		return previousYearPercentageField;
	}

	public void setPreviousYearPercentageField(WebElement previousYearPercentageField) {
		this.previousYearPercentageField = previousYearPercentageField;
	}

	public WebElement getPreviousYearRepresentative() {
		return previousYearRepresentative;
	}

	public void setPreviousYearRepresentative(WebElement previousYearRepresentative) {
		this.previousYearRepresentative = previousYearRepresentative;
	}

	public WebElement getAcademicYearDropdown() {
		return academicYearDropdown;
	}

	public void setAcademicYearDropdown(WebElement academicYearDropdown) {
		this.academicYearDropdown = academicYearDropdown;
	}

	public WebElement getChooseClassDropdown() {
		return chooseClassDropdown;
	}

	public void setChooseClassDropdown(WebElement chooseClassDropdown) {
		this.chooseClassDropdown = chooseClassDropdown;
	}

	public WebElement getBloodGrpDropdown() {
		return bloodGrpDropdown;
	}

	public void setBloodGrpDropdown(WebElement bloodGrpDropdown) {
		this.bloodGrpDropdown = bloodGrpDropdown;
	}

	public WebElement getParentIDField() {
		return parentIDField;
	}

	public void setParentIDField(WebElement parentIDField) {
		this.parentIDField = parentIDField;
	}

	public WebElement getAddressField() {
		return addressField;
	}

	public void setAddressField(WebElement addressField) {
		this.addressField = addressField;
	}

	public WebElement getStdLocationField() {
		return stdLocationField;
	}

	public void setStdLocationField(WebElement stdLocationField) {
		this.stdLocationField = stdLocationField;
	}

	public WebElement getFatherNameField() {
		return fatherNameField;
	}

	public void setFatherNameField(WebElement fatherNameField) {
		this.fatherNameField = fatherNameField;
	}

	public WebElement getFatherEmailField() {
		return fatherEmailField;
	}

	public void setFatherEmailField(WebElement fatherEmailField) {
		this.fatherEmailField = fatherEmailField;
	}

	public WebElement getFatherMobileNumField() {
		return fatherMobileNumField;
	}

	public void setFatherMobileNumField(WebElement fatherMobileNumField) {
		this.fatherMobileNumField = fatherMobileNumField;
	}

	public WebElement getFatherAlternateMobileNumField() {
		return fatherAlternateMobileNumField;
	}

	public void setFatherAlternateMobileNumField(WebElement fatherAlternateMobileNumField) {
		this.fatherAlternateMobileNumField = fatherAlternateMobileNumField;
	}

	public WebElement getMotherNameField() {
		return motherNameField;
	}

	public void setMotherNameField(WebElement motherNameField) {
		this.motherNameField = motherNameField;
	}

	public WebElement getMotherEmailField() {
		return motherEmailField;
	}

	public void setMotherEmailField(WebElement motherEmailField) {
		this.motherEmailField = motherEmailField;
	}

	public WebElement getMotherMobileNumField() {
		return motherMobileNumField;
	}

	public void setMotherMobileNumField(WebElement motherMobileNumField) {
		this.motherMobileNumField = motherMobileNumField;
	}

	public WebElement getMotherAlternateMobileNumField() {
		return motherAlternateMobileNumField;
	}

	public void setMotherAlternateMobileNumField(WebElement motherAlternateMobileNumField) {
		this.motherAlternateMobileNumField = motherAlternateMobileNumField;
	}

	public WebElement getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(WebElement fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public WebElement getMotherOccupation() {
		return motherOccupation;
	}

	public void setMotherOccupation(WebElement motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public WebElement getFatherAnnualIncomeField() {
		return fatherAnnualIncomeField;
	}

	public void setFatherAnnualIncomeField(WebElement fatherAnnualIncomeField) {
		this.fatherAnnualIncomeField = fatherAnnualIncomeField;
	}

	public WebElement getMotherAnnualIncomeField() {
		return motherAnnualIncomeField;
	}

	public void setMotherAnnualIncomeField(WebElement motherAnnualIncomeField) {
		this.motherAnnualIncomeField = motherAnnualIncomeField;
	}

	public WebElement getEmergencyContactNumField() {
		return emergencyContactNumField;
	}

	public void setEmergencyContactNumField(WebElement emergencyContactNumField) {
		this.emergencyContactNumField = emergencyContactNumField;
	}

	public WebElement getStdNameField() {
		return stdNameField;
	}

	public void setStdNameField(WebElement stdNameField) {
		this.stdNameField = stdNameField;
	}

	public WebElement getDate_picker() {
		return date_picker;
	}

	public void setDate_picker(WebElement date_picker) {
		this.date_picker = date_picker;
	}

	public WebElement getStdGenderDropdown() {
		return stdGenderDropdown;
	}

	public void setStdGenderDropdown(WebElement stdGenderDropdown) {
		this.stdGenderDropdown = stdGenderDropdown;
	}

	public WebElement getStdIDField() {
		return stdIDField;
	}

	public void setStdIDField(WebElement stdIDField) {
		this.stdIDField = stdIDField;
	}

	public WebElement getStdRollNumField() {
		return stdRollNumField;
	}

	public void setStdRollNumField(WebElement stdRollNumField) {
		this.stdRollNumField = stdRollNumField;
	}

	public WebElement getAdmissionNumField() {
		return admissionNumField;
	}

	public void setAdmissionNumField(WebElement admissionNumField) {
		this.admissionNumField = admissionNumField;
	}

	public WebElement getStdMobileNumField() {
		return stdMobileNumField;
	}

	public void setStdMobileNumField(WebElement stdMobileNumField) {
		this.stdMobileNumField = stdMobileNumField;
	}

	public void NavigateToTheCreateStudentProfilePage() {
		explicitWaitClickable(20, getMenubarSchoolOpearations());
		clickWithRetry(getMenubarSchoolOpearations());
		explicitWaitClickable(20, getManageStd());
		clickWithRetry(getManageStd());
		explicitWaitClickable(20, getAddStudentBtn());
		clickWithRetry(getAddStudentBtn());

	}

	public void CreateNewStudentProfile()
			throws IOException, AWTException, InterruptedException, CsvException {

		// Create a Scanner object to read input from the user
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the row number:");
		int rowNum = scanner.nextInt();

		// Display the entered file path
		System.out.println("You have entered " + rowNum + " as Row number");

		// Close the Scanner to prevent resource leaks
		scanner.close();

		explicitWaitClickable(20, getStdNameField());
		clickWithRetry(getStdNameField());
		String cell1 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 0);
		EnterInTextbox(getStdNameField(), cell1);
		// System.out.println(cell1);

		explicitWaitClickable(20, getDate_picker());
		clickWithRetry(getDate_picker());
		String cell2 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 1);
		EnterInTextbox(getDate_picker(), cell2);
		// System.out.println(cell2);

		explicitWaitClickable(20, getStdGenderDropdown());
		clickWithRetry(getStdGenderDropdown());
		String cell3 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 2);
		selectDdnByValue(getStdGenderDropdown(), cell3);
		// System.out.println(cell3);

		explicitWaitClickable(20, getStdIDField());
		clickWithRetry(getStdIDField());
		NewStudentID = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 3);
		EnterInTextbox(getStdIDField(), NewStudentID);
		// System.out.println(cell4);

		explicitWaitClickable(20, getStdRollNumField());
		clickWithRetry(getStdRollNumField());
		String cell5 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 4);
		EnterInTextbox(getStdRollNumField(), cell5);
		// System.out.println(cell5);

		explicitWaitClickable(20, getAdmissionNumField());
		clickWithRetry(getAdmissionNumField());
		String cell6 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 5);
		EnterInTextbox(getAdmissionNumField(), cell6);
		// System.out.println(cell6);

		explicitWaitClickable(20, getStdMobileNumField());
		clickWithRetry(getStdMobileNumField());
		String cell7 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 6);
		EnterInTextbox(getStdMobileNumField(), cell7);
		// System.out.println(cell7);

		explicitWaitClickable(20, getAcademicYearDropdown());
		clickWithRetry(getAcademicYearDropdown());
		String cell8 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 7);
		selectDdnByText(getAcademicYearDropdown(), cell8);
		// selectDdnByValue(getAcademicYearDropdown(), cell8);
		// System.out.println(cell8);

		explicitWaitClickable(20, getChooseClassDropdown());
		getChooseClassDropdown().click();
		clickWithRetry(getChooseClassDropdown());
		String text1 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 8);
		standard = SplitAndMergeString(text1);
		selectDdnByText(getChooseClassDropdown(), text1);
		// selectDdnByValue(getChooseClassDropdown(), cell9);
		// System.out.println(cell9);

		explicitWaitClickable(20, getBloodGrpDropdown());
		clickWithRetry(getBloodGrpDropdown());
		String cell10 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 9);
		selectDdnByValue(getBloodGrpDropdown(), cell10);
		// System.out.println(cell10);

		explicitWaitClickable(20, getParentIDField());
		clickWithRetry(getParentIDField());
		String cell11 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 10);
		EnterInTextbox(getParentIDField(), cell11);
		// System.out.println(cell11);

		explicitWaitClickable(20, getAddressField());
		clickWithRetry(getAddressField());
		String cell12 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 11);
		EnterInTextbox(getAddressField(), cell12);
		// System.out.println(cell12);

		explicitWaitClickable(20, getStdLocationField());
		clickWithRetry(getStdLocationField());
		String cell13 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 12);
		EnterInTextbox(getStdLocationField(), cell13);
		// System.out.println(cell13);

		explicitWaitClickable(20, getFatherNameField());
		clickWithRetry(getFatherNameField());
		String cell14 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 13);
		EnterInTextbox(getFatherNameField(), cell14);
		// System.out.println(cell14);

		explicitWaitClickable(20, getFatherEmailField());
		clickWithRetry(getFatherEmailField());
		String cell15 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 14);
		EnterInTextbox(getFatherEmailField(), cell15);
		// System.out.println(cell15);

		explicitWaitClickable(20, getFatherMobileNumField());
		clickWithRetry(getFatherMobileNumField());
		String cell16 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 15);
		EnterInTextbox(getFatherMobileNumField(), cell16);
		// System.out.println(cell16);

		explicitWaitClickable(20, getFatherAlternateMobileNumField());
		clickWithRetry(getFatherAlternateMobileNumField());
		String cell17 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 16);
		EnterInTextbox(getFatherAlternateMobileNumField(), cell17);
		// System.out.println(cell17);

		explicitWaitClickable(20, getMotherNameField());
		clickWithRetry(getMotherNameField());
		String cell18 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 17);
		EnterInTextbox(getMotherNameField(), cell18);
		// System.out.println(cell18);

		explicitWaitClickable(20, getMotherEmailField());
		clickWithRetry(getMotherEmailField());
		String cell19 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 18);
		EnterInTextbox(getMotherEmailField(), cell19);
		// System.out.println(cell19);

		explicitWaitClickable(20, getMotherMobileNumField());
		clickWithRetry(getMotherMobileNumField());
		String cell20 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 19);
		EnterInTextbox(getMotherMobileNumField(), cell20);
		// System.out.println(cell20);

		explicitWaitClickable(20, getMotherAlternateMobileNumField());
		clickWithRetry(getMotherAlternateMobileNumField());
		String cell21 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 20);
		EnterInTextbox(getMotherAlternateMobileNumField(), cell21);
		// System.out.println(cell21);

		explicitWaitClickable(20, getFatherOccupation());
		clickWithRetry(getFatherOccupation());
		String cell22 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 21);
		EnterInTextbox(getFatherOccupation(), cell22);
		// System.out.println(cell22);

		explicitWaitClickable(20, getMotherOccupation());
		clickWithRetry(getMotherOccupation());
		String cell23 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 22);
		EnterInTextbox(getMotherOccupation(), cell23);
		// System.out.println(cell23);

		explicitWaitClickable(20, getFatherAnnualIncomeField());
		clickWithRetry(getFatherAnnualIncomeField());
		String cell24 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 23);
		EnterInTextbox(getFatherAnnualIncomeField(), cell24);
		// System.out.println(cell24);

		explicitWaitClickable(20, getMotherAnnualIncomeField());
		clickWithRetry(getMotherAnnualIncomeField());
		String cell25 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 24);
		EnterInTextbox(getMotherAnnualIncomeField(), cell25);
		// System.out.println(cell25);

		explicitWaitClickable(20, getEmergencyContactNumField());
		clickWithRetry(getEmergencyContactNumField());
		String cell26 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 25);
		EnterInTextbox(getEmergencyContactNumField(), cell26);
		// System.out.println(cell26);

		explicitWaitClickable(20, getRteRadioBtn());
		clickWithRetry(getRteRadioBtn());

		explicitWaitClickable(20, getPreviousSchoolNameField());
		clickWithRetry(getPreviousSchoolNameField());
		String cell27 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 26);
		EnterInTextbox(getPreviousSchoolNameField(), cell27);
		// System.out.println(cell27);

		explicitWaitClickable(20, getChooseBoardDropdown());
		clickWithRetry(getChooseBoardDropdown());
		String cell28 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 27);
		selectDdnByValue(getChooseBoardDropdown(), cell28);
		// EnterInTextbox(getStdMobileNumField(), cell7);
		// System.out.println(cell28);

		explicitWaitClickable(20, getMarkObtainedField());
		clickWithRetry(getMarkObtainedField());
		String cell29 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 28);
		EnterInTextbox(getMarkObtainedField(), cell29);
		// System.out.println(cell29);

		explicitWaitClickable(20, getPreviousYearClsField());
		clickWithRetry(getPreviousYearClsField());
		String cell30 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 29);
		EnterInTextbox(getPreviousYearClsField(), cell30);
		// System.out.println(cell30);

		explicitWaitClickable(20, getPreviousYearPercentageField());
		clickWithRetry(getPreviousYearPercentageField());
		String cell31 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 30);
		EnterInTextbox(getPreviousYearPercentageField(), cell31);
		// System.out.println(cell31);

		explicitWaitClickable(20, getPreviousYearRepresentative());
		clickWithRetry(getPreviousYearRepresentative());
		String cell32 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 31);
		EnterInTextbox(getPreviousYearRepresentative(), cell32);
		// System.out.println(cell32);

		explicitWaitClickable(20, getContinueBtn());
		clickWithRetry(getContinueBtn());

		explicitWaitClickable(20, getAddressProffHyplink());
		clickWithRetry(getAddressProffHyplink());
		String cell33 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 32);
		System.out.println(cell33);

		Robot robot = new Robot();

		robot.delay(1000);

		command_TabRobot(robot);
		robot.delay(500);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection = new StringSelection(cell33);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		explicitWaitClickable(20, getBirthCertificateHyplink());
		clickWithRetry(getBirthCertificateHyplink());
		String cell34 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 33);
		System.out.println(cell34);

		robot.delay(500);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection1 = new StringSelection(cell34);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		explicitWaitClickable(20, getPhotoImgHyplink());
		clickWithRetry(getPhotoImgHyplink());
		String cell35 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 34);
		System.out.println(cell35);

		robot.delay(500);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection2 = new StringSelection(cell35);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		explicitWaitClickable(20, getAadharImgHyplink());
		clickWithRetry(getAadharImgHyplink());
		String cell36 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 35);
		System.out.println(cell36);

		robot.delay(500);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection3 = new StringSelection(cell36);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection3, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		explicitWaitClickable(20, getDomicileCertificateHyplink());
		clickWithRetry(getDomicileCertificateHyplink());
		String cell37 = readSpecificCell(getPropertyFileValue("StdDataCSV"), rowNum, 36);
		System.out.println(cell37);

		robot.delay(500);

		openSearchTabRobot(robot);
		robot.delay(500);

		StringSelection stringSelection4 = new StringSelection(cell37);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection4, null);

		pasteTextRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		robot.delay(500);

		EnterRobot(robot);

		Thread.sleep(3000);

		explicitWaitClickable(20, getSubmitBtn());
		clickWithRetry(getSubmitBtn());

		explicitWaitClickable(20, getClkOKBtn());
		clickWithRetry(getClkOKBtn());

		Thread.sleep(3000);

		try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(
				new FileReader(getPropertyFileValue("StdDataCSV")))) {

			reader.skip(rowNum - 1);
			CsvMapData = reader.readMap();

			System.out.println(CsvMapData);

			// CsvMapData = convertCsvToMap(getPropertyFileValue("StdDataCSV"), rowNum);

			// System.out.println("CSV Data: " + CsvMapData);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

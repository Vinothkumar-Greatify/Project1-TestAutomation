package com.pagemanager;

import com.pages.CreateNewStudentPage;
import com.pages.FeeManagementPage;
import com.pages.SchoolAdminOnboardPage;
import com.pages.StudentInformationPage;
import com.pages.TimetableConfigurationPage;

public class PageObjectManager {

	private StudentInformationPage studentInformationPage;

	public StudentInformationPage getStudentInformationPage() {
		return (studentInformationPage == null) ? studentInformationPage = new StudentInformationPage()
				: studentInformationPage;
	}

	private CreateNewStudentPage createNewStudentPage;

	public CreateNewStudentPage getCreateNewStudentPage() {
		return (createNewStudentPage == null) ? createNewStudentPage = new CreateNewStudentPage()
				: createNewStudentPage;
	}

	private SchoolAdminOnboardPage schoolAdminOnboardPage;

	public SchoolAdminOnboardPage getSchoolAdminOnboardPage() {
		return (schoolAdminOnboardPage == null) ? schoolAdminOnboardPage = new SchoolAdminOnboardPage()
				: schoolAdminOnboardPage;
	}

	private TimetableConfigurationPage timetableConfigurationPage;

	public TimetableConfigurationPage getTimetableConfigurationPage() {
		return (timetableConfigurationPage == null) ? timetableConfigurationPage = new TimetableConfigurationPage()
				: timetableConfigurationPage;
	}

	private FeeManagementPage feeManagementPage;

	public FeeManagementPage getFeeManagementPage() {
		return (feeManagementPage == null) ? feeManagementPage = new FeeManagementPage() : feeManagementPage;
	}

}

@TimetableConfiguration
Feature: Timetable generation for all the classes in the newly onboarded school

  Background: 
    Given the user is logged into the School Admin Dashboard

  Scenario: School Admin generates the timetable for all the classes in the newly onboarded school
    When the user configures subject hours in the "Subject Mapping" page
    And the user configures holiday information for the academic year in the "Manage Calendar" page
    And the user navigates to the "Manage Timetable" page in the School Admin Dashboard
    And the user enters all the required credentials for creating the timetable
    And the user configures and publishes the timetable
    Then the user verifies the successful popup message

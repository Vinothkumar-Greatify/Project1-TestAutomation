@StudentInformation
Feature: Verify Student Details, Parent Details, Class Details in Dashboards with CSV File

  Background: 
    Given the user is logged into the school admin dashboard
    And the user is logged into the teacher dashboard
    And the user is logged into the principal dashboard

  Scenario: Verify Student Information in Dashboards with CSV File
    When the user navigates to the create student profile page in the School Admin Dashboard
    And the user creates a new student profile in the School Admin Dashboard
    When the user navigates to the Student Management of School Admin Dashboard
    Then the user verifies Student ID with Student Id in the CSV File
    And the user identifies and records the Student Details in School Admin Dashboard
    And the user identifies and records the Parent Details in School Admin Dashboard
    And the user identifies and records the Class Details in School Admin Dashboard
    Then the user should verify the Student Details in School Admin Dashboard with CSV File
    And the user should verify the Parent Details in School Admin Dashboard with CSV File
    And the user should verify the Class Details in School Admin Dashboard with CSV File
    When the user navigates to the Student Details page in the Teacher Dashboard
    Then the user verifies Student ID in the Teacher Dashboard with Student Id in the CSV File
    And the user identifies and records the student details in Teacher Dashboard
    And the user identifies and records the Parent Details in Teacher Dashboard
    And the user identifies and records the Class Details in Teacher Dashboard
    Then the user should verify the Student Details in Teacher Dashboard with CSV File
    And the user should verify the Parent Details in Teacher Dashboard with CSV File
    And the user should verify the Class Details in Teacher Dashboard with CSV File
    When the user navigates to the Student Page of Principal Dashboard
    Then the user verifies Student ID in the Principal Dashboard with Student Id in the CSV File
    And the user identifies and records the student details in Principal Dashboard
    And the user identifies and records the Parent Details in Principal Dashboard
    And the user identifies and records the Class Details in Principal Dashboard
    Then the user should verify the Student Details in Principal Dashboard with CSV File
    And the user should verify the Parent Details in Principal Dashboard with CSV File
    And the user should verify the Class Details in Principal Dashboard with CSV File

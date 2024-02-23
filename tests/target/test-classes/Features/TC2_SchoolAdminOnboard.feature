@SchoolOnboard
Feature: Generate a new school invite from Super Admin Dashboard. Onboard the new school and log in to School Admin Dashboard.

  Scenario: Invite a new school, onboard the school, and log in to the School Admin Dashboard.
    Given the user is logged into the Super Admin Dashboard
    When the user navigates to the "Manage Schools" page in the Super Admin Dashboard
    And the user generates a new School Profile invite from the Super Admin Dashboard
    Then the user should verify the "Success" popup message in the Super Admin Dashboard.
    Then the user fetch "username" and "password" from Mailosaur portal 
    And the user logs in to the School Admin Dashboard using the mailed credentials
    Then the user should verify the School Admin Mail-ID on the Onboard page.
    And the user onboards the school using the corresponding CSV file
    Then the user should verify the "Successfully" popup message in the School Admin Dashboard.

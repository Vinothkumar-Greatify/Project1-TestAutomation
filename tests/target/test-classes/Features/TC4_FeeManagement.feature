@FeeManage
Feature: Manage School Fees, Add-On Fees, and Fee Discounts for newly Onboarded School

  Background: 
    Given the user is logged into the School Admin Dashboard

  Scenario: Manage School Fees, Add-On Fees, Fee Discounts
    When the user creates new School Fees
    Then the user should see the created School Fees
    And the user publish the School fees
    When the user creates new Add-On Fees
    Then the user should see the created Add-On Fees
    When the user creates new Fee Discount
    Then the user should see the created Fee Discount
    When the user updates the School Fees
    Then the user should see the updated School Fees
    When the user updates the Add-On Fees
    Then the user should see the updated Add-On Fees
    When the user updates the Fee Discount
    Then the user should see the updated Fee Discount
    When the user deletes the Fee Discount
    Then the user should verify that the Fee Discount is deleted
    When the user deletes the Add-On Fees
    Then the user should verify that the Add-On Fee is deleted
    When the user deletes the School Fees
    Then the user should verify that the School Fees are deleted

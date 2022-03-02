@logout
Feature: Logout functionality

  Scenario: The user should be able to logout
    Given the user logged in a sales manager_sb
    When the user click on user menu_sb
    And click on logout button_sb
    Then the user should be land on login page_sb
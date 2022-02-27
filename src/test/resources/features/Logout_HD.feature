@hd
Feature: Logout functionality_HD

  Scenario: User should be able to logout_HD
    Given the user is logged in_HD
    When the user clicks on the user topbar_HD
    Then the Log out option appears in the drop-down menu_HD
    When the user clicks on Log out option_HD
    Then the user logouts and lands on the login page_HD
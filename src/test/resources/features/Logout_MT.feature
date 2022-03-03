@logout
Feature: User should be able to logout_MT

  Scenario: Login as a valid user_MT
    Given the user is on the login page_MT
    And the user enters the valid "posmanager" information_MT
    When the user click on actual user name_MT
    And the user click on logout_MT
    Then the user should able to logout_MT
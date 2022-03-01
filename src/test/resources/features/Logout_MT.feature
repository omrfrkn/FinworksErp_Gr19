@logout
Feature: User should be able to logout_MT

  Background:
    Given the user is on the login page_MT

@wip
  Scenario: Login as a valid user_MT
    When the user enters the valid "posmanager" information_MT
    Then the user should able to logout_MT
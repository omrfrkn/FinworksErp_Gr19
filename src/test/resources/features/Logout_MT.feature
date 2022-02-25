@logout
Feature: User should be able to logout

  Background:
    Given the user is on the login page

@wip
  Scenario: Login as a valid user
    When the user enters the valid "posmanager" information
    Then the user should able to logout
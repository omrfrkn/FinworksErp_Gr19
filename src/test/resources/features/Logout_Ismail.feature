@logout
Feature: User should be able to logout

  Background:
    Given the user is on the login page


  Scenario: User should be able to logout
    When the user click user menu
    Then the user should able to logout
@login
Feature: Users Logout Feature

  Scenario: The user should be able to logout_KT
    Given the user is on the login page_KT
    And the user enters "posmanager10@info.com" and "posmanager"_KT
    Then the user should be able to see own name as a "POSManager10"_KT
    And the user should be able to logout and title as a "Login | Best solution for startups"_KT
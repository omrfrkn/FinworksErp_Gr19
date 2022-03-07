@logout
Feature: FinworksErp Logout Feature

  Scenario: the user should be able to logout
    Given the user is on the login page_YB
    When the user logs in with "posmanager116@info.com" and "posmanager"_YB
    And  the user clicks own username on the top bar_YB
    And  the user clicks on Log out option_YB
    Then the user should see the title "Login | Best solution for startups"_YB

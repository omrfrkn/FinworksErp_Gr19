@logout @smoke
Feature:Logout Functionality

  Scenario: User can logout
    Given the user is on the login page_US
    And the user logged in_US
    When the user click user menu_US
    And the user click logout button_US
    Then the user should see page title as "Login | Best solution for startups"_US
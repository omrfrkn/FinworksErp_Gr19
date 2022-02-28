@logout @smoke
Feature:Logout Functionality

  Scenario: User can logout
    Given the user is on the login page
    And the user logged in
    When the user click user menu
    And the user click logout button
    Then the user should see page title as "Login | Best solution for startups"

Feature: FinworksErp Logout Scenarios

  Scenario Outline: User should be able to logout

    Given User is logged in using following "<email>" and "<password>"
    When User clicks username right side on the topbar
    And User clicks Log out in the user drop down menu
    Then User is redirected login page and title should be  "Login | Best solution for startups"

    Examples:
      | email                      | password         |
      | posmanager116@info.com     | posmanager       |
      | salesmanager16@info.com    | salesmanager     |
      | imm116@info.com            | inventorymanager |
      | expensesmanager16@info.com | expensesmanager  |
      | manuf_user16@info.com      | manufuser        |

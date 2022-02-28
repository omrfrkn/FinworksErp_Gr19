
Feature: FinworksErp Logout Scenarios_tarik

  Scenario Outline: User should be able to logout_tarik

    Given User is logged in using following "<email>" and "<password>"_tarik
    When User clicks username right side on the topbar_tarik
    And User clicks Log out in the user drop down menu_tarik
    Then User is redirected login page and title should be  "Login | Best solution for startups"_tarik

    Examples:
      | email                      | password         |
      | posmanager116@info.com     | posmanager       |
      | salesmanager16@info.com    | salesmanager     |
      | imm116@info.com            | inventorymanager |
      | expensesmanager16@info.com | expensesmanager  |
      | manuf_user16@info.com      | manufuser        |

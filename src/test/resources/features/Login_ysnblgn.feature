@login
Feature: FinworksErp Login Feature

  Scenario: the user should be able to login with valid credentials
    Given the user logged in
    Then the user should see the title "#Inbox - Odoo"
    And the user should see own username as "POSManager116"

  Scenario Outline: the user should NOT be able to login with invalid credentials
    Given the user logged in "<username>" and "<password>"
    Then "Wrong login/password" error message should appear

    Examples:
      | username              | password   |
      | wrong                 | wrong      |
      | posmanager10@info.com | wrong      |
      | wrong                 | posmanager |

  Scenario Outline: the user should NOT be able to login with empty credentials
    Given the user logged in "<username>" and "<password>"
    Then "Please fill out this field." warning message should appear

    Examples:
      | username | password |
      |          | wrong    |
      | wrong    |          |
      |          |          |
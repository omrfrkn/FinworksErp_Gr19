
Feature: FinworksErp Login Scenarios

  Scenario Outline:User should be able to login with valid credentials
    When User enters valid "<email>" and "<password>"
    Then User should see page title "#Inbox - Odoo"
    Examples:
      | email                      | password         |
      | posmanager116@info.com     | posmanager       |
      | salesmanager16@info.com    | salesmanager     |
      | imm116@info.com            | inventorymanager |
      | expensesmanager16@info.com | expensesmanager  |
      | manuf_user16@info.com      | manufuser        |

  Scenario Outline: User can not login with invalid credentials
    When User enters invalid "<email>" and "<password>"
    Then User should see "Wrong login/password" warning message

    Examples:
      | email                 | password      |
      | posmanager10@info.com | wrongPassword |
      | wrongMail             | posmanager    |
      | wrongMail             | wrongPassword |

  Scenario Outline: User can not login when email field or password field are blank
    When User does not enter "<email>" or "<password>"
    Then User should see "Please fill out this field." error message

    Examples:
      | email                 | password   |
      | posmanager10@info.com |            |
      |                       | posmanager |
      |                       |            |
@smoke
Feature: FinworksErp Login Scenarios_tarik

  Scenario Outline:User should be able to login with valid credentials_tarik
    When User enters valid "<email>" and "<password>"_tarik
    Then User should see page title "#Inbox - Odoo"_tarik
    Examples:
      | email                      | password         |
      | posmanager116@info.com     | posmanager       |
      | salesmanager16@info.com    | salesmanager     |
      | imm116@info.com            | inventorymanager |
      | expensesmanager16@info.com | expensesmanager  |
      | manuf_user16@info.com      | manufuser        |

  Scenario Outline: User can not login with invalid credentials_tarik
    When User enters invalid "<email>" and "<password>"_tarik
    Then User should see "Wrong login/password" warning message_tarik

    Examples:
      | email                 | password      |
      | posmanager10@info.com | wrongPassword |
      | wrongMail             | posmanager    |
      | wrongMail             | wrongPassword |

  Scenario Outline: User can not login when email field or password field are blank_tarik
    When User does not enter "<email>" or "<password>"_tarik
    Then User should see "Please fill out this field." error message_tarik

    Examples:
      | email                 | password   |
      | posmanager10@info.com |            |
      |                       | posmanager |
      |                       |            |
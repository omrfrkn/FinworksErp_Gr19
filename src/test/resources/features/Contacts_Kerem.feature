@contact
Feature: FinWorksErp ContactsModule_KT

  Background:
    Given the user is on the "Contacts" page_KT


  Scenario Outline: User should be able create new contacts_KT
    When the user clicks the Create button_KT
    And the user writes Contact's name as "<Contacts Name>"_KT
    And the user writes first address as a "Sırınevler Mah"_KT
    And the user writes city as "Nazilli"_KT
    When the user clicks the dropdown button for country_KT
    And the user select country "<Country>"_KT
    Then the user sees the "<Country>" selected in the options_KT
    When the user clicks the Save button_KT
    Then the title contains "<Contacts Name>"_KT
    Examples:
      | Contacts Name    |  | Country     |
      | Cybertek Group19 |  | Afghanistan |


  Scenario Outline: User should be able to edit existing Contact_KT
    When the user clicks the Search button_KT
    And the user writes "<Contacts Name>" in the search button_KT
    Then the "<Contacts Name>" contact visible for existing_KT
    When the user clicks existing contacts "<Contacts Name>"_KT
    Then the title contains "<Contacts Name>"_KT
    When the user clicks the edit button_KT
    And the user changes Contact's name as "<New Contacts Name>"_KT
    And the user changes to first address as a "Şirinevler Mah 857 sok"_KT
    And the user changes city as "Naz Naz Nazilli"_KT
    When the user clicks the dropdown button for country_KT
    And the user changes country "<New Country>"_KT
    Then the user sees the "<New Country>" selected in the options_KT
    When the user clicks the Save button_KT
    Then the title contains "<New Contacts Name>"_KT
    Examples:
      | Contacts Name    |  | New Contacts Name |  | New Country |
      | Cybertek Group19 |  | Cydeo Group19     |  | Turkey      |


  Scenario Outline: The user should be able to find contact by using search function_KT
    When the user clicks the Search button_KT
    And the user writes "<New Contacts Name>" in the search button_KT
    Then the "<New Contacts Name>" note visible for existing_KT
    Examples:
      | New Contacts Name |
      | Cydeo Group19     |


  Scenario Outline: The user should be able to delete an existing contacts_KT
    When the user clicks the Search button_KT
    And the user writes "<New Contacts Name>" in the search button_KT
    When the user clicks existing contacts "<New Contacts Name>"_KT
    And the user clicks the Action and "Delete" button_KT
    Then Confirmation pop-up_KT
    When the user clicks OK button_KT
    Then the contact is deleted "<New Contacts Name>"_KT
    Examples:
      | New Contacts Name |
      | Cydeo Group19     |






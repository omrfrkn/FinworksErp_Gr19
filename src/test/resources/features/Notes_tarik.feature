@smoke
Feature:FinworkErp Notes Module Scenarios

  Background:
    Given User should be able to log in application_tarik
    And User should be able to navigate "Notes" module_tarik


  Scenario:User should be able to create a new note_tarik
    When User clicks create button_tarik
    And User enter note as "Demo Meeting at 14:00 pm "_tarik
    When User clicks save button_tarik
    Then User should be able to see page title as "Demo Meeting at 14:00 pm - Odoo"_tarik


  Scenario:User should be able to edit existing notes_tarik
    When User clicks on the note which want to edit_tarik
    And User enter note as "(editted)"_tarik
    When User clicks save button_tarik
    Then User should be able to see page title as "Demo Meeting at 14:00 pm (editted) - Odoo"_tarik


  Scenario: User should be able to find notes by using search function_tarik
    When User writes key word "Demo"  in the search box and presses enter_tarik
    Then User should only see notes about to key word on the page and notes should contains "Demo"_tarik


  Scenario: User should be able to delete existing notes_tarik
    When User hover over the note to delete_tarik
    And User clicks three vertical dot icon and drop-down menu is displayed_tarik
    And User clicks delete button and confirmation pop-up menu is opened_tarik
    Then User clicks Ok button on the confirmation pop-up_tarik

    Scenario: User should be able to change the note stage name
      When User clicks gear icon between stage name and plus sign_tarik
      And User clicks Edit Stage button on the dropdown menu_tarik
      And User writes "Yesterday" in the stage name input box_tarik
      And User clicks Save button_tarik
      Then User should see new stage name as "Yesterday"_tarik



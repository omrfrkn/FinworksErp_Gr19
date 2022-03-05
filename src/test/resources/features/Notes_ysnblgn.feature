@notes
Feature: FinworksErp Notes_Module

  Background:
    Given the user navigates to "Notes" page_YB

  Scenario: the user should be able to create a new note
    When the user clicks on "Create" button_YB
    And the user writes a note as "Lorem ipsum" in the panel textbox_YB
    And the user clicks on "Save" button_YB
    Then the user should see the title "Lorem ipsum - Odoo"_YB

  Scenario: the user should be able to edit an existing note
    When the user clicks on an existing note_YB
    And the user clicks on "Edit" button_YB
    And the user writes a note as "EDITED Lorem ipsum" in the panel textbox_YB
    And the user clicks on "Save" button_YB
    Then the user should see the title "EDITED Lorem ipsum - Odoo"_YB

  Scenario: the user should be able to find note by using search box
    When the user enters a note summary as "EDITED Lorem ipsum" in the search box_YB
    Then the user should see note summary as "EDITED Lorem ipsum" in the web table_YB

  Scenario: the user should be able to delete an existing note
    When the user selects an existing note's checkbox_YB
    And the user clicks on Delete button_YB
    And the user clicks on Ok button on the pop up_YB
    Then the user should not see deleted note in the web table_YB

  Scenario: the user should be able to change the note stage
    When the user moves an existing note to "Today" stage_YB
    Then the user should see that note's stage name changed as "Today"_YB
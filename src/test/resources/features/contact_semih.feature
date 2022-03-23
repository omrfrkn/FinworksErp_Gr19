
@wip
  Feature: Contact module

    Background:
    Given the user should be logged in as a "posmanager10@info.com" with password "posmanager"_sb
      And the user navigated to contact page_sb

    Scenario:The user should be able create new contact_sb
      When the user clicks on create button_sb
      And  the user enter contact name as "user1"_sb
      And the user enter contact info_sb
      And the user click on save button_sb
      Then the page title should have company name and contact name_sb

      Scenario: The user should be able find the contact by searching
        When the user enter contact name as "user1" in the search box_sb
        And  the user hits the enter_sb
        Then user1 should appear on the page_sb

        Scenario: The user should be able to edit an existing contact
          When the user enter contact name as "user1" in the search box_sb
          And the user hits the enter_sb
          And the user clicks on contact_sb
          And the user clicks on edit button_sb
          And the user change the user name as "user2"_sb
          And the user hits the save button_sb
          Then user name should be changed as "user2"_sb




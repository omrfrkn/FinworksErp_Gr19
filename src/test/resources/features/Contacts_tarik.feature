@smoke
  Feature: Contacts Module Scenarios
    Background:
      Given User should be able to log in application_tarik
      And User should be able to navigate "Contacts" module_tarik

    Scenario:User should be able to create a new contact_tarik
      When User clicks create button_tarik
      And User enters contact name as "New Contact by Tarik" in the name box_tarik
      And User clicks save button_tarik
      Then User should see "New Contact by Tarik" near the avatar_tarik

    Scenario:User should be able to edit existing contact_tarik
      When User enters contact name as "New Contact by Tarik" in the search box and presses enter_tarik
      And User clicks on contact which is title "New Contact by Tarik" _tarik
      And User clicks Edit button_tarik
      And User enters contact name as "Editted Contact by Tarik" in the name box_tarik
      And User clicks save button_tarik
      Then User should see "Editted Contact by Tarik" near the avatar_tarik
Feature: Used Cars listing verification

  @trademe_page
  Scenario: Check there is at least one listing in the TradeMe UsedCars category.
    Given User navigates to TradeMe SandBox Page
    When User go to used car page
    Then User checks there is at least one listing in the UsedCars category

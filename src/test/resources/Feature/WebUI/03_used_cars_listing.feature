Feature: Verify listed car details

  @trademe_page
  Scenario: Check any existing Used Car listing and confirm that the details are shown
    Given User navigates to TradeMe SandBox Page
    When User go to used car page
    And Click any used car listing
    Then User checks the car details "Number plate,Kilometres,Body,Seats,Fuel type,Engine,Transmission,History,Registration expires,WoF expires,Model detail"
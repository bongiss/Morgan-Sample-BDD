Feature: Search specific Car listing verification

  @trademe_page
  Scenario: Check if there is car listing for KIA
    Given User navigates to TradeMe SandBox Page
    When User search for car "KIA"
    Then User verify there is at least one listing

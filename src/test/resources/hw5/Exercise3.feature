Feature: Vip checkbox

  Scenario: Vip checkbox test

    Given I open Main page of JDI Github site
    And I login as user Roman Iovlev
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    When I select vip checkbox for Sergey Ivan
    Then One log row has "Vip: condition changed to true" text in log section
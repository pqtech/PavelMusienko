Feature: Different Elements page
  In order to check page elements
  As a logged user
  I want to click elements and check their logs

  Scenario: Display logs for actions on page elements
    Given I open Main page of JDI Github site
    Then Browser title is equal to 'Home Page'
    Given I login as user Roman Iovlev
    Then Correct username 'ROMAN IOVLEV' is shown on the Main Page
    Given I click on "Service" in Header on the Main Page
    And I select "Different Elements" in dropdown menu on the Main page
    When I click on Water checkbox on the Different Elements page
    And I click on Wind checkbox on the Different Elements page
    And I click on "Selen" radio button on the Different Elements page
    And I select "Yellow" in the color dropdown menu on the Different Elements page
    Then Correct Water checkbox log is shown in the logs area
    And Correct Wind checkbox log is shown in the logs area
    And Correct "Selen" radio button log is shown in the logs area
    And Correct dropdown menu log for "Yellow" color is shown in the logs area

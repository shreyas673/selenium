Feature: Login into URL

  Scenario Outline: Positive Scenario
    Given I navigate to URL
    When I enter "<email>" and "<password>"
    And I click on login button

    Examples:
      | email                       |password |
      | samdamoo1968@gmail.com      |Sam@1999 |
Feature: Verify Copyright Text on UC Auction Website

@verify
  Scenario: Verify the copyright text on the UC Auction homepage
    Given I open the browser
    When I navigate to the URL 
    And I wait for 2 seconds
    And I click close on the image on the homepage
    And I click on the copyright text on the homepage
    Then I should see the text Copyright © 2022 UC auction - All rights reserved


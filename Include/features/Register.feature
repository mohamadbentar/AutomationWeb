@register_all_scenario
Feature: User Registration at UC Auction

	@register_without_npwp
  Scenario: New user registration is successful without NPWP
		Given  user is on the UC Auction registration page without npwp
    When  user fills in a personal data form without npwp
    And  user fills in the payment data form without npwp
    Then  user sees the message New data successfully added without npwp
    
   @register_with_npwp
   Scenario: New user registration is successful with npwp
    Given  user is on the UC Auction registration page there is npwp
    When  user fills in the personal data form with npwp
    And  user fills in the payment data form with npwp
    Then  user sees the message New data successfully added with npwp
    
   @register_with_nik
   Scenario: New user registration is successful with nik
    Given user is on the UC Auction registration page with nik 
    When  user fills in the personal data form with nik
    And  user fills in the payment data form with nik
    Then  user sees the message New data successfully added with nik
    

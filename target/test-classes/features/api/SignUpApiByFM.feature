Feature: DuoBank SignUp Page New User End to End Test Scenarios
  Background:
    Given I Set New User API Service Endpoint

  Scenario: Positive Test With Valid Input
    When I POST New User Positive Testing
    Then Positive Check Response Status Code Should Be 201

  Scenario: Negative Test With Valid Input That Attempt Illegal Operations
    When I POST Negative New User Testing
    Then The Negative Check Response Status Code Should Be 422


  Scenario: Duplicate User Registration Verification
    When I POST same user credentials to verify if duplicate user registrations are allowed
    Then The Negative check response for duplicate user code should be 422
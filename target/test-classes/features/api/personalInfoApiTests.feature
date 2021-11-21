Feature: API tests for Personal Info Page
  Background:
    Given I set user service api endpoint


# Testing an account with with saved data
  Scenario: Personal Info Page GET application list
    Given I am an authorized user
    When I send a GET request to current personal information application
    Then I GET the status code result should be 200

#  Testing an account with no saved data
  Scenario: Personal Info Page GET application list account with no saved data
    When I send a GET request to current personal information application account with no saved data
    Then The response status code should be 200

#   Testing POST mortagagedetails endpoint in isolation
    Scenario: Test POST mortagagedetails in isolation
      Given I add the following payload for the personal info page
        | b_firstName | b_lastName | b_email              | b_ssn       | b_martial | b_cell       |
        | kyle        | tomas      | kyle.tomas@gmail.com | 111-22-1234 | Married   | 201-909-2121 |
      When I send a POST request to "/mortagagedetails.php" endpoint

#      Verifying the response payload

# Scenario: Verifying the response payload
#   When I send a GET request to the "/mortagagedetails" endpoint
#   Then The response payload should have the following tabs : "b_firstName", "b_lastName", "b_email" , "b_ssn", "b_marital", "b_cell";





  Feature: Operation on Employment And Income page (API level).
  Background: steps for all scenarios
    Given The base, URI is up and running
    Then I am at mortagagedetails.php API ENDPOINT


  @smoke @regression
  Scenario: Posting new applicant and verifying if new information stored in the right order
    When I'm adding new  applicant information
    Then I'm  pulling new data back from the database tablet
    Then I'm verifying if the information is a match and stored in the correct order.


#
#  @smoke @regression
#  Scenario: Verify validation of Own Check Box
#    When I selecting the Own checkbox
#    Then I enter random digits in the First Mortagage Payment field
#    Then I go to next page
#
#  @smoke @regression #bug
#  Scenario: Verify validation of First Mortagage Payment field
#    When I selecting the Own checkbox
#    Then I enter random, trillion value, digits in the First Mortgage Payment field
#    Then I go to next page
#
#  @smoke @regression #bug
#  Scenario: Verify validation of Rental Payment field
#    When I selecting the Rent checkbox
#    Then I enter random, trillion value, digits in the Monthly Rental Payment field
#    Then I go to next page
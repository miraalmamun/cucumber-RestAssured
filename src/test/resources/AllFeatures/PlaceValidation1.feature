@PlaceAPI1
Feature: Validating Place API's
  User want to use this template for my feature file

  @AddPlaceAPI1
  Scenario: Verify if Place is being Succesfully added using AddPlaceAPI
    Given User add place payload
    When User calls "AddPlaceAPI" with Post http request
    Then The API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

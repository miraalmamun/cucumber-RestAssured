@PlaceAPI2
Feature: Validating Place API's
  User want to use this template for my feature file

  @AddPlaceAPI2
  Scenario Outline: 
    Verify if Place is being Succesfully added using AddPlaceAPI

    Given User add place payload with "<name>" "<phone>" "<address>"
    When User calls "AddPlaceAPI" with Post http request
    Then The API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples: 
      | name        | phone       | address         |
      | Dream House | 91763548542 | 142-20 Homeland |
      | DreamHouse2 | 71863548542 | 142-20 Worldman |

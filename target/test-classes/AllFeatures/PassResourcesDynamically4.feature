@Regrassion7
Feature: Validating Place API's
  User want to use this template for my feature file

  @AddPlaceAPIGet
  Scenario Outline: End to end test for creating, retriving and deleting
    Verify if Place is being Succesfully added using AddPlaceAPI

    Given User add place payload with "<name>" "<phone>" "<address>"
    When User calls "ADDPLACEAPI" with "POST" http request
    Then User verify in response body place_id is created
    And The API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And User verify place_id created maps to "<name>" using "GETPLACEAPI" with "GET" http request

    Examples: 
      | name        | phone       | address         |
      | Dream House | 91763548542 | 142-20 Homeland |

  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given User added DeletePlace Payload
    When User calls "DELETEPLACEAPI" with "POST" http request
    Then The API call is success with status code 200
    And "status" in response body is "OK"

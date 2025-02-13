#language: en


Feature: Validate unsupported request method for brands API

  @Successful
  Scenario Outline: Sending a PUT request to the brands list
    Given the user has access to the brands API
    When the user sends a PUT request to "<resource>"
    Then the response status code should 405
    And the response message for PUT should be error message

    Examples:
        |resource   |
        |/brandsList|

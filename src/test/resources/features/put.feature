#language: en


Feature: Validate unsupported request method for brands API

  @Success
  Scenario Outline: Sending a PUT request to the brands list
    Given the user has access to the brands API
    When the user sends a PUT request to "<resource>"
    Then the response status code should be "<status_code>"
    And the response message should be "<response_message>"

    Examples:
        |resource   | status_code | response_message                      |
        |/brandsList| 405         | This request method is not supported. |

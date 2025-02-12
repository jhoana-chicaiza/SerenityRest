#language: en

Feature: Validate unsupported request method for products API

  @Successful
  Scenario Outline: Sending a POST request to the products list
    Given the user has access to the products API
    When the user sends a POST request to "<resource>"
    Then the response status code should be "<status_code>"
    And the response message should be "<response_message>"

    Examples:
      | resource     | status_code | response_message                      |
      |/productsList | 405         | This request method is not supported. |

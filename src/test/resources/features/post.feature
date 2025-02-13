#language: en

Feature: Validate unsupported request method for products API

  @Successful
  Scenario Outline: Sending a POST request to the products list
    Given the user has access to the products API
    When the user sends a POST request to "<resource>"
    Then the response status code should be 405
    And the response message for POST should be error message

    Examples:
      | resource     |
      |/productsList |

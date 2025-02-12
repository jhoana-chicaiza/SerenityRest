#language: en

Feature: Validate GET request for product list
  @Successful
  Scenario Outline: Successfully retrieve the product list
    Given the user has access to the product API
    When they send a GET request with the resource "<resource>"
    Then the response message should be the product list

    Examples:
      | resource      |
      | /productsList |
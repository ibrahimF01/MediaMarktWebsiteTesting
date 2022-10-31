Feature: Stock Inquiry / Search Result

  Background:
    Given Navigate to MediaMarkt
    When Verify that you are on the home page

    Scenario: Stock Inquiry / Search Result
      Given Click on Personal Care products
      And Click on Male Grooming products
      And Sort products from most expensive to least expensive
      And Choose the most expensive product
      And Get Item No (serial number)
      And Click on Stock Inquiry Button
      And Make a stock inquiry of the product
      And Stock information

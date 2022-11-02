Feature: Buying Most Expensive Product
  Background:
    Given Navigate to MediaMarkt
    When Verify that you are on the home page

  Scenario: Buying the Most Expensive Smart TV
    Given Type Smart TV to the search box and click enter
    And Click Most Expensive Price
    And Click the First Product on the List
    And Click add to cart
    And Click on Continue button
    And Click on the continue without registration
    And Fill in the address form
    And Accept privacy policy and save the form
    And Click on the payment method
    And Click on the remove product from cart
    Then Verify that there are no items in the cart
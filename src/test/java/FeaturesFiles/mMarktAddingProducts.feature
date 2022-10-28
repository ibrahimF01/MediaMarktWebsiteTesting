Feature: Adding Products and Payment Functionality
  Scenario: Adding Product and Payment

    Given Navigate to MediaMarkt
    When Verify that you are on the home page
    And Type the product in the search box and click enter
    And Click on the random product
    And Click add to cart
    And Click on the additional insurance
    And Add to cart and click continue
    And Click on the go to cart
    And Click on the continue
    And Click on the continue without registration
    And Fill in the address form and save
    And Click on the payment method
    And Click on the remove product from cart
    Then Verify that there are no items in the cart




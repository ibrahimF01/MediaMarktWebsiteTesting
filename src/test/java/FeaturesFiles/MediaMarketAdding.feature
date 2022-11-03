Feature: Adding and Payment Functionality
  Scenario: Adding and Payment

    Given Navigate to MediaMarkt
    When Verify that you are on the home page
    And Using the Action class, go to All categories, then to Computer and from within the computer to computer accessories.
    And Select DAYTONA brand from computer accessories and DAYTONA DYT'i secin
    And Check the stock status of the product and exit after viewing
    And Add the product to the cart and save the price of the product
    And Press the Continue button and proceed from the section -Continue without a member- on the page that opens.
    And Click on the payment method
    And Click on the remove product from cart
    Then Verify that there are no items in the cart


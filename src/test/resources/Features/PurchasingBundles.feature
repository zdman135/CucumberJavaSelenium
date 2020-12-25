Feature: Purchasing Bundles of Product
  
  As a customer of AlgaeCal
  I want to be able to purchase bundles of the product

  Scenario: Ability to add bundle to cart
    Given I am on the pricing bundle page
    When I add a bundle to the cart
    Then I should see the product bundle added to the cart
    And I am on the checkout page

  Scenario: Confirmation appears when exiting the Checkout Page
    Given I have items in my shopping cart
    And I am on the checkout page
    When I exit the checkout page
    Then I will see I confirmation to exit the checkout page

  Scenario: Able to add coupon when attempting to leave checkout page
    Given I have items in my shopping cart
    And I am on the checkout page
    And I exit the checkout page
    When I accept the coupon presented
    Then I will see the prices updated in the cart

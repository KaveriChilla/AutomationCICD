
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

 Background:
 Given I landed on Ecommerce Website


  @Regression
  Scenario Outline: Positive test of submitting order
    Given Logged in with username <name> and passowrd <password>
    When I add product <productname> from cart
    Then checkout <productname> and submit the order
    

    Examples: 
      | name                | password        |productname|
      | shetty@gmail.com    | Iamking@000     |ZARA COAT 3|
     

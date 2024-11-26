
@tag
Feature: Error validation
  I want to use this template for my feature file


  @ErrorValidations
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Website
    When Logged in with username <name> and passowrd <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
     | name                | password        |productname|
      | shetty@gmail.com    | Iamking@00     |ZARA COAT 3|
     
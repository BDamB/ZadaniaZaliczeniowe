Feature: Add new address

  Scenario Outline: user can add new address
    Given user is on the My Store website and user has a register account
    When user clicks Sign in button
    And user inputs correct email , password and clicks sign in button below
    And user clicks on Addresses section button
    And user clicks +Create new address
    And user inputs field "<alias>" , "<address>", "<city>", "<zip>", "<country>" , "<phone>" and clicks Save button
    Then new address has been added and success message is displayed

    Examples:
    |alias|address |city  |zip   |country       |phone      |
    |House|Sunny 10|London|55-555|United Kingdom|666-666-666|








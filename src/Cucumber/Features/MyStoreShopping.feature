Feature:

  Scenario Outline: User buy the sweater
    Given user is on the My Store website and he earlier register an account
    When user clicks in Sign in button
    And user inputs email, password to his account and clicks in Sign in button
    And user inputs "<product name>" in search input window and clicks magnifier sign
    And user clicks in thumbnail of Hummingbird Printed Sweater
    And user choose "<size>" , "<quantity>"  and user adds product to the cart
    And user clicks Proceed to checkout button and again clicks Proceed to checkout button in next window
    And user clicks Continue to confirm the address
    And user clicks PrestaShop and clicks Continue to confirm
    And user clicks circle button next to Pay by Check and clicks square checkbox to agree to the terms of service and clicks Order With An Obligation To Pay button
    Then user sees the confirmation of success and the screenshot of this site will be taken


    Examples:
    |product name               |size|quantity|
    |Hummingbird Printed Sweater|M   |5       |
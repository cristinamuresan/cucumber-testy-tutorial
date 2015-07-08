@screen
Feature: Login

  Scenario: Login with no password
    Given I access "https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com"
    When I enter "bcristinabianca" credentials
    And I click button
    Then I expect "Please enter your password" error message

  Scenario Outline: Failed login
    Given I acces "https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com"
    When I enter "<email>"/"<password>" credentials
    And I click button
    Then I expect "<message>" error message
    Examples:
      | email           | password   | message                                                                  |
      |                 |            | Invalid ID or password.\nPlease try again using your full Yahoo ID.      |
      | bcristinabianca |            | Please enter your password                                               |
      |                 | A.12!ab    | Invalid ID or password.\nPlease try again using your full Yahoo ID.      |
      | bcristinabianca | bcdyejwu   | Invalid ID or password.\nPlease try again using your full Yahoo ID.      |
      | ksdjwiofcj      | chdbsjakiv | This ID is not yet taken.\nAre you trying to register for a new account? |
      | BCRISTINABIANCA | A.12!AB    | Invalid ID or password.\nPlease try again using your full Yahoo ID.      |

  Scenario: Successfully login
    Given I acces "https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com"
    And I insert correct credentials
    When I click button
    Then I check if home page appears

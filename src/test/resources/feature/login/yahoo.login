@screen
  Feature: Login

    Scenario: Successfully login
      Given I acces "https://login.yahoo.com/?.src=ym&.intl=ro&.lang=ro-RO&.done=https%3a//mail.yahoo.com"
      And I insert correct credentials
      When I click button
      Then I check if home page appears


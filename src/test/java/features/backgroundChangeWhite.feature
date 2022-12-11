@changeBackgroundColor
Feature: Techfios testing website background change

  Background: 
    Given "Set SkyWhite Background" button exists

  Scenario: User should be able to Change background color to white

    When I click on the button    
    Then the background color will change to "White"
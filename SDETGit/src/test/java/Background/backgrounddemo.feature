Feature: This is background demo

Background: User is logged in to saucedemo app
Given User is accessing saucedemo login page 
When User enters valid username and password
Then User should be able to navigate home page 

Scenario: Test Menu Items

And click on breadcrumb icon 
Then User should be able to see the menu items

Scenario: Verify add to cart functionality

And Clicks on Add button 
Then Item should be added to the cart

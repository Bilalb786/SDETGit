Feature: Login page Automation of saucedemo App
Scenario Outline: Check login is successful with valid creds
Given User is go to login page
When Enter the valid "<username>" and "<password>"
And clicks on the Login Button 
Then User is navigated to home page
And User close the browser

Examples:
| username | password | 
| standard_user | secret_sauce |
#| locked_out_user | secret_sauce |
#| problem_user | secret_sauce | 
#| performance_glitch_user | secret_sauce |
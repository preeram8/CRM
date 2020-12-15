
@Activity4
Feature: Creating a Product

 Scenario Outline: To use an Examples table to add products
  Given User is on CRM login page4
	When user enters username and password4
	Then Navigate to All -> Products-> Create Product
	And User enters "<Productname>" and "<Price>"
	And close the browser4
    
Examples:
    | Productname | Price |
    | Headphone     | 300  |
    | Bluetooth Speaker | 600  |
    | Television | 1600  |
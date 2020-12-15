
@Activity1
Feature: Login and Count Dashlets

  @tag1
  Scenario: Open the homepage and count the number of the dashlets on the page
    Given User is on CRM login page
    When user enters username and password
    Then counts the dashlets on the homepage and print its title
    And close the browser


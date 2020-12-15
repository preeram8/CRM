
@Activity2
Feature: Create leads and Save

  @tag1
  Scenario: Go to Leads page and create a Lead and Save it
   Given User is on CRM login page2
	When user enters username and password2
	Then Navigate to Sales -> Leads -> Create Lead
	And close the browser2

  